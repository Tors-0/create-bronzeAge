package net.rae.bronze_age.content.entity.projectile;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ThrownSpear extends ThrownTrident {
    public ThrownSpear(EntityType<? extends ThrownTrident> p_37561_, Level p_37562_) {
        super(p_37561_, p_37562_);
    }

    public ThrownSpear(Level p_37569_, LivingEntity p_37570_, ItemStack p_37571_) {
        super(p_37569_, p_37570_, p_37571_);
    }
}
