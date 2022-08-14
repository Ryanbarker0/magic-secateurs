package com.magicsecateurs;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("magic-secateurs")
public interface MagicSecateursConfig extends Config
{
    @ConfigItem(
            keyName = "showMagicSecateursWarning",
            name = "Enable Magic Secateurs Warning",
            description = "Configured whether or not to display Magic Secateurs warning overlay",
            position = 1
    )
    default boolean showMagicSecateursWarning()
    {
        return true;
    }
}
