package top.sw.things.loaders;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import top.sw.things.item.tools.PortableSolarGenerator;
import top.sw.things.item.trinkets.FlightCharm;
import top.sw.things.item.trinkets.WaterBreathingCharm;

import static top.sw.things.Utils.identifier;

public class ItemLoader {
    public static Item WATER_BREATHING_CHARM;
    public static Item FLIGHT_CHARM;
    public static Item PORTABLE_SOLAR_GENERATOR;
    public static BlockItem ENERGY_EXTRACTOR;

    public static boolean Loaded = false;

    public ItemLoader () {
        if (!Loaded) this.load();
    }

    public void load () {
        WATER_BREATHING_CHARM = Registry.register(Registries.ITEM, identifier("water_breathing_charm"), new WaterBreathingCharm(new Item.Settings().maxCount(1)));
        FLIGHT_CHARM = Registry.register(Registries.ITEM, identifier("flight_charm"), new FlightCharm(new Item.Settings().maxCount(1)));
        PORTABLE_SOLAR_GENERATOR = Registry.register(Registries.ITEM, identifier("portable_solar_generator"), new PortableSolarGenerator(new Item.Settings()));
        Loaded = true;
    }
}
