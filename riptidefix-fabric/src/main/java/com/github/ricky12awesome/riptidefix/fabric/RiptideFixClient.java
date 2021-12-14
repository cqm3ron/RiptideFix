package com.github.ricky12awesome.riptidefix.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class RiptideFixClient implements ClientModInitializer {
    public static boolean ENABLED = true;

    @Override
    public void onInitializeClient() {
        if (FabricLoader.getInstance().isModLoaded("fabric")) {
            com.github.ricky12awesome.riptidefix.fabric.fabricapi.RegisterToggleCommand.Register();
        }
    }
}
