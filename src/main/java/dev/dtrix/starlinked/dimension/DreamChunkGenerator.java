package dev.dtrix.starlinked.dimension;

import dev.dtrix.starlinked.StarLinked;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.WorldGenRegion;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.server.ServerWorld;

public class DreamChunkGenerator extends ChunkGenerator {



    public DreamChunkGenerator(IWorld worldIn, BiomeProvider biomeProviderIn) {
        super(worldIn, biomeProviderIn, Config.createDefault());
    }

    @Override
    public void generateSurface(WorldGenRegion region, IChunk chunk) {
        BlockState bedrock = Blocks.BEDROCK.getDefaultState();
        if(chunk.getPos().x == 0 && chunk.getPos().z == 0) {
            BlockPos.Mutable pos = new BlockPos.Mutable();
            for(int x = 0; x<16;x++) {
                for(int z = 0; z<16; z++) {
                    chunk.setBlockState(pos.setPos(x, 0, z), bedrock, false);
                }
            }
        }
       /* BlockState bedrock = Blocks.BEDROCK.getDefaultState();
        BlockState stone = Blocks.STONE.getDefaultState();
        ChunkPos chunkpos = chunk.getPos();

        BlockPos.Mutable pos = new BlockPos.Mutable();

        int x;
        int z;

        for (x = 0; x < 16; x++) {
            for (z = 0; z < 16; z++) {
                chunk.setBlockState(pos.setPos(x, 0, z), bedrock, false);
            }
        }

        for (x = 0; x < 16; x++) {
            for (z = 0; z < 16; z++) {
                int realx = chunkpos.x * 16 + x;
                int realz = chunkpos.z * 16 + z;
                int height = (int) (65 + Math.sin(realx / 20.0f)*10 + Math.cos(realz / 20.0f)*10);
                for (int y = 1 ; y < height ; y++) {
                    chunk.setBlockState(pos.setPos(x, y, z), stone, false);
                }
            }
        }*/
    }

    @Override
    public int getGroundHeight() {
        return world.getSeaLevel() + 1;
    }

    @Override
    public void makeBase(IWorld worldIn, IChunk chunkIn) {
    }

    @Override
    public void generateStructures(BiomeManager biomeManager, IChunk chunk, ChunkGenerator chunkGenerator, TemplateManager templateManager) {
        super.generateStructures(biomeManager, chunk, chunkGenerator, templateManager);
       /* if(!this.world.getBlockState(new BlockPos(0,2,0)).getBlock().equals(Blocks.SMOOTH_QUARTZ)) {
            templateManager.getTemplate(new ResourceLocation(StarLinked.MODID, "shaman_hut/spawn")).addBlocksToWorld(this.world, new BlockPos(0, 2, 0), new PlacementSettings());
            templateManager.getTemplate(new ResourceLocation(StarLinked.MODID, "shaman_hut/portal")).addBlocksToWorld(this.world, new BlockPos(-24, 0, 0), new PlacementSettings());
        }*/

    }

    @Override
    public int func_222529_a(int p_222529_1_, int p_222529_2_, Heightmap.Type heightmapType) {
        return 0;
    }

    public static class Config extends GenerationSettings {

        public static Config createDefault() {
            Config config = new Config();
            config.setDefaultBlock(Blocks.QUARTZ_BLOCK.getDefaultState());
            config.setDefaultFluid(Blocks.WATER.getDefaultState());
            return config;
        }

    }

    @Override
    public boolean hasStructure(Biome biomeIn, Structure structureIn) {
        return false;
    }
}
