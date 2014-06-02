package com.example.planboardv3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
 
/*
* sql�� ����ϱ� ���� ���� Ŭ����
* SQLiteOpenHelper�� ��뿡 ������ �ִ� Ŭ�����̴�.
*/
public class MySQLiteOpenHelper extends SQLiteOpenHelper {
 
    public MySQLiteOpenHelper(Context context, String name,
            CursorFactory factory, int version) {
        super(context, name, factory, version);
        // TODO Auto-generated constructor stub
 
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        // SQLiteOpenHelper �� ���� ���� �Ǿ��� ��
        String sql = "create table student (" +
                "_id integer primary key autoincrement, " +
                "name text, " +
                "player1x text, " +
                "player1y text, " +
                "player2x text, " +
                "player2y text, " +
                "player3x text, " +
                "player3y text, " +
                "player4x text, " +
                "player4y text, " +
                "player5x text, " +
                "player5y text, " +
                "player6x text, " +
                "player6y text, " +
                "player7x text, " +
                "player7y text, " +
                "player8x text, " +
                "player8y text, " +
                "player9x text, " +
                "player9y text, " +
                "player10x text, " +
                "player10y text, " +
                "ballx text, " +
                "bally text );";
        db.execSQL(sql);
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // db = ������ db, old/new �� ����/�Ź���
        // TODO Auto-generated method stub
        /*
         * db ������ ���׷��̵� �Ǿ��� �� ����Ǵ� �޼ҵ�
         * �� �κ��� ��뿡 �����ؾ� �ϴ� ���� ���� �ִ�. ������ 1�� ����ڰ� 2�� �ٲ��
         * �ѹ��� ������ �ϸ� ������ ������ 3���� �Ǹ� 1�� ����ڰ� 2, 3�� ���ľ� �ϰ�
         * 2�� ����ڴ� 3 ������ ��ġ�� �ȴ�. �̷��� ������ ���� ������ ���� �������Ƿ�
         * ������ ����ؾ� �ϸ� �����ϸ� ���� ���� �ÿ� �Ϻ��� ���ϴ� ���� ���� ���� ���̴�.
         * �׽�Ʈ������ ������ �����͸� ��� ����� �ٽ� ����� ���·� �ϰڴ�.
         */
        
        String sql = "drop table if exists student";
        db.execSQL(sql);
        
        onCreate(db); // ���̺��� �������Ƿ� �ٽ� ���̺��� ������ִ� ����
    }
}  
