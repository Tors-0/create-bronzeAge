package net.rae.bronze_age.registry;

import com.mojang.math.Vector3f;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rae.bronze_age.BronzeAge;
import net.rae.bronze_age.content.fluid.BaseFluidType;

public class ModFluidTypes {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation(BronzeAge.MOD_ID, "block/mbronze_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation(BronzeAge.MOD_ID, "block/mbronze_flow");
    public static final ResourceLocation BRONZE_OVERLAY_RL = new ResourceLocation(BronzeAge.MOD_ID, "misc/in_molten_bronze");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, BronzeAge.MOD_ID);

    public static final RegistryObject<FluidType> MOLTEN_BRONZE_FLUID_TYPE = register("molten_bronze_fluid",
            FluidType.Properties.create().lightLevel(15).density(3000).viscosity(6000)
                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                    .temperature(1500).pathType(BlockPathTypes.LAVA).adjacentPathType(null)
                    .canSwim(false).canDrown(false)
    );

    private static RegistryObject<FluidType> register(String name, FluidType.Properties properties) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, BRONZE_OVERLAY_RL,
                0xffffffff, new Vector3f(151f / 255f, 94f / 255f, 37f / 255f), properties));
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}
