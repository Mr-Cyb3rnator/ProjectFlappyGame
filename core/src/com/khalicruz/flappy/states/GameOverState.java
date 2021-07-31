package com.khalicruz.flappy.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.khalicruz.flappy.flappygame;

//Herencia de la clase states
public class GameOverState extends states{

    private Texture Background;
    private Texture GameOver;
    private Texture playButton;

    public GameOverState (GameStateManager gameStateManager){
        super(gameStateManager);
        Background= new Texture("bgMegaman.png");
        GameOver= new Texture("gameover.png");
        playButton = new Texture("playButton.png");
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    protected void update(float dt) {
        handleInput();
    }

    @Override
    protected void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();

        spriteBatch.draw(Background, 0,0, flappygame.WIDTH, flappygame.HEIGHT);

        spriteBatch.draw(GameOver, (flappygame.WIDTH/2)-(playButton.getWidth()/2),(flappygame.HEIGHT/2)-(playButton.getHeight()));

        spriteBatch.draw(playButton, (flappygame.WIDTH/2)-(playButton.getWidth()/2),(flappygame.HEIGHT/3)-(playButton.getHeight()));

        spriteBatch.end();
    }

    @Override
    public void dispose() {
        GameOver.dispose();
        Background.dispose();
        playButton.dispose();
    }
}
