package inf3995_03.javachess.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import inf3995_03.javachess.R;
import inf3995_03.javachess.controller.CycleStateListener;
import inf3995_03.javachess.model.ChessSquareView;

public class BoardActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_layout);

        ChessSquareView chessboard = (ChessSquareView)findViewById(R.id.a8);

        chessboard.setOnTouchListener(stateListener);
    }
    private CycleStateListener stateListener = new CycleStateListener();

}
