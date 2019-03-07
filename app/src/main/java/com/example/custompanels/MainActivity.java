package com.example.custompanels;

import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.custompanels.databinding.MainActivityBinding;

public class MainActivity extends AppCompatActivity {

    MainActivityBinding mainActivityBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        mainActivityBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        mainActivityBinding.draggablePanel.setFragmentManager(getSupportFragmentManager());
        mainActivityBinding.draggablePanel.setTopFragment(new One());
        mainActivityBinding.draggablePanel.setBottomFragment(new Two());
        mainActivityBinding.draggablePanel.setTopViewHeight(500);
        mainActivityBinding.draggablePanel.initializeView();

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mainActivityBinding.draggablePanel.closeToLeft();
            }
        },100);

        mainActivityBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivityBinding.draggablePanel.maximize();
            }
        });
    }
}
