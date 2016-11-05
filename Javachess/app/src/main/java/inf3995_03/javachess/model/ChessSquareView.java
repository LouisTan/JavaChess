package inf3995_03.javachess.model;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.Map;

import inf3995_03.javachess.R;

/**
 * Created by lester on 16-11-03.
 */

public class ChessSquareView extends ImageView {
    //private IChessPiece mPiece = new NullPiece();
    public ChessSquareView(Context context){
        super(context);
        setClickable(true);
    }

    //NB: AttributeSet = {...provides an efficient mechanism for retrieving data from compiled XML files}
    public ChessSquareView(Context context, AttributeSet attributes) {
        super(context, attributes);
        setClickable(true);
    }

    Map<String, ChessSquareView> ChessMap = new HashMap<String, ChessSquareView()>();
    ChessMap.put("_a1", new (ChessSquareView)findViewById(R.id.a1));


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