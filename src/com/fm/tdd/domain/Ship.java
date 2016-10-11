package com.fm.tdd.domain;

/**
 * <p>A Ship has a {@link com.fm.tdd.domain.Position}, {@link com.fm.tdd.domain.Heading}, length and name</p>
 *
 * <p>A Ship's {@link com.fm.tdd.domain.Heading} and {@link com.fm.tdd.domain.Position} are defined as the direction the ship is heading
 * and the coordinate of the front (or bow) of the Ship. Below details {@link com.fm.tdd.domain.Heading}'s meaning</p>
 *
 * <table summary="Description of Ship Heading">
 *     <tr>
 *         <td>{@link com.fm.tdd.domain.Heading#NORTH}</td>
 *         <td>Heading towards Y = MAX_VALUE</td>
 *     </tr>
 *     <tr>
 *         <td>{@link com.fm.tdd.domain.Heading#EAST}</td>
 *         <td>Heading towards X = MAX_VALUE</td>
 *     </tr>
 *     <tr>
 *         <td>{@link com.fm.tdd.domain.Heading#SOUTH}</td>
 *         <td>Heading towards Y = 0</td>
 *     </tr>
 *     <tr>
 *         <td>{@link com.fm.tdd.domain.Heading#WEST}</td>
 *         <td>Heading towards X = 0</td>
 *     </tr>
 * </table>
 */
public class Ship {

	private String name;
	private int length;
	private Heading heading;
	private Position position;

	public Ship(String name, int length, Heading heading, Position position) {
		this.name = name;
		this.length = length;
		this.heading = heading;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public int getLength() {
		return length;
	}

	public Heading getHeading() {
		return heading;
	}

	public Position getPosition() {
		return position;
	}

	public boolean isHit(Position position) {
		return false;
	}

	public boolean isSunk() {
		return false;
	}

	public void addShipObserver(ShipObserver shipObserver) {

	}

	public void removeShipObserver(ShipObserver shipObserver) {

	}

	public boolean overlaps(Ship otherShip) {
		return false;
	}
}
