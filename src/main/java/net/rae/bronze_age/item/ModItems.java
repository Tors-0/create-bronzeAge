package net.rae.bronze_age.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rae.bronze_age.ModTiers;
import net.rae.bronze_age.fluid.ModFluids;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, net.rae.bronze_age.BronzeAge.MOD_ID);
    // bronze items here
    public static final RegistryObject<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot", // registered
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COOL_TAB)));
    public static final RegistryObject<Item> BRONZE_PLATE = ITEMS.register("bronze_plate",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COOL_TAB)));
    /*public static final RegistryObject<Item> BRONZE_GEAR = ITEMS.register("bronze_gear",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COOL_TAB)));
    public static final RegistryObject<Item> SMALL_BRONZE_GEAR = ITEMS.register("small_bronze_gear",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COOL_TAB)));*/
    public static final RegistryObject<Item> BRONZE_NUGGET = ITEMS.register("bronze_nugget", // registered
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COOL_TAB)));
    // tin items here
    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", // registered
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COOL_TAB)));
    public static final RegistryObject<Item> TIN_NUGGET = ITEMS.register("tin_nugget", // registered
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COOL_TAB)));
    public static final RegistryObject<Item> RAW_TIN = ITEMS.register("raw_tin", // registered
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COOL_TAB)));

    // bronze casting items here
    public static final RegistryObject<Item> SMALL_SAND_CAST = ITEMS.register("small_sand_cast",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COOL_TAB)));
    public static final RegistryObject<Item> LARGE_SAND_CAST = ITEMS.register("large_sand_cast",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COOL_TAB)));
    public static final RegistryObject<Item> SMALL_BRONZE_COG_ASSEMBLY = ITEMS.register("bronze_gear",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COOL_TAB)));
    public static final RegistryObject<Item> LARGE_BRONZE_COG_ASSEMBLY = ITEMS.register("large_bronze_gear",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COOL_TAB)));
    public static final RegistryObject<Item> MOLTEN_BRONZE_BUCKET = ITEMS.register("molten_bronze_bucket",
            () -> new BucketItem(ModFluids.SOURCE_MOLTEN_BRONZE,
                    new Item.Properties().tab(ModCreativeModeTab.COOL_TAB).craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<SwordItem> BRONZE_GLADIUS = ITEMS.register("bronze_gladius",
            () -> new SwordItem(ModTiers.BRONZE,3,-2.4f, props()));
    public static final RegistryObject<PickaxeItem> BRONZE_PICKAXE = ITEMS.register("bronze_pickaxe",
            () -> new PickaxeItem(ModTiers.BRONZE, 1, -2.8f, props()));
    public static final RegistryObject<ShovelItem> BRONZE_SHOVEL = ITEMS.register("bronze_shovel",
            () -> new ShovelItem(ModTiers.BRONZE,1.5f,-3.0f, props()));
    public static final RegistryObject<AxeItem> BRONZE_AXE = ITEMS.register("bronze_axe",
            () -> new AxeItem(ModTiers.BRONZE, 6.0f, -3.1f,props()));
    public static final RegistryObject<HoeItem> BRONZE_HOE = ITEMS.register("bronze_hoe",
            () -> new HoeItem(ModTiers.BRONZE, -2,-1.0f,props()));

    protected static Item.Properties props() {
        return new Item.Properties().tab(ModCreativeModeTab.COOL_TAB);
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static class Tiers {

    }
}
