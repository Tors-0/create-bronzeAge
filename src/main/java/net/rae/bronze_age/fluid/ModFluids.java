package net.rae.bronze_age.fluid;

import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rae.bronze_age.BronzeAge;
import net.rae.bronze_age.block.ModBlocks;
import net.rae.bronze_age.item.ModItems;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, BronzeAge.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_MOLTEN_BRONZE = FLUIDS.register("molten_bronze_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.MOLTEN_BRONZE_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_MOLTEN_BRONZE = FLUIDS.register("flowing_molten_bronze",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.MOLTEN_BRONZE_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties MOLTEN_BRONZE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.MOLTEN_BRONZE_FLUID_TYPE, SOURCE_MOLTEN_BRONZE, FLOWING_MOLTEN_BRONZE)
            .slopeFindDistance(2).levelDecreasePerBlock(3).block(ModBlocks.MOLTEN_BRONZE_BLOCK).bucket(ModItems.MOLTEN_BRONZE_BUCKET);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
