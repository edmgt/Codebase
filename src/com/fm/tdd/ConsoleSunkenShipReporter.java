package com.fm.tdd;

import com.fm.tdd.domain.Ship;
import com.fm.tdd.domain.ShipObserver;

import java.io.PrintStream;

/**
 * Reports to standard out when a {@link Ship} has sunk
 */
public class ConsoleSunkenShipReporter {

	private PrintStream printStream;

	public ConsoleSunkenShipReporter(PrintStream printStream) {
		if (printStream == null) throw new IllegalArgumentException();
		this.printStream = printStream;
	}

	public void watchShip(Ship ship) {
		if (ship == null) throw new IllegalArgumentException();
		ship.addShipObserver(new ShipObserver() {
			@Override
			public void sunk(Ship ship) {
				printStream.println("You sunk my Battleship!!!");
			}
		});
	}

}
