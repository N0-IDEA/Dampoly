package net.ddns.noidea.Graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;



public class DFFont {
    SpriteBatch batch;
    BitmapFont font;
    ShaderProgram fontShader;

    public void create ()
    {
        Texture text = new Texture(Gdx.files.internal("data/verdana39.png"));
        text.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        batch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("data/verdana39.fnt"), new TextureRegion(text), false);//"test" + ".fnt"
        font.setColor(Color.BLACK);
        font.getData().setScale(3);
        fontShader = new ShaderProgram(Gdx.files.internal("data/shaders/distancefield.vert"), Gdx.files.internal("data/shaders/distancefield.frag"));


    }


   /* public void render ()
    {
        //Gdx.gl.glClearColor(1, 1, 1, 1);
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setShader(fontShader);
       /* batch.begin();

        font.draw(batch, "jii", 0, 100);
        batch.end();*/
//    }
}
