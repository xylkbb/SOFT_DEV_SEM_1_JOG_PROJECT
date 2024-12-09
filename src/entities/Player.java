package entities;

import static utilz.Constants.PlayerConstants.*;
import static utilz.HelpMethods.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import utilz.LoadSave;

public class Player extends Entity {
    private BufferedImage[][] animations;
    private int aniTick, aniIndex, aniSpeed = 25;
    private int playerAction = IDLE;
    private boolean moving = false;
    private boolean attacking = false;
    private boolean left, up, right, down, jump;
    private float playerSpeed = 1.0f * Game.SCALE;
    private int[][] lvlData;
    private float xDrawOffset = 21 * Game.SCALE;
    private float yDrawOffset = 4 * Game.SCALE;

    // Jumping / Gravity
    private float airSpeed = 0f;
    private float gravity = 0.04f * Game.SCALE;
    private float jumpSpeed = -2.25f * Game.SCALE;
    private float fallSpeedAfterCollision = 0.5f * Game.SCALE;
    private boolean inAir = false;

    public Player(float x, float y, int width, int height) {
        super(x, y, width, height);
        loadAnimations();
        // TODO: call initHitbox passing in x, y, (int) (20 * Game.SCALE), (int) (27 * Game.SCALE)
    }

    public void update() {
        updatePos();
        updateAnimationTick();
        setAnimation();
    }

    public void render(Graphics g) {
        // TODO: call g.drawImage passing in animations[playerAction][aniIndex], (int)(hitbox.x - xDrawOffset), (int)(hitbox.y - YDrawOffset), width, height, null)
    }

    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= GetSpriteAmount(playerAction)) {
                aniIndex = 0;
                attacking = false;
            }
        }
    }

    private void setAnimation() {
        int startAni = playerAction;
        if (moving)
            playerAction = RUNNING;
        else
            playerAction = IDLE;

        // TODO: if inAir
        // TODO: if airSpeed is less than 0
        // TODO: set playerAction to JUMP
        // TODO: else set playerAction to FALLING


        if (attacking)
            playerAction = ATTACK_1;

        if (startAni != playerAction)
            resetAniTick();
    }

    private void resetAniTick() {
        aniTick = 0;
        aniIndex = 0;
    }

    private void updatePos() {
        moving = false;

        // TODO: if jump
        // TODO: call jump()
        // TODO: if not left and not right and not inAir
        // TODO: return

        // create a float called xSpeed and set to 0

        // TODO: if left subtract playerSpeed from xSpeed
        // TODO: if right add playerSpeed to xSpeed


        // TODO: if not inAir
        // TODO: if not IsEntityOnFloor(hitbox, lvlData)
        // TODO: set inAir to true


        // TODO: if inAir
        // TODO: if CanMoveHere(hitbox.x, hitbox.y + airSpeed, hitbox.width, hitbox.height, lvlData)
        // TODO: add airSpeed to hitbox.y
        // TODO: add gravity to airSpeed
        // TODO: updateXPos
        // TODO: else
        // TODO: set hitbox.y to GetEntityYPosUnderRoofOrAboveFloor(hitbox, airSpeed)
        // TODO: if airSpeed is positive
        // TODO: call resetInAir()
        // TODO: else
        // TODO: set airSpeed to fallSpeedAfterCollision
        // TODO: done with else call updateXPos(xSpeed)
        // TODO: else (based off of if inAir)
        // TODO: call updateXPos(xSpeed)
        // TODO: set moving to true
    }

    private void jump() {
        // TODO: if inAir then return
        // TODO: set inAir to true
        // TODO: set airSpeed to jumpSpeed
    }

    private void resetInAir() {
        // TODO: set inAir to false
        // TODO: set airSpeed to 0
    }

    private void updateXPos(float xSpeed) {
        // TODO: if CanMoveHere(hitbox.x + xSpeed, hitbox.y, hitbox.width, hitbox.height, lvlData)
        // TODO: add xSpeed to hitbox.x
        // TODO: else set hitbox.x to GetEntityXPosNextToWall(hitbox, xSpeed)
    }

    private void loadAnimations() {
        // TODO: create a BufferedImage called img and set to LoadSvae.GetSpriteAtlas(LoadSave.PLAYER_ATLAS)

        animations = new BufferedImage[9][6];
        for (int row = 0; row < animations.length; row++)
            for (int col = 0; col < animations[row].length; col++)
                animations[row][col] = img.getSubimage(col * 64, row * 40, 64, 40);

    }

    public void loadLvlData(int[][] lvlData) {
        // TODO: set this lvlData to lvlData
        // TODO: if not IsEntityOnFloor(hitbox, lvlData)
        // TODO: set inAir to true
    }

    public void resetDirBooleans() {
        left = false;
        right = false;
        up = false;
        down = false;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    // TODO: repeat for Up, Down, Right for previous 2


    public void setJump(boolean jump) {
        // TODO: set this jump to jump.
    }

}