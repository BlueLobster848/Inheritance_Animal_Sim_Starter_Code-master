package com.mcelrea;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Animal {

    protected int x;
    protected int y;
    protected Texture image = new Texture("animal foot.png");
    protected Texture bloodimage = new Texture("blood splatter.png");

    public Animal(int x, int y){
        this.x = x;
        this.y = y;

    }

    public void draw(SpriteBatch batch){
        if(MyGdxGame.winnerText.equals("")) {
            batch.draw(image, x, y, 50, 50);
        }
        else if(x <= 920) {
            batch.draw(bloodimage, x, y, 50, 50);
        }
        else{
            batch.draw(image,x,y,50,50);
        }


    }

    public void act() {
        int chance = (int) (1 + Math.random() * 100);
        if (chance <= 50) {
            x++; //move one step to the right
        }
        else{
            x--; //move one step to the left
            if(x<0) {
                x = 0;
            }
        }

    }

    public boolean isFinished(){
        return this.x >MyGdxGame.finishX;
    }

    @Override
    public String toString(){
        return "Animal";
    }

}
