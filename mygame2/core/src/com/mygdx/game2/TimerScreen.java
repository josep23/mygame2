package com.mygdx.game2;

public class TimerScreen extends BaseScreen {

    float gameTime;
    float alarmTime;
    float alarmDuration = 1;  // 1 segundo

    TimerScreen(MyGdxGame game) {
        super(game);
    }

    @Override
    public void render(float delta) {

        gameTime += delta;

        if(gameTime > alarmTime){
            alarmTime = gameTime + alarmDuration;
            System.out.println("Alarm");
        }
    }
}