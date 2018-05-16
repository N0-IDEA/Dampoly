/*
 * Copyright (c) 2018 franciscoquintana<https://github.com/franciscoquintana>.
 */

package net.ddns.noidea.Graphics;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameScene extends Stage {
       private GameLayer gameLayer;
    public GameScene(){
        super();

        setViewport(new FitViewport(getWidth(),getHeight()));

        gameLayer = new GameLayer();
        //float maxGameLayer = (gameLayer.getWidth())/3;
        gameLayer.setWidth(getWidth()/3);
        gameLayer.setHeight(getHeight());
        addActor(gameLayer);
    }

    public void init() {
        gameLayer.build();
    }

    public void update() {
        gameLayer.update();
    }
}

