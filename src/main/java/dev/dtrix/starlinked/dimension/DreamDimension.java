package dev.dtrix.starlinked.dimension;

import dev.dtrix.starlinked.command.TeleportationTools;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.biome.provider.SingleBiomeProvider;
import net.minecraft.world.biome.provider.SingleBiomeProviderSettings;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.OverworldChunkGenerator;
import net.minecraft.world.gen.OverworldGenSettings;

import javax.annotation.Nullable;

public class DreamDimension extends Dimension {

    private static final BlockPos SPAWN = new BlockPos(0, 30, 0);

    public DreamDimension(World world, DimensionType dimensionType) {
        super(world, dimensionType, 0.0f);
    }

    @Override
    public ChunkGenerator<?> createChunkGenerator() {
        //return new OverworldChunkGenerator(world, new SingleBiomeProvider(new SingleBiomeProviderSettings(world.getWorldInfo())), new OverworldGenSettings());
        return new DreamChunkGenerator(world, new SingleBiomeProvider(new SingleBiomeProviderSettings(world.getWorldInfo())));
    }

    @Nullable
    @Override
    public BlockPos getSpawnCoordinate() {
        return SPAWN;
    }

    @Nullable
    @Override
    public BlockPos findSpawn(ChunkPos chunkPosIn, boolean checkValid) {
        return null;
    }

    @Nullable
    @Override
    public BlockPos findSpawn(int posX, int posZ, boolean checkValid) {
        return null;
    }

    @Override
    public float calculateCelestialAngle(long worldTime, float partialTicks) {
        double d0 = MathHelper.frac((double)worldTime / 24000.0D - 0.25D);
        double d1 = 0.5D - Math.cos(d0 * Math.PI) / 2.0D;
        return (float)(d0 * 2.0D + d1) / 3.0F;
    }

    @Override
    public boolean isSurfaceWorld() {
        return true;
    }

    @Override
    public Vec3d getFogColor(float celestialAngle, float partialTicks) {
        return new Vec3d(1, 1, 1);
    }

    @Override
    public boolean canRespawnHere() {
        return false;
    }

    @Override
    public boolean doesXZShowFog(int x, int z) {
        return true;
    }

    @Override
    public boolean isDaytime() {
        return true;
    }

    @Override
    public void tick() {
        if(this.getWorldTime() >= 12000)  {
            this.world.getServer().getPlayerList().getPlayers().forEach(player -> {
                TeleportationTools.teleport(player, DimensionType.OVERWORLD, getOverworldSpawnpoint(player));
            });
        }
    }

    public BlockPos getOverworldSpawnpoint(PlayerEntity player) {
        return player.getBedLocation(DimensionType.OVERWORLD) != null ? player.getBedLocation(DimensionType.OVERWORLD) : this.getWorld().getServer().getWorld(DimensionType.OVERWORLD).getSpawnPoint();
    }
}
