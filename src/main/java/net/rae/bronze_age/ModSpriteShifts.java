package net.rae.bronze_age;

import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import com.simibubi.create.foundation.block.connected.CTType;


public class ModSpriteShifts {
    private static CTSpriteShiftEntry omni(String name) {
        return getCT(AllCTTypes.OMNIDIRECTIONAL, name);
    }
    public static final CTSpriteShiftEntry BRONZE_CASING = omni("bronze_casing");
    private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName, String connectedTextureName) {
        return CTSpriteShifter.getCT(type, BronzeAge.asResource("block/" + blockTextureName),
                BronzeAge.asResource("block/" + connectedTextureName + "_connected"));
    }
    private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName) {
        return getCT(type, blockTextureName, blockTextureName);
    }
}
