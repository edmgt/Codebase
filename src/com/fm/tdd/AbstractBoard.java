package com.fm.tdd;

public abstract class AbstractBoard implements DrawableBoard {

	protected CoordinateState[][] grid;

	public AbstractBoard() {

	}

	@Override
	public CoordinateState[][] getGrid() {
		return grid;
	}
}
