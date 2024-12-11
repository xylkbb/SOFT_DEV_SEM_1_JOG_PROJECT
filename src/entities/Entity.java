package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public abstract class Entity {

    protected float x, y;
    protected int width;
    protected int height;
    protected Rectangle2D.Float hitbox;


    public Entity(float x, float y, int width, int height) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }

    protected void drawHitbox(Graphics g) {
        g.setColor(Color.PINK);
        g.drawRect((int) hitbox.x, (int) hitbox.y, (int) hitbox.width, (int) hitbox.height);

    }

    protected void initHitbox(float x, float y, int width, int height) {
        hitbox = new Rectangle2D.Float();

    }

    public Rectangle2D.Float getHitbox() {
        return this.hitbox;

    }

}