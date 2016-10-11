package com.fm.tdd;

import com.fm.tdd.domain.Position;
import com.fm.tdd.domain.Ship;
import com.fm.tdd.utils.BoardObserver;
import java.util.List;

/**
 * <p>Represents the players own {@link com.fm.tdd.Board} including the {@link com.fm.tdd.domain.Ship}s</p>
 * <p/>
 * <p>Note that we are hard coding to be a board of size 10 X 10
 * <p/>
 * </p>
 */
public class PlayerBoard extends AbstractBoard implements Board, ObservableBoard {

	public static final int BOARD_HEIGHT = 10;
	public static final int BOARD_WIDTH = 10;

	@Override
	public void addShip(Ship ship) {

	}

	public List<Ship> getShips() {
		return null;
	}

	@Override
	public void fireMine(Position position) {

	}

	@Override
	public int getRemainingShipCount() {
		return 0;
	}


	@Override
	public void addBoardObserver(BoardObserver boardObserver) {

	}

	@Override
	public void removeBoardObserver(BoardObserver boardObserver) {

	}
}
