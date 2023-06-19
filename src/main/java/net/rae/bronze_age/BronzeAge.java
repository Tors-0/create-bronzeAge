package net.rae.bronze_age;
// YT Tutorial Playlist:
// https://www.youtube.com/playlist?list=PLKGarocXCE1HrC60yuTNTGRoZc6hf5Uvl

import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.rae.bronze_age.block.ModBlocks;
import net.rae.bronze_age.block_entity.ModBlockEntityType;
import net.rae.bronze_age.fluid.ModFluidTypes;
import net.rae.bronze_age.fluid.ModFluids;
import net.rae.bronze_age.item.ModItems;
import net.rae.bronze_age.world.feature.ModConfiguredFeatures;
import net.rae.bronze_age.world.feature.ModPlacedFeatures;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BronzeAge.MOD_ID)
public class BronzeAge {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "bronze_age";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID);

    public BronzeAge() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlockEntityType.register();
        ModBlocks.register(modEventBus);

        REGISTRATE.registerEventListeners(modEventBus);

        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);

        ModFluids.register(modEventBus);
        ModFluidTypes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_MOLTEN_BRONZE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_MOLTEN_BRONZE.get(), RenderType.translucent());
        }
    }
    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
