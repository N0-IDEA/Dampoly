package net.ddns.noidea;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;



import java.util.ArrayList;

public class InterfazJugador {
    /*for (int i = 1; i <= 6; i++) {
            texturas.add(new Texture("dado"+i+".gif"));
        }*/

        /*
        Texture texture = new Texture("dadosjuntos.png");
        regions = TextureRegion.split(texture,200 ,100);
        setNumber(1);*/
    private Skin skin = new Skin(Gdx.files.internal("gdx-skins-master/biological-attack/skin/biological-attack-ui.json"));
    ArrayList<Texture> texturas = new ArrayList<Texture>();

    TextureRegion[][] regions;

    private Integer numero;

    public InterfazJugador() {
        Label nameLabel = new Label("Name:", skin);
        TextField nameText = new TextField("", skin);
        Label addressLabel = new Label("Address:", skin);
        TextField addressText = new TextField("", skin);

        Table table = new Table();
        table.add(nameLabel);
        table.add(nameText).width(100);
        table.row();
        table.add(addressLabel);
        table.add(addressText).width(100);

    }
/*
    public void setNumber(int number) {
        numero = number;
    }

    public Integer getNumber() {
        return numero;
    }

    public TextureRegion getImg() {
        int a = numero / 3 >= 1 ? 1 : 0;
        int b = numero > 3 ? numero -3 : numero;
        return regions[a][b-1];
    }*/

}
