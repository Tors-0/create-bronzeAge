package net.rae.bronze_age.registry;

import com.simibubi.create.content.decoration.encasing.CasingBlock;
import com.simibubi.create.content.kinetics.BlockStressDefaults;
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockModel;
import com.simibubi.create.content.kinetics.simpleRelays.CogWheelBlock;
import com.simibubi.create.content.kinetics.simpleRelays.CogwheelBlockItem;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rae.bronze_age.ModCreativeModeTab;
import net.rae.bronze_age.ModSpriteShifts;
import net.rae.bronze_age.content.block.BronzeCogwheelBlock;
import net.rae.bronze_age.content.block.BronzeKeyBlock;
import net.rae.bronze_age.content.block.RotaryNOTBlock;

import java.util.function.Supplier;

import static com.simibubi.create.foundation.data.BlockStateGen.simpleCubeAll;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;
import static net.rae.bronze_age.ModTags.forgeBlockTag;
import static net.rae.bronze_age.registry.ModRegistrate.REGISTRATE;

public class  ModBlocks {
    static {
        REGISTRATE.creativeModeTab(() -> ModCreativeModeTab.COOL_TAB);
    }
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, net.rae.bronze_age.BronzeAge.MOD_ID);

    // FUNKY BLOCKS
    public static final BlockEntry<CogWheelBlock> BRONZE_COGWHEEL =
            REGISTRATE.block("bronze_cogwheel", BronzeCogwheelBlock::small)
                    .initialProperties(SharedProperties::stone)
                    .properties(p -> p.sound(SoundType.METAL))
                    .properties(p -> p.color(MaterialColor.METAL))
                    .transform(BlockStressDefaults.setNoImpact())
                    .transform(pickaxeOnly())
                    .blockstate(BlockStateGen.axisBlockProvider(false))
                    .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
                    .item(CogwheelBlockItem::new)
                    .build()
                    .register();
    public static final BlockEntry<CogWheelBlock> LARGE_BRONZE_COGWHEEL =
            REGISTRATE.block("large_bronze_cogwheel", BronzeCogwheelBlock::large)
                    .initialProperties(SharedProperties::stone)
                    .properties(p -> p.sound(SoundType.METAL))
                    .properties(p -> p.color(MaterialColor.METAL))
                    .transform(BlockStressDefaults.setNoImpact())
                    .transform(pickaxeOnly())
                    .blockstate(BlockStateGen.axisBlockProvider(false))
                    .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
                    .item(CogwheelBlockItem::new)
                    .build()
                    .register();

    //public static final BlockEntry<WoundSpringBlock> WOUND_UP_SPRING = REGISTRATE.block("wound_spring", WoundSpringBlock::new).initialProperties(SharedProperties::stone).properties(p -> p.sound(SoundType.METAL)).properties(p -> p.color(MaterialColor.METAL)).transform(pickaxeOnly()).register(); //VERY wip, id suggest not touching it

    public static final BlockEntry<BronzeKeyBlock> BRONZE_KEY =
            REGISTRATE.block("bronze_key", BronzeKeyBlock::new)
                    .item(BlockItem::new)
                    .build()
                    .register();

    public static final BlockEntry<RotaryNOTBlock> ROTARY_NOT =
            REGISTRATE.block("rotary_not", RotaryNOTBlock::new)
                    .initialProperties(SharedProperties::stone)
                    .properties(p -> p.sound(SoundType.METAL))
                    .properties(p -> p.color(MaterialColor.METAL))
                    .item(BlockItem::new)
                    .build()
                    .register();



    public static final BlockEntry<GravelBlock> BASALT_PEBBLES = REGISTRATE.block("basalt_pebbles", GravelBlock::new)
            .initialProperties(() -> Blocks.GRAVEL)
            .properties(p -> p.color(MaterialColor.COLOR_BLACK))
            .blockstate(simpleCubeAll("basalt_pebbles"))
            .tag(BlockTags.MINEABLE_WITH_SHOVEL, forgeBlockTag("gravel"))
            .lang("Basalt Pebbles")
            .item(BlockItem::new)
            .build()
            .register();
    public static final BlockEntry<CasingBlock> BRONZE_CASING = REGISTRATE.block("bronze_casing", CasingBlock::new)
            .properties(p -> p.color(MaterialColor.TERRACOTTA_BROWN))
            .transform(BuilderTransformers.casing(() -> ModSpriteShifts.BRONZE_CASING))
            .register();
    public static final BlockEntry<Block> TIN_BLOCK = REGISTRATE.block("tin_block",Block::new)
            .properties(p -> p.requiresCorrectToolForDrops().explosionResistance(6).strength(3))
            .item(BlockItem::new)
            .build()
            .register();
    public static final BlockEntry<Block> BRONZE_BLOCK = REGISTRATE.block("bronze_block",Block::new)
            .properties(p -> p.requiresCorrectToolForDrops().explosionResistance(6).strength(3))
            .item(BlockItem::new)
            .build()
            .register();

    public static final BlockEntry<DropExperienceBlock> TIN_ORE = REGISTRATE.block("tin_ore", p ->
                    new DropExperienceBlock(BlockBehaviour.Properties.of(Material.METAL)
                            .requiresCorrectToolForDrops().explosionResistance(6).strength(3),
                            UniformInt.of(3,7)))
            .item(BlockItem::new)
            .build()
            .register();
    public static final BlockEntry<DropExperienceBlock> DEEPSLATE_TIN_ORE = REGISTRATE.block("deepslate_tin_ore", p ->
            new DropExperienceBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .requiresCorrectToolForDrops().explosionResistance(6).strength(4),
                    UniformInt.of(3,7)))
            .item(BlockItem::new)
            .build()
            .register();
    public static final BlockEntry<Block> RAW_TIN_BLOCK = REGISTRATE.block("raw_tin_block", Block::new)
            .item(BlockItem::new)
            .build()
            .register();
    public static final BlockEntry<Block> WET_SAND = REGISTRATE.block("wet_sand", p ->
            new Block(BlockBehaviour.Properties.copy(Blocks.SAND)))
            .tag(BlockTags.MINEABLE_WITH_SHOVEL)
            .item(BlockItem::new)
            .build()
            .register();
    public static final BlockEntry<LiquidBlock> MOLTEN_BRONZE_BLOCK = REGISTRATE.block("molten_bronze_block",b ->
            new LiquidBlock(ModFluids.SOURCE_MOLTEN_BRONZE, BlockBehaviour.Properties.copy(Blocks.LAVA)))
            //.lang("Molten Bronze")
            .register();
    //DAT: dont do .lang its stupid and clutters stuff since we now have datagen which does this for us


    // BLOCKS
    /*public static final RegistryObject<Block> TIN_BLOCK = registerBlock("tin_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .requiresCorrectToolForDrops()
                    .explosionResistance(6).strength(3)), ModCreativeModeTab.COOL_TAB);
    public static final RegistryObject<Block> BRONZE_BLOCK = registerBlock("bronze_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .requiresCorrectToolForDrops()
                    .explosionResistance(6).strength(3)), ModCreativeModeTab.COOL_TAB);
    public static final RegistryObject<Block> TIN_ORE = registerBlock("tin_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .requiresCorrectToolForDrops().explosionResistance(6).strength(3),
                    UniformInt.of(3,7)), ModCreativeModeTab.COOL_TAB);
    public static final RegistryObject<Block> DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .requiresCorrectToolForDrops().explosionResistance(6).strength(4),
                    UniformInt.of(3,7)), ModCreativeModeTab.COOL_TAB);
    public static final RegistryObject<Block> WET_SAND = registerBlock("wet_sand",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SAND)), ModCreativeModeTab.COOL_TAB);
    public static final RegistryObject<LiquidBlock> MOLTEN_BRONZE_BLOCK = BLOCKS.register("molten_bronze_block",
            () -> new LiquidBlock(ModFluids.SOURCE_MOLTEN_BRONZE, BlockBehaviour.Properties.copy(Blocks.LAVA)));*/


    // END BLOCKS

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
