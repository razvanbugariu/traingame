package edu.kit.informatik.RollingStock;

import java.io.IOException;

abstract class RollingStock {

    protected int length;
    protected boolean couplingFront;
    protected boolean couplingBack;
    protected int trainId;

    abstract String getId();
    public int getTrainId() { return this.trainId; }

    //metodele protected sau public???
    public void setTrainId(int id) {
        this.trainId = id;
    }

    public boolean getCouplingFront() {
        return this.couplingFront;
    }

    public boolean getCouplingBack() {
        return this.couplingBack;
    }
    protected void setLength(int length) throws IOException {
        if (length > 0) {
            this.length = length;
        } else {
            throw new IOException("length has to be > 0");
        }
    }

    public void setCoupling(boolean couplingFront, boolean couplingBack) throws IOException {
        if (couplingFront || couplingBack) {
            this.couplingFront = couplingFront;
            this.couplingBack = couplingBack;
        } else {
            throw new IOException("the object has to contain at least one coupling");
        }
    }

}
