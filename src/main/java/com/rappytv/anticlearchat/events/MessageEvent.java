package com.rappytv.anticlearchat.events;

import com.rappytv.anticlearchat.AntiChatClearAddon;
import net.labymod.api.events.MessageReceiveEvent;

public class MessageEvent implements MessageReceiveEvent {

    @Override
    public boolean onReceive(String s, String s1) {
        return AntiChatClearAddon.getMain().enabled && s1.trim().isEmpty();
    }
}