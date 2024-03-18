package de.madluffy.justsomeadditions.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Map;

public class uenchant {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher){

        List<String> enchantments = null;
        LiteralArgumentBuilder<CommandSourceStack> command = Commands.literal("uenchant");
        IntegerArgumentType level = IntegerArgumentType.integer(0, 127);

        for (Enchantment e: ForgeRegistries.ENCHANTMENTS){
            command.then(Commands.literal(e.getDescriptionId().replace("enchantment.minecraft.", "")).then(Commands.argument("level", level).executes(uenchant::addEnchantment)));

        }
        dispatcher.register(command);
    }
    private static int addEnchantment(CommandContext<CommandSourceStack> command){
        int level = Integer.parseInt(command.getInput().replaceAll("[^0-9]", ""));
        String enchantment = "enchantment.minecraft." + command.getNodes().get(1).getNode().getName();
        if (level <= 0 || level >= 128){
            command.getSource().getPlayer().sendSystemMessage(Component.literal("Invalid Range, choose a number between 1 and 127!")
                    .withStyle(ChatFormatting.RED), false);
            return 0;
        }
        if (command.getSource().getPlayer().getMainHandItem().getItem() == Items.AIR){
            command.getSource().getPlayer().sendSystemMessage(Component.literal("You need to have a item in your main hand!")
                    .withStyle(ChatFormatting.RED), false);
            return 0;
        }
        for (Enchantment ench: ForgeRegistries.ENCHANTMENTS){
            if (ench.getDescriptionId().equals(enchantment)){
                ItemStack item = command.getSource().getPlayer().getMainHandItem();
                Map<Enchantment, Integer> enchantments = item.getAllEnchantments();
                enchantments.remove(ench);
                enchantments.put(ench, level);
                EnchantmentHelper.setEnchantments(enchantments, item);
                break;
            }
        }
        return Command.SINGLE_SUCCESS;
    }
}
