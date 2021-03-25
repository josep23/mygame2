package com.mygdx.game2;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


import java.util.ArrayList;

public class PantallaJuego extends BaseScreen {

    PantallaJuego(MyGdxGame game) {
        super(game);
    }

    SpriteBatch spriteBatch;
    Texture background, ballonRed, ballonGreen, ballonBlue;

    int i;
    int Puntucion;
    int Velocidad=0;
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


        //crea globos
        if (ContadorSegundos > 5 && ContadorSegundosReset > 5){
            ContadorSegundosReset=0;
            Arrayglobos.add(globo);

        }
        //Guarda los globos en array
        for (i = 0; i < Arrayglobos.size(); i++) {
            spriteBatch.draw(Arrayglobos.get(i).texture,Arrayglobos.get(i).x,Arrayglobos.get(i).y,Arrayglobos.get(i).size,Arrayglobos.get(i).size);

        }

        //hace que suban los globos
        for (int j = 0; j <Arrayglobos.size(); j++) {
            Arrayglobos.get(j).y++;
        }
        //comprueba que lleguen al tope de altura
        //for (int jj = 0; jj <Arrayglobos.size() ; jj++) {
          //  if (Arrayglobos.get(jj).y ==480){
            //    Arrayglobos.get(jj).y=Arrayglobos.get(jj).y-y2;
            //}
        //}
        //quita puntos si llega al techo
        for (int j = 0; j < Arrayglobos.size(); j++) {
            if (Arrayglobos.get(j).y>=479){
                Puntucion--;
                Arrayglobos.remove(j);
            }
        }

        System.out.println("Contador de segundos " + ContadorSegundos);
        System.out.println("Contador de segundosReset " +ContadorSegundosReset);
        System.out.println("ArrayGlobos "+ Arrayglobos.size());
        System.out.println("Puntuacion "+ Puntucion);
        System.out.println("VELOCIDAD "+ Velocidad);
        spriteBatch.end();
    }
}
