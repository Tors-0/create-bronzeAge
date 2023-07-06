package net.rae.bronze_age.registry;



import com.simibubi.create.content.kinetics.crank.HandCrankBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockEntityInstance;
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockEntityRenderer;
import com.simibubi.create.content.kinetics.transmission.GearshiftBlockEntity;
import com.simibubi.create.content.kinetics.transmission.SplitShaftBlockEntity;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import net.rae.bronze_age.content.block.RotaryNOTBlockEntity;


import static net.rae.bronze_age.registry.ModRegistrate.REGISTRATE;

public class ModBlockEntityTypes {
    public static final BlockEntityEntry<RotaryNOTBlockEntity> ROTARY_NOT = REGISTRATE
            .blockEntity("rotary_not", RotaryNOTBlockEntity::new)
            .validBlocks(ModBlocks.ROTARY_NOT)
            .register();

    public static final BlockEntityEntry<HandCrankBlockEntity> BRONZE_KEY = REGISTRATE
            .blockEntity("bronze_key", HandCrankBlockEntity::new)
            .validBlocks(ModBlocks.BRONZE_KEY)
            .register();

    public static final BlockEntityEntry<BracketedKineticBlockEntity> BRONZE_COGWHEELS = REGISTRATE
            .blockEntity("bronze_cogwheels", BracketedKineticBlockEntity::new)
            .instance(() -> BracketedKineticBlockEntityInstance::new, false)
            .validBlocks(ModBlocks.LARGE_BRONZE_COGWHEEL, ModBlocks.BRONZE_COGWHEEL)
            .renderer(() -> BracketedKineticBlockEntityRenderer::new)
            .register();
    // Load this class
    public static void register() {}

}
