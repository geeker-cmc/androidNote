package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.sqlite.helper.MySQLiteDatabaseHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_create, btn_query, btn_update, btn_add, btn_del;
    private MySQLiteDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new MySQLiteDatabaseHelper(this, "BookTable.db", null, 1);

        btn_create = findViewById(R.id.btn_create);
        btn_add = findViewById(R.id.btn_add);
        btn_query = findViewById(R.id.btn_query);
        btn_del = findViewById(R.id.btn_del);
        btn_update = findViewById(R.id.btn_update);


        btn_create.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_query.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_update.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_create:
                create();
                break;
            case R.id.btn_add:
                add();
                break;
            case R.id.btn_update:
                update();
                break;
            case R.id.btn_query:
                query();
                break;
            case R.id.btn_del:
                del();
                break;
        }
    }

    private void create() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
    }

    private void add() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put("name", "测试");
        value.put("price", 11.22);
        db.insert("Book", null, value);
        value.clear();
        value.put("name", "测试2");
        value.put("price", 23.45);
        db.insert("Book", null, value);
    }

    private void query() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("Book", null, null, null, null, null, null);
        if(cursor.moveToNext()){
            do{
               String name = cursor.getString(cursor.getColumnIndex("name"));
               double price = cursor.getDouble(cursor.getColumnIndex("price"));
                Log.i("main", name);
                Log.i("main", price + "");
            }while (cursor.moveToNext());
            cursor.close();
        }
    }

    private void update() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("price", 122.12);
        db.update("Book", values, "name = ?" , new String[]{"测试"});
    }

    private void del() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("Book", "name = ?", new String[]{"测试2"} );
    }


}
