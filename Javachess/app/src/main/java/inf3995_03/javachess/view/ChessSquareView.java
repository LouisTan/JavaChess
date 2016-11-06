package inf3995_03.javachess.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by lester on 16-11-03.
 */

public class ChessSquareView extends ImageView {

    public ChessSquareView(Context context){
        super(context);
        setClickable(true); //TODO: ...an empty square shouldn't be clickable

        /*if (vacancy) {
            setClickable(true);
        }*/
    }

    public ChessSquareView(Context context, AttributeSet attributes) {
        super(context, attributes);
        setClickable(true);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);



        //canvas.setBitmap(drawGraph);

        //canvas.drawBitmap(drawGraph, 100, 100, bgPaint);
        /*ImageView myImageView = (ImageView) findViewById(R.id.your_imageview_id);
        myImageView.setImageResource(R.drawable.mypicture);*/

    }

}