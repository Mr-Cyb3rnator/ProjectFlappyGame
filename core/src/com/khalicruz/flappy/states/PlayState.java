package com.khalicruz.flappy.states;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.khalicruz.flappy.flappygame;
import com.khalicruz.flappy.sprites.Bird;
import com.khalicruz.flappy.sprites.Tube;

import javax.swing.JLabel;

public class PlayState extends states {

    SpriteBatch batch;

    private static final int TUBE_SPACING = 150;
    private static final int TUBE_COUNT = 150;
    private static final int GROUND_Y_OFFSET = -150;

    private Bird bird;

    private Texture bg;

    private Texture ground;
    private Vector2 groundpos1;
    private Vector2 groundpos2;

    private Array<Tube> tubes;


    public PlayState(GameStateManager gsm) {

        super(gsm);
        bird = new Bird(50,320);
        camera.setToOrtho(false, flappygame.WIDTH/2, flappygame.HEIGHT /2 );
        bg = new Texture("bgMegamanjuego.png");

        ground = new Texture("ground.png");
        groundpos1 = new Vector2( camera.position.x - camera.viewportWidth/2+GROUND_Y_OFFSET, 0);
        groundpos2 = new Vector2 ( (camera.position.x - camera.viewportWidth/2)+ground.getWidth()+GROUND_Y_OFFSET,0);

        tubes = new Array<Tube>();

        for ( int i = 1; i <= TUBE_COUNT; i++){
            tubes.add(new Tube(i *(TUBE_SPACING+ Tube.TUBE_WIDTH)));
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
        updateGround();
        bird.update(dt);

        camera.position.x = bird.getPosition().x + 80;

        for (int i = 0; i < tubes.size; i++){
            Tube tube = tubes.get(i);
            if (camera.position.x - (camera.viewportWidth/2) > tube.getPosTopTube().x + tube.getTopTube().getWidth()){
                tube.reposition(tube.getPosTopTube().x+((Tube.TUBE_WIDTH + TUBE_SPACING) * TUBE_COUNT));
            }

            if ( tube.collides(bird.getBounds())){
                gsm.set(new GameOverState(gsm));
            }

        }

        if (bird.getPosition().y <= ground.getHeight())
            gsm.set(new GameOverState(gsm));

        camera.update();
    }

    @Override
    protected void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(bg, camera.position.x - (camera.viewportWidth / 2),camera.position.y - (camera.viewportHeight / 2), flappygame.WIDTH / 2, flappygame.HEIGHT /2);
        spriteBatch.draw(bird.getTexture(),bird.getPosition().x,bird.getPosition().y);


        for ( Tube tube : tubes) {
            spriteBatch.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
            spriteBatch.draw(tube.getBottomTube(), tube.getPosBotTube().x, tube.getPosBotTube().y);
        }
        spriteBatch.draw(ground, groundpos1.x, groundpos1.y);
        spriteBatch.draw ( ground, groundpos2.x, groundpos2.y);



        spriteBatch.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        ground.dispose();
        bird.dispose();
        for(Tube tube: tubes)
            tube.dispose();
        System.out.println("Play state disposed");
    }

    public void updateGround(){
        if((camera.position.x - camera.viewportWidth/2+GROUND_Y_OFFSET)> groundpos1.x + ground.getWidth()){
            groundpos1.add(ground.getWidth()*2, 0);

        }
        if((camera.position.x - camera.viewportWidth/2+GROUND_Y_OFFSET)> groundpos2.x + ground.getWidth()){
            groundpos2.add(ground.getWidth()*2, 0);

        }
    }
}
