package inf3995_03.javachess.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import inf3995_03.javachess.R;
import inf3995_03.javachess.controller.CycleStateListener;
import inf3995_03.javachess.views.ChessSquareView;

public class BoardActivity extends AppCompatActivity {

    ChessSquareView tile = new ChessSquareView(this);
    CycleStateListener stateListener = new CycleStateListener();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_layout);
    }


}
