package de.madluffy.justsomeadditions.init.vanilla;

import de.madluffy.justsomeadditions.enchantments.arrowInfinity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EnchantmentInit {

    public static final DeferredRegister<Enchantment> VANILLA_ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, "minecraft");

    public static final RegistryObject<Enchantment> ARROWINFINITY = VANILLA_ENCHANTMENTS.register("infinity",
            () -> new arrowInfinity(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND));

}
