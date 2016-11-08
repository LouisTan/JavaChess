package inf3995_03.javachess.view;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import inf3995_03.javachess.R;
import inf3995_03.javachess.controller.CycleStateListener;
import inf3995_03.javachess.controller.FocusStateListener;
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

    public static final Map<String, ChessSquareView> chessSquareViewMap = new HashMap<>();
    public static final Map<String, ChessPiece> chessPieceMap = new HashMap<>();

    //public static until proven wrong
    public static CycleStateListener stateListener = new CycleStateListener();
    public static FocusStateListener focusListener = new FocusStateListener();
    public static boolean onHold = false;

    public static Stack piecesHeld = new Stack();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_layout);

        initChessSquares();
        initChessPieces();
        drawChessPieces();
    }

    public void initChessSquares() {

        for (int i = 97; i<105; i++){
            for (int j = 1; j<9; j++) {

                String col = (char) (i) + "";
                String row = Integer.toString(j);
                String pos = col+row;

                int idRes = getResources().getIdentifier(pos, "id", getPackageName());

                chessSquareViewMap.put(pos, (ChessSquareView) findViewById(idRes));
            }
        }
    }//initChessSquares()

    public void initChessPieces(){

        //Black pawns initialisation
        for (int i = 97; i<105; i++) {

            String col = (char) (i) + "";
            String pos = col + Integer.toString(7);

            chessPieceMap.put(pos, new ChessPiece(BLACK,PAWN,pos,getApplicationContext()));
        }//initChessPieces()

        //White pawns initialisation
        for (int i = 97; i<105; i++) {

            String col = (char) (i) + "";
            String pos = col + Integer.toString(2);

           chessPieceMap.put(pos, new ChessPiece(WHITE,PAWN,pos,getApplicationContext()));
        }

        chessPieceMap.put("e8", new ChessPiece(BLACK,KING,"e8",getApplicationContext()));
        chessPieceMap.put("e1", new ChessPiece(WHITE,KING,"e1",getApplicationContext()));

        chessPieceMap.put("d8", new ChessPiece(BLACK,QUEEN,"d8",getApplicationContext()));
        chessPieceMap.put("d1", new ChessPiece(WHITE,QUEEN,"d1",getApplicationContext()));

        chessPieceMap.put("c8", new ChessPiece(BLACK,BISHOP,"c8",getApplicationContext()));
        chessPieceMap.put("c1", new ChessPiece(WHITE,BISHOP,"c1",getApplicationContext()));
        chessPieceMap.put("f1", new ChessPiece(WHITE,BISHOP,"f1",getApplicationContext()));

        chessPieceMap.put("b8", new ChessPiece(BLACK,KNIGHT,"b8",getApplicationContext()));
        chessPieceMap.put("g8", new ChessPiece(BLACK,KNIGHT,"g8",getApplicationContext()));
        chessPieceMap.put("b1", new ChessPiece(WHITE,KNIGHT,"b1",getApplicationContext()));
        chessPieceMap.put("g1", new ChessPiece(WHITE,KNIGHT,"g1",getApplicationContext()));

        chessPieceMap.put("a8", new ChessPiece(BLACK,ROOK,"a8",getApplicationContext()));
        chessPieceMap.put("h8", new ChessPiece(BLACK,ROOK,"h8",getApplicationContext()));
        chessPieceMap.put("a1", new ChessPiece(WHITE,ROOK,"a1",getApplicationContext()));
        chessPieceMap.put("h1", new ChessPiece(WHITE,ROOK,"h1", getApplicationContext()));
    }//initChessPieces()

    public static void drawChessPieces(){
        for (String key: chessPieceMap.keySet()){
            chessSquareViewMap.get(key).setImageBitmap(chessPieceMap.get(key).getImage());
        }

        setFocusOnPieces();
    }//drawChessPieces()

    public static void moveChessPiece(View v) {
        piecesHeld.push(v.getResources().getResourceEntryName(v.getId()));
        if (piecesHeld.size() == 2) {
            String destination = (String) piecesHeld.pop();
            String source = (String) piecesHeld.pop();

            if(chessPieceMap.containsKey(destination)) {
                chessPieceMap.remove(destination);
            }

            chessPieceMap.get(source).setPosition(destination);
            chessPieceMap.put(destination, chessPieceMap.get(source));
            chessPieceMap.remove(source);

            chessSquareViewMap.get(source).setImageBitmap(null);

            v.clearFocus();
            drawChessPieces();
        }else{
            setFocusOnBoard();
        }
    }//moveChessPiece

    public static void setFocusOnPieces(){
        for (String key: chessSquareViewMap.keySet()){
            if (chessPieceMap.keySet().contains(key)){
                chessSquareViewMap.get(key).setOnTouchListener(stateListener);
                chessSquareViewMap.get(key).setOnFocusChangeListener(focusListener);
            }else {
                chessSquareViewMap.get(key).setOnTouchListener(null);
                chessSquareViewMap.get(key).setOnFocusChangeListener(null);
            }
        }
    }//setFocusOnPieces()

    public static void setFocusOnBoard(){
        for (String key: chessSquareViewMap.keySet()){
            chessSquareViewMap.get(key).setOnTouchListener(stateListener);
            chessSquareViewMap.get(key).setOnFocusChangeListener(focusListener);
        }
    }//setFocusOnBoard()



}
