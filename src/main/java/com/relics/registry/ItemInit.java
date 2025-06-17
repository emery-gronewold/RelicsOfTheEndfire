package com.relics.registry;

import com.relics.RelicsOfTheEndfire;
import com.relics.items.*;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.RegistryBuilder;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RelicsOfTheEndfire.MODID);

    public static final RegistryObject<Item> FLAMING_RUBY_AXE = ITEMS.register("flaming_ruby_axe", FlamingRubyAxe::new);
    public static final RegistryObject<Item> GLOWING_AMBER_SWORD = ITEMS.register("glowing_amber_sword", GlowingAmberSword::new);
    public static final RegistryObject<Item> INFERNAL_THORNBLADE = ITEMS.register("infernal_thornblade", InfernalThornblade::new);
    public static final RegistryObject<Item> TOTEM_OF_MALICE = ITEMS.register("totem_of_malice", TotemOfMalice::new);
}
