package de.madluffy.justsomeadditions.init;

import de.madluffy.justsomeadditions.items.InfinityBowItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

    public static final DeferredRegister<Item> VANILLA_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "minecraft");

    public static final RegistryObject<Item> BOW = VANILLA_ITEMS.register("bow",
            () -> new InfinityBowItem(new Item.Properties().durability(384)));

}
