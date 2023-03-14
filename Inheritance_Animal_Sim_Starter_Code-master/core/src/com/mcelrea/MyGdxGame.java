package com.mcelrea;

/*
 * If you are using Intellij idea, this might help:
 *    Settings -> Build, Execution, Deployment ->
 *                Gradle ->
 *                Build and run using: IntelliJ IDEA
 */

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	ShapeRenderer shapeRenderer;
	BitmapFont defaultFont;
	public static String winnerText = "";
	ArrayList<Animal> animals = new ArrayList<>();
	public final static int finishX = 920;


	public void addAnimals(){
		animals.add(new Kangaroo(5,600));
		animals.add(new Rat(5,500));
		animals.add(new Turtle(5,400));
		animals.add(new Hare(5,300));
	}

	public void letThemAct(){
		for(Animal a: animals){
			a.act();
			if(a.isFinished() && winnerText.equals("")){
				winnerText = "Winner is " + a.toString();
			}
		}
	}

	public void drawAnimals(){
		for(Animal a: animals){
			a.draw(batch);
		}
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		defaultFont= new BitmapFont();
		defaultFont.setColor(1,0,0,1);
		addAnimals();
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);

		//All AI code
		if(winnerText.equals(""))
			letThemAct();

		shapeRenderer.setAutoShapeType(true);
		shapeRenderer.setColor(1,0,0,0);
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.rect(950,0,20,800);
		shapeRenderer.end();

		//MUST draw all graphics between begin() and end()
		batch.begin();
		drawAnimals();
		defaultFont.draw(batch,winnerText,400,400);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
