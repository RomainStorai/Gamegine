package cf.romain.game.controllers;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class Mouse implements MouseListener {

    public static List<ListenerMouse> listeners = new ArrayList<ListenerMouse>();


    public void mouseEvent(Event e) {
        for (ListenerMouse mouse : listeners) mouse.onMouseEvent(e);
    }

    public static Point getPoint() {
        return MouseInfo.getPointerInfo().getLocation();
    }

    public static boolean isInside(Rectangle r) {
        return r.contains(getPoint());
    }

    // Collecting events from listener
    public void mouseClicked(MouseEvent e) {
        mouseEvent(new Event(EventType.CLICK, e));
    }

    public void mouseEntered(MouseEvent e) {
        mouseEvent(new Event(EventType.ENTER, e));
    }

    public void mouseExited(MouseEvent e) {
        mouseEvent(new Event(EventType.EXIT, e));
    }

    public void mousePressed(MouseEvent e) {
        mouseEvent(new Event(EventType.PRESS, e));
    }

    public void mouseReleased(MouseEvent e) {
        mouseEvent(new Event(EventType.RELEASE, e));
    }

    public enum EventType {
        CLICK,
        ENTER,
        EXIT,
        PRESS,
        RELEASE;
    }

    public class Event {

        EventType type = EventType.CLICK;
        MouseEvent event;

        Event(EventType type, MouseEvent event) {
            this.type = type;
            this.event = event;
        }

        public EventType getType() {
            return type;
        }

        public MouseEvent getMouseEvent() {
            return event;
        }

    }

}