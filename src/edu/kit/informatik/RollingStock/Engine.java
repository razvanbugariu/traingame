package edu.kit.informatik.RollingStock;

import java.io.IOException;

public class Engine extends RollingStock {

    private String id;
    private String classId;
    private String name;
    private int trainId;
    private EngineType type;
    private int length;
    private boolean couplingFront;
    private boolean couplingBack;

    public Engine(EngineType type, String name, String classId, int length, boolean couplingFront, boolean couplingBack)
            throws IOException {
        this.type = type;
        this.classId = classId;
        this.name = name;
        setId(name, classId);
        setLength(length);
        this.couplingFront = couplingFront;
        this.couplingBack = couplingBack;
        this.trainId = -1;

    }
    private void setLength(int length) throws IOException {
       if (length > 0) {
           this.length = length;
       } else {
           throw new IOException();
       }
    }

    private void setId(String name, String classId) throws IOException {
        if (!classId.equals("W")) {
            this.id = classId + "-" + name;
        } else {
            throw new IOException();
        }
    }

    public void setTrainId(int id) {
        this.trainId = id;
    }

    @Override
    public String toString() {
        String str = "";
        if (trainId == -1) {
            str += "none ";
        } else {
            str += trainId + " ";
        }
        str += type + " " + classId + " " + name + " " + length + " " + couplingFront + " " + couplingBack;
        return str;
    }

}
