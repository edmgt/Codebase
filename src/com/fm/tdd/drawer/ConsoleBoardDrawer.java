package com.fm.tdd.drawer;

import com.fm.tdd.DrawableBoard;
import java.io.PrintStream;

/**
 * Draws a {@link DrawableBoard} to standard out
 */
public class ConsoleBoardDrawer implements BoardDrawer {

	private PrintStream printStream;

	public ConsoleBoardDrawer(PrintStream printStream) {
		this.printStream = printStream;
	}

	@Override
	public void draw(DrawableBoard drawableBoard) {

	}
}
