package top.sw.things;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.sw.things.loaders.ItemGroupLoader;
import top.sw.things.loaders.ItemLoader;

public class Things implements ModInitializer {

    public static final String ModID = Utils.ModID;
    public static final Logger Logger = LoggerFactory.getLogger(Things.ModID);

    public ItemLoader ItemLoader;
    public ItemGroupLoader ItemGroupLoader;

    @Override
    public void onInitialize () {
        Things.Logger.info("Loading");
        this.ItemLoader = new ItemLoader();
        this.ItemGroupLoader = new ItemGroupLoader();
    }

}