package com.mcelrea;

import com.badlogic.gdx.graphics.Texture;

public class Turtle extends Animal {
     public Turtle(int x, int y){
         super(x,y);
         image = new Texture("tortoise.png");
     }

     @Override
     public void act(){
         int chance = (int) (1 + Math.random() * 100);
         if (chance <= 10) {
             x+=2;
         }
         else if( chance<=50){
             x+=1;
         }
         else if(chance<=40){
             x--;
         }
     }

    @Override
    public String toString(){
        return "Turtle";
    }
}
