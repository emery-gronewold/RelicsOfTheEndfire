package com.relics.items;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

public class GlowingAmberSword extends SwordItem {
    public GlowingAmberSword() {
        super(Tiers.NETHERITE, 9, -2.4F, new Item.Properties().durability(1000).fireResistant());
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // 25% chance to apply slowness
        if (target.level().random.nextFloat() < 0.25F) {
            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1)); // Slowness II for 3 seconds
        }
        return super.hurtEnemy(stack, target, attacker);
    }
}
