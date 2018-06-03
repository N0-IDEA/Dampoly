package net.ddns.noidea.Graphics;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import net.ddns.noidea.internal.Casillas.Casilla;

public class GCasilla extends Group {
    public static int width = 75;
    public static int height = 100;

    private Casilla casilla;
    private Texture texture;
    private Skin skin;
    private ShapeRenderer shapeRenderer;
    private boolean projectionMatrixSet;

    private Table table;

    public GCasilla(float x, float y, Color color, Casilla casilla, Skin skin) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        setColor(color);
        this.skin = skin;
        loadCasilla(casilla);

        shapeRenderer = new ShapeRenderer();
        projectionMatrixSet = false;
    }


    public void loadCasilla(Casilla casilla) {
        this.casilla = casilla;
        StringBuilder stringBuilder = new StringBuilder();
        String[] strs = casilla.getNombre().split(" ");
        for (int i = 0; i < strs.length; i++) {
            if (i != 0)
                stringBuilder.append('\n');
            stringBuilder.append(strs[i]);
        }

        table = new Table(skin);

        table.setFillParent(true);

        Label label = new Label(stringBuilder.toString(), skin);

        label.setAlignment(Align.center);

        table.add(label).expand().top();
        table.row().right();

        table.right().bottom();

        Label labelNum = new Label("n" + casilla.getNumero().toString(), skin);;

        table.add(labelNum);

        addActor(table);

    }

    private void createTexture(int width, int height, Color color) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fillRectangle(0, 0, width, height);
        texture = new Texture(pixmap);
        pixmap.dispose();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();
        if(!projectionMatrixSet){
            shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());
            shapeRenderer.setTransformMatrix(batch.getTransformMatrix());
        }
        Color color = getColor();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        shapeRenderer.rect(getX(), getY(), getWidth(), getHeight());
        shapeRenderer.end();
        batch.begin();
        super.draw(batch, parentAlpha);
    }

}
