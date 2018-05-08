package net.ddns.noidea.internal;

import java.io.File;

public class Ficha {

    public File imagen;

    public Ficha(File imagen) {
        this.imagen = imagen;
    }

    public File getImagen() {
        return imagen;
    }

}
