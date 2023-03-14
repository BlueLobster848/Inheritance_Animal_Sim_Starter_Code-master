package com.mcelrea;

import com.badlogic.gdx.graphics.Texture;

public class Rat extends Animal{

    public Rat(int x,int y){
        super(x,y);
        image = new Texture("rat.png");
    }

    @Override
    public void act(){
        int chance = (int) (1 + Math.random() * 100);
        if (chance <= 10) {
            x+=5;
        }
        else if( chance<=30){
            x+=3;
        }
        else if(chance<=50){
            x-=2;
        }
    }
    @Override
    public String toString(){
        return "Rat";
    }
}
