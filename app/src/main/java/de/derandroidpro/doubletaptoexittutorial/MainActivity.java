package de.derandroidpro.doubletaptoexittutorial;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    boolean pressedOnce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode == event.KEYCODE_BACK){

            if(!pressedOnce){
                pressedOnce = true;
                Toast.makeText(getApplicationContext(), "Erneut drücken, um zu beenden.", Toast.LENGTH_SHORT).show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pressedOnce = false;
                    }
                }, 3000);
            } else if (pressedOnce){
                pressedOnce = false;
                onBackPressed();
            }

            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
