package net.rae.bronze_age.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, net.rae.bronze_age.BronzeAge.MOD_ID);

    public static final RegistryObject<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COOL_TAB)));
    public static final RegistryObject<Item> BRONZE_GEAR = ITEMS.register("bronze_gear",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COOL_TAB)));
    public static final RegistryObject<Item> SMALL_BRONZE_GEAR = ITEMS.register("small_bronze_gear",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COOL_TAB)));
    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COOL_TAB)));
    public static final RegistryObject<Item> RAW_TIN = ITEMS.register("raw_tin",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COOL_TAB)));

    public static final RegistryObject<SwordItem> BRONZE_GLADIUS = ITEMS.register("bronze_gladius",
            () -> new SwordItem(Tiers.BRONZE,6,1.6f, props()));
    public static final RegistryObject<PickaxeItem> BRONZE_PICKAXE = ITEMS.register("bronze_pickaxe",
            () -> new PickaxeItem(Tiers.BRONZE, 4, 1.2f, props()));
    public static final RegistryObject<ShovelItem> BRONZE_SHOVEL = ITEMS.register("bronze_shovel",
            () -> new ShovelItem(Tiers.BRONZE,5f,1,props()));
    public static final RegistryObject<AxeItem> BRONZE_AXE = ITEMS.register("bronze_axe",
            () -> new AxeItem(Tiers.BRONZE, 9, 0.85f,props()));
    public static final RegistryObject<HoeItem> BRONZE_HOE = ITEMS.register("bronze_hoe",
            () -> new HoeItem(Tiers.BRONZE, 1,2.5f,props()));

    private static Item.Properties props() {
        return new Item.Properties().tab(ModCreativeModeTab.COOL_TAB);
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static class Tiers {
        public static final Tier BRONZE = new ForgeTier(
                2,
                500,
                6.5f,
                2.5f,
                15,
                BlockTags.MINEABLE_WITH_PICKAXE,
                () -> Ingredient.of(ModItems.BRONZE_INGOT.get()));
    }
}
