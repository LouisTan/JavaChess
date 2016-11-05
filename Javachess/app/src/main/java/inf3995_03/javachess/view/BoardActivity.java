package inf3995_03.javachess.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;

import inf3995_03.javachess.R;
import inf3995_03.javachess.controller.CycleStateListener;
import inf3995_03.javachess.model.ChessSquareView;

public class BoardActivity extends AppCompatActivity {

    private CycleStateListener stateListener = new CycleStateListener();
    private static boolean isOccupied = false;

    private static final HashMap<String, ChessSquareView> chessMap = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_layout);

        initChessboard();
    }

    public void initChessboard() {

        for (int i = 97; i==105; i++){
            for (int j = 1; j==8; j++) {

                String col = (char) (i) + "";
                String row = Integer.toString(j);
                String pos = col+row;

                int idRes = getResources().getIdentifier(pos, "id", getPackageName());

                chessMap.put(pos, (ChessSquareView) findViewById(idRes));
                chessMap.get(pos).setOnTouchListener(stateListener);

            }
        }

    }//initChesboard

    public static boolean isOnBoard(String position) {
        return isOccupied;
    }

}
