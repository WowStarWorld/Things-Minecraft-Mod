package top.sw.things.loaders;

import net.minecraft.item.Item;
import net.minecraft.registry.*;

import static top.sw.things.Utils.identifier;

import top.sw.things.items.trinkets.*;

public class ItemLoader {
    public static Item WATER_BREATHING_CHARM;
    public static Item FLIGHT_CHARM;

    public ItemLoader () {
        this.load();
    }

    public void load () {
        WATER_BREATHING_CHARM = Registry.register(Registries.ITEM, identifier("water_breathing_charm"), new WaterBreathingCharm(new Item.Settings().maxCount(1)));
        FLIGHT_CHARM = Registry.register(Registries.ITEM, identifier("flight_charm"), new FlightCharm(new Item.Settings().maxCount(1)));
    }
}
