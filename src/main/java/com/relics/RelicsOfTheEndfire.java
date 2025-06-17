package com.relics;

import com.relics.registry.ItemInit;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(RelicsOfTheEndfire.MODID)
public class RelicsOfTheEndfire {
    public static final String MODID = "relics";

    public RelicsOfTheEndfire() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.ITEMS.register(modEventBus);

        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTabKey().location().toString().equals("minecraft:combat")) {
            event.accept(ItemInit.FLAMING_RUBY_AXE.get());
            event.accept(ItemInit.GLOWING_AMBER_SWORD.get());
            event.accept(ItemInit.INFERNAL_THORNBLADE.get());
            event.accept(ItemInit.TOTEM_OF_MALICE.get());
        }
    }

    public static ResourceLocation id(String name) {
        return new ResourceLocation(MODID, name);
    }
}
