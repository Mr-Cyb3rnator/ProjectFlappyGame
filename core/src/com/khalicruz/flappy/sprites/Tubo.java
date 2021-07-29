package com.khalicruz.flappy.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Tubo {

    public static final int TUBE_WIDTH = 52;
    private static final int FLUCTUATION = 450;
    private static final int TUBE_GAP = 280;
    private static final int LOWEST_OPENING = 120;

    private Texture topTube;
    private  Texture BottonTube;

    private Vector2 posTopTube;
    private Vector2 posBotTube;

    private Random rand;

    public Texture getTopTube() {
        return topTube;
    }

    public void setTopTube(Texture topTube) {
        this.topTube = topTube;
    }

    public Texture getBottonTube() {
        return BottonTube;
    }

    public void setBottonTube(Texture bottonTube) {
        BottonTube = bottonTube;
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

    public Tubo(float x){
        topTube = new Texture("topTubeMegaman.png");
        BottonTube = new Texture("bottomTubeMegaman.png");

        rand = new Random();

        posTopTube = new Vector2(x,rand.nextInt(FLUCTUATION)+TUBE_GAP + LOWEST_OPENING);
        posBotTube = new Vector2(x, posTopTube.y-TUBE_GAP - BottonTube.getHeight());
    }

    public void reposition (float x){
        posTopTube.set(x,rand.nextInt(FLUCTUATION)+TUBE_GAP + LOWEST_OPENING);
        posBotTube.set(x, posTopTube.y-TUBE_GAP - BottonTube.getHeight());
    }

}
