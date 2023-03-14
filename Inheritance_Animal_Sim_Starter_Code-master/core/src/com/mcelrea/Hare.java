package com.mcelrea;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Hare extends Animal {

    protected Texture sleepImage;
    protected boolean isMoving = false;
     public Hare(int x,int y){
         super(x,y);
         image = new Texture("hare moving.png");
         sleepImage = new Texture("hare sleeping.png");
     }

    public void act(){
        int chance = (int) (1 + Math.random() * 100);
        if (chance <= 2) {
            x+=10;
            isMoving = true;
        }
        else if( chance<=4){
            x+=5;
            isMoving = true;
        }
        else{
            isMoving = false;
        }
    }
    @Override
    public void draw(SpriteBatch batch){
         if(isMoving == true){
             batch.draw(image,x,y,50,50);
         }
         else{
             batch.draw(sleepImage,x,y,50,50);
         }

    }

    @Override
    public String toString(){
        return "Hare";
    }
}
