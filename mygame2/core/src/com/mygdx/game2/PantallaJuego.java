package com.mygdx.game2;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Interpolation;

import java.util.ArrayList;

import sun.awt.X11.XGlobalCursorManager;

public class PantallaJuego extends BaseScreen {

    PantallaJuego(MyGdxGame game) {
        super(game);
    }

    SpriteBatch spriteBatch;
    Texture background, ballonRed, ballonGreen, ballonBlue;
    int i;

    int Random = (int) (Math.random()*10);
    float ContadorSegundos;
    float ContadorSegundosReset;
    ArrayList<Globo> Arrayglobos = new ArrayList<Globo>();



    @Override
    public void show() {
        spriteBatch = new SpriteBatch();

        background = new Texture("background.png");
        ballonRed = new Texture("ballon_red.png");
        ballonGreen = new Texture("ballon_green.png");
        ballonBlue = new Texture("ballon_blue.png");
    }

    @Override
    public void render(float delta) {
        int x = (int) (Math.random() * 639);
        int y = (int) (Math.random() * 479);
        int size = (int) (Math.random() * 50);
        Globo globo= new Globo (x, y, size , 1);
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, 640, 480);
        ContadorSegundos+=delta;
        ContadorSegundosReset+=delta;

        if (ContadorSegundos > 5 && ContadorSegundosReset > 5){
            ContadorSegundosReset=0;
            Arrayglobos.add(globo);

        }
        for (i = 0; i < Arrayglobos.size(); i++) {
            spriteBatch.draw(Arrayglobos.get(i).texture,Arrayglobos.get(i).x,Arrayglobos.get(i).y,Arrayglobos.get(i).size,Arrayglobos.get(i).size);

        }
        System.out.println("Contador de segundos " + ContadorSegundos);
        System.out.println("Contador de segundosReset " +ContadorSegundosReset);
        System.out.println("ArrayGlobos "+ Arrayglobos.size());
        spriteBatch.end();
    }
}
