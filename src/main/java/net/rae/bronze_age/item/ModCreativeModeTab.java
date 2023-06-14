package net.rae.bronze_age.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.rae.bronze_age.block.ModBlocks;
import org.jetbrains.annotations.NotNull;

public class ModCreativeModeTab {
    public static final CreativeModeTab COOL_TAB = new CreativeModeTab("cooltab") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(ModBlocks.BRONZE_BLOCK.get());
        }
    };
}
