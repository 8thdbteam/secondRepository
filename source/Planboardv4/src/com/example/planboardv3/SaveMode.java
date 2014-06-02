package com.example.planboardv3;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

@SuppressLint("NewApi")
public class SaveMode extends Activity implements OnTouchListener, //전술 저장을 위한 모드를 의미하는 액티비티
		OnDragListener {

	float screenWidth; // 스크린 너비
	float screenHeight; // 스크린 높이
	private Ball ball;;// 농구공
	private Player redPlayer[] = new Player[5]; // 빨강 선수
	private Player bluePlayer[] = new Player[5]; // 파랑 선수
	private LinearLayout linearLayout;
	private int flag_court = 0; // 하프 코트, 풀코트 식별자

	private RadioGroup rg;
	private Button btnSave;
	private Button btnAllSave;
	
	private int rdId[]={0,0,0,0,0,0,0,0,0,0};
	private int ballX[]=new int[10];
	private int ballY[]=new int[10];
	private int redX[][]=new int[5][];
	private int redY[][]=new int[5][];
	private int blueX[][]=new int[5][];
	private int blueY[][]=new int[5][];
	

	private String player_x[] = new String[10];
	private String player_y[] = new String[10];
	private String ball_x = "";
	private String ball_y = "";

	SQLiteDatabase db;
	MySQLiteOpenHelper helper;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initPlayer(redPlayer,bluePlayer);
		setContentView(R.layout.court_frame);
		
		ball = new Ball(this);
		for(int i=0;i<5;i++){
			redPlayer[i]=new Player(this);
			bluePlayer[i]=new Player(this);
		}
	
		for (int i = 0; i < 5; i++) {
			redX[i] = new int[10];
			redY[i] = new int[10];
			blueX[i] = new int[10];
			blueY[i] = new int[10];
		}
		
		setBall(R.id.courtpart);
		setPlayer(R.id.courtpart, bluePlayer,	R.drawable.blueplayer);
		setPlayer(R.id.courtpart, redPlayer,	R.drawable.redplayer);
		
		rg=(RadioGroup)findViewById(R.id.rdgroup);
		rg.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// 라디오 버튼 변경시 저장된 위치로 이동
				
				
				for(int i=0;i<10;i++){
					if(rdId[i]==rg.getCheckedRadioButtonId()){
						ball.setX(ballX[i]);
						ball.setY(ballY[i]);

						for (int k = 0; k < 5; k++) {
							redPlayer[k].setX(redX[k][i]);
							redPlayer[k].setY(redY[k][i]);
							bluePlayer[k].setX(blueX[k][i]);
							bluePlayer[k].setY(blueY[k][i]);
						}

						break;
					}
					
				}
			}
			
		});
		
		btnSave=(Button)findViewById(R.id.btnSave);
		btnSave.setOnClickListener(new android.view.View.OnClickListener(){

			@Override
			public void onClick(View v) {
				// 각 라디오 프레임에 포메이션 저장
				
				int i=0;
				while(true){
					if(rdId[i]==rg.getCheckedRadioButtonId()){
						ballX[i]=(int) ball.getX();
						ballY[i]=(int) ball.getY();
						for(int j=0;j<5;j++){
							
								redX[j][i] = (int) redPlayer[j].getX();
								redY[j][i] = (int) redPlayer[j].getY();
								blueX[j][i] = (int) bluePlayer[j].getX();
								blueY[j][i] = (int) bluePlayer[j].getY();
							
						}
						break;
					}
					else if(rdId[i]==0){
						rdId[i]=rg.getCheckedRadioButtonId();
						ballX[i]=(int) ball.getX();
						ballY[i]=(int) ball.getY();
						for(int j=0;j<5;j++){
							
								redX[j][i] = (int) redPlayer[j].getX();
								redY[j][i] = (int) redPlayer[j].getY();
								blueX[j][i] = (int) bluePlayer[j].getX();
								blueY[j][i] = (int) bluePlayer[j].getY();
							
						}
						break;
					}
					else
						i++;
				}
				

			}
			
		});

		helper = new MySQLiteOpenHelper(this, // 현재 화면의 context
				"person.db", // 파일명
				null, // 커서 팩토리
				1); // 버전 번호
		
		for(int i=0;i<10;i++){ //데이터 베이스에 저장할 선수좌표 초기화
			player_x[i]="";
			player_y[i]="";
			
		}
		btnAllSave=(Button)findViewById(R.id.btnAllSave);
		btnAllSave.setOnClickListener(new android.view.View.OnClickListener(){

			@Override
			public void onClick(View v) {
				// 각 저장된 라디오프레임을 전부 저장
				
				
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 10; j++) {
						if (i < 5)
							player_x[i]=player_x[i].concat(","+String.valueOf(redX[i][j]));
						else
							player_x[i]=player_x[i].concat(","+String.valueOf(blueX[i-5][j]));

					}
					ball_x=ball_x.concat(","+String.valueOf(ballX[i]));
				}
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 10; j++) {
						if (i < 5)
							player_y[i]=player_y[i].concat(","+String.valueOf(redY[i][j]));
						else
							player_y[i]=player_y[i].concat(","+String.valueOf(blueY[i-5][j]));

					}
					ball_y=ball_y.concat(","+String.valueOf(ballY[i]));
				}
				OpenPlanNameDlg();
				
			}
			
		});

	}
	 public void insert(String name, String p1x, String p1y,
			 String p2x, String p2y,
			 String p3x, String p3y,
			 String p4x, String p4y,
			 String p5x, String p5y,
			 String p6x, String p6y,
			 String p7x, String p7y,
			 String p8x, String p8y,
			 String p9x, String p9y,
			 String p10x, String p10y,
			 String bx, String by) {
	        db = helper.getWritableDatabase(); // db 객체를 얻어온다. 쓰기 가능
	 
	        ContentValues values = new ContentValues();
	        // db.insert의 매개변수인 values가 ContentValues 변수이므로 그에 맞춤
	        // 데이터의 삽입은 put을 이용한다.
	        values.put("name", name);
	        values.put("player1x", p1x);
	        values.put("player1y", p1y);
	        values.put("player2x", p2x);
	        values.put("player2y", p2y);
	        values.put("player3x", p3x);
	        values.put("player3y", p3y);
	        values.put("player4x", p4x);
	        values.put("player4y", p4y);
	        values.put("player5x", p5x);
	        values.put("player5y", p5y);
	        values.put("player6x", p6x);
	        values.put("player6y", p6y);
	        values.put("player7x", p7x);
	        values.put("player7y", p7y);
	        values.put("player8x", p8x);
	        values.put("player8y", p8y);
	        values.put("player9x", p9x);
	        values.put("player9y", p9y);
	        values.put("player10x", p10x);
	        values.put("player10y", p10y);
	        values.put("ballx", bx);
	        values.put("bally", by);
	        
	        db.insert("student", null, values); // 테이블/널컬럼핵/데이터(널컬럼핵=디폴트)
	        // tip : 마우스를 db.insert에 올려보면 매개변수가 어떤 것이 와야 하는지 알 수 있다.
	    }
	
	protected void OpenPlanNameDlg() {
		//전술저장 클릭 시 입력 팝업창 띄움
		Context mContext = getApplicationContext();
		LayoutInflater inflater = (LayoutInflater) mContext
				.getSystemService(LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.custom_dialog,
				(ViewGroup) findViewById(R.id.layout_root));

		AlertDialog.Builder aDialog = new AlertDialog.Builder(
				this);// 패키지이름
		aDialog.setTitle("작전명을 입력하세요");
		aDialog.setView(layout);
		final EditText editview=(EditText)layout.findViewById(R.id.pname);
		aDialog.setPositiveButton("저장",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,
							int which) {
						
						String str=editview.getText().toString();
						
						insert(str,
								 player_x[0],player_y[0],
								 player_x[1],player_y[1],
								 player_x[2],player_y[2],
								 player_x[3],player_y[3],
								 player_x[4],player_y[4],
								 player_x[5],player_y[5],
								 player_x[6],player_y[6],
								 player_x[7],player_y[7],
								 player_x[8],player_y[8],
								 player_x[9],player_y[9],
								 ball_x,ball_y);
						
					}
				});
		aDialog.setNegativeButton("취소",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,
							int which) {
					}
				});
		AlertDialog ad = aDialog.create();
		ad.show();

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

	
	

	public void initPlayer(Player[] player1,Player[] player2){
		for (int i = 0; i < 5; i++) {// 선수들 초기화
			redPlayer[i] = null;
			bluePlayer[i] = null;
		}
	}
	// 공을 레이아웃에 추가함
	public void setBall(int layoutId) {
		linearLayout = (LinearLayout) findViewById(layoutId);
		//ball = new Ball(this);
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
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.

		menu.add(0, 0, 0, "전술 보기");
		

		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 0:
			Intent intent = new Intent(this, AnimateMode.class);
			startActivity(intent);
			break;
			
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	
	}
}
