package net.rae.bronze_age.registry;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.rae.bronze_age.ModCreativeModeTab;
import net.rae.bronze_age.ModTiers;
import net.rae.bronze_age.content.item.SpearItem;

import static net.rae.bronze_age.BronzeAge.REGISTRATE;
import static net.rae.bronze_age.ModTags.forgeItemTag;

public class AllModItems {
    static {
        REGISTRATE.creativeModeTab(() -> ModCreativeModeTab.COOL_TAB);
    }
    // Raw items
    public static final ItemEntry<Item> RAW_TIN =
            taggedBasicItem("raw_tin", forgeItemTag("raw_materials"), forgeItemTag("raw_materials/tin"));
    // Refined materials
    public static final ItemEntry<Item>
            TIN_INGOT = taggedBasicItem("tin_ingot",forgeItemTag("ingots/tin"),forgeItemTag("ingots")),
            TIN_NUGGET = taggedBasicItem("tin_nugget",forgeItemTag("nuggets/tin"),forgeItemTag("nuggets")),
            BRONZE_INGOT = taggedBasicItem("bronze_ingot",forgeItemTag("ingots/bronze"),forgeItemTag("ingots")),
            BRONZE_NUGGET = taggedBasicItem("bronze_nugget",forgeItemTag("nuggets/bronze"),forgeItemTag("nuggets")),
            SMALL_SAND_CAST = basicItem("small_sand_cast"),
            LARGE_SAND_CAST = basicItem("large_sand_cast"),
            BRONZE_GEAR = basicItem("bronze_gear"),
            LARGE_BRONZE_GEAR = basicItem("large_bronze_gear");
    public static final ItemEntry<BucketItem> MOLTEN_BRONZE_BUCKET = REGISTRATE.item("molten_bronze_bucket",
                    p -> new BucketItem(ModFluids.SOURCE_MOLTEN_BRONZE,props().craftRemainder(Items.BUCKET).stacksTo(1)))
            .register();
    public static final ItemEntry<Item> BRONZE_SHEET = REGISTRATE.item("bronze_plate", Item::new)
            .tag(forgeItemTag("plates")).tag(forgeItemTag("plates/bronze"))
            .lang("Bronze Sheet")
            .register();
    // Bronze tools/uniques
    public static final ItemEntry<SpearItem> BRONZE_SPEAR = REGISTRATE.item("bronze_spear", SpearItem::new)
            .register();
    /* SPEAR ITEM GONNA BE LAME UNTIL THIS PART WORKS, IDK WHATS WRONG AND TTERAG STOPPED HELPING
    public static final EntityType<ThrownSpear> THROWN_BRONZE_SPEAR = REGISTRATE.object("thrown_bronze_spear")
            .entity(ThrownSpear::new, MobCategory.MISC)
            .loot((tb, e) -> tb.add(e, LootTable.lootTable()))
            .renderer(() -> ThrownTridentRenderer::new)
            .register();*/
    public static final ItemEntry<SwordItem> BRONZE_SWORD =
            REGISTRATE.item("bronze_sword", p -> new SwordItem(ModTiers.BRONZE,3,-2.4f,props()))
                    .lang("Bronze Gladius")
                    .register();
    public static final ItemEntry<PickaxeItem> BRONZE_PICKAXE =
            REGISTRATE.item("bronze_pickaxe", p -> new PickaxeItem(ModTiers.BRONZE,1,-2.8f,props()))
                    .register();
    public static final ItemEntry<ShovelItem> BRONZE_SHOVEL =
            REGISTRATE.item("bronze_shovel", p -> new ShovelItem(ModTiers.BRONZE,1.5f,-3.0f,props()))
                    .register();
    public static final ItemEntry<AxeItem> BRONZE_AXE =
            REGISTRATE.item("bronze_axe", p -> new AxeItem(ModTiers.BRONZE, 6.0f, -3.1f,props()))
                    .register();
    public static final ItemEntry<HoeItem> BRONZE_HOE =
            REGISTRATE.item("bronze_hoe", p -> new HoeItem(ModTiers.BRONZE, -2,-1.0f,props()))
                    .register();
    // Mass item methods
    private static ItemEntry<Item> basicItem(String name) {
        return REGISTRATE.item(name, Item::new)
                .register();
    }
    private static ItemEntry<Item> taggedBasicItem(String name, TagKey<Item>... tags) {
        return REGISTRATE.item(name, Item::new)
                .tag(tags)
                .register();
    }
    private static Item.Properties props() {
        return new Item.Properties().tab(ModCreativeModeTab.COOL_TAB);
    }
    // Load this class
    public static void register() {}
}
