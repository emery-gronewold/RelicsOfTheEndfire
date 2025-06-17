package com.relics.events;

import com.relics.registry.ItemInit;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class TotemEventHandler {
    @SubscribeEvent
    public static void onPlayerDeath(LivingDeathEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (player.level().isClientSide) return;

        for (InteractionHand hand : InteractionHand.values()) {
            ItemStack item = player.getItemInHand(hand);
            if (item.getItem() == ItemInit.TOTEM_OF_MALICE.get()) {
                event.setCanceled(true);
                item.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(hand));
                player.setHealth(10.0F); // Revive with 5 hearts
                player.clearFire();
                player.removeAllEffects();

                // Curse nearby mobs
                if (player.level() instanceof ServerLevel serverLevel) {
                    serverLevel.getEntities(player, player.getBoundingBox().inflate(5)).forEach(e -> {
                        if (e instanceof LivingEntity target && target != player) {
                            target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 1));
                            target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 60, 0));
                        }
                    });
                }

                break;
            }
        }
    }
}
