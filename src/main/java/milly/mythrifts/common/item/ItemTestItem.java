package milly.mythrifts.common.item;

import milly.mythrifts.MythRifts;
import milly.mythrifts.common.lib.ItemNames;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemTestItem extends Item {

    public ItemTestItem() {
        this.setUnlocalizedName(ItemNames.TEST_ITEM);
        this.setRegistryName(new ResourceLocation(MythRifts.MODID, ItemNames.TEST_ITEM));
    }
}
