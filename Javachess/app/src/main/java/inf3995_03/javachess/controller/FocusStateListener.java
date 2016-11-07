package inf3995_03.javachess.controller;

import android.util.Log;
import android.view.View;

/**
 * Created by lester on 16-11-06.
 */

//Not sure to use it yet
public class FocusStateListener implements View.OnFocusChangeListener {

    @Override
    public void onFocusChange(View v, boolean hasFocus)
    {
        if(hasFocus) {
            Log.d("FocusListener", "On focus");
        }else {
            Log.d("FocusListener", "Lost focus");
        }
    }



}
