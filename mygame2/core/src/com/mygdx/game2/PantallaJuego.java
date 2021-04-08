package com.mygdx.game2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


import java.util.ArrayList;

// ALTO 480 -- ANCHO 640
public class PantallaJuego extends BaseScreen {

    private BitmapFont bitmapFont;

    PantallaJuego(MyGdxGame game) {
        super(game);
    }

    SpriteBatch spriteBatch;
    Texture background, ballonRed, ballonGreen, ballonBlue;

    int i;

    public PantallaJuego(MyGdxGame game, int puntuacion) {
        super(game);
        this.puntuacion = puntuacion;
    }

    int puntuacion;
    int velocidad =5;
    int Random = (int) (Math.random()*10);
    float contadorSegundos;
    float contadorSegundosReset;
    ArrayList<Globo> arrayglobos = new ArrayList<Globo>();


    @Override
    public void show() {
        spriteBatch = new SpriteBatch();
        bitmapFont = new BitmapFont();
        bitmapFont.getData().setScale(1);
        bitmapFont.setColor(new Color(0, 0, 0, 1));

        background = new Texture("nieve2.jpg");
        ballonRed = new Texture("ballon_red.png");
        ballonGreen = new Texture("ballon_green.png");
        ballonBlue = new Texture("ballon_blue.png");

    }

    private void update(float delta) {

        for (int j = 0; j < arrayglobos.size(); j++) {
            if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
                if (Gdx.input.getX() == (int) arrayglobos.get(j).x && Gdx.input.getY()== (int) arrayglobos.get(j).y){
                    System.out.println("FUNCIONA");
                }
            }
        }


        int x = (int) (Math.random() * 639);
        int y = (int) (Math.random() * 200);
        int size = (int) (10 + (Math.random() * 50));

        contadorSegundos +=delta;
        contadorSegundosReset +=delta;

        //crea globos
        if (contadorSegundos > velocidad && contadorSegundosReset > velocidad){
            contadorSegundosReset =0;
            Globo globo = new Globo (x, y, size , 1);

            arrayglobos.add(globo);

        }
        //hace que suban los globos
        for (int j = 0; j < arrayglobos.size(); j++) {
            arrayglobos.get(j).y++;
        }
        //quita puntos si llega al techo
        for (int j = 0; j < arrayglobos.size(); j++) {
            if (arrayglobos.get(j).y>=479){
                --puntuacion;
                arrayglobos.remove(j);
            }
        }

        for (int j = 0; j < arrayglobos.size(); j++) {                  
            if (puntuacion <-50){
                velocidad= (int) 0.5;
            }
            else if (puntuacion <-40){
                velocidad=(int) 1;
            }else if (puntuacion <-30){
                velocidad=(int) 2;
            }else if (puntuacion <-20){
                velocidad=(int) 3;
            }else if (puntuacion <-10){
                velocidad=(int) 4;
            }
            else if (puntuacion <-5){
                velocidad=(int) 5;
            }
        }
    }


    @Override
    public void render(float delta) {
        update(delta);



        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, 640, 480);
        bitmapFont.draw(spriteBatch, " TU PUNTUACION ES " + puntuacion, 450, 460);

        //Guarda los globos en array
        for (i = 0; i < arrayglobos.size(); i++) {
            spriteBatch.draw(arrayglobos.get(i).texture, arrayglobos.get(i).x, arrayglobos.get(i).y, arrayglobos.get(i).size, arrayglobos.get(i).size);
        }


        System.out.println("Contador de segundos " + contadorSegundos);
        System.out.println("Contador de segundosReset " + contadorSegundosReset);
        System.out.println("ArrayGlobos "+ arrayglobos.size());
        System.out.println("Puntuacion "+ puntuacion);
        System.out.println("VELOCIDAD "+ velocidad);
        spriteBatch.end();
    }
}
