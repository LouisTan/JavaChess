package inf3995_03.javachess.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by lester on 16-11-03.
 */

public class ChessSquareView extends ImageView {
    //private IChessPiece mPiece = new NullPiece();
    public ChessSquareView(Context context){
        super(context);
        setClickable(true);
    }
    public ChessSquareView(Context context, AttributeSet attributes) {
        super(context, attributes);
        setClickable(true);
    }
    /*
    public void setPiece(IChessPiece _piece){
        mPiece = _piece;
    }
    public IChessPiece getPiece(){
        return mPiece;
    }

    @Override
    protected void onDraw(Canvas _canvas){
        super.onDraw(_canvas);
        mPiece.draw(_canvas, getPaddingLeft(), getPaddingTop());
    }*/
}