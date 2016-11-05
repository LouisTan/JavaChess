package inf3995_03.javachess.model;

import inf3995_03.javachess.view.BoardActivity;

/**
 * Created by lester on 16-11-05.
 * Based on http://faculty.washington.edu/stepp/courses/2005spring/tcss360/lectures/files/2005-05-25/Piece.java
 */

public class ChessPiece {
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
    private String position;

    public ChessPiece(String color, String type, String position) {
        if (!(color.equals(BLACK) || color.equals(WHITE))
           || !(type.equals(KING) || type.equals(QUEEN)
           || type.equals(BISHOP) || type.equals(KNIGHT)
           || type.equals(ROOK)   || type.equals(PAWN))
           || !BoardActivity.isOnBoard(position))
        {
            throw new IllegalArgumentException();
        }

        this.color      = color;
        this.type       = type;
        this.position	= position;
    }

}
