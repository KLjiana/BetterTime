package org.hediacamellia.bettertime.core.config;

import net.minecraft.client.gui.screens.Screen;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

public class ScreenProvider implements IConfigScreenFactory {
    @Override
    public Screen createScreen(ModContainer modContainer, Screen screen) {
        return new ConfigScreen();
    }
}
