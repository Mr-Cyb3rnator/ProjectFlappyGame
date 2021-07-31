package com.khalicruz.flappy.states;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.khalicruz.flappy.flappygame;
import com.khalicruz.flappy.sprites.Bird;

public class PlayState extends states {

    private Bird bird;

    public PlayState(GameStateManager gsm) {

        super(gsm);
        bird = new Bird(50,320);
        camera.setToOrtho(false, flappygame.WIDTH/2, flappygame.HEIGHT /2 );

    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){

            bird.jump();
        }
    }

    @Override
    protected void update(float dt) {
        handleInput();
        bird.update(dt);
    }

    @Override
    protected void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(bird.getBird(),bird.getPosition().x,bird.getPosition().y);
        spriteBatch.end();
    }

    @Override
    public void dispose() {

    }
}
