package net.ddns.noidea.Graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;
import net.ddns.noidea.DamPoly;

public class GameIntro {

    private Stage stage;

    private Skin skin;

    private Image intro;

    private Texture imgIntro;

    private TextButton jugar, configuracion, salir;

    public void gamentro() {

        imgIntro = new Texture("intro.png");
        stage = new Stage(new FitViewport(640, 360));
        skin = new Skin(Gdx.files.internal("~/Documentos/Monopoly/core/assets/data/skin/uiskin.json"));
        intro = new Image(imgIntro);

        //botones
        jugar = new TextButton("Jugar", skin);
        configuracion = new TextButton("Configuración", skin);
        salir = new TextButton("Salir", skin);

        //posiciones
        intro.setPosition(320 - intro.getWidth()/2, 320 - intro.getHeight());
        jugar.setSize(200,100);
        jugar.setPosition(220,50);
        stage.addActor(jugar);
        stage.addActor(intro);


    }
    public void dispose(){
        stage.dispose();
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0.4f, 0.5f, 0.8f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();

    }
}
