package inf3995_03.javachess.model;

import inf3995_03.javachess.view.ChessSquareView;

import static inf3995_03.javachess.view.BoardActivity.chessSquareViewMap;

/**
 * Created by lester on 16-11-05.
 */

public class ChessSquare {

    private boolean vacancy;
    private String position;
    private ChessSquareView chessSquare;

    public ChessSquare(String position) {

        this.position = position;
        this.chessSquare = chessSquareViewMap.get(position);

    }

    //Getters
    public boolean getVacancy() {
        return vacancy;
    }

    public String getPosition() {
        return position;
    }

    public ChessSquareView getChessSquare() {
        return chessSquare;
    }

    //Setters
    public void setVacancy(boolean vacancy) {
        this.vacancy = vacancy;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setChessSquare(ChessSquareView chessSquare) {
        this.chessSquare = chessSquare;
    }

}
