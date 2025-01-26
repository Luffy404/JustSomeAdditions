package de.madluffy.justsomeadditions.init.vanilla;

import de.madluffy.justsomeadditions.items.InfinityBowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

    public static final DeferredRegister<Item> VANILLA_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "minecraft");

    public static final RegistryObject<Item> BOW = VANILLA_ITEMS.register("bow",
            () -> new InfinityBowItem(new Item.Properties().durability(384)));
    public static final RegistryObject<Item> TOTEM_OF_UNDYING = VANILLA_ITEMS.register("totem_of_undying",
            () -> new InfinityBowItem(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON)));

}
