package com.example.planboardv3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.widget.TextView;

@SuppressLint("NewApi")
public class Ball extends TextView implements OnTouchListener, //농구공 클래스
OnDragListener{

	
	private float pX;
	private float pY;
	
	public Ball(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		
	
	}

	@Override
	public boolean onTouch(View view, MotionEvent motionEvent) {
		if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
			DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
			view.startDrag(null, shadowBuilder, view, 0);
			view.setVisibility(View.INVISIBLE);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean onDrag(View layoutview, DragEvent event) {

		switch (event.getAction()) {
		case DragEvent.ACTION_DROP:

			float X = event.getX();
			float Y = event.getY();

			View view = (View) event.getLocalState();
			view.setX(X - (view.getWidth() / 2));
			view.setY(Y - (view.getHeight() / 2));
			view.setVisibility(View.VISIBLE);

			
			
		default:
			break;
		}

		return true;
	}

	
}
