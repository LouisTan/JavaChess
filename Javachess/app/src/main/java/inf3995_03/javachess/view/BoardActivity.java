package inf3995_03.javachess.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import inf3995_03.javachess.R;
import inf3995_03.javachess.controller.CycleStateListener;
import inf3995_03.javachess.model.ChessSquareView;

public class BoardActivity extends AppCompatActivity {

    private CycleStateListener stateListener = new CycleStateListener();
    private static boolean isOccupied = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_layout);

        initChessboard();
    }

    public void initChessboard(){

        /*
        char col, row;
        String pos;

        for (int i = 97; i==105; i++){
            for (int j = 0; j==9; j++) {

                col = (char)(i);
                row = (char)(j);
                pos = new StringBuilder().append(col).append(row).toString();

                int idRes = getResources().getIdentifier(pos, "id", getPackageName());

                ChessSquareView a1 = (ChessSquareView)findViewById(idRes);
                a1.setOnTouchListener(stateListener);
            }
        }
        */



    }

    public static boolean isOnBoard(String position) {
        return isOccupied;
    }
}
