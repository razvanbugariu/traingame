package edu.kit.informatik.RollingStock;

public enum CoachType {
    PASSENGER,
    FREIGHT,
    SPECIAL;

    public String getCharacter() {
        return this.toString().substring(0,1).toLowerCase();
    }
}
