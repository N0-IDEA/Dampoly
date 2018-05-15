package net.ddns.noidea.Graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import net.ddns.noidea.internal.Jugador;
import net.ddns.noidea.internal.Tablero;

import java.util.ArrayList;

public class GameLayer extends Group {

    private static final String UI_FILE = "data/skin/comic-ui.json";

    private static final String TEXT_SETTINGS = "Settings";
    private static final String TEXT_SOUND = "SOUND";
    private static final String TEXT_VOLUME = "Volume";

    private Skin skin;

    private Label nombreJTurno;

    private ImageButton dado;

    public GameLayer() {
        loadTextures();
    }

    private void loadTextures()
    {
        skin = new Skin(Gdx.files.internal(UI_FILE));
    }

    ArrayList<VisualJugador> visualJugadorList;

    public void build() {

        Tablero tablero = Tablero.getInstance();
        final Label turno = new Label("Turno:", skin, "button");

        nombreJTurno = new Label("#####", skin);

        Texture texture = new Texture(Gdx.files.internal("data/dado.png"));
        dado = new ImageButton(new TextureRegionDrawable(new TextureRegion(texture)));
        dado.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Tablero.getInstance().getJugadorActual().lanzarDados();
                return true;
            }
        });



        // ---------------------------------------------------------------
        // Table
        // ---------------------------------------------------------------
        Table table = new Table(skin);
        table.setFillParent(true);
        //table.setDebug(true);
        table.top().left();

        table.add(turno);
        table.add(nombreJTurno);
        table.add(dado);

        separator(table, 10);

        visualJugadorList = new ArrayList<VisualJugador>();
        for (Jugador jugador : tablero.getJugadores()) {
            table.add(jugador.getFicha().name());
            VisualJugador visualJugador = new VisualJugador(jugador);
            visualJugadorList.add(visualJugador);
            table.add(" Dinero: ", "font", Color.DARK_GRAY);
            table.add(visualJugador.getMoney());
            table.row();
            Tree tree = new Tree(skin);
            tree.add(visualJugador.getNodeCalles());
            tree.add(visualJugador.getNodeEstaciones());
            tree.add(visualJugador.getNodeServicios());
            tree.add(visualJugador.getNodeTarjetas());
            table.add(tree);
            separator(table, 10);

        }

        //table.add(nombreJTurno);


        addActor(table);

    }

    private void separator(Table table, int size) {
        final Label padding = new Label("", skin);
        padding.setHeight(size);

        table.row();
        table.add(padding);
        table.row();
    }

    public void update() {
        Jugador jugadorActual = Tablero.getInstance().getJugadorActual();

        dado.setTouchable(jugadorActual.getTiradaDisponible() ? Touchable.enabled : Touchable.disabled);

        nombreJTurno.setText(Tablero.getInstance().getJugadorActual().getFicha().name());

        for (VisualJugador visualJugador : visualJugadorList) {
            Jugador jugador = visualJugador.getJugador();
            visualJugador.money.setText(jugador.dinero.toString());

            //TODO Añadir las propiedades a su correspondiente arbol, es necesario poder saber las casillas del jugador desde el objeto jugador
        }
    }

    public class VisualJugador {
        private Label money =  new Label("####", skin);
        private Jugador jugador;

        public VisualJugador(Jugador jugador) {
            this.jugador = jugador;
        }

        Tree.Node nodeCalles = new Tree.Node(new Label("Calles", skin));
        Tree.Node nodeEstaciones = new Tree.Node(new Label("Estaciones", skin));
        Tree.Node nodeServicios = new Tree.Node(new Label("Servicios", skin));
        Tree.Node nodeTarjetas = new Tree.Node(new Label("Tarjetas", skin));

        public Jugador getJugador() {
            return jugador;
        }

        public Label getMoney() {
            return money;
        }

        public Tree.Node getNodeCalles() {
            return nodeCalles;
        }

        public Tree.Node getNodeEstaciones() {
            return nodeEstaciones;
        }

        public Tree.Node getNodeServicios() {
            return nodeServicios;
        }

        public Tree.Node getNodeTarjetas() {
            return nodeTarjetas;
        }
    }
}
