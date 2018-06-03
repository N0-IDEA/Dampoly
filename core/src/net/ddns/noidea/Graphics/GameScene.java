/*
 * Copyright (c) 2018 franciscoquintana<https://github.com/franciscoquintana>.
 */

package net.ddns.noidea.Graphics;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

public class GameScene extends Stage {
    private GameLayer gameLayer;
    private GameLayerTablero gameLayerTablero;
    private static float scale = 0.8f;

    public static int height = (int) ((GCasilla.height * 11) * scale);
    public static int width = (int) ((GCasilla.width * 11) * scale);

    public GameScene() {
        super();

        setViewport(new ScalingViewport(Scaling.stretch, getWidth(), getHeight()));

        float size = 213;

        gameLayer = new GameLayer();
        gameLayer.setWidth(size);
        gameLayer.setHeight(getHeight());

        gameLayerTablero = new GameLayerTablero();
        gameLayerTablero.setWidth(size * 3);
        gameLayerTablero.setHeight(getHeight());
        gameLayerTablero.setPosition(size, 0);

        addActor(gameLayer);
        addActor(gameLayerTablero);
    }

    @Override
    public void draw() {
        super.draw();
    }

    public void init() {
        gameLayer.build();
        gameLayerTablero.build();
        gameLayerTablero.setScale(scale);
    }

    public void update() {
        gameLayer.update();
    }

}