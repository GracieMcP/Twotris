package com.github.capstone.Scene;

import com.github.capstone.Util.Helper;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Rectangle;
import org.newdawn.slick.opengl.Texture;

public class TitleSprite
{
    private Texture sprite;
    private Rectangle hitBox;

    public TitleSprite(String texture)
    {
        this.sprite = Helper.loadTexture(texture);
        this.hitBox = new Rectangle(0, 0, sprite.getImageWidth(), sprite.getImageHeight());
    }

    public void draw()
    {
        this.hitBox.setX((Display.getWidth() / 2) - (this.hitBox.getWidth() / 2));
        this.hitBox.setY(Display.getHeight() / 16);

        float x = (float) hitBox.getX();
        float y = (float) hitBox.getY();
        float w = (float) hitBox.getWidth();
        float h = (float) hitBox.getHeight();

        GL11.glBindTexture(GL11.GL_TEXTURE_2D, sprite.getTextureID());
        GL11.glColor3f(1F, 1F, 1F);

        // Allows the background to scale w/o blurring
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

        GL11.glBegin(GL11.GL_QUADS);

        GL11.glTexCoord2f(0F, 0F);
        GL11.glVertex2f(x, y);

        GL11.glTexCoord2f(1F, 0F);
        GL11.glVertex2f(x + w, y);

        GL11.glTexCoord2f(1F, 1F);
        GL11.glVertex2f(x + w, y + h);

        GL11.glTexCoord2f(0F, 1F);
        GL11.glVertex2f(x, y + h);

        GL11.glEnd();

        GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
    }

    public Rectangle getHitBox()
    {
        return this.hitBox;
    }
}
