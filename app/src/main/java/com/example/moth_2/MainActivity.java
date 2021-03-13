package com.example.moth_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    //바텀 네비게이션뷰 선언
    private BottomNavigationView bottomNavigationView;

    //프레임 과련 선언
    private FragmentManager fm;
    private FragmentTransaction ft;


    //프레그먼트 5개 선언 (아키텍쳐랑 xml 연결)
    private Main_Frag1_home main_frag1_home;
    private Main_Frag2_search main_frag2_search;
    private Main_Frag3_writing main_frag3_writing;
    private Main_Frag4_message main_frag4_message;
    private Main_Frag5_myhome main_frag5_myhome;


    //햄버거바 선언

    private DrawerLayout mDrawerLayout;
    private Context context = this;


    //간편 메모장버튼에 메모장 연결
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_memo, menu);
        return true;
    }


    //툴바에서 버튼 클릭했을 때
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {


            //간편 메모장 클릭시.
            case R.id.main_action_memo:
                Intent intent = new Intent(MainActivity.this, Simple_memo.class);
                startActivity(intent);
                break;

            //햄버거바 클릭시
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }


    //기본 오버라이드  --------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //툴바를 액션툴바로 지정.
        Toolbar main_Toolbar = (Toolbar) findViewById(R.id.main_toolbar_navi);
        setSupportActionBar(main_Toolbar);

        //툴바 타이틀 제거&변경
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //툴바에 홈버튼 생성
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //홈버튼에 이미지(햄버거바) 추가
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_main_toolbar_navi);


        //햄버거바 연결하기
        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_toolbar_drawer);

        //햄버거바에 내비연결하기
        NavigationView navigationView = (NavigationView) findViewById(R.id.main_nav_view);



        // 햄버거바에 내비 기능 부여
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {
                menuitem.setChecked(true);


                //햄버거바 숨기기
                mDrawerLayout.closeDrawers();

                // 햄버거바 내부 생명주기
                int id = menuitem.getItemId();
                String title = menuitem.getTitle().toString();

                if (id == R.id.navi1) {
                    Toast.makeText(context, "good", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.navi2) {
                    Toast.makeText(context, "good", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.navi3) {
                    Toast.makeText(context, "good", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.navi4) {
                    Toast.makeText(context, "good", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.navi5) {
                    Toast.makeText(context, "good", Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });


        //바텀 네비게이션 연결
        bottomNavigationView = findViewById(R.id.bottmNavi);

        //바텀 네비게이션 실핼
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                //메뉴 아이템에 순서 지정.
                switch (menuItem.getItemId()) {

                    case R.id.action_1_home:
                        setFrag(0);
                        break;

                    case R.id.action_2_search:
                        setFrag(1);
                        break;

                    case R.id.action_3_writing:
                        setFrag(2);
                        break;

                    case R.id.action_4_message:
                        setFrag(3);
                        break;

                    case R.id.action_5_myhome:
                        setFrag(4);
                        break;
                }

                return true;
            }
        });

        //프레그먼트 연결
        main_frag1_home = new Main_Frag1_home();
        main_frag2_search = new Main_Frag2_search();
        main_frag3_writing = new Main_Frag3_writing();
        main_frag4_message = new Main_Frag4_message();
        main_frag5_myhome = new Main_Frag5_myhome();

        //메인 화면은 뭘로 띄울까?
        setFrag(0);
    }


    //프레임 실행
    private void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        // n번 케이스일땐, 메인프레그에서 n번 프레그로 교체하고 저장하라.

        switch (n) {

            case 0:
                ft.replace(R.id.main_frame, main_frag1_home);
                ft.commit();
                break;

            case 1:
                ft.replace(R.id.main_frame, main_frag2_search);
                ft.commit();
                break;

            case 2:
                ft.replace(R.id.main_frame, main_frag3_writing);
                ft.commit();
                break;

            case 3:
                ft.replace(R.id.main_frame, main_frag4_message);
                ft.commit();
                break;

            case 4:
                ft.replace(R.id.main_frame, main_frag5_myhome);
                ft.commit();
                break;
        }






        }

    }

