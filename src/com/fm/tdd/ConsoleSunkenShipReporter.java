package com.fm.tdd;

import com.fm.tdd.domain.Ship;
import java.io.PrintStream;

/**
 * Reports to standard out when a {@link Ship} has sunk
 */
public class ConsoleSunkenShipReporter {

	private PrintStream printStream;

	public ConsoleSunkenShipReporter(PrintStream printStream) {
		this.printStream = printStream;
	}

	public void watchShip(Ship ship) {

	}

}
