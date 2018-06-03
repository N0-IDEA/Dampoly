package net.ddns.noidea.Graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import net.ddns.noidea.DamPoly;
import net.ddns.noidea.internal.Tablero;

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
        /*Texture texture = new Texture(Gdx.files.internal("data/tablero.jpg" ));
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        tableroInterfaz = new ImageButton(new TextureRegionDrawable(new TextureRegion(texture)));

        final Table tabla = new Table();
        tabla.setBackground(skin.getDrawable("white"));//Fondo de la tabla principal (no deja modificar "Button"), es la que se queda abajo
        tabla.setFillParent(true);
        tabla.add(tableroInterfaz).width(getWidth());*/

        //addActor(tabla);
        addActor(new GCasilla(0, 0, Color.BLUE, Tablero.getInstance().getCasillas().get(4), skin));
        addActor(new GCasilla(75, 0, Color.BLUE, Tablero.getInstance().getCasillas().get(5), skin));
    }



}
