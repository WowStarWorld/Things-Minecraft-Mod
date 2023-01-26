package top.sw.things.loaders;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;


import static top.sw.things.Utils.identifier;

public class ItemGroupLoader {
    public static ItemGroup THINGS_GROUP;
    public static Item[] THINGS_GROUP_ITEMS = {ItemLoader.WATER_BREATHING_CHARM, ItemLoader.FLIGHT_CHARM};

    public ItemGroupLoader () {
        this.load();
        this.putItems();
    }

    public void putItems () {
        ItemGroupEvents.modifyEntriesEvent(THINGS_GROUP).register(
            content -> {
                for (Item thingsGroupItem : THINGS_GROUP_ITEMS) {
                    content.add(thingsGroupItem);
                }
            }
        );
    }
    public void load () {
        THINGS_GROUP = FabricItemGroup.builder(
            identifier("item_group")
        ).icon(
            () -> new ItemStack(ItemLoader.WATER_BREATHING_CHARM)
        ).build();
    }
}
