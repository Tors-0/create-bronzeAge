package net.rae.bronze_age.registry;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TridentItem;
import net.rae.bronze_age.ModCreativeModeTab;
import net.rae.bronze_age.ModTiers;

import static net.rae.bronze_age.BronzeAge.REGISTRATE;
import static net.rae.bronze_age.ModTags.forgeItemTag;
import static net.rae.bronze_age.registry.ModItems.props;

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
            BRONZE_NUGGET = taggedBasicItem("bronze_nugget",forgeItemTag("nuggets/bronze"),forgeItemTag("nuggets"));
    // Bronze tools/uniques
    public static final ItemEntry<TridentItem> BRONZE_SPEAR = REGISTRATE.item("bronze_spear",TridentItem::new)
            .register();
    public static final ItemEntry<SwordItem> BRONZE_SWORD =
            REGISTRATE.item("bronze_sword", p -> new SwordItem(ModTiers.BRONZE,3,-2.4f,props()))
                    .register();
    // Mass item methods
    private static ItemEntry<Item> taggedBasicItem(String name, TagKey<Item>... tags) {
        return REGISTRATE.item(name, Item::new)
                .tag(tags)
                .register();
    }
    // Load this class
    public static void register() {}
}
