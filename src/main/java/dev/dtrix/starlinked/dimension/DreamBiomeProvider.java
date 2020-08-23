package dev.dtrix.starlinked.dimension;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.feature.structure.Structure;

import java.util.Set;

public class DreamBiomeProvider extends BiomeProvider {

    protected DreamBiomeProvider(Set<Biome> biomesIn) {
        super(biomesIn);
    }

    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return null;
    }

    @Override
    public boolean hasStructure(Structure<?> structureIn) {
        return false;
    }


}
