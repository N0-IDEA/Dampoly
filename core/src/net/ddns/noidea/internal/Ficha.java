package net.ddns.noidea.internal;

import com.badlogic.gdx.graphics.Color;

import java.io.File;

public enum  Ficha {
    PLANCHA("plancha.png", Color.RED), BARCO("barco.png", Color.BLUE), DEDAL("dedal.png", Color.BLACK), COCHE("coche.png", Color.BROWN);
    private File imagen;
    private Color color;

    Ficha(String imagen, Color color) {
        this.imagen = new File(imagen);
        this.color = color;
    }

    public File getImagen() {
        return imagen;
    }

    public Color getColor() {
        return color;
    }

    public static Ficha fromStr(String name) {
        for (Ficha ficha : values()) {
            if (ficha.name().equalsIgnoreCase(name))
                return ficha;
        }
        return null;
    }

}
