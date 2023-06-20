package net.rae.bronze_age;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.rae.bronze_age.registry.ModItems;

public class ModTiers {
    public static final Tier BRONZE = new ForgeTier(
            2,
            420,
            6.5f,
            2.0f,
            15,
            BlockTags.MINEABLE_WITH_PICKAXE,
            () -> Ingredient.of(ModItems.BRONZE_INGOT.get()));
}
