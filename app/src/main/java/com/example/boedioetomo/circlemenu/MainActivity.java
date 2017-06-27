package com.example.boedioetomo.circlemenu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;

public class MainActivity extends AppCompatActivity {

    CircleMenu circleMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circleMenu = (CircleMenu) findViewById(R.id.circle_menu);

        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"),R.drawable.ic_menu, R.drawable.ic_cancel);
        circleMenu.addSubMenu(Color.parseColor("#25BCFF"),R.drawable.ic_profil)
                    .addSubMenu(Color.parseColor("#30A400"),R.drawable.ic_report)
                    .addSubMenu(Color.parseColor("#FF4B32"),R.drawable.ic_shop)
                    .addSubMenu(Color.parseColor("#8A39FF"),R.drawable.ic_setting)
                    .addSubMenu(Color.parseColor("#FF6A00"),R.drawable.ic_about);

        circleMenu.setOnMenuSelectedListener(new OnMenuSelectedListener() {
            @Override
            public void onMenuSelected(int i) {
                switch (i){
                    case 0:
                        Toast.makeText(MainActivity.this, "Profil Button Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this,"Report Button Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this,"Shop Button Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this,"Setting Button Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(MainActivity.this,"About Button Clicked",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        circleMenu.setOnMenuStatusChangeListener(new OnMenuStatusChangeListener() {
            @Override
            public void onMenuOpened() {
                Toast.makeText(MainActivity.this,"Menu Opened",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMenuClosed() {
                Toast.makeText(MainActivity.this,"Menu Closed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void OnBackPressed (){
        if (circleMenu.isOpened())
            circleMenu.closeMenu();
        else
            finish();
    }
}
