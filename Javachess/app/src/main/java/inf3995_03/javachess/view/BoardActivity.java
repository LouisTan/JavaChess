package inf3995_03.javachess.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;

import inf3995_03.javachess.R;
import inf3995_03.javachess.controller.CycleStateListener;

public class BoardActivity extends AppCompatActivity {

    public static final HashMap<String, ChessSquareView> chessSquaresMap = new HashMap<>();
    public static final HashMap<String, ChessSquareView> chessPiecesMap = new HashMap<>();

    private CycleStateListener stateListener = new CycleStateListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_layout);

        initChessSquares();
        initChessPieces();

    }

    public void initChessSquares() {

        for (int i = 97; i<105; i++){
            for (int j = 1; j<9; j++) {

                String col = (char) (i) + "";
                String row = Integer.toString(j);
                String pos = col+row;

                int idRes = getResources().getIdentifier(pos, "id", getPackageName());

                chessSquaresMap.put(pos, (ChessSquareView) findViewById(idRes));
                chessSquaresMap.get(pos).setOnTouchListener(stateListener);

            }
        }
    }//initChessboard

    public void initChessPieces(){

        //ChessPiece blackPawnA = new ChessPiece(BLACK,PAWN,"a2");

       // = BitmapFactory.decodeResource(getResources(), );
       //imageItems.add(blackPawnA.getImage());

    }

}
