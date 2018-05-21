package net.ddns.noidea.Graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameIntro {

    private Texture intro;
    private SpriteBatch batch;
    private int width, height;

    public void create() {
        intro = new Texture("intro.png");
        batch = new SpriteBatch();
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
    }

    public void dispose() {
        intro.dispose();
        batch.dispose();
    }

    public void render(){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(intro, width, height);

        batch.end();
    }
}
