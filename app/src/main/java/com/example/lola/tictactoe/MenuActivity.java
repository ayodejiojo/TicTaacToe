package com.example.lola.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void exit(View view){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }

    public void singleplayer(View view){
        Intent intent = new Intent(MenuActivity.this,SingleActivity.class);
        startActivity(intent);
    }

    public void singleplayertwo(View view){
        Intent intent = new Intent(MenuActivity.this,Single2Activity.class);
        startActivity(intent);
    }


    public void twoplayer(View view){
        Intent intent = new Intent(MenuActivity.this,TwoActivity.class);
        startActivity(intent);
    }


    public void twoplayerfive(View view){
        Intent intent = new Intent(MenuActivity.this,Two2Activity.class);
        startActivity(intent);
    }
}
