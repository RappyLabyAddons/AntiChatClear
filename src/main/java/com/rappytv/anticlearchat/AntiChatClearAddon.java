package com.rappytv.anticlearchat;

import com.rappytv.anticlearchat.events.MessageEvent;
import net.labymod.api.LabyModAddon;
import net.labymod.settings.elements.BooleanElement;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Consumer;
import net.labymod.utils.Material;

import java.util.List;

public class AntiChatClearAddon extends LabyModAddon {

    public boolean enabled = true;
    public static AntiChatClearAddon instance;

    public static AntiChatClearAddon getMain() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        getApi().getEventManager().register(new MessageEvent());
    }

    @Override
    public void loadConfig() {
        enabled = getConfig().has("enabled") ? getConfig().get("enabled").getAsBoolean() : enabled;
    }

    @Override
    protected void fillSettings(List<SettingsElement> list) {
        BooleanElement enabledEl = new BooleanElement("Enabled", new ControlElement.IconData(Material.LEVER), new Consumer<Boolean>() {

            @Override
            public void accept(Boolean accepted) {
                enabled = accepted;

                getConfig().addProperty("enabled", enabled);
                saveConfig();
            }

        }, true);

        list.add(enabledEl);
    }
}