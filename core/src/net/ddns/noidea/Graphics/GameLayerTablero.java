package net.ddns.noidea.Graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import net.ddns.noidea.internal.Jugador;
import net.ddns.noidea.internal.Tablero;

import java.util.ArrayList;

public class GameLayerTablero extends Group {

    private static final String UI_FILE = "data/skin/comic-ui.json";

    private Skin skin;
    private ImageButton tableroInterfaz;

    public GameLayerTablero() {
        loadTextures();
    }

    private void loadTextures()
    {
        skin = new Skin(Gdx.files.internal(UI_FILE));
    }


    public void build() {
        Texture texture = new Texture(Gdx.files.internal("data/tablero.png" ));
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        tableroInterfaz = new ImageButton(new TextureRegionDrawable(new TextureRegion(texture)));

        final Table tabla = new Table();
        tabla.setBackground(skin.getDrawable("white"));//Fondo de la tabla principal (no deja modificar "Button"), es la que se queda abajo
        tabla.setFillParent(true);
        tabla.add(tableroInterfaz).width(getWidth());

        addActor(tabla);

    }



}
