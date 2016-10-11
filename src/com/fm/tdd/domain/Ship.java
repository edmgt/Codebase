package com.fm.tdd.domain;

import javafx.geometry.Pos;

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
    private Position shipEndPos;
    private int lives;

    public Ship(String name, int length, Heading heading, Position position) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException();
        if (length < 1 || length > 5) throw new IllegalArgumentException();
        if (heading == null || position == null) throw new IllegalArgumentException();

        if (heading == heading.EAST) {
            shipEndPos = new Position(position.getX() - length, position.getY());
        } else if (heading == heading.WEST) {
            shipEndPos = new Position(position.getX() + length, position.getY());
        } else if (heading == heading.NORTH) {
            shipEndPos = new Position(position.getX(), position.getY() - length);
        } else if (heading == heading.SOUTH) {
            shipEndPos = new Position(position.getX(), position.getY() + length);
        }
        this.name = name;
        this.length = length;
        this.heading = heading;
        this.position = position;

        this.lives = length;
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
        if (inBounds(position)) {
            this.lives--;
            return true;
        }

        return false;
    }

    public boolean isSunk() {
        return lives == 0;
    }

    public void addShipObserver(ShipObserver shipObserver) {
        if (shipObserver == null) throw new IllegalArgumentException();
    }

    public void removeShipObserver(ShipObserver shipObserver) {
        if (shipObserver == null) throw new IllegalArgumentException();
    }

    public boolean overlaps(Ship otherShip) {
        if(inBounds(otherShip.position) || inBounds(otherShip.shipEndPos)) return true;
        int startPosX = Math.max(otherShip.position.getX(), otherShip.shipEndPos.getX());
        int endPosX = Math.min(otherShip.position.getX(), otherShip.shipEndPos.getX());
        while(startPosX <= endPosX) {
            int startPosY = Math.min(otherShip.position.getY(), otherShip.shipEndPos.getY());
            int endPosY = Math.max(otherShip.position.getY(), otherShip.shipEndPos.getY());
            while(startPosY <= endPosY) {
                if(inBounds(new Position(startPosX, startPosY))) return true;
                startPosY++;
            }
            startPosX++;
        }
        return false;
    }

    private boolean inBounds(Position position) {
        if (position.getX() <= Math.max(shipEndPos.getX(), this.position.getX()) &&
                position.getX() >= Math.min(shipEndPos.getX(), this.position.getX()) &&
                position.getY() >= Math.min(shipEndPos.getY(), this.position.getY()) &&
                position.getY() <= Math.max(this.position.getY(), this.shipEndPos.getY()))
            return true;
        return false;
    }
}
