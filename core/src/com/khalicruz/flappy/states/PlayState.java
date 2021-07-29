package com.khalicruz.flappy.states;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.khalicruz.flappy.flappygame;
import com.khalicruz.flappy.sprites.Bird;
import com.khalicruz.flappy.sprites.Tubo;

import sun.net.www.protocol.http.HttpURLConnection;

public class PlayState extends states {


    private static final int TUBE_SPACING = 180;
    private static final int TUBE_COUNT = 4;
    private Bird bird;
    private Texture bg;
    private Tubo tube;

    private Array<Tubo> Tubos;

    public PlayState(GameStateManager gsm) {

        super(gsm);
        bird = new Bird(50,320);
        camera.setToOrtho(false, flappygame.WIDTH/2, flappygame.HEIGHT /2 );
        bg = new Texture( "bgMegamanjuego.png" );
        tube = new Tubo (100);
        Tubos = new Array<Tubo>();

        for (int i = 1; i<= TUBE_COUNT; i++){
            Tubos.add(new Tubo(i*(TUBE_SPACING + Tubo.TUBE_WIDTH)));
        }
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

        camera.position.x = bird.getPosition().x + 80;

        for (Tubo tubo : Tubos){
            if ( camera.position.x - (camera.viewportWidth/2) > tubo.getPosTopTube().x + tubo.getTopTube().getWidth()){
                tubo.reposition(tubo.getPosTopTube().x+((Tubo.TUBE_WIDTH+TUBE_SPACING)*TUBE_COUNT));
            }
        }
        camera.update();
    }

    @Override
    protected void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(bg, camera.position.x - (camera.viewportWidth / 2),camera.position.y - (camera.viewportHeight / 2), flappygame.WIDTH / 2, flappygame.HEIGHT /2);
        spriteBatch.draw(bird.getBird(),bird.getPosition().x,bird.getPosition().y);
        for (Tubo tube : Tubos) {
            spriteBatch.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
            spriteBatch.draw(tube.getBottonTube(), tube.getPosBotTube().x, tube.getPosBotTube().y);
        }
        spriteBatch.end();
    }

    @Override
    public void dispose() {

    }
}
