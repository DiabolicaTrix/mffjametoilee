package dev.dtrix.starlinked.structure;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import dev.dtrix.starlinked.StarLinked;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.jigsaw.JigsawPiece;
import net.minecraft.world.gen.feature.jigsaw.SingleJigsawPiece;
import net.minecraft.world.gen.feature.structure.AbstractVillagePiece;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.template.*;

import java.util.List;

public class ShamanHutPiece {

    public static void addPieces(ChunkGenerator<?> p_215139_0_, TemplateManager p_215139_1_, BlockPos p_215139_2_, List<StructurePiece> p_215139_3_, SharedSeedRandom p_215139_4_) {
        JigsawManager.addPieces(new ResourceLocation("shaman_hut/shaman_hut"), 4, ShamanHutPiece.ShamanHut::new, p_215139_0_, p_215139_1_, p_215139_2_, p_215139_3_, p_215139_4_);
    }

    static {
        JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation("shaman_hut/shaman_hut"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(new SingleJigsawPiece(new ResourceLocation(StarLinked.MODID,"shaman_hut/shaman_hut").toString()), 1)), JigsawPattern.PlacementBehaviour.RIGID));
    }

    public static class ShamanHut extends AbstractVillagePiece {
        public ShamanHut(TemplateManager p_i50560_1_, JigsawPiece p_i50560_2_, BlockPos p_i50560_3_, int p_i50560_4_, Rotation p_i50560_5_, MutableBoundingBox p_i50560_6_) {
            super(StarlinkedStructures.SHAMAN_HUT_PIECE, p_i50560_1_, p_i50560_2_, p_i50560_3_, p_i50560_4_, p_i50560_5_, p_i50560_6_);
        }

        public ShamanHut(TemplateManager p_i50561_1_, CompoundNBT p_i50561_2_) {
            super(p_i50561_1_, p_i50561_2_, StarlinkedStructures.SHAMAN_HUT_PIECE);
        }
    }

}
