package com.redink.seequence;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.hardware.SensorEvent;
import android.view.MotionEvent;

public abstract class Screen {
	
	protected Context context;
	protected Activity activity;
	protected List<ScreenElement> elements;
	
	public Screen(Activity activity){
		this.context = activity;
		this.activity = activity;
	}

	public abstract void loadContent();

	public abstract void draw(Canvas canvas);
	
	public void drawElements(Canvas canvas)
	{
		for (ScreenElement element : elements)
		{
				element.update();
				element.draw(canvas);
		}	
	}

	public abstract void update();
	
	public abstract void pause();
	
	public abstract void ready();

	public boolean processTouchInput(MotionEvent event){
		
		for (ScreenElement element : elements)
		{
			element.onTouchEvent(event);
		}
		return true;
	}
	
	public boolean processMotionInput(SensorEvent event){
		for (ScreenElement element : elements){
			element.onAccelerometerEvent(event);
		}
		return true;
	}

}
