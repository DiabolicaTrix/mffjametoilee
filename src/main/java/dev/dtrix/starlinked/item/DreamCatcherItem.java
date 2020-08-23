package dev.dtrix.starlinked.item;

import dev.dtrix.starlinked.StarlinkedBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class DreamCatcherItem extends BlockItem {

    public DreamCatcherItem() {
        super(StarlinkedBlocks.DREAM_CATCHER.get(), new Item.Properties().maxStackSize(1));
    }

}
