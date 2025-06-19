package com.relics;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import com.relics.registry.ItemInit;

@Mod(RelicsOfTheEndfire.MODID)
public class RelicsOfTheEndfire {
    public static final String MODID = "relics";

    public RelicsOfTheEndfire() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ItemInit.ITEMS.register(modEventBus);
    }
}
