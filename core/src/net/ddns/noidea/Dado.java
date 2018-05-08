package net.ddns.noidea;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class Dado {
    Texture img;

    ArrayList<Texture> texturas = new ArrayList<Texture>();

    public Dado() {
        for (int i = 1; i <= 6; i++) {
            texturas.add(new Texture("dado"+i+".gif"));
        }
        setNumber(1);
    }

    public void setNumber(int number) {
        img = texturas.get(number-1);
    }

    public Texture getImg() {
        return img;
    }
}
