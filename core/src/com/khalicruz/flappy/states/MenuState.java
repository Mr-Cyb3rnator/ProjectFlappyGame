package com.khalicruz.flappy.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.khalicruz.flappy.flappygame;

//Herencia de la clase states
public class MenuState extends states{

    private Texture background;
    private Texture playButton;

    public MenuState(GameStateManager gameStateManager) {
        super(gameStateManager);
        background = new Texture("bgMegaman.png");
        playButton = new Texture("playbtn.png");
    }

    @Override
    public void handleInput() {

        if (Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
            dispose();
        }

    }

    @Override
    protected void update(float dt) {
        handleInput();
    }

    @Override
    protected void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();

        spriteBatch.draw(background, 0,0, flappygame.WIDTH, flappygame.HEIGHT);

        spriteBatch.draw(playButton, (flappygame.WIDTH/2)-(playButton.getWidth()/2),(flappygame.HEIGHT/3)-(playButton.getHeight()));

        spriteBatch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playButton.dispose();
    }
}
