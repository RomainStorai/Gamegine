package cf.romain.game;

import cf.romain.game.controllers.Keybord;
import cf.romain.game.controllers.Mouse;
import cf.romain.game.controllers.WindowMotion;
import cf.romain.game.data.Logs;
import cf.romain.game.visuals.GameBoard;
import cf.romain.game.visuals.stages.GameStage;

import javax.swing.*;
import java.awt.*;

public class Game {

    public static Logs      LOGS;

    public static GameBoard GAME_BOARD;
    public static JFrame    FRAME;

    public static void main(String[] args) {
        LOGS = new Logs();
        GAME_BOARD = new GameBoard(800, 600);

        // Launch Frame
        FRAME = createFrame(GAME_BOARD);

        // Prepare the game
        GameStage.setGameStage(GameStage.Stage.LOADING, true);

        // Start looping
        GAME_BOARD.ready();
    }

    private static JFrame createFrame(JPanel gamepanel) {
        // Try to use OpenGL
        System.setProperty("sun.java2d.opengl", "true");

        // Frame
        JFrame frame = new JFrame("GameBase");
        frame.setSize(new Dimension(800,600));
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);
        frame.add(gamepanel);

        // Adding listeners
        frame.addKeyListener(new Keybord());
        frame.addMouseListener(new Mouse());

        // Move window
        WindowMotion motion = new WindowMotion(frame, gamepanel);
        frame.addMouseListener(motion);
        frame.addMouseMotionListener(motion);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);

        return frame;
    }
}
