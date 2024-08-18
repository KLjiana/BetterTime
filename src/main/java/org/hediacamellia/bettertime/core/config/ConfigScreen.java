package org.hediacamellia.bettertime.core.config;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.HashMap;
import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class ConfigScreen extends Screen {

    EditBox dateX;
    EditBox dateY;
    EditBox dateColor;

    public ConfigScreen() {
        super(Component.translatable("config.bettertime.title"));
    }

    @Override
    protected void init() {
        super.init();

        //this.addRenderableWidget(new EditBox(this.font, this.width  - 60, this.height -40,40,20, Component.empty()));

        this.addRenderableWidget(new Button.Builder(Component.literal(Config.showDateHud.get().toString()),e -> {
            Config.showDateHud.set(!Config.showDateHud.get());
            e.setMessage(Component.literal(Config.showDateHud.get().toString()));
        }).bounds(this.width - 60, 60,40,15)
                .tooltip(Tooltip.create(Component.translatable("config.bettertime.showDateHud.desc"))).build());

        this.addRenderableWidget(new Button.Builder(Component.literal(Config.showDayTitle.get().toString()),e -> {
            Config.showDayTitle.set(!Config.showDayTitle.get());
            e.setMessage(Component.literal(Config.showDayTitle.get().toString()));
        }).bounds(this.width - 60, 80,40,15)
                .tooltip(Tooltip.create(Component.translatable("config.bettertime.showDayTitle.desc"))).build());


        this.addRenderableWidget(new Button.Builder(Component.translatable("config.bettertime.comfirm"),e -> {
            onClose();
        }).bounds(this.width/2 - 20  , this.height-30,40,15).build());

        dateX = new EditBox(this.font, this.width  - 60, 100,40,15, Component.literal(Config.dateX.get().toString()));
        dateY = new EditBox(this.font, this.width  - 60, 120,40,15, Component.literal(Config.dateY.get().toString()));
        dateColor = new EditBox(this.font, this.width  - 60, 140,40,15, Component.literal(Config.dateColor.get().toString()));
        dateX.setMaxLength(10);
        dateY.setMaxLength(10);
        dateColor.setMaxLength(10);
        dateX.setValue(Config.dateX.get().toString());
        dateY.setValue(Config.dateY.get().toString());
        dateColor.setValue(Config.dateColor.get().toString());
        this.addRenderableWidget(dateX);
        this.addRenderableWidget(dateY);
        this.addRenderableWidget(dateColor);
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(graphics,mouseX,mouseY,partialTick);
        super.render(graphics, mouseX, mouseY, partialTick);
        int h = graphics.guiHeight();
        int w = graphics.guiWidth();

        String titleStr = Component.translatable("config.bettertime.title").getString();
        graphics.drawString(this.font, titleStr, w / 2 - font.width(titleStr) / 2,  20, 0xFFFFFF,false);

        String showDateHud = Component.translatable("config.bettertime.showDateHud").getString();
        graphics.drawString(this.font, showDateHud, 20,  60, 0xFFFFFF,false);
        String showDayTitle = Component.translatable("config.bettertime.showDayTitle").getString();
        graphics.drawString(this.font, showDayTitle, 20,  80, 0xFFFFFF,false);
        String dateX = Component.translatable("config.bettertime.dateX").getString();
        graphics.drawString(this.font, dateX, 20,  100, 0xFFFFFF,false);
        String dateY = Component.translatable("config.bettertime.dateY").getString();
        graphics.drawString(this.font, dateY, 20,  120, 0xFFFFFF,false);
        String dateColor = Component.translatable("config.bettertime.dateColor").getString();
        graphics.drawString(this.font, dateColor, 20,  140, 0xFFFFFF,false);
    }

    @Override
    public void onClose() {
        super.onClose();
        Config.dateX.set(Integer.valueOf(dateX.getValue()));
        Config.dateY.set(Integer.valueOf(dateY.getValue()));
        Config.dateColor.set(Integer.valueOf(dateColor.getValue()));

    }

    private Map<Map<Integer,Integer>,String> map = new HashMap<>();
}
