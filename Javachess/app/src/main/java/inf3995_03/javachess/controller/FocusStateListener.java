package inf3995_03.javachess.controller;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;

import static inf3995_03.javachess.view.BoardActivity.moveChessPiece;
import static inf3995_03.javachess.view.BoardActivity.onHold;
import static inf3995_03.javachess.view.BoardActivity.setFocusOnBoard;

/**
 * Created by lester on 16-11-06.
 */

public class FocusStateListener implements View.OnFocusChangeListener {

    @Override
    public void onFocusChange(View v, boolean hasFocus)
    {
        if (hasFocus && onHold) {
            Log.d("FocusListener", "On focus");
            moveChessPiece(v);
        }else {
            Log.d("FocusListener", "Changed focus");
            Drawable back = v.getBackground();
            back.setLevel(0);
        }
    }



}
