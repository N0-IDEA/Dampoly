package net.ddns.noidea;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import net.ddns.noidea.Graphics.GameLayer;
import net.ddns.noidea.Graphics.GameScene;
import net.ddns.noidea.internal.Tablero;

public class DamPoly extends ApplicationAdapter {
	SpriteBatch batch;
	Dado dados[];
	Tablero tablero;
	GameScene gameScene;

	private boolean showDados = false;

    public Dado[] getDados() {
        return dados;
    }

	public boolean isShowDados() {
		return showDados;
	}

	public void setShowDados(boolean showDados) {
		this.showDados = showDados;
	}

	public Tablero getTablero() {
		return tablero;
	}

	@Override
	public void create () {
    	dados = new Dado[2];
		batch = new SpriteBatch();
		dados[0] = new Dado();
		dados[1] = new Dado();
		tablero = Tablero.setInstance(this);
		gameScene = new GameScene();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		if (isShowDados()) {
			batch.draw(dados[0].getImg(), 0, 0);
			batch.draw(dados[1].getImg(), 250, 0);
		}
		gameScene.act();
		gameScene.draw();
		batch.end();
		Gdx.input.setInputProcessor(gameScene);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
