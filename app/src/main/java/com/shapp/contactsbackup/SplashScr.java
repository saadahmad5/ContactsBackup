package com.shapp.contactsbackup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Saad Harris Ahmad on 002 Mar 27, 16.
 */
public class SplashScr extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscr);

        Thread timerThread = new Thread(){
            public void run(){ //Some internet help xD
                try{
                    sleep(500); // 500 milli-seconds, half second
                }catch(InterruptedException e){ // Don't know exceptions
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(SplashScr.this,MainActivity.class); //Activity of Splash starts and then back to Main after 500 ms
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }
}
