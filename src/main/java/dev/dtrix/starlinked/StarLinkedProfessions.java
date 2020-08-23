package dev.dtrix.starlinked;

import com.google.common.collect.ImmutableSet;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;
import net.minecraft.village.PointOfInterestType;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

public class StarLinkedProfessions {

    private static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(ForgeRegistries.PROFESSIONS, StarLinked.MODID);

    public static final RegistryObject<VillagerProfession> SHAMAN_PROFESSION = PROFESSIONS.register("shaman", () -> new VillagerProfession( "shaman", PointOfInterestType.FARMER, ImmutableSet.of(), ImmutableSet.of(), null));

    public static void init() {
        PROFESSIONS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {

        @SubscribeEvent
        public static void villagerTrades(VillagerTradesEvent event) {
            if(event.getType().equals(SHAMAN_PROFESSION.get())) {
                event.getTrades().get(1).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 16), new ItemStack(StarLinkedItems.DREAM_CATCHER.get()), 8, 10, 0F));
            }
        }

    }


}
