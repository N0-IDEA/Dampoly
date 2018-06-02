/*
 * Copyright (c) 2018 franciscoquintana<https://github.com/franciscoquintana>.
 */

package net.ddns.noidea.Graphics;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

public class GameScene extends Stage {
       private GameLayer gameLayer;
       private GameLayerTablero gameLayerTablero;
    public GameScene(){
        super();

        setViewport(new ScalingViewport(Scaling.stretch,getWidth(),getHeight()));

        float size = getWidth()/3;

        gameLayer = new GameLayer();
        gameLayer.setWidth(size);
        gameLayer.setHeight(getHeight());

        gameLayerTablero = new GameLayerTablero();
        gameLayerTablero.setWidth(size*2);
        gameLayerTablero.setHeight(getHeight());
        gameLayerTablero.setPosition(size,0);

        addActor(gameLayer);
        addActor(gameLayerTablero);
    }

    public void init() {
        gameLayer.build();
        gameLayerTablero.build();
    }
    public void update() {
        gameLayer.update();
    }

}