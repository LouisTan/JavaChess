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
    private ChessPiece chessPiece = null;
    private boolean isBusy = false;
    private String position;

    public ChessSquare(Context context){
        super(context);
        setClickable(true);
    }



    //Getters
    public ChessPiece getPiece(){
        return this.chessPiece;
    }

    public boolean getIsBusy() {
        return this.isBusy;
    }

    public String getPosition() {
        return position;
    }

    //Setters
    public void setPiece(ChessPiece chessPiece){
        this.chessPiece = chessPiece;
    }

    public void setIsBusy(boolean isBusy) {
        this.isBusy = isBusy;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}