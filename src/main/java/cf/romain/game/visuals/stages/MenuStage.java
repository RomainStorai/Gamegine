package cf.romain.game.visuals.stages;

import com.sun.org.apache.regexp.internal.RE;

import java.awt.*;

public class MenuStage extends GameStage {

    @Override
    public void init() {

    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.setColor(Color.RED);
        Rectangle rect2 = new Rectangle(100, 100, 20, 20);

        g2d.rotate(Math.toRadians(15));
        g2d.draw(rect2);
        g2d.fill(rect2);
    }
}
