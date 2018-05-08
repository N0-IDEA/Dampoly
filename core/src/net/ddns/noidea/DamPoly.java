package net.ddns.noidea;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DamPoly extends ApplicationAdapter {
	SpriteBatch batch;
	Dado dado;

    public Dado getDado() {
        return dado;
    }

    @Override
	public void create () {
		batch = new SpriteBatch();
		dado = new Dado();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(dado.getImg(), 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
