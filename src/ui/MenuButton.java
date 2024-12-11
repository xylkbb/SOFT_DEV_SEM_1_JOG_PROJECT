package ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import gamestates.Gamestate;
import utilz.LoadSave;

import static utilz.Constants.UI.Buttons.*;

public class MenuButton {
    private int xPos;
    private int yPos;
    private int rowIndex;
    private int index;
    private int xOffsetCenter = B_WIDTH / 2;
    private Gamestate state;
    private BufferedImage[] imgs;
    private boolean mouseOver;
    private boolean mousePressed;
    private Rectangle bounds;
    // TODO: create private fields
    // TODO: int xPos, yPos, rowIndex, index
    // TODO: xOffsetCenter set to B_WIDTH / 2
    // TODO: Gamestate called state
    // TODO: BufferedImage[] imgs
    // TODO: boolean mouseOver, mousePressed
    // TODO: Rectangle bounds

    public MenuButton(int xPos, int yPos, int rowIndex, Gamestate state) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.rowIndex = rowIndex;
		this.state = state;
		loadImgs();
		initBounds();
        // TODO: set this xPos to xPos
        // TODO: set this yPos to yPos
        // TODO: set this rowIndex to rowIndex
        // TODO: set this state to state
        // TODO: call loadImgs()
        // TODO: call initBounds()
    }

    private void initBounds() {
		bounds = new Rectangle(xPos - xOffsetCenter, yPos, B_WIDTH, B_HEIGHT);
        // TODO: set bounds to newRectangle(xPos - xOffsetCenter, yPos, B_WIDTH, B_HEIGHT)
    }

    private void loadImgs() {
        imgs = new BufferedImage[3];
        BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.MENU_BUTTONS);
        // TODO: set img to new BufferedImage[3];
        // TODO: create a BufferedImage called temp and set to LoadSave.GetSpriteAtlas(LoadSave.MENU_BUTTONS)
        for (int i = 0; i < imgs.length; i++)
            imgs[i] = temp.getSubimage(i * B_WIDTH_DEFAULT, rowIndex * B_HEIGHT_DEFAULT, B_WIDTH_DEFAULT, B_HEIGHT_DEFAULT);
    }

    public void draw(Graphics g) {
        g.drawImage(imgs[index], xPos - xOffsetCenter, yPos, B_WIDTH, B_HEIGHT, null);
        // TODO: call g.drawImage passing in
        // TODO: imgs[index], xPos - xOffsetCenter, yPos, B_WIDTH, B_HEIGHT, null)

    }

    public void update() {
        index = 0;
        if (mouseOver){
            index  = 1;
        }
        if (mousePressed){
            index = 2;
        }
        // TODO: set index to 0
        // TODO if mouseOver
        // TODO: set index to 1
        // TODO: end of if statement
        // TODO: if mousePressed
        // TODO: set index to 2
    }

    public boolean isMouseOver() {
        return mouseOver;
        // TODO: return mouseOver
    }

    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
        // TODO: set this mouseOver to mouseOver
    }

    public boolean isMousePressed() {
        return mousePressed;
        // TODO: return mousePressed
    }

    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
        // TODO: set this mousePressed to mousePressed
    }

    public Rectangle getBounds() {
        return bounds;
        // TODO: return bounds
    }

    public void applyGamestate() {
        Gamestate.state = state;
        // TODO: set Gamestate.state to state
    }

    public void resetBools() {
        mouseOver = false;
        mousePressed = false;
        //TODO: set mouseOver and mousePressed to false
    }

}
