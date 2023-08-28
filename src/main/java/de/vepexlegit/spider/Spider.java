package de.vepexlegit.spider;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Spider.MODID, version = Spider.VERSION)
public class Spider {
    public static final String MODID = "spider";
    public static final String VERSION = "1.0";

    public void init(FMLInitializationEvent event) {
        System.out.println("DIRT BLOCK >> " + Blocks.dirt.getUnlocalizedName());
    }
}
