package inf3995_03.javachess.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by lester on 16-11-03.
 */

public class ChessSquareView extends ImageView {

    public ChessSquareView(Context context){
        super(context);
        setClickable(true);
    }

    public ChessSquareView(Context context, AttributeSet attributes) {
        super(context, attributes);
        setClickable(true);
    }

}