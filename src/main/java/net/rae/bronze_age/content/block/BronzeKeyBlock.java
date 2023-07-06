package net.rae.bronze_age.content.block;

import com.simibubi.create.AllItems;
import com.simibubi.create.content.kinetics.crank.HandCrankBlock;
import com.simibubi.create.content.kinetics.crank.HandCrankBlockEntity;
import com.simibubi.create.foundation.advancement.AllAdvancements;
import com.simibubi.create.infrastructure.config.AllConfigs;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.rae.bronze_age.registry.ModBlockEntityTypes;


public class BronzeKeyBlock extends HandCrankBlock {

    public BronzeKeyBlock(Properties properties) {
        super(properties);
    }

   //im just gonna push it


    @Override
    public BlockEntityType<? extends HandCrankBlockEntity> getBlockEntityType() {
        return ModBlockEntityTypes.BRONZE_KEY.get();
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn,
                                 BlockHitResult hit) {
        if (player.isSpectator())
            return InteractionResult.PASS;

        withBlockEntityDo(worldIn, pos, be -> be.turn(player.isShiftKeyDown()));
        if (!player.getItemInHand(handIn)
                .is(AllItems.EXTENDO_GRIP.get()))
            player.causeFoodExhaustion(getRotationSpeed() * AllConfigs.server().kinetics.crankHungerMultiplier.getF());

        if (player.getFoodData()
                .getFoodLevel() == 0)
            AllAdvancements.HAND_CRANK.awardTo(player);

        return InteractionResult.SUCCESS;
    }

}
