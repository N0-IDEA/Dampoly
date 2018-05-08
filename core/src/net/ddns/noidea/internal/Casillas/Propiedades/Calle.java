package net.ddns.noidea.internal.Casillas.Propiedades;

import net.ddns.noidea.internal.Casillas.PropiedadCasilla;

public class Calle extends PropiedadCasilla {

    public Integer alquilerBase;

    public Integer alquilerUnaCasa;

    public Integer alquilerDosCasas;

    public Integer alquilerTresCasas;

    public Integer alquilerCuatroCasas;

    public Integer alquilerHotel;

    public Integer precioCasa;

    public Integer precioHotel;

    public Integer numCasas;

    public Integer numHoteles;

    public Calle(String nombre,Integer precio, Integer hipoteca, Integer alquilerBase, Integer alquilerUnaCasa, Integer alquilerDosCasas, Integer alquilerTresCasas, Integer alquilerCuatroCasas, Integer alquilerHotel, Integer precioCasa, Integer precioHotel) {
        super(nombre, precio, hipoteca);
        this.alquilerBase = alquilerBase;
        this.alquilerUnaCasa = alquilerUnaCasa;
        this.alquilerDosCasas = alquilerDosCasas;
        this.alquilerTresCasas = alquilerTresCasas;
        this.alquilerCuatroCasas = alquilerCuatroCasas;
        this.alquilerHotel = alquilerHotel;
        this.precioCasa = precioCasa;
        this.precioHotel = precioHotel;
        numCasas = 0;
        numHoteles = 0;
    }

    public void edificar() {
    }

}