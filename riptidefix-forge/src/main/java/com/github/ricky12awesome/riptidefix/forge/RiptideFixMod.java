package com.github.ricky12awesome.riptidefix.forge;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("riptide_fix")
public class RiptideFixMod {
    private static final Logger LOGGER = LogManager.getLogger();
    public static boolean ENABLED = true;

    public RiptideFixMod() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    void setup(final FMLClientSetupEvent event) {
        LOGGER.warn("[Riptide Fix] Client-Side command to toggle mod doesn't not work in forge yet.");
    }
}
