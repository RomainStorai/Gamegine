package cf.romain.game.visuals.stages;

import cf.romain.game.Game;

import java.awt.*;

public abstract class GameStage {

    public static Stage     gamestage = Stage.LOADING;

    public static void setGameStage(Stage stage, boolean reset) {
        gamestage = stage;
        if (reset) stage.getStage().init();
    }

    public static void renderStage(Graphics2D g2d) {
        gamestage.getStage().render(g2d);
        g2d.setColor(Color.MAGENTA);
        g2d.drawString(Game.GAME_BOARD.currentFPS() + " FPS", 50, 50);
    }

    public static void updateStage() {
        gamestage.getStage().update();
    }


    public abstract void init();
    public abstract void update();
    public abstract void render(Graphics2D g2d);

    public enum Stage {

        LOADING(new LoadStage()),
        MENU(new MenuStage()),
        SETTINGS(new SettingsStage()),
        PLAY(new PlayStage());

        private GameStage stage;

        Stage(GameStage stage) {
            this.stage = stage;
        }

        public GameStage getStage() {
            return stage;
        }
    }
}
