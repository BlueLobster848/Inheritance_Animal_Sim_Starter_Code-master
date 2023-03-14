package com.mcelrea;

import com.badlogic.gdx.graphics.Texture;

public class Kangaroo extends Animal{

    public Kangaroo(int x,int y){
        super(x,y);
        image = new Texture("kangaroo.png");
    }

    @Override
    public void act(){
        int chance = (int) (1 + Math.random() * 100);
        if (chance <= 30) {
            x+=3;
            y-=3;
        }
        else if( chance<=20){
            x+=2;
        }
        else if(chance<=50){
            x++;
            y+=3;
        }

    }
    @Override
    public String toString(){
        return "Kangaroo";
    }
}

