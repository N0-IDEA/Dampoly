package net.ddns.noidea.internal;

import com.badlogic.gdx.Gdx;
import net.ddns.noidea.DamPoly;
import net.ddns.noidea.Graphics.GameScene;
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

    private DamPoly damPoly;

    private static Tablero tablero;

    private Tablero(DamPoly damPoly) {
        this.damPoly = damPoly;
        casillas = new ArrayList<Casilla>();
        cargarCasillas();
        jugadores = new ArrayList<Jugador>();
        dineroInicial = 100;
        playing = false;
    }


    public static Tablero getInstance() {
        return tablero;
    }

    public static Tablero setInstance(DamPoly damPoly) {
        tablero = new Tablero(damPoly);
        return tablero;
    }

    public DamPoly getDamPoly() {
        return damPoly;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public void siguienteTurno() {
        if (jugadorActual != jugadores.size() -1)
            jugadorActual++;
        else
            jugadorActual = 0;

        getDamPoly().setShowDados(false);

    }

    public void empezarPartida() {
        jugadorActual = 0;
        for (Jugador jugador : jugadores) {
            jugador.dinero = dineroInicial;
            Casilla casilla = getCasillas().get(0);
            casilla.addJugador(jugador);
        }

        Gdx.app.postRunnable(new Runnable() {
            @Override
            public void run() {
                getDamPoly().getGameScene().init();
                setPlaying(true);
            }
        });

    }

    public void configurarPartida(Integer dineroInicial) {
        this.dineroInicial = dineroInicial;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public Jugador getJugadorActual() {
        return getJugadores().get(jugadorActual);
    }

    private boolean checkIfJugadorExists(Jugador jugadorComprueba) {
        boolean exist = false;

        for (Jugador jugador : getJugadores()) {
            if (jugador.getFicha() == jugadorComprueba.getFicha())
                return true;
        }

        return exist;
    }

    public boolean addJugador(Jugador jugador) {
        if (!checkIfJugadorExists(jugador)) {
            this.jugadores.add(jugador);
            return true;
        }
        return false;
    }

    public ArrayList<Casilla> getCasillas() {
        return casillas;
    }

    public void moverJugador(int tirada) {
        Jugador jugador = getJugadorActual();
        Casilla nuevaCasilla = getCasillas().get(jugador.getCasillaActual().getNumero() + tirada);
        jugador.setCasillaActual(nuevaCasilla);


        if(jugador.getCasillaActual().getNumero() + tirada>= 39){
            nuevaCasilla = getCasillas().get(jugador.getCasillaActual().getNumero() +
                    tirada-40);
            jugador.setCasillaActual(nuevaCasilla);
            jugador.dinero+=200;
        }
    }

    private void addCasilla(Casilla casilla) {
        casillas.add(casilla);
        casilla.setNumero(casillas.indexOf(casilla));
    }

    private void cargarCasillas() {
        addCasilla(new SalidaCasilla());
//      addCasilla(new Calle("Calle Ejemplo",0, 0, 0, 0, 0, 0, 0, 0, 0 ,0));
        addCasilla(new Calle("Ronda De Valencia",60, 30, 2, 10, 30, 90, 160, 250, 50 ,50));
        addCasilla(new TarjetasCasilla("Caja De Comunidad"));
        addCasilla(new Calle("Plaza Lavapiés",60, 30, 4, 20, 60, 180, 320, 450, 50 ,50));
        addCasilla(new ImpuestoEspecialCasilla("Impuesto Sobre El Capital", 200, 10));
        addCasilla(new Estacion("Estacion De Goya", 200, 100, 25,50,10,200));
        addCasilla(new Calle("Glorieta Cuatro Caminos", 100,50,6,30,90,270,400,550,50,50));
        addCasilla(new TarjetasCasilla("Suerte"));
        addCasilla(new Calle("Avenida De Reina Victoria",100,50,6,30,90,270,400,550,50,50));
        addCasilla(new Calle("Calle Bravo Murillo",120,60,8,40,100,300,450,600,50,50));
        addCasilla(new TarjetasCasilla("Cárcel / Solo Visitas"));//De visita por la carcel
        addCasilla(new Calle("Glorieta De Bilbao", 140,70,10,50,150,450,625,750,100,100));
        addCasilla(new Servicio("Compañia de Electricidad", 150,75));
        addCasilla(new Calle("Calle De Alberto Aguilera", 140, 70,10,50,150,450,625,750,100,100));
        addCasilla(new Calle("Calle Fuencarral", 160,80,12,60,180,500,700,900,100,100));
        addCasilla(new Estacion("Estación De Las Delicias", 200,100,25,50,100,200));
        addCasilla(new Calle("Avenida Felipe II",180,90,14,70,200,550,750,950,100,100));
        addCasilla(new TarjetasCasilla("Caja De Comunidad"));
        addCasilla(new Calle("Calle Velázquez", 180,90,14,70,200,550,750,950,100,100));
        addCasilla(new Calle("Calle Serrano", 200,100,16,80,220,600,800,1000,100,100));
        addCasilla(new TarjetasCasilla("Parking Gratuito"));//No hace nadaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
        addCasilla(new Calle("Avenida De America" ,220,110,18,90,250,700,875,1050,150,150));
        addCasilla(new Calle("Suerte",220,110,18,90,250,700,875,1050,150,150));
        addCasilla(new Calle("Calle María De Molina",220,120,20,100,300,750,925,1100,150,150));
        addCasilla(new Calle("Calle De Cea Bermudez",240,111,100,100,100,100,100,100,100,100));
        addCasilla(new Estacion("Estación Del Mediodia",200,100,25,50,100,200));
        addCasilla(new Calle("Avenida De Los Reyes Cátolicos",260,130,22,110,330,800,975,1150,150,150));
        addCasilla(new Calle("Calle Bailen",260,130,22,110,330,800,975,1150,150,150));
        addCasilla(new Servicio("Compañia Distribuicion De Aguas",150,75));
        addCasilla(new Calle("Plaza España",280,140,22,120,360,850,1025,1200,150,150));
        addCasilla(new EncarcelarCasilla(1));
        addCasilla(new Calle("Puerta Del Sol",300,150,26,130,390,900,1100,1275,200,200));
        addCasilla(new Calle("Calle De Alcalá",300,150,26,130,390,900,1100,1275,200,200));
        addCasilla(new TarjetasCasilla("Caja De Comunidad"));
        addCasilla(new Calle("Gran Via",320,160,28,150,450,1000,1200,1400,200,200));
        addCasilla(new Estacion("Estación Del Norte",200,100,25,50,100,200));
        addCasilla(new TarjetasCasilla("Suerte"));
        addCasilla(new Calle("Paseo De La Castellana",350,175,35,175,500,1100,1300,1500,200,200));
        addCasilla(new ImpuestoCasilla("Impuesto de lujo",75));
        addCasilla(new Calle("Paseo Del Prado",400,200,50,200,600,1400,1700,2000,200,200));

/*        addCasilla(new ImpuestoCasilla("Impuesto", 5000));
        addCasilla(new ImpuestoEspecialCasilla("Impuesto Porcentaje", 10000, 25));
        //addCasilla(new Estacion("Estacion sur", 20000, 10000));
        addCasilla(new Servicio("Servicio", 20000, 10000));*/
    }

}
