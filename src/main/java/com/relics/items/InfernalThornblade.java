package com.relics.items;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

public class InfernalThornblade extends SwordItem {
    public InfernalThornblade() {
        super(Tiers.NETHERITE, 13, -2.8F, new Item.Properties().durability(850).fireResistant());
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // 20% chance to "explode"
        if (target.level().random.nextFloat() < 0.2F) {
            // Deal area damage (non-destructive)
            target.level().getEntities(attacker, target.getBoundingBox().inflate(2)).forEach(e -> {
                if (e instanceof LivingEntity && e != attacker) {
                    ((LivingEntity) e).hurt(attacker.damageSources().explosion(attacker), 4.0F);
                }
            });

            // Show explosion particles
            if (target.level() instanceof ServerLevel serverLevel) {
                Vec3 pos = target.position();
                serverLevel.sendParticles(ParticleTypes.EXPLOSION, pos.x, pos.y + 1, pos.z, 8, 0.3, 0.3, 0.3, 0.01);
            }
        }

        return super.hurtEnemy(stack, target, attacker);
    }
}
