package inf3995_03.javachess.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

import inf3995_03.javachess.model.ChessPiece;

/**
 * Created by lester on 16-11-03.
 */

public class ChessSquareView extends ImageView {
    private ChessPiece chessPiece;
    public ChessSquareView(Context context){
        super(context);
        setClickable(true);
    }

    //NB: AttributeSet = {...provides an efficient mechanism for retrieving data from compiled XML files}
    public ChessSquareView(Context context, AttributeSet attributes) {
        super(context, attributes);
        setClickable(true);
    }

    public void setPiece(ChessPiece chessPiece){
        this.chessPiece = chessPiece;
    }
    public ChessPiece getPiece(){
        return this.chessPiece;
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        //chessPiece.draw(canvas);
    }
}