package com.magicsecateurs;

import java.awt.*;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;

import net.runelite.api.*;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.LineComponent;


class MagicSecateursOverlay extends OverlayPanel {

    private final Client client;
    private final MagicSecateursConfig config;
    private final MagicSecateursPlugin plugin;


    @Inject
    private MagicSecateursOverlay(Client client, MagicSecateursConfig config, MagicSecateursPlugin plugin) {
        super(plugin);
        this.plugin = plugin;
        this.client = client;
        this.config = config;

        setPosition(OverlayPosition.TOP_CENTER);
        setPriority(OverlayPriority.MED);
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        final ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);
        final ItemContainer equipment = client.getItemContainer(InventoryID.EQUIPMENT);

        if (equipment != null && equipment.contains(ItemID.MAGIC_SECATEURS)) {
            return super.render(graphics);
        }

        if (inventory != null && inventory.contains(ItemID.MAGIC_SECATEURS)) {

            final String text = "Equip Secateurs!";
            final Color color = config.magicSecateursTextColor();
            final float size = (float) config.magicSecateursTextSize();
            final Font font = graphics.getFont().deriveFont(size);

            panelComponent.getChildren().add(LineComponent.builder()
                    .left(text)
                    .leftFont(font)
                    .leftColor(color)
                    .build());
        }
        return super.render(graphics);
    }
}
