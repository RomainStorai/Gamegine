package cf.romain.game.visuals;

import cf.romain.game.Game;
import cf.romain.game.visuals.stages.GameStage;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameBoard extends JPanel {

    private boolean active = true;

    int                     fps = 0;
    private int             frames = 0;
    private long            counter;

    int                     HEIGHT = 600, WIDTH = 800;

    private BufferedImage   back_screen;
    private Graphics2D      renderer;

    public GameBoard(int WIDTH, int HEIGHT) {
        this.HEIGHT = HEIGHT;
        this.WIDTH = WIDTH;

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();

        // Initializing Back Screen
        back_screen = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        renderer = back_screen.createGraphics();
        renderer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        counter = System.currentTimeMillis();

        // Parameters
        setOpaque(false);
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public double currentFPS() {
        return fps;
    }

    public boolean isActive() {
        return active;
    }

    public boolean kill() {
        return active = false;
    }

    public void ready() {
        while (active) {

            GameStage.updateStage();
            GameStage.renderStage(renderer);

            Graphics g2 = getGraphics();
            g2.drawImage(back_screen, 0, 0, WIDTH, HEIGHT, null);
            g2.dispose();
            frames++;

            // FRAMERATES
            if (System.currentTimeMillis() - counter > 1000) {
                fps = frames;
                frames = 0;
                counter = System.currentTimeMillis();
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                String error = "[Error :: 1!] Can't sleep main thread.\n"
                        + "-    Reference:   GameBoard - loop.";
                Game.LOGS.log(error);
                System.out.println(error);
            }
        }
    }
}
