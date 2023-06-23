package net.rae.bronze_age.registry;

import static net.rae.bronze_age.BronzeAge.REGISTRATE;

public class ModLang {
    static {
        customLang("fluid_type.bronze_age.molten_bronze_fluid","Molten Bronze");
        customLang("itemGroup.cooltab","Create: Bronze Age");
    }
    public static void customLang(String key, String value) {
        REGISTRATE.addRawLang(key,value);
    }
}
