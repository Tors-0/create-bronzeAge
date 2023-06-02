package net.rae.coolmod.items;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab COOL_TAB = new CreativeModeTab("cooltab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.BRONZE_INGOT.get());
        }
    };
}
