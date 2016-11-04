package inf3995_03.javachess.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import inf3995_03.javachess.R;
import inf3995_03.javachess.controller.CycleStateListener;
import inf3995_03.javachess.views.ChessSquareView;

public class BoardActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_layout);

        ChessSquareView chessboard = (ChessSquareView)findViewById(R.id.a8);
        //CycleStateListener stateListener = new CycleStateListener();

        chessboard.setOnTouchListener(stateListener);
    }
    private CycleStateListener stateListener = new CycleStateListener();

}
