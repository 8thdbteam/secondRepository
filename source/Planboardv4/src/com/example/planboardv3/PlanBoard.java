package com.example.planboardv3;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

@SuppressLint("NewApi")
public class PlanBoard extends Activity implements OnTouchListener, //작전판 보기 버튼 클릭시 발생하는 인텐트
		OnDragListener {

	float screenWidth; // 스크린 너비
	float screenHeight; // 스크린 높이
	private Ball ball;;// 농구공
	private Player redPlayer[] = new Player[5]; // 빨강 선수
	private Player bluePlayer[] = new Player[5]; // 파랑 선수
	private LinearLayout linearLayout;
	private int flag_court = 0; // 하프 코트, 풀코트 식별자

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.basketballcourt);

		linearLayout = (LinearLayout) findViewById(R.id.court);

		setBall(R.id.court, ball);

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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.

		menu.add(0, 0, 0, "하프코트/풀코드 변경");
		menu.add(0, 1, 0, "선수추가");
		menu.add(0, 2, 0, "전술저장하기");

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case 0: // To change court size to half or full
			if (flag_court == 0) { // 하프코트로 변경
				setContentView(R.layout.basketballcourt_half);
				setBall(R.id.court, ball);
				flag_court = 1;
			} else { // 풀코트로 변경
				setContentView(R.layout.basketballcourt);
				setBall(R.id.court, ball);
				flag_court = 0;
			}
			initPlayer(redPlayer,bluePlayer);
			break;
		case 1: // 선수 추가 버튼 ->빨강 or 파랑 선택
			String[] addPlayerMenuItems = { "빨강팀 추가", "파랑팀 추가" };
			Builder dialog = new AlertDialog.Builder(this);
			dialog.setTitle("선수추가");
			dialog.setItems(addPlayerMenuItems, new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {

				
					switch (which) {
					case 0:

						//선수 추가시 팀당 최대 5명이 넘지않도록
						if (redPlayer[0] != null) {
							Toast.makeText(PlanBoard.this, "선수추가 불가능", 2)
									.show();

							break;
						}
						setPlayer(R.id.court, redPlayer,R.drawable.redplayer);

						break;

					case 1:

						
						if (bluePlayer[0] != null) {
							Toast.makeText(PlanBoard.this, "선수추가 불가능", 2)
									.show();
							break;
						}
						setPlayer(R.id.court, bluePlayer,R.drawable.blueplayer);

						break;
					}
				}
			});
			dialog.show();
			return true;
		case 2:
			Intent intent = new Intent(PlanBoard.this, SaveMode.class);
			startActivity(intent);
			break;
			/* 애니메이션 효과
			TranslateAnimation ani = new TranslateAnimation(0,
					(screenWidth / 2) - redPlayer[0].getX(), 0,
					(screenHeight / 2) - redPlayer[0].getY());
			ani.setFillAfter(true); // 애니메이션 후 이동한좌표에
			ani.setDuration(1000); // 지속시간

			redPlayer[0].startAnimation(ani);
			break;
			*/
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	public void initPlayer(Player[] player1,Player[] player2){
		for (int i = 0; i < 5; i++) {// 선수들 초기화
			redPlayer[i] = null;
			bluePlayer[i] = null;
		}
	}
	// 공을 레이아웃에 추가함
	public void setBall(int layoutId, Ball ball) {
		linearLayout = (LinearLayout) findViewById(layoutId);
		ball = new Ball(this);
		ball.setBackgroundResource(R.drawable.basketball);
		ball.setTextSize(20);
		ball.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT));

		LayoutParams params = (LayoutParams) ball.getLayoutParams();
		params.width = 60;
		params.height = 60;
		ball.setLayoutParams(params);
		// adding view to layout
		linearLayout.addView(ball);
		// make visible to program

		ball.setOnTouchListener(this);
		ball.getRootView().setOnDragListener(this);
	}

	// 선수를 레이아웃에 추가함
	public void setPlayer(int layoutId, Player[] player, int resId) {

		linearLayout = (LinearLayout) findViewById(layoutId);

		for (int i = 0; i < 5; i++) {
			player[i] = new Player(this);

			player[i].setBackgroundResource(resId);
			player[i].setGravity(Gravity.CENTER);
			player[i].setText(String.valueOf(i + 1));
			player[i].setTextSize(20);

			player[i].setLayoutParams(new LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

			LayoutParams params = (LayoutParams) player[i].getLayoutParams();
			if (flag_court == 0) {
				params.width = 60;
				params.height = 60;
			} else {
				params.width = 90;
				params.height = 90;
			}
			player[i].setLayoutParams(params);
			// adding view to layout
			linearLayout.addView(player[i]);
			// make visible to program

			player[i].setOnTouchListener(this);
			player[i].getRootView().setOnDragListener(this);
		}

	}
}
