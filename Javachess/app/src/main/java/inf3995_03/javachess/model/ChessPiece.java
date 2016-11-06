package inf3995_03.javachess.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import inf3995_03.javachess.R;

/**
 * Created by lester on 16-11-05.
 * Based on http://faculty.washington.edu/stepp/courses/2005spring/tcss360/lectures/files/2005-05-25/Piece.java
 */

public class ChessPiece{
    public static final String BLACK = "Black";
    public static final String WHITE = "White";

    public static final String PAWN = "Pawn";
    public static final String KNIGHT = "Knight";
    public static final String BISHOP = "Bishop";
    public static final String ROOK = "Rook";
    public static final String QUEEN = "Queen";
    public static final String KING = "King";

    private String color;
    private String type;
    //private ChessSquare position;
    private Bitmap image;


    public ChessPiece(String color, String type, Context context){//, String position) {
        if (!(color.equals(BLACK)  || color.equals(WHITE))
            || !(type.equals(KING) || type.equals(QUEEN)
            || type.equals(BISHOP) || type.equals(KNIGHT)
            || type.equals(ROOK)   || type.equals(PAWN)))
        {
           throw new IllegalArgumentException();
        }

        this.color = color;
        this.type = type;
        //this.context = getApplicationContext();
        //this.position = chessMap.get(position);

        if (color.equals(BLACK)) {
            switch (type){
                case KING:
                    this.image = BitmapFactory.decodeResource(context.getResources(), R.drawable.piece_kb);
                    break;
                case QUEEN:
                    this.image = BitmapFactory.decodeResource(context.getResources(), R.drawable.piece_qb);
                    break;
                case BISHOP:
                    this.image = BitmapFactory.decodeResource(context.getResources(), R.drawable.piece_bb);
                    break;
                case KNIGHT:
                    this.image = BitmapFactory.decodeResource(context.getResources(), R.drawable.piece_nb);
                    break;
                case ROOK:
                    this.image = BitmapFactory.decodeResource(context.getResources(), R.drawable.piece_rb);
                    break;
                case PAWN:
                    this.image = BitmapFactory.decodeResource(context.getResources(), R.drawable.piece_pb);
                    break;
            }

        } else {
            switch (type){
                case KING:
                    this.image = BitmapFactory.decodeResource(context.getResources(), R.drawable.piece_kw);
                    break;
                case QUEEN:
                    this.image = BitmapFactory.decodeResource(context.getResources(), R.drawable.piece_qw);
                    break;
                case BISHOP:
                    this.image = BitmapFactory.decodeResource(context.getResources(), R.drawable.piece_bw);
                    break;
                case KNIGHT:
                    this.image = BitmapFactory.decodeResource(context.getResources(), R.drawable.piece_nw);
                    break;
                case ROOK:
                    this.image = BitmapFactory.decodeResource(context.getResources(), R.drawable.piece_rw);
                    break;
                case PAWN:
                    this.image = BitmapFactory.decodeResource(context.getResources(), R.drawable.piece_pw);
                    break;
            }

        }

    } //ChessPiece


    //Getters
    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

   /* public ChessSquare getPosition() {
        return position;
    }*/

    public Bitmap getImage() {
        return image;
    }

    //Setters
    public void setColor(String color) {
        this.color = color;
    }

    //(No setter for type)

   /* public void setPosition(ChessSquare position) {
        this.position = position;
    }*/

    public void setImage(Bitmap image) {
         this.image = image;
    }


}