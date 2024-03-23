package de.madluffy.justsomeadditions.enchantments;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.ArrowInfiniteEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.MendingEnchantment;

public class arrowInfinity extends ArrowInfiniteEnchantment {
    public arrowInfinity(Enchantment.Rarity p_44584_, EquipmentSlot... p_44585_) {
        super(p_44584_, p_44585_);
    }

    @Override
    public boolean checkCompatibility(Enchantment p_44590_) {
        return p_44590_ instanceof MendingEnchantment || super.checkCompatibility(p_44590_);
    }
}
