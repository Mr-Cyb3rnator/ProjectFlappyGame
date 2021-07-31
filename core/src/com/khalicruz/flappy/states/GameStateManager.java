package com.khalicruz.flappy.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class GameStateManager {

    private Stack<states> states;

    public GameStateManager(){
        states = new Stack<states>();
    }

    public void push(states states1){
        states.push(states1);
    }

    public void pop(){
        states.pop().dispose();
    }

    public void set(states states1){
        states.pop().dispose();
        states.push(states1);
    }

    public void update(float dt){
        states.peek().update(dt);
    }

    public void render(SpriteBatch sb){
        states.peek().render(sb);
    }
}
