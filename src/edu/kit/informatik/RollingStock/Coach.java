package edu.kit.informatik.RollingStock;

import java.io.IOException;

public class Coach extends RollingStock {

    private static int id;
    private CoachType type;

    public Coach(CoachType type, int length, boolean couplingFront, boolean couplingBack) throws IOException {
        this.type = type;
        setLength(length);
        setCoupling(couplingFront, couplingBack);
        this.trainId = -1;
        this.id++;

    }

    public String getId() {
        return ("W" + Coach.id);
    }

    @Override
    public String toString() {
        String str = "";
        if (trainId == -1) {
            str += id + " none ";
        } else {
            str += id + " " + trainId + " ";
        }
        str += type.getCharacter() + " " + length + " " + couplingFront + " " + couplingBack;
        return str;
    }


}
