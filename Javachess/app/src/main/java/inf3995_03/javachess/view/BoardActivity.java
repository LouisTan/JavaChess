package inf3995_03.javachess.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;

import inf3995_03.javachess.R;
import inf3995_03.javachess.controller.CycleStateListener;
import inf3995_03.javachess.model.ChessPiece;

import static inf3995_03.javachess.model.ChessPiece.BISHOP;
import static inf3995_03.javachess.model.ChessPiece.KING;
import static inf3995_03.javachess.model.ChessPiece.KNIGHT;
import static inf3995_03.javachess.model.ChessPiece.PAWN;
import static inf3995_03.javachess.model.ChessPiece.QUEEN;
import static inf3995_03.javachess.model.ChessPiece.ROOK;
import static inf3995_03.javachess.model.ChessPiece.WHITE;
import static inf3995_03.javachess.model.ChessPiece.BLACK;

public class BoardActivity extends AppCompatActivity {

    public static final HashMap<String, ChessSquareView> chessSquareViewMap = new HashMap<>();
    public static final HashMap<String, ChessPiece> chessPieceMap = new HashMap<>();

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

                chessSquareViewMap.put(pos, (ChessSquareView) findViewById(idRes));
                chessSquareViewMap.get(pos).setOnTouchListener(stateListener);
            }
        }
    }//initChessSquares

    public void initChessPieces(){

        //Black pawns initialisation
        for (int i = 97; i<105; i++) {

            String col = (char) (i) + "";
            String pos = col + Integer.toString(7);

            chessPieceMap.put(pos, new ChessPiece(BLACK,PAWN,getApplicationContext()));
        }

        //White pawns initialisation
        for (int i = 97; i<105; i++) {

            String col = (char) (i) + "";
            String pos = col + Integer.toString(2);

           chessPieceMap.put(pos, new ChessPiece(WHITE,PAWN,getApplicationContext()));
        }

        chessPieceMap.put("e8", new ChessPiece(BLACK,KING,getApplicationContext()));
        chessPieceMap.put("e1", new ChessPiece(WHITE,KING,getApplicationContext()));

        chessPieceMap.put("d8", new ChessPiece(BLACK,QUEEN,getApplicationContext()));
        chessPieceMap.put("d1", new ChessPiece(WHITE,QUEEN,getApplicationContext()));

        chessPieceMap.put("c8", new ChessPiece(BLACK,BISHOP,getApplicationContext()));
        chessPieceMap.put("c1", new ChessPiece(WHITE,BISHOP,getApplicationContext()));
        chessPieceMap.put("f1", new ChessPiece(WHITE,BISHOP,getApplicationContext()));

        chessPieceMap.put("b8", new ChessPiece(BLACK,KNIGHT,getApplicationContext()));
        chessPieceMap.put("g8", new ChessPiece(BLACK,KNIGHT,getApplicationContext()));
        chessPieceMap.put("b1", new ChessPiece(WHITE,KNIGHT,getApplicationContext()));
        chessPieceMap.put("g1", new ChessPiece(WHITE,KNIGHT,getApplicationContext()));

        chessPieceMap.put("a8", new ChessPiece(BLACK,ROOK,getApplicationContext()));
        chessPieceMap.put("h8", new ChessPiece(BLACK,ROOK,getApplicationContext()));
        chessPieceMap.put("a1", new ChessPiece(WHITE,ROOK,getApplicationContext()));
        chessPieceMap.put("h1", new ChessPiece(WHITE,ROOK,getApplicationContext()));

    }//initChessPieces

}
