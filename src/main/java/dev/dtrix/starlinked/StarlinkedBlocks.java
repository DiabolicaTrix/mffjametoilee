package dev.dtrix.starlinked;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class StarlinkedBlocks {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, StarLinked.MODID);

    public static final RegistryObject<Block> DREAM_CATCHER = BLOCKS.register("dream_catcher", () -> new Block(Block.Properties.create(Material.WOOD)));

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
