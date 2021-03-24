package com.mygdx.game2;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class ObjectScreen extends BaseScreen {

    ObjectScreen(MyGdxGame game) {
        super(game);
    }

    SpriteBatch spriteBatch;
    List<Globo> globoList;

    @Override
    public void show() {
        spriteBatch = new SpriteBatch();

        globoList = new ArrayList<>();
       // globoList.add(new Globo(10, 10, 30, 20, Globo.Color.ROJO));
       // globoList.add(new Globo(50, 50, 50, 12, Globo.Color.VERDE));
        //globoList.add(new Globo(100, 100, 70, 8, Globo.Color.AZUL));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        for(Globo globo: globoList) globo.update(delta);

        spriteBatch.begin();
        for(Globo globo: globoList) globo.render(spriteBatch);
        spriteBatch.end();
    }
}
