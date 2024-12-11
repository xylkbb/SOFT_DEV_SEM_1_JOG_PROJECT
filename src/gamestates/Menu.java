package gamestates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import main.Game;
import ui.MenuButton;
import utilz.LoadSave;

public class Menu extends State implements Statemethods {
    private MenuButton[] buttons = new MenuButton[3];
    private BufferedImage backgroundImg;
private int menuX;
private int menuY;
private int menuWidth;
private int menuHeight;
    // TODO: all fields are private
    // TODO: create a MenuButton[] called buttons and set to new MenuButton[3]
    // TODO: create a Buffered image called backgroundImg.
    // TODO: create ints for menuX, menuY, menuWidth, menuHeight

    public Menu(Game game) {
		super(game);
		loadButtons();
		loadBackground();
        // TODO: call super passing in game
        // TODO: call loadButtons()
        // TODO: call loadBackground();
    }

    private void loadBackground() {
		backgroundImg = LoadSave.GetSpriteAtlas(LoadSave.MENU_BACKGROUND);
		menuWidth = (int) (backgroundImg.getWidth()  * Game.SCALE);
		menuHeight = (int) (backgroundImg.getHeight() * Game.SCALE);
		menuX = Game.GAME_WIDTH / 2 - menuWidth / 2;
		menuY = (int) (45 * Game.SCALE);

        // TODO: set backgroundImg to LoadSave.GetSpriteAtlas(LoadSave.MENU_BACKGROUND)0
        // TODO: set menuWidth to (int) (backgroundImg.getWidth()  * Game.SCALE
        // TODO: set menuHeight to (int) (backgroundImg.getHeight() * Game.SCALE
        // TODO: set menuX to Game.GAME_WIDTH / 2 - menuWidth / 2
        // TODO: set menuY to )(int) (45 * Game.SCALE
    }

    private void loadButtons() {
		buttons[0] = new MenuButton(Game.GAME_WIDTH / 2, (int) (150 * Game.SCALE), 0, Gamestate.PLAYING);
		buttons[1] = new MenuButton(Game.GAME_WIDTH / 2, (int) (220 * Game.SCALE), 1, Gamestate.OPTIONS);
		buttons[2] = new MenuButton(Game.GAME_WIDTH / 2, (int) (290 * Game.SCALE), 1, Gamestate.QUIT);
        // TODO: set buttons[0] to new MenuButton(Game.GAME_WIDTH / 2, (int) (150 * Game.SCALE), 0, Gamestate.PLAYING)
        // TODO: set buttons[1] to new MenuButton(Game.GAME_WIDTH / 2, (int) (220 * Game.SCALE), 1, Gamestate.OPTIONS)
        // TODO: set buttons[2] to new MenuButton(Game.GAME_WIDTH / 2, (int) (290 * Game.SCALE), 1, Gamestate.QUIT)
    }

    @Override
    public void update() {
        // TODO: this is an enhanced for loop or a foreach loop
        for (MenuButton mb : buttons)
            mb.update();
    }

    @Override
    public void draw(Graphics g) {
		g.drawImage(backgroundImg, menuX, menuY, menuWidth, menuHeight, null);
		for (MenuButton mb : buttons)
			mb.draw(g);

        // TODO: g.drawImage passing in
        // backgroundImg, menuX, menuY, menuWidth, menuHeight, null
        // TODO: for each MenuButton mb in loadButtons()
        // TODO: call mb.draw(g)
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
		for (MenuButton mb : buttons)
			if (isIn(e, mb)){
				mb.setMousePressed(true);
			}
        // TODO: for each MenuButton mb in buttons
        // TODO: if isIn(e, mb) then call mb.setMousePressed(true)
    }

    @Override
    public void mouseReleased(MouseEvent e) {
		for (MenuButton mb : buttons)
			if (isIn(e, mb)){
				if (mb.isMousePressed()){
					mb.applyGamestate();
					break;
				}
				resetButtons();
			}
        // TODO: foreach MenuButton mb  in buttons
        // TODO: if isIn(e, mb) then if (mb.isMousePressed()) call mb.applyGameState() and break
        // TODO: call resetButtons()

    }

    private void resetButtons() {
		for (MenuButton mb : buttons)
			mb.resetBools();
        // TODO: for each MenuButton mb in buttons
        // TODO: call mb.resetBools()
    }

    @Override
    public void mouseMoved(MouseEvent e) {
		for (MenuButton mb : buttons)
			mb.setMouseOver(false);

		for (MenuButton mb : buttons)
			if (isIn(e, mb)){
				mb.setMouseOver(false);
				break;
			}
        // TODO: for each MenuButton mb in buttons
        // TODO: call mb.setMouseOver(false)

        // TODO: for each MenuButton mb in buttons
        // TODO: if isIn(e, mb) then call mb.setMouseOver(false) and then break;

    }

    @Override
    public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER){
			Gamestate.state = Gamestate.PLAYING;
		}
        // TODO: if e.getKeyCode() is equal to KeyEvent.VK_ENTER then set Gamestate.state to GameState.Playing
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

}