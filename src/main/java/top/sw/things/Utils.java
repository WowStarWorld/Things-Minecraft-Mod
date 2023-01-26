package top.sw.things;

import net.minecraft.util.Identifier;

public class Utils {

    public static final String ModID = "things";

    public static Identifier identifier (String path) {
        return Identifier.of(ModID, path);
    }
}
