package inf3995_03.javachess.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;

import java.util.Map;

import inf3995_03.javachess.R;
import inf3995_03.javachess.controller.BitmapResizer;

import static inf3995_03.javachess.view.BoardActivity.chessPieceMap;

/**
 * Created by lester on 16-11-05.
 * Based on http://faculty.washington.edu/stepp/courses/2005spring/tcss360/lectures/files/2005-05-25/Piece.java
 */

public class ChessPiece extends AppCompatActivity{
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
    private Bitmap image;
    private String position;

    public ChessPiece(String color, String type, String position, Context context) {
        if (!(color.equals(BLACK)  || color.equals(WHITE))
            || !(type.equals(KING) || type.equals(QUEEN)
            || type.equals(BISHOP) || type.equals(KNIGHT)
            || type.equals(ROOK)   || type.equals(PAWN)))
        {
            throw new IllegalArgumentException();
        }

        this.color = color;
        this.type = type;
        this.position = position;
        //Let's hardcode the size to be (36x36)dp for now
        Bitmap unResizedImage = null;

        if (color.equals(BLACK)) {
            switch (type) {
                case KING:
                    unResizedImage = BitmapFactory.decodeResource(context.getResources(), R.drawable.piece_kb);
                    break;
                case QUEEN:
                    unResizedImage = BitmapFactory.decodeResource(context.getResources(), R.drawable.piece_qb);
                    break;
                case BISHOP:
                    unResizedImage = BitmapFactory.decodeResource(context.getResources(), R.drawable.piece_bb);
                    break;
                case KNIGHT:
                    unResizedImage = BitmapFactory.decodeResource(context.getResources(), R.drawable.piece_nb);
                    break;
                case ROOK:
                    unResizedImage = BitmapFactory.decodeResource(context.getResources(), R.drawable.piece_rb);
                    break;
                case PAWN:
                    unResizedImage = BitmapFactory.decodeResource(context.getResources(), R.drawable.piece_pb);
                    break;
            }
        } else {
            switch (type) {
                case KING:
                    unResizedImage = BitmapFactory.decodeResource(context.getResources(), R.drawable.piece_kw);
                    break;
                case QUEEN:
                    unResizedImage = BitmapFactory.decodeResource(context.getResources(), R.drawable.piece_qw);
                    break;
                case BISHOP:
                    unResizedImage = BitmapFactory.decodeResource(context.getResources(), R.drawable.piece_bw);
                    break;
                case KNIGHT:
                    unResizedImage = BitmapFactory.decodeResource(context.getResources(), R.drawable.piece_nw);
                    break;
                case ROOK:
                    unResizedImage = BitmapFactory.decodeResource(context.getResources(), R.drawable.piece_rw);
                    break;
                case PAWN:
                    unResizedImage = BitmapFactory.decodeResource(context.getResources(), R.drawable.piece_pw);
                    break;
            }
        }//else
        this.image = BitmapResizer.resize(unResizedImage,36,36);
    }//ChessPiece

    //Getters
    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public String getPosition() {
        return position;
    }

    public Bitmap getImage() {
        return image;
    }

    //Setters
    public void setColor(String color) {
        this.color = color;
    }

    //(No setter for type)

   public void setPosition(String position) {
        this.position = position;
    }

    public void setImage(Bitmap image) {
        BitmapResizer.resize(image,36,36);
        this.image = image;
    }

    public String getPlayer() {
        if(color== BLACK)
            return "2";
        return "1";
    }

}