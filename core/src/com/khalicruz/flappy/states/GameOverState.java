package com.khalicruz.flappy.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.khalicruz.flappy.flappygame;

//Herencia de la clase states
public class GameOverState extends states{

    private Texture background;
    private Texture playButton;
    private Texture GameOver;

    public GameOverState(GameStateManager gameStateManager) {
        super(gameStateManager);
        camera.setToOrtho(false, flappygame.WIDTH/2, flappygame.HEIGHT /2 );
        background = new Texture("bgMegamanjuego.png");
        playButton = new Texture("playbtn.png");
        GameOver = new Texture("gameover.png");
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
        spriteBatch.setProjectionMatrix(camera.combined);

        spriteBatch.begin();

        spriteBatch.draw(background, camera.position.x - (camera.viewportWidth / 2),camera.position.y - (camera.viewportHeight / 2), flappygame.WIDTH / 2, flappygame.HEIGHT /2);

        spriteBatch.draw(GameOver, camera.position.x - ((camera.viewportWidth / 3)+20), camera.position.y, 384, 84);

        spriteBatch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playButton.dispose();
        GameOver.dispose();
        System.out.println("Game Over state disposed");
    }
}
