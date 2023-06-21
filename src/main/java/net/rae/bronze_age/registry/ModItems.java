package net.rae.bronze_age.registry;


import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rae.bronze_age.ModTiers;
import net.rae.bronze_age.ModCreativeModeTab;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, net.rae.bronze_age.BronzeAge.MOD_ID);
    // bronze items here
    /*public static final RegistryObject<Item> BRONZE_PLATE = ITEMS.register("bronze_plate",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COOL_TAB)));
    public static final RegistryObject<Item> BRONZE_GEAR = ITEMS.register("bronze_gear",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COOL_TAB)));
    public static final RegistryObject<Item> SMALL_BRONZE_GEAR = ITEMS.register("small_bronze_gear",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COOL_TAB)));*/

    // bronze casting items here

    public static final RegistryObject<Item> SMALL_BRONZE_COG_ASSEMBLY = ITEMS.register("bronze_gear",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COOL_TAB)));
    public static final RegistryObject<Item> LARGE_BRONZE_COG_ASSEMBLY = ITEMS.register("large_bronze_gear",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COOL_TAB)));
    /*public static final RegistryObject<Item> MOLTEN_BRONZE_BUCKET = ITEMS.register("molten_bronze_bucket",
            () -> new BucketItem(ModFluids.SOURCE_MOLTEN_BRONZE,
                    new Item.Properties().tab(ModCreativeModeTab.COOL_TAB).craftRemainder(Items.BUCKET).stacksTo(1)));*/




    private static Item.Properties props() {
        return new Item.Properties().tab(ModCreativeModeTab.COOL_TAB);
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
