package net.ddns.noidea.internal;

import java.io.File;

public enum  Ficha {
    PLANCHA("plancha.png"), BARCO("barco.png"), DEDAL("dedal.png"), COCHE("coche.png");
    public File imagen;

    Ficha(String imagen) {
        this.imagen = new File(imagen);
    }

    public File getImagen() {
        return imagen;
    }

    public static Ficha fromStr(String name) {
        for (Ficha ficha : values()) {
            if (ficha.name().equalsIgnoreCase(name))
                return ficha;
        }
        return null;
    }

}
