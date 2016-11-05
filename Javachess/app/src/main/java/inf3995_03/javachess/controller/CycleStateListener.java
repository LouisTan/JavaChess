package inf3995_03.javachess.controller;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by lester on 16-11-03.
 * Based on https://staticallytyped.wordpress.com/2011/02/01/android-avoiding-custom-views-with-resources-cont/
 */

public class CycleStateListener implements View.OnTouchListener {
    @Override
    public boolean onTouch(View arg0, MotionEvent arg1) {
        if(arg1.getAction() == MotionEvent.ACTION_DOWN){
            Drawable back = arg0.getBackground();
            switch(back.getLevel()){
                case 0:
                    Log.d("CycleListener", "Level 0");
                    back.setLevel(1);
                    break;
                case 1:
                    Log.d("CycleListener", "Level 1");
                    back.setLevel(2);
                    break;
                case 2:
                    Log.d("OnTouch", "Level 2");
                    back.setLevel(0);
                    break;
            }
            return true;
        }
        return false;
    }
}