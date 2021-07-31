package com.khalicruz.flappy.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Tube {
    public static final int TUBE_WIDTH = 170;

    private static final int FLUCTUATION = 130;
    private static final int TUBE_GAP = 200;
    private static final int LOWEST_OPENING = 120;

    private Texture topTube;
    private Texture bottomTube;

    private Vector2 posTopTube;
    private Vector2 posBotTube;

    private Random rand;

    private Rectangle boundsTop;
    private Rectangle boundsBot;

    public Tube( float x){
        topTube = new Texture("topTubeMegaman.png");
        bottomTube = new Texture("bottomTubeMegaman.png");

        rand = new Random();

        posTopTube = new Vector2(x, rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        posBotTube = new Vector2(x,posTopTube.y - TUBE_GAP - bottomTube.getHeight());

        boundsTop = new Rectangle (posTopTube.x, posTopTube.y, topTube.getWidth(), topTube.getHeight());
        boundsBot = new Rectangle (posBotTube.x, posBotTube.y, bottomTube.getWidth(), bottomTube.getHeight());

    }

    public void reposition( float x){

        posTopTube.set(x, rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        posBotTube.set(x,posTopTube.y - TUBE_GAP - bottomTube.getHeight());

        boundsTop.setPosition(posTopTube.x, posTopTube.y);
        boundsBot.setPosition(posBotTube.x, posTopTube.y);
    }

    public boolean collides (Rectangle player){
        return player.overlaps(boundsTop) || player.overlaps(boundsBot);
    }

    public Texture getTopTube() {
        return topTube;
    }

    public void setTopTube(Texture topTube) {
        this.topTube = topTube;
    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public void setBottomTube(Texture bottomTube) {
        this.bottomTube = bottomTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public void setPosTopTube(Vector2 posTopTube) {
        this.posTopTube = posTopTube;
    }

    public Vector2 getPosBotTube() {
        return posBotTube;
    }

    public void setPosBotTube(Vector2 posBotTube) {
        this.posBotTube = posBotTube;
    }

    public void dispose(){
        topTube.dispose();
        bottomTube.dispose();
    }

}
