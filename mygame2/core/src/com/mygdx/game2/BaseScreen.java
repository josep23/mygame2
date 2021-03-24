package com.mygdx.game2;

import com.badlogic.gdx.Screen;
import com.mygdx.game2.MyGdxGame;

public class BaseScreen implements Screen {
    public final MyGdxGame game;
    public BaseScreen(MyGdxGame game){ this.game = game; }
    public void setScreen(Screen screen){ game.setScreen(screen); }
    @Override public void show() {}
    @Override public void render(float delta) {}
    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() {}
}