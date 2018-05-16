/*
 * Copyright (c) 2018 franciscoquintana<https://github.com/franciscoquintana>.
 */

package net.ddns.noidea.Graphics;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class GameScene extends Stage {
       private GameLayer gameLayer;
    public GameScene(){
        super(new ScreenViewport());

        gameLayer = new GameLayer();
        gameLayer.setWidth(getWidth()/3);
        gameLayer.setHeight(getHeight());
        gameLayer.build();
        addActor(gameLayer);
    }

    public void update() {
        gameLayer.update();
    }
}

