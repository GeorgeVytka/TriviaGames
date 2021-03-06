package com.example.triviagame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Constraints;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HeaderClass extends AppCompatActivity {

    //public ConstraintLayout layout_header = findViewById(R.id.layoutHeader);


    public final static String GAME_NAME = "Trivia Game";
    public static final String DATABASE_NAME = "GameDatabase.db";
    public static final String TABLE_NAME = "TRIVIA_QUESTIONS";

    //"R.drawable.background_gradient" this have integer value and BACKGROUND 1 is default
    public final static int BACKGROUND1 = R.drawable.background_gradient;
    public final static int BACKGROUND2 = R.drawable.background_gradient1;
    private SharedPreferences backgroundPref;
    private SharedPreferences.Editor prefEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.top_menu_bar);


        //layout_header = (ConstraintLayout)findViewById(R.id.layoutHeader);
    }

    public int chnageBackground(int backgroundNum, ConstraintLayout layout){

        if (backgroundNum != 0){
            if(backgroundNum == BACKGROUND1){
                layout.setBackgroundResource(BACKGROUND2);
                return BACKGROUND2;}
            else{
                layout.setBackgroundResource(BACKGROUND1);
                return BACKGROUND1;
            }
        }else
            return 3;
    }
    public void saveBackground(int prefBackground, Context context){
        backgroundPref = PreferenceManager.getDefaultSharedPreferences(context);
        prefEditor = backgroundPref.edit();

        prefEditor.putInt("Background", prefBackground);
        prefEditor.apply();
    }

    public void setBackground( ConstraintLayout layout, Context context) {
        this.backgroundPref = PreferenceManager.getDefaultSharedPreferences(context);
        prefEditor = backgroundPref.edit();

        int backgroundNum1 = backgroundPref.getInt("Background", 0);
        if(backgroundNum1 != 0 ){
            layout.setBackgroundResource(backgroundNum1);
        }
    }

    public void saveBackground(int prefBackground){
        this.backgroundPref = PreferenceManager.getDefaultSharedPreferences(HeaderClass.this);
        prefEditor = backgroundPref.edit();

        prefEditor.putInt("Background", prefBackground);
        prefEditor.apply();
    }

    public int getCurBackground(Context context){
        backgroundPref = PreferenceManager.getDefaultSharedPreferences(context);
        return (backgroundPref.getInt("Background", 0));
    }

}
