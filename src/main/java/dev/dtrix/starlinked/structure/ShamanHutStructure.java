package dev.dtrix.starlinked.structure;

import com.mojang.datafixers.Dynamic;
import net.minecraft.util.Rotation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.Random;
import java.util.function.Function;

public class ShamanHutStructure extends ScatteredStructure<NoFeatureConfig> {

    private static final int FEATURE_DISTANCE = 31;
    private static final int FEATURE_SEPARATION = 8;

    public ShamanHutStructure(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
        super(configFactoryIn);
    }

    @Override
    protected int getSeedModifier() {
        return 165745296;
    }

    @Override
    public IStartFactory getStartFactory() {
        return ShamanHutStructure.Start::new;
    }

    @Override
    public String getStructureName() {
        return "shaman_hut";
    }

    @Override
    public int getSize() {
        return 3;
    }

    @Override
    protected ChunkPos getStartPositionForPosition(ChunkGenerator<?> generator, Random random, int chunkX, int chunkZ, int offsetX, int offsetZ) {
        int lvt_9_1_ = chunkX + FEATURE_DISTANCE * offsetX;
        int lvt_10_1_ = chunkZ + FEATURE_DISTANCE * offsetZ;
        int lvt_11_1_ = lvt_9_1_ < 0 ? lvt_9_1_ - FEATURE_DISTANCE + 1 : lvt_9_1_;
        int lvt_12_1_ = lvt_10_1_ < 0 ? lvt_10_1_ - FEATURE_DISTANCE + 1 : lvt_10_1_;
        int lvt_13_1_ = lvt_11_1_ / FEATURE_DISTANCE;
        int lvt_14_1_ = lvt_12_1_ / FEATURE_DISTANCE;
        ((SharedSeedRandom)random).setLargeFeatureSeedWithSalt(generator.getSeed(), lvt_13_1_, lvt_14_1_, 10387312);
        lvt_13_1_ *= FEATURE_DISTANCE;
        lvt_14_1_ *= FEATURE_DISTANCE;
        lvt_13_1_ += random.nextInt(FEATURE_DISTANCE - FEATURE_SEPARATION);
        lvt_14_1_ += random.nextInt(FEATURE_DISTANCE - FEATURE_SEPARATION);
        return new ChunkPos(lvt_13_1_, lvt_14_1_);
    }


    @Override
    public boolean canBeGenerated(BiomeManager manager, ChunkGenerator<?> generator, Random random, int chunkX, int chunkZ, Biome biome) {
        ChunkPos chunkpos = this.getStartPositionForPosition(generator, random, chunkX, chunkZ, 0, 0);
        if (chunkX == chunkpos.x && chunkZ == chunkpos.z) {
            for(Biome biome1 : generator.getBiomeProvider().getBiomes(chunkX * 16 + 9, generator.getSeaLevel(), chunkZ * 16 + 9, 32)) {
                if (!generator.hasStructure(biome1, this)) {
                    return false;
                }
            }
            Random random1 = new Random((long)(chunkX + chunkZ * 10387313));
            Rotation rotation = Rotation.values()[random1.nextInt(Rotation.values().length)];
            int i = 5;
            int j = 5;
            if (rotation == Rotation.CLOCKWISE_90) {
                i = -5;
            } else if (rotation == Rotation.CLOCKWISE_180) {
                i = -5;
                j = -5;
            } else if (rotation == Rotation.COUNTERCLOCKWISE_90) {
                j = -5;
            }

            int k = (chunkX << 4) + 7;
            int l = (chunkZ << 4) + 7;
            int i1 = generator.func_222531_c(k, l, Heightmap.Type.WORLD_SURFACE_WG);
            int j1 = generator.func_222531_c(k, l + j, Heightmap.Type.WORLD_SURFACE_WG);
            int k1 = generator.func_222531_c(k + i, l, Heightmap.Type.WORLD_SURFACE_WG);
            int l1 = generator.func_222531_c(k + i, l + j, Heightmap.Type.WORLD_SURFACE_WG);
            int minHeight = Math.min(Math.min(i1, j1), Math.min(k1, l1));
            int maxHeight = Math.max(Math.max(i1, j1), Math.max(k1, l1));
            if (maxHeight - minHeight < 2 && maxHeight - minHeight > -2) {
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    public class Start extends MarginedStructureStart {

        public Start(Structure<?> structIn, int int_1, int int_2, MutableBoundingBox mutableBB, int int_3, long long_1) {
            super(structIn, int_1, int_2, mutableBB, int_3, long_1);
        }

        @Override
        public void init(ChunkGenerator<?> generator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn) {
            BlockPos blockpos = new BlockPos(chunkX * 16, 90, chunkZ * 16);
            ShamanHutPiece.addPieces(generator, templateManagerIn, blockpos, this.components, this.rand);
            this.recalculateStructureSize();
        }

    }

}
