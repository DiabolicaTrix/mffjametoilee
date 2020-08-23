package dev.dtrix.starlinked.entity;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;

public class ShamanEntity extends CreatureEntity {

    public ShamanEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
    }

}
