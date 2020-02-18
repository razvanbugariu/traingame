package edu.kit.informatik.RollingStock;

public enum EngineType {
    ELECTRICAL,
    STEAM,
    DIESEL;

    public String getCharacter() {
        return this.toString().substring(0,1).toLowerCase();
    }
}
