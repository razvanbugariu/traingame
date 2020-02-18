package edu.kit.informatik.RollingStock;

import java.io.IOException;

public class TrainSet extends Locomotive {

    public TrainSet(String classId, String name, int length, boolean couplingFront, boolean couplingBack) throws IOException {
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
        str += classId + " " + name + " " + length + " " + couplingFront + " " + couplingBack;
        return str;
    }
}
