package com.khalicruz.flappy.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.khalicruz.flappy.flappygame;

//Herencia de la clase states
public class MenuState extends states{

    private Texture background;
    private Texture playButton;
    private Texture LogoWulu;

    public MenuState(GameStateManager gameStateManager) {
        super(gameStateManager);
        camera.setToOrtho(false, flappygame.WIDTH/2, flappygame.HEIGHT /2 );
        background = new Texture("bgMegamanjuego.png");
        playButton = new Texture("playbtn.png");
        LogoWulu = new Texture("FlappyWuluVerde2.png");
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

        spriteBatch.draw(LogoWulu, camera.position.x - ((camera.viewportWidth / 2)), camera.position.y- (camera.viewportHeight / 14), 556, 331);

        spriteBatch.draw(playButton, camera.position.x - ((camera.viewportWidth / 2)-120), camera.position.y- (camera.viewportHeight / 3));

        spriteBatch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playButton.dispose();
        LogoWulu.dispose();
        System.out.println("Menu state disposed");
    }
}
