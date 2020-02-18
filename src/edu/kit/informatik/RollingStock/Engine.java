package edu.kit.informatik.RollingStock;

import java.io.IOException;

public class Engine extends Locomotive {
    private EngineType type;

    public Engine(EngineType type, String classId, String name, int length, boolean couplingFront, boolean couplingBack)
            throws IOException {
        this.type = type;
        this.classId = classId;
        this.name = name;
        setId(name, classId);
        setLength(length);
        setCoupling(couplingFront, couplingBack);
        this.trainId = -1;

    }

    @Override
    public String toString() {
        String str = "";
        if (trainId == -1) {
            str += "none ";
        } else {
            str += trainId + " ";
        }
        str += type.getCharacter() + " " + classId + " " + name + " " + length + " " + couplingFront + " " + couplingBack;
        return str;
    }

}
