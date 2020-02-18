package edu.kit.informatik.RollingStock;

import java.io.IOException;

public class Locomotive extends RollingStock {

    protected String id;
    protected String classId;
    protected String name;

    protected void setId(String name, String classId) throws IOException {
        if (!classId.equals("W")) {
            this.id = classId + "-" + name;
        } else {
            throw new IOException("class can not be 'W'");
        }
    }

    public String getId() {
        return this.id;
    }

    protected String getClassId() {
        return this.classId;
    }

}
