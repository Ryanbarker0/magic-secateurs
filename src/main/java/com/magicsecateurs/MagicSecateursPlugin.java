package com.magicsecateurs;

import javax.inject.Inject;

import com.google.inject.Provides;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
        name = "Magic Secateurs",
        description = "Highlight when magic secateurs aren't equipped on a farming run",
        tags = {"overlay", "skilling"}
)

public class MagicSecateursPlugin extends Plugin {
    @Inject
    private MagicSecateursOverlay overlay;

    @Inject
    private OverlayManager overlayManager;

    @Provides
    MagicSecateursConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(MagicSecateursConfig.class);
    }


    @Override
    public void startUp() {
        overlayManager.add(overlay);
    }

    @Override
    public void shutDown() {
        overlayManager.remove(overlay);
    }
}