package net.ddns.noidea.Graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.*;

public class GameLayer extends Group {

    private static final String UI_FILE = "data/skin/rainbow-ui.json";

    private static final String TEXT_SETTINGS = "Settings";
    private static final String TEXT_SOUND = "SOUND";
    private static final String TEXT_VOLUME = "Volume";

    private Skin skin;

    public GameLayer() {
        loadTextures();
    }

    private void loadTextures()
    {
        skin = new Skin(Gdx.files.internal(UI_FILE));
    }

    public void build() {

        final Label titleLabel1 = new Label("Prueba", skin, "normal", Color.YELLOW);

        final Label padding = new Label("", skin);
        padding.setHeight(10);


        // ---------------------------------------------------------------
        // Table
        // ---------------------------------------------------------------
        Table table = new Table();

        table.setSize(getWidth(), getHeight());

        table.row();
        table.add(titleLabel1).expandY().expandX();
        table.row();
        table.add(titleLabel1).expandY();
        table.row();
        table.add(titleLabel1);
        table.row();
        table.add(titleLabel1).expandY().expandX();
        table.row();
        table.add(titleLabel1);
        table.row();

        for (int i = 0; i < 9; i++)
        {
            table.add(padding);
            table.row();
        }

        table.setFillParent(true);

        table.pack();

        addActor(table);
        addActor(titleLabel1);
    }

    public void update() {

    }
}
