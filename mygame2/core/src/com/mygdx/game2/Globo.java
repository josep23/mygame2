package com.mygdx.game2;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Globo {

    enum Color {ROJO, VERDE, AZUL}

    static Texture globoRed = new Texture("ballon_red.png");
    static Texture globoGreen = new Texture("ballon_green.png");
    static Texture globoBlue = new Texture("ballon_blue.png");
    Texture texture;
    float x, y, size;
    float speed;
    Color color;
    int elegircolor = (int) (Math.random() * 3);


    Globo(float x, float y, float size, float speed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.speed = speed;

        if (elegircolor==1){
            texture = globoRed;
        }
        else if (elegircolor==2){
            texture = globoGreen;
        }
        else if (elegircolor==3){
            texture = globoBlue;
        }
        else {
            texture = globoBlue;
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
