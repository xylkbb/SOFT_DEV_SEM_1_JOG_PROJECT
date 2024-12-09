package main;

import java.awt.Graphics;

import gamestates.Gamestate;
import gamestates.Menu;
import gamestates.Playing;

public class Game implements Runnable {

    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int FPS_SET = 120;
    private final int UPS_SET = 200;
    private Playing playing;
    private Menu menu;
    // TODO: create a private field of type Playing named playing.
    // TODO: create a private field of type Menu named menu

    public static int TILES_DEFAULT_SIZE = 32;
    public static float SCALE = 2f;
    public static int TILES_IN_WIDTH = 26;
    public static int TILES_IN_HEIGHT = 14;
    public static int TILES_SIZE = (int) (TILES_DEFAULT_SIZE * SCALE);
    public static int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
    public static int GAME_HEIGHT = TILES_SIZE * TILES_IN_WIDTH;
    // TODO: create public final static fields of the following name and value (these are some extra constants)
    // TODO: int TILES_DEFAULT_SIZE set to 32
    // TODO: float SCALE set to 2f
    // TODO: int TILES_IN_WIDTH set to 26
    // TODO: int TILES_IN_HEIGHT set to 14
    // TODO: int TILES_SIZE set to (int) (TILES_DEFAULT_SIZE * SCALE)
    // TODO: int GAME_WIDTH set to TILES_SIZE * TILES_IN_WIDTH
    // TODO: int GAME_HEIGHT set to TILES_SIZE * TILE_IN_HEIGHT

    public Game() {
        initClasses();

        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();

        startGameLoop();

    }

    private void initClasses() {
        menu = new Menu(this);
        playing = new Playing(this);
        // TODO: set menu to new Menu passing in this
        // TODO: set playing to new Playing passing in this
    }

    private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void update() {
        switch (Gamestate.state) {
            case MENU:
                menu.update();
                // TODO: call menu.update()
                break;
            case PLAYING:
                playing.update();
                // TODO: call playing.update()
                break;
            case OPTIONS:
            case QUIT:
            default:
                System.exit(0);
                // TODO: call System.exit passing in 0
                break;
        }
    }

    public void render(Graphics g) {
        switch (Gamestate.state) {
            case MENU:
                menu.draw(g);
                // TODO: call menu.draw passing in g
                break;
            case PLAYING:
                playing.draw(g);
                // TODO: call playing.draw passing in g
                break;
            default:
                break;
        }
    }

    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;

        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;

        while (true) {
            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if (deltaU >= 1) {
                update();
                updates++;
                deltaU--;
            }

            if (deltaF >= 1) {
                gamePanel.repaint();
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;

            }
        }

    }

    public void windowFocusLost() {
        if (Gamestate.state == Gamestate.PLAYING){
            playing.getPlayer().resetDirBooleans();
        }
        // TODO: if Gamestate.state is equal to Gamestate.PLAYING
        // TODO: call playing.getPlayer().resetDirBoolean()
    }

    public Menu getMenu() {
        return menu;
    }

    public Playing getPlaying() {
        return playing;
    }
}