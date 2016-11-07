package inf3995_03.javachess.controller;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import static inf3995_03.javachess.view.BoardActivity.onHold;

/**
 * Created by lester on 16-11-03.
 * Based on https://staticallytyped.wordpress.com/2011/02/01/android-avoiding-custom-views-with-resources-cont/
 */

public class CycleStateListener implements View.OnTouchListener {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            Drawable back = v.getBackground();
            switch(back.getLevel()){
                case 0:
                    v.requestFocus();
                    onHold = true;
                    Log.d("CycleListener", "Level 1");
                    back.setLevel(1);
                    break;
                case 1:
                    onHold = false;
                    Log.d("CycleListener", "Level 0");
                    back.setLevel(0);
                    break;
            }
            return true;
        }
        return false;
    }

}