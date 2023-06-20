package net.rae.bronze_age.item;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TridentItem;

import static net.rae.bronze_age.BronzeAge.REGISTRATE;
import static net.rae.bronze_age.ModTags.forgeItemTag;

public class AllModItems {
    static {
        REGISTRATE.creativeModeTab(() -> ModCreativeModeTab.COOL_TAB);
    }
    // Raw Items
    public static final ItemEntry<Item> RAW_TIN =
            taggedBasicItem("raw_tin", forgeItemTag("raw_materials"), forgeItemTag("raw_materials/tin"));
    // Refined Materials
    public static final ItemEntry<Item>
            TIN_INGOT = taggedBasicItem("tin_ingot",forgeItemTag("ingots/tin"),forgeItemTag("ingots")),
            BRONZE_INGOT = taggedBasicItem("bronze_ingot",forgeItemTag("ingots/bronze"),forgeItemTag("ingots"));
    // Bronze Tools
    public static final ItemEntry<TridentItem> BRONZE_SPEAR = REGISTRATE.item("bronze_spear",TridentItem::new)
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
