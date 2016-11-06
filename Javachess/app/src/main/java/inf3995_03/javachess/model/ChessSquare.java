package inf3995_03.javachess.model;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

import inf3995_03.javachess.model.ChessPiece;

/**
 * Created by lester on 16-11-03.
 */

public class ChessSquare extends ImageView {
    private boolean isBusy;
    private String position;

    public ChessSquare(Context context){
        super(context);
        setClickable(true);
    }

    //Getters
    public boolean getIsBusy() {
        return this.isBusy;
    }

    public String getPosition() {
        return position;
    }

    //Setters
    public void setIsBusy(boolean isBusy) {
        this.isBusy = isBusy;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}