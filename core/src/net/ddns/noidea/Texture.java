package net.ddns.noidea;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Texture implements ApplicationListener {

    private Texture                 texture;
    private SpriteBatch             batch;
    private TextureRegion[]         regions = new TextureRegion[6];

    @Override
    public void create() {
        texture = new Texture(Gdx.files.internal("dadosjuntos.png"));
        batch = new SpriteBatch();
        regions[0] = new TextureRegion(Texture,   0,     0,   200,  200);
        regions[1] = new TextureRegion(Texture, 200,     0,   400,  200);
        regions[2] = new TextureRegion(Texture, 400,     0,   600,  200);
        regions[3] = new TextureRegion(Texture,   0,   200,   200,  400);
        regions[4] = new TextureRegion(Texture, 200,   200,   400,  400);
        regions[5] = new TextureRegion(Texture, 400,   200,   400,  600);
    }

    @Override
    public void render() {
        batch.begin();
        batch.draw(Texture, 0 ,0 , 200, 200);
        for (int i=0; i<regions.length; i++){
            batch.draw(regions[i], 150 , 300);
        }

        batch.end();

    }
}
