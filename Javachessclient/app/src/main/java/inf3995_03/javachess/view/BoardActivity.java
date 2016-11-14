package inf3995_03.javachess.view;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.*;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import cz.msebera.android.httpclient.Header;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import inf3995_03.javachess.R;
import inf3995_03.javachess.controller.CycleStateListener;
import inf3995_03.javachess.controller.FocusStateListener;
import inf3995_03.javachess.controller.RestClientHandler;
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

    public static Map<String, ChessSquareView> chessSquareViewMap = new HashMap<>();
    public static Map<String, ChessPiece> chessPieceMap = new HashMap<>();

    public static CycleStateListener stateListener = new CycleStateListener();
    public static FocusStateListener focusListener = new FocusStateListener();

    public static Stack piecesHeld = new Stack();

    private static boolean whiteToPlay = true;
    private static String BOARDACTIVITY = "BOARD";
    //private static String myStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_layout);

        initChessSquares();
        initChessPieces();
        drawChessPieces();
        setFocusOnPieces();

        final Button button = (Button) findViewById(R.id.btnId);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(BoardActivity.this, MenuPrincipal.class);
                startActivity(intent);
            }
        });

    }

    public void initChessSquares() {

        for (int i = 97; i < 105; i++) {
            for (int j = 1; j < 9; j++) {

                String col = (char) (i) + "";
                String row = Integer.toString(j);
                String pos = col + row;

                int idRes = getResources().getIdentifier(pos, "id", getPackageName());

                chessSquareViewMap.put(pos, (ChessSquareView) findViewById(idRes));
            }
        }
    }//initChessSquares()

    public void initChessPieces() {

        //Black pawns initialisation
        for (int i = 97; i < 105; i++) {

            String col = (char) (i) + "";
            String pos = col + Integer.toString(7);

            chessPieceMap.put(pos, new ChessPiece(BLACK, PAWN, pos, getApplicationContext()));
        }

        //White pawns initialisation
        for (int i = 97; i < 105; i++) {

            String col = (char) (i) + "";
            String pos = col + Integer.toString(2);

            chessPieceMap.put(pos, new ChessPiece(WHITE, PAWN, pos, getApplicationContext()));
        }

        chessPieceMap.put("e8", new ChessPiece(BLACK, KING, "e8", getApplicationContext()));
        chessPieceMap.put("e1", new ChessPiece(WHITE, KING, "e1", getApplicationContext()));

        chessPieceMap.put("d8", new ChessPiece(BLACK, QUEEN, "d8", getApplicationContext()));
        chessPieceMap.put("d1", new ChessPiece(WHITE, QUEEN, "d1", getApplicationContext()));

        chessPieceMap.put("c8", new ChessPiece(BLACK, BISHOP, "c8", getApplicationContext()));
        chessPieceMap.put("f8", new ChessPiece(BLACK, BISHOP, "f8", getApplicationContext()));
        chessPieceMap.put("c1", new ChessPiece(WHITE, BISHOP, "c1", getApplicationContext()));
        chessPieceMap.put("f1", new ChessPiece(WHITE, BISHOP, "f1", getApplicationContext()));

        chessPieceMap.put("b8", new ChessPiece(BLACK, KNIGHT, "b8", getApplicationContext()));
        chessPieceMap.put("g8", new ChessPiece(BLACK, KNIGHT, "g8", getApplicationContext()));
        chessPieceMap.put("b1", new ChessPiece(WHITE, KNIGHT, "b1", getApplicationContext()));
        chessPieceMap.put("g1", new ChessPiece(WHITE, KNIGHT, "g1", getApplicationContext()));

        chessPieceMap.put("a8", new ChessPiece(BLACK, ROOK, "a8", getApplicationContext()));
        chessPieceMap.put("h8", new ChessPiece(BLACK, ROOK, "h8", getApplicationContext()));
        chessPieceMap.put("a1", new ChessPiece(WHITE, ROOK, "a1", getApplicationContext()));
        chessPieceMap.put("h1", new ChessPiece(WHITE, ROOK, "h1", getApplicationContext()));
    }//initChessPieces()

    public static void drawChessPieces() {
        for (String key : chessSquareViewMap.keySet()) {
            Drawable back = chessSquareViewMap.get(key).getBackground();
            back.setLevel(0);
            chessSquareViewMap.get(key).setBackground(back);
            if (chessPieceMap.containsKey(key)) {
                chessSquareViewMap.get(key).setImageBitmap(chessPieceMap.get(key).getImage());
            } else {
                chessSquareViewMap.get(key).setImageBitmap(null);
            }
        }
    }

    public static void initChessMove(View v) {

        piecesHeld.push(v.getResources().getResourceEntryName(v.getId()));

        if (piecesHeld.size() == 2) {
            whiteToPlay = !whiteToPlay;
            String destination = (String) piecesHeld.pop();
            String source = (String) piecesHeld.pop();
            String player = chessPieceMap.get(source).getPlayer();

            String move = destination + "-" + source;

            HashMap<String, String> paramMap = new HashMap<>();
            /*paramMap.put("player", player);
            paramMap.put("move", move);*/

            RequestParams params = new RequestParams();

            //POST
            RestClientHandler.post("move/" + player + "/" + move, params, new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    Log.d(BOARDACTIVITY, String.valueOf(response));
                    //myStatus = String.valueOf(response);
                }

               /* @Override
                public void onFinish() {
                    super.onFinish();
                    Log.d(BOARDACTIVITY, "ON FINISH");

                }*/

                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {
                    // Pull out the first event on the public timeline
                    //moveChessPiece(source,destination);
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, String result, Throwable throwable) {
                    Log.d(BOARDACTIVITY, String.valueOf(statusCode));
                    Log.d(BOARDACTIVITY, result);
                }
            });

            if (chessPieceMap.containsKey(destination)) {
                chessPieceMap.remove(destination);
            }
            
            chessPieceMap.get(source).setPosition(destination);
            chessPieceMap.put(destination, chessPieceMap.get(source));
            chessPieceMap.remove(source);

            chessSquareViewMap.get(source).setImageBitmap(null);

            drawChessPieces();
            setFocusOnPieces();

        } else {
            setFocusOnBoard();
        }
    }

   /* //GET
    RestClientHandler.get("game_details/", null, new JsonHttpResponseHandler(){
         @Override
         public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
             // If the response is JSONObject instead of expected JSONArray

             String tweetText = null;
             try {
                 tweetText = String.valueOf(response.getString("player1"));

             } catch (JSONException e) {
                 e.printStackTrace();
             }

             // Do something with the response
             Log.d(BOARDACTIVITY, tweetText);
         }

         @Override
         public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {
             // Pull out the first event on the public timeline

         }

         @Override
         public void onFailure(int statusCode, Header[] headers,String result,Throwable throwable) {
             //
             Log.d(BOARDACTIVITY, String.valueOf(statusCode));
             Log.d(BOARDACTIVITY, res);

         }
    });*/

    /*public static void moveChessPiece(String source, String destination) {
        if (chessPieceMap.containsKey(destination)) {
            chessPieceMap.remove(destination);
        }

        chessPieceMap.get(source).setPosition(destination);
        chessPieceMap.put(destination, chessPieceMap.get(source));
        chessPieceMap.remove(source);

        chessSquareViewMap.get(source).setImageBitmap(null);

        drawChessPieces();
        setFocusOnPieces();
    }*/


    public static void setFocusOnPieces() {

        for (String key : chessSquareViewMap.keySet()) {
            if (whiteToPlay) {
                if (chessPieceMap.keySet().contains(key) && chessPieceMap.get(key).getColor().equals(WHITE)) {
                    chessSquareViewMap.get(key).setOnTouchListener(stateListener);
                    chessSquareViewMap.get(key).setOnFocusChangeListener(focusListener);
                } else {
                    chessSquareViewMap.get(key).setOnTouchListener(null);
                    chessSquareViewMap.get(key).setOnFocusChangeListener(null);
                }
            } else {
                if (chessPieceMap.keySet().contains(key) && chessPieceMap.get(key).getColor().equals(BLACK)) {
                    chessSquareViewMap.get(key).setOnTouchListener(stateListener);
                    chessSquareViewMap.get(key).setOnFocusChangeListener(focusListener);
                } else {
                    chessSquareViewMap.get(key).setOnTouchListener(null);
                    chessSquareViewMap.get(key).setOnFocusChangeListener(null);
                }
            }
        }

    }

    public static void setFocusOnBoard() {
        for (String key : chessSquareViewMap.keySet()) {
            chessSquareViewMap.get(key).setOnTouchListener(stateListener);
            chessSquareViewMap.get(key).setOnFocusChangeListener(focusListener);
        }
    }
}
