package com.relics.registry;

import com.relics.RelicsOfTheEndfire;
import com.relics.items.FlamingRubyAxe;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RelicsOfTheEndfire.MODID);

    public static final RegistryObject<Item> FLAMING_RUBY_AXE = ITEMS.register("flaming_ruby_axe", FlamingRubyAxe::new);
}
