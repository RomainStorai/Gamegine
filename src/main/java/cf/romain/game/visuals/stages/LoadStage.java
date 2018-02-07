package cf.romain.game.visuals.stages;

import cf.romain.game.Game;
import cf.romain.game.controllers.Keybord;
import cf.romain.game.controllers.ListenerKeybord;

import java.awt.*;
import java.awt.event.KeyEvent;

public class LoadStage extends GameStage {

    private int     ticks;
    private int     alpha;

    public LoadStage() {
    }

    @Override
    public void init() {
        ticks = 0;
    }

    @Override
    public void update() {

        ticks++;
        if (this.ticks < 120)
        {
            this.alpha = ((int)(255.0D - 255.0D * (1.0D * this.ticks / 2 / 60.0D)));
            if (this.alpha < 0) {
                this.alpha = 0;
            }
        }
        if (this.ticks > 240)
        {
            this.alpha = ((int)(255.0D * (1.0D * this.ticks / 2 - 60.0D - 60.0D) / 60.0D));
            if (this.alpha > 255) {
                this.alpha = 255;
            }
        }
        if (this.ticks > 360) {
            GameStage.setGameStage(Stage.MENU, true);
        }

        if (Keybord.isTyped(KeyEvent.VK_ESCAPE))
            GameStage.setGameStage(Stage.MENU, true);
    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, Game.GAME_BOARD.getWIDTH(), Game.GAME_BOARD.getHEIGHT());
        g2d.setColor(new Color(0, 0, 0, alpha));
        g2d.fillRect(0, 0, Game.GAME_BOARD.getWIDTH(), Game.GAME_BOARD.getHEIGHT());

    }
}
