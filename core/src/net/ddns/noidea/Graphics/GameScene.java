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

        setViewport(new ScalingViewport(Scaling.stretch,getWidth()*9/7,getHeight()*9/7));
        gameLayer = new GameLayer();
        gameLayerTablero = new GameLayerTablero();
        //float maxGameLayer = (gameLayer.getWidth())/3;
        gameLayer.setWidth(getWidth()/4);
        gameLayerTablero.setPosition(getWidth()/4, 0);
        gameLayerTablero.setWidth(((getWidth()*3)/4));
        gameLayer.setHeight(getHeight());
        gameLayerTablero.setHeight(getHeight());
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