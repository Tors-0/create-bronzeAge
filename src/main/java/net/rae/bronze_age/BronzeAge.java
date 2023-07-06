package net.rae.bronze_age;
// YT Tutorial Playlist:
// https://www.youtube.com/playlist?list=PLKGarocXCE1HrC60yuTNTGRoZc6hf5Uvl

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
import net.rae.bronze_age.registry.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.rae.bronze_age.registry.ModRegistrate.REGISTRATE;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BronzeAge.MOD_ID)
public class BronzeAge {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "bronze_age";
    // Directly reference a slf4j logger
    public static final String NAME = "Bronze age";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);


    public BronzeAge() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        AllModItems.register();
        ModItems.register(modEventBus);

        ModBlockEntityTypes.register();
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
