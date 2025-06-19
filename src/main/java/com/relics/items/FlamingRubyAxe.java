package com.relics.items;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class FlamingRubyAxe extends AxeItem {
    public FlamingRubyAxe() {
        super(Tiers.NETHERITE, 10.0F, -3.0F, new Item.Properties().durability(1200).fireResistant());
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setSecondsOnFire(5);
        return super.hurtEnemy(stack, target, attacker);
    }
}
