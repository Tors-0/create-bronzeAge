package net.rae.bronze_age.item;

import com.mojang.realmsclient.gui.screens.RealmsGenericErrorScreen;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.rae.bronze_age.ModTiers;

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
            BRONZE_NUGGET = taggedBasicItem("bronze_nugget",forgeItemTag("nuggets/bronze"),forgeItemTag("nuggets"));
    // Bronze tools/uniques
    public static final ItemEntry<TridentItem> BRONZE_SPEAR = REGISTRATE.item("bronze_spear",TridentItem::new)
            .register();
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
    // Mass item methods
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
