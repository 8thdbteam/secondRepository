package com.example.planboardv3;

import java.util.StringTokenizer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AnimateMode extends Activity{
	
	private LinearLayout linearLayout;
	private String planName[];
	private int planCount=0;
	
	
	
	private Player redPlayer[]=new Player[5];
	private Player bluePlayer[]=new Player[5];
	
	private int ballX[]=new int[10];
	private int ballY[]=new int[10];
	private int playerX[][]=new int[10][];
	private int playerY[][]=new int[10][];
	

	private String player_x[] = new String[10];
	private String player_y[] = new String[10];
	private String ball_x = "";
	private String ball_y = "";
	
	SQLiteDatabase db;
    MySQLiteOpenHelper helper;

    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        setContentView(R.layout.court_animation);
        for (int i = 0; i < 10; i++) {
			playerX[i] = new int[10];
			playerY[i] = new int[10];
			
		}
        helper = new MySQLiteOpenHelper(this, // 현재 화면의 context
                "person.db", // 파일명
                null, // 커서 팩토리
                1); // 버전 번호
        
        openListFromDb();
        OpenPlanNameDlg();
        
    }
	// select
    public void select() {
 
        // 1) db의 데이터를 읽어와서, 2) 결과 저장, 3)해당 데이터를 꺼내 사용
 
        db = helper.getReadableDatabase(); // db객체를 얻어온다. 읽기 전용
        Cursor c = db.query("student", null, null, null, null, null, null);
 
        /*
         * 위 결과는 select * from student 가 된다. Cursor는 DB결과를 저장한다. public Cursor
         * query (String table, String[] columns, String selection, String[]
         * selectionArgs, String groupBy, String having, String orderBy)
         */
 
        
		// c의 int가져와라 ( c의 컬럼 중 id) 인 것의 형태이다.
		int _id = c.getInt(c.getColumnIndex("_id"));
		player_x[0] = c.getString(c.getColumnIndex("player1x"));
		player_y[0] = c.getString(c.getColumnIndex("player1y"));
		player_x[1] = c.getString(c.getColumnIndex("player2x"));
		player_y[1] = c.getString(c.getColumnIndex("player2y"));
		player_x[2] = c.getString(c.getColumnIndex("player3x"));
		player_y[2] = c.getString(c.getColumnIndex("player3y"));
		player_x[3] = c.getString(c.getColumnIndex("player4x"));
		player_y[3] = c.getString(c.getColumnIndex("player4y"));
		player_x[4] = c.getString(c.getColumnIndex("player5x"));
		player_y[4] = c.getString(c.getColumnIndex("player5y"));
		player_x[5] = c.getString(c.getColumnIndex("player6x"));
		player_y[5] = c.getString(c.getColumnIndex("player6y"));
		player_x[6] = c.getString(c.getColumnIndex("player7x"));
		player_y[6] = c.getString(c.getColumnIndex("player7y"));
		player_x[7] = c.getString(c.getColumnIndex("player8x"));
		player_y[7] = c.getString(c.getColumnIndex("player8y"));
		player_x[8] = c.getString(c.getColumnIndex("player9x"));
		player_y[8] = c.getString(c.getColumnIndex("player9y"));
		player_x[9] = c.getString(c.getColumnIndex("player10x"));
		player_y[9] = c.getString(c.getColumnIndex("player10y"));
		ball_x = c.getString(c.getColumnIndex("ballx"));
		ball_y = c.getString(c.getColumnIndex("bally"));
		
		
        
    }

    public void getIntFromString(){
    	
		for (int i = 0; i < 10; i++) {
		
			int j;
			StringTokenizer strtok = new StringTokenizer(player_x[i], ",");
			StringTokenizer strtok2 = new StringTokenizer(player_y[i],",");
			j = 0;
			while (strtok.hasMoreTokens()) {
				playerX[i][j] = Integer.valueOf(strtok.nextToken());
				j++;
			}
			j=0;
			while (strtok2.hasMoreTokens()) {
				playerY[i][j] = Integer.valueOf(strtok2.nextToken());
				j++;
			}		
		}
		StringTokenizer strtok3=new StringTokenizer(ball_x,",");
		StringTokenizer strtok4=new StringTokenizer(ball_y,",");
		int i=0;
		while (strtok3.hasMoreTokens()) {
			ballX[i] = Integer.valueOf(strtok3.nextToken());
			i++;
		}
		i=0;
		while (strtok4.hasMoreTokens()) {
			ballY[i] = Integer.valueOf(strtok4.nextToken());
			i++;
		}
    }
    
    public void openListFromDb(){//db에서 여태까지 저장된 데이터를 가져옴(작전명 만)
    	 db = helper.getReadableDatabase(); // db객체를 얻어온다. 읽기 전용
         Cursor c = db.query("student", null, null, null, null, null, null);

         while (c.moveToNext()) {
             //db의 student 테이블안에 작전이 몇개인가 구함
             planCount++;     
         }
        
         planName=new String[planCount]; //초기화
         int i=0;
         c.moveToFirst();
    	  while (c.moveToNext()) {
              // 작전명을 받아와 planName 배열에 저장
              int _id = c.getInt(c.getColumnIndex("_id"));
              planName[i]= c.getString(c.getColumnIndex("name"));
              i++;
              if(i==planCount) break;
              
          }

    }
    protected void OpenPlanNameDlg() {
		//무슨 작전을 선택할 것인지  팝업창 띄움
		Context mContext = getApplicationContext();
		LayoutInflater inflater = (LayoutInflater) mContext
				.getSystemService(LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.planlist_dialog,
				(ViewGroup) findViewById(R.id.layout_planlist));

		AlertDialog.Builder aDialog = new AlertDialog.Builder(
				this);// 패키지이름
		aDialog.setTitle("작전명");
		aDialog.setView(layout);

		aDialog.setItems(planName, new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// 애니메이트 해보고싶은 작전을 클릭했을때 이벤트 처리 (그 작전name에 해당하는 row를 선택해줘야함)
				
			}
		});

		AlertDialog ad = aDialog.create();
		ad.show();

	}
}
