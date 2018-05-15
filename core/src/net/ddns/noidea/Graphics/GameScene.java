/*
 * Copyright (c) 2018 franciscoquintana<https://github.com/franciscoquintana>.
 */

package net.ddns.noidea.Graphics;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class GameScene extends Stage {
    int num = 0;
    private GameLayer gameLayer;
    public GameScene(){
        super(new ScreenViewport());
        /*Texture texture = new Texture("monopoly.jpg");

        Image image2 = new Image(texture);
        image2.setSize(200,200);
        image2.setPosition(getWidth()/2-image2.getWidth()/2,getHeight()-image2.getHeight());

        image2.addListener(new InputListener() {
                               public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                                   System.out.println("No me toques al tio " + num++);
                                   return true;
                               }
                           });




        addActor(image2);*/

        gameLayer = new GameLayer();
        gameLayer.setWidth(getWidth()/3);
        gameLayer.setHeight(getHeight());
        gameLayer.build();
        //gameLayer.setPosition(getWidth()/2-gameLayer.getWidth(), getHeight()/2);
        addActor(gameLayer);
    }

    public void update() {
        gameLayer.update();
    }
}
