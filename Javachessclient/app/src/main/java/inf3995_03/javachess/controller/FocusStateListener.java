package inf3995_03.javachess.controller;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;

import static inf3995_03.javachess.view.BoardActivity.initChessMove;

/**
 * Created by lester on 16-11-06.
 */

public class FocusStateListener implements View.OnFocusChangeListener {

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                Log.d("FocusListener", "On focus");
                initChessMove(v);
                v.clearFocus();
            } else {
                Log.d("FocusListener", "Changed focus");
                //La trace sur la case vide
                Drawable back = v.getBackground();
                back.setLevel(0);
            }
    }
}
