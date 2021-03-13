package com.example.moth_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Simple_memo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_memo);


        //툴바를 액션툴바로 지정.
        Toolbar main_Toolbar = findViewById(R.id.main_toolbar2);
        setSupportActionBar(main_Toolbar);
        //툴바 타이틀 제거&변경
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //툴바에 뒤로가기 버튼 생성
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); }


        //뒤로가기 버튼 기능부여.
        @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
                return true; } }
        return super.onOptionsItemSelected(item);
    }}
