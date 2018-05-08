package net.ddns.noidea.internal;

import net.ddns.noidea.internal.Casillas.*;
import net.ddns.noidea.internal.Casillas.Impuestos.ImpuestoCasilla;
import net.ddns.noidea.internal.Casillas.Impuestos.ImpuestoEspecialCasilla;
import net.ddns.noidea.internal.Casillas.Propiedades.Calle;
import net.ddns.noidea.internal.Casillas.Propiedades.Estacion;
import net.ddns.noidea.internal.Casillas.Propiedades.Servicio;

import java.util.ArrayList;

public class Tablero {

    public Integer dineroInicial;

    public ArrayList<Jugador> jugadores;

    public Integer jugadorActual;

    private ArrayList<Casilla> casillas;

    private boolean playing;

    public Tablero() {
        casillas = new ArrayList<Casilla>();
        cargarCasillas();
        jugadores = new ArrayList<Jugador>();
        dineroInicial = 20000;
        playing = false;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public void siguienteTurno() {

    }

    public void empezarPartida() {
        setPlaying(true);
        jugadorActual = 0;
    }

    public void configurarPartida(Integer dineroInicial) {
        this.dineroInicial = dineroInicial;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void addJugador(Jugador jugador) {
        this.jugadores.add(jugador);
    }

    private void addCasilla(Casilla casilla) {
        casillas.add(casilla);
        casilla.setNumero(casillas.indexOf(casilla));
    }

    private void cargarCasillas() {
        addCasilla(new SalidaCasilla());
//      addCasilla(new Calle("Calle Ejemplo",0, 0, 0, 0, 0, 0, 0, 0, 0 ,0));
        addCasilla(new Calle("Avenida Mediterráneo",60, 30, 2, 10, 30, 90, 160, 250, 50 ,50));
        addCasilla(new TarjetasCasilla("Arca Comunal"));
        addCasilla(new Calle("Avenida Báltica",60, 30, 4, 20, 60, 180, 320, 450, 50 ,50));
        addCasilla(new ImpuestoEspecialCasilla("Impuesto Porcentaje", 200, 10));
        addCasilla(new Estacion("Estacion Reading", 200, 100, 25,50,10,200));
        addCasilla(new Calle("Avenida Oriental", 100,50,6,30,90,270,400,550,50,50));
        addCasilla(new TarjetasCasilla("Casualidad"));
        addCasilla(new Calle("Avenida Vermot",100,50,6,30,90,270,400,550,50,50));
        addCasilla(new Calle("Avenida Connecticut",120,60,8,40,100,300,450,600,50,50));
        addCasilla(new TarjetasCasilla("De visita por la carcel"));//De visita por la carcel
        addCasilla(new Calle("Plaza San Carlos", 140,70,10,50,150,450,625,750,100,100));
        addCasilla(new Servicio("Compañia de Electricidad", 150,75));
        addCasilla(new Calle("Avenida de los Estados", 140, 70,10,50,150,450,625,750,100,100));
        addCasilla(new Calle("Avenida Virginia", 160,80,12,60,180,500,700,900,100,100));
        addCasilla(new Estacion("Ferrocarril Pensilvania", 200,100,25,50,100,200));
        addCasilla(new Calle("Plaza Santiago",180,90,14,70,200,550,750,950,100,100));
        addCasilla(new TarjetasCasilla("Arca Comunal"));
        addCasilla(new Calle("Avenida Tennesee", 180,90,14,70,200,550,750,950,100,100));
        addCasilla(new Calle("Avenida Nueva York", 200,100,16,80,220,600,800,1000,100,100));
        addCasilla(new TarjetasCasilla("Parada libre"));//No hace nadaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
        addCasilla(new Calle("Avenida Kentucky",220,110,18,90,250,700,875,1050,150,150));
        addCasilla(new Calle("Avenida Indiana",220,110,18,90,250,700,875,1050,150,150));
        addCasilla(new Calle("Avenida Illinóis",240,120,20,100,300,750,925,1100,150,150));
        addCasilla(new Estacion("Ferrocarril B. & O.",200,100,25,50,100,200));
        addCasilla(new Calle("Avenida Atlántico",260,130,22,110,330,800,975,1150,150,150));
        addCasilla(new Calle("Avenida Ventnor",260,130,22,110,330,800,975,1150,150,150));
        addCasilla(new Servicio("Obras de Agua Potable",150,75));
        addCasilla(new Calle("Jardines Marvin",280,140,22,120,360,850,1025,1200,150,150));
        addCasilla(new EncarcelarCasilla(1));
        addCasilla(new Calle("Avenida Pacífico",300,150,26,130,390,900,1100,1275,200,200));
        addCasilla(new Calle("Avenida Carolina Del Norte",300,150,26,130,390,900,1100,1275,200,200));
        addCasilla(new TarjetasCasilla("Arca Comunal"));
        addCasilla(new Calle("Avenida Pensilvania",320,160,28,150,450,1000,1200,1400,200,200));
        addCasilla(new Estacion("Ferrocarril Short Line",200,100,25,50,100,200));
        addCasilla(new TarjetasCasilla("Casualidad"));
        addCasilla(new Calle("Plaza del Parque",350,175,35,175,500,1100,1300,1500,200,200));
        addCasilla(new ImpuestoCasilla("Impuesto sobre posesiones de lujo",75));
        addCasilla(new Calle("Paseo Tablado",400,200,50,200,600,1400,1700,2000,200,200));

/*        addCasilla(new ImpuestoCasilla("Impuesto", 5000));
        addCasilla(new ImpuestoEspecialCasilla("Impuesto Porcentaje", 10000, 25));
        //addCasilla(new Estacion("Estacion sur", 20000, 10000));
        addCasilla(new Servicio("Servicio", 20000, 10000));*/
    }

}
