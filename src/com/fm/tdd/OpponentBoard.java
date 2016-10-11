package com.fm.tdd;

import com.fm.tdd.domain.Position;
import com.fm.tdd.utils.BoardObserver;

import static com.fm.tdd.PlayerBoard.BOARD_HEIGHT;
import static com.fm.tdd.PlayerBoard.BOARD_WIDTH;

/**
 * Represents the board a player has which holds hits and misses on their opponents board
 */
public class OpponentBoard extends AbstractBoard {

    //private ObservableBoard observableBoard;

	public OpponentBoard() {
		grid = new CoordinateState[BOARD_HEIGHT][BOARD_WIDTH];
		for (int i = 0; i < BOARD_HEIGHT; i++) {
			for (int j = 0; j < BOARD_WIDTH; j++) {
				grid[i][j] = CoordinateState.EMPTY;
			}
		}
	}

	public void register(ObservableBoard observableBoard) {
        if (observableBoard == null) throw new IllegalArgumentException();
        observableBoard.addBoardObserver(new BoardObserver() {
            @Override
            public void hit(Position position) {
                grid[position.getY()][position.getX()] = CoordinateState.HIT;
            }

            @Override
            public void miss(Position position) {
                grid[position.getY()][position.getX()] = CoordinateState.MISS;
            }
        });
	}

	@Override
	public CoordinateState[][] getGrid() {
		return grid;
	}

}
