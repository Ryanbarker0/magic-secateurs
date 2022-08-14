package com.magicsecateurs;

import java.awt.*;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;

import net.runelite.api.*;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.TitleComponent;


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

        setLayer(OverlayLayer.ABOVE_SCENE);
        setPosition(OverlayPosition.DYNAMIC);
        setPriority(OverlayPriority.MED);
        panelComponent.setPreferredSize(new Dimension(150, 0));
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        final ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);
        final ItemContainer equipment = client.getItemContainer(InventoryID.EQUIPMENT);


        if (config.showMagicSecateursWarning()) {
            if (equipment != null && equipment.contains(ItemID.MAGIC_SECATEURS)) {
                return null;
            }

            if (inventory != null && inventory.contains(ItemID.MAGIC_SECATEURS)) {

                final String text = "Equip Secateurs!";
                final int textWidth = graphics.getFontMetrics().stringWidth(text);
                final int textHeight = graphics.getFontMetrics().getAscent() - graphics.getFontMetrics().getDescent();
                final int width = (int) client.getRealDimensions().getWidth();
                java.awt.Point jPoint = new java.awt.Point((width / 2) - textWidth, textHeight + 75);
                panelComponent.getChildren().clear();
                panelComponent.getChildren().add(TitleComponent.builder().text(text).color(Color.RED).build());
                panelComponent.setPreferredLocation(jPoint);
                return panelComponent.render(graphics);
            }
        }
        return null;
    }
}
