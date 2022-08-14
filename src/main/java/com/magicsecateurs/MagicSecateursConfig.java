package com.magicsecateurs;

import java.awt.Color;

import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

import static com.magicsecateurs.MagicSecateursPlugin.MAX_FONT_SIZE;

@ConfigGroup("magic-secateurs")
public interface MagicSecateursConfig extends Config {

    @Alpha
    @ConfigItem(
            keyName = "magicSecateursTextColor",
            name = "Text color",
            description = "Configures the color of the secateurs warning text",
            position = 1
    )
    default Color magicSecateursTextColor() {
        return Color.RED;
    }

    @Range(
            max = MAX_FONT_SIZE
    )
    @ConfigItem(
            keyName = "magicSecateursTextSize",
            name = "Text size",
            description = "Configures the size of the secateurs warning text",
            position = 2
    )
    default int magicSecateursTextSize() {
        return 16;
    }


}
