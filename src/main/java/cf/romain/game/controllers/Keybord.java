package cf.romain.game.controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Keybord implements KeyListener {

    private static HashMap<Integer, Boolean>    keys = new HashMap<Integer, Boolean>();
    public static List<ListenerKeybord>         listeners = new ArrayList<ListenerKeybord>();

    // COLLECT INFORMATIONS ABOUT LISTENER
    public void keyReleased(KeyEvent e) {
        for (ListenerKeybord l : listeners)
            l.onKeybordEvent(new Event(EventType.RELEASE, e));
        keys.put(e.getKeyCode(), false);
    }

    public void keyTyped(KeyEvent e) {
        for (ListenerKeybord l : listeners)
            l.onKeybordEvent(new Event(EventType.TYPE, e));
        keys.put(e.getKeyCode(), true);
    }

    public void keyPressed(KeyEvent e) {
        for (ListenerKeybord l : listeners)
            l.onKeybordEvent(new Event(EventType.PRESS, e));
        keys.put(e.getKeyCode(), true);
    }

    // KNOW IF A KEY IS TYPED
    public static boolean isTyped(int keycode) {
        if (!keys.containsKey(keycode)) keys.put(keycode, false);
        return keys.get(keycode);
    }


    public enum EventType {
        RELEASE,
        TYPE,
        PRESS
    }

    public class Event {

        EventType type = EventType.RELEASE;
        KeyEvent event;

        Event(EventType type, KeyEvent event) {
            this.type = type;
            this.event = event;
        }

        public EventType getType() {
            return type;
        }

        public KeyEvent getKeybordEvent() {
            return event;
        }

    }
}