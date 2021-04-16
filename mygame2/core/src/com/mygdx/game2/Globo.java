package com.mygdx.game2;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Globo {



    enum Color {ROJO, VERDE, AZUL}

    static Texture globoRed = new Texture("ballon_red.png");
    static Texture globoGreen = new Texture("ballon_green.png");
    static Texture globoBlue = new Texture("ballon_blue.png");
    static Texture globoyellow = new Texture("ballon_amarillo.png");
    static Texture globorainbow = new Texture("ballon_rainbow.png");
    static Texture globoblanco = new Texture("ballon_blanco.png");
    static Texture globonegro = new Texture("ballon_negro.png");
    static Texture globonaranja = new Texture("ballon_naranja.png");
    static Texture ballonblanco = new Texture("ballon_blanco.png");
    static Texture ballonnaranja = new Texture("ballon_naranja.png");
    static Texture ballonnegro = new Texture("ballon_negro.png");
    static Texture ballonrainbow = new Texture("ballon_rainbow.png");

    Texture texture;
    float x, y, size;
    float speed;
    Color color;
    boolean remove = false;
    int elegircolor = (int) (Math.random() * 7);


    Globo(float x, float y, float size, float speed,boolean remove) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.speed = speed;
        this.remove = remove;

        if (elegircolor==1){
            texture = globoRed;
        }
        else if (elegircolor==2){
            texture = globoGreen;
        }
        else if (elegircolor==3){
            texture = globoBlue;
        }
        else if (elegircolor==4){
            texture = globoblanco;
        }
        else if (elegircolor==5){
            texture = globonaranja;
        }
        else if (elegircolor==6){
            texture = globonegro;
        }
        else if (elegircolor==7){
            texture = globorainbow;
        }
        else {
            texture = globoyellow;
        }
    }


    public void update(float delta) {
        x += speed * delta;
        y += speed * delta;
    }

    public void render(SpriteBatch spriteBatch) {
        //Texture texture;




     //   spriteBatch.draw(texture, x, y, size, size);
    }
}
