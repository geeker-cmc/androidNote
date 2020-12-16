package com.example.contentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class NextActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_add, btn_query, btn_update, btn_del;
    private String newId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        btn_add = findViewById(R.id.btn_add);
        btn_query = findViewById(R.id.btn_query);
        btn_update = findViewById(R.id.btn_update);
        btn_del = findViewById(R.id.btn_del);

        btn_add.setOnClickListener(this);
        btn_query.setOnClickListener(this);
        btn_update.setOnClickListener(this);
        btn_del.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                add();
                break;
            case R.id.btn_query:
                query();
                break;
            case R.id.btn_update:
                update();
                break;
            case R.id.btn_del:
                del();
                break;
        }
    }

    private void add() {
        Log.i("table", "add >>>");
        Uri uri = Uri.parse("content://com.example.contentprovider/book");
        ContentValues values = new ContentValues();
        values.put("name", "书名");
        values.put("author", "康康");
        Uri newUri = getContentResolver().insert(uri, values);
        newId = newUri.getPathSegments().get(1);
        Log.i("测试", newId);
    }

    private void query() {
        Uri uri = Uri.parse("content://com.example.contentprovider/book");
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        if(cursor != null) {
            while (cursor.moveToNext()){
                String name = cursor.getString(cursor.getColumnIndex("name"));
                Log.i("测试",name);
                String author = cursor.getString(cursor.getColumnIndex("author"));
                Log.i("测试", author);
            }
            cursor.close();
        }
    }


    private void update() {
        // 更新数据
        Uri uri = Uri.parse("content://com.example.contentprovider/book");
        ContentValues value = new ContentValues();
        value.put("author", "丽丽");
        getContentResolver().update(uri, value, "author = ?", new String[]{"康康"});
    }

    private void del() {
        Uri uri = Uri.parse("content://com.example.contentprovider/book");
        getContentResolver().delete(uri, "author = ?", new String[]{"丽丽"});
    }

}
