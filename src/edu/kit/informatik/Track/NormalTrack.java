package edu.kit.informatik.Track;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NormalTrack extends Track {

    private int id;
    private List<Point> points;
    private int length;

    public NormalTrack(Point startPoint, Point endPoint) throws IOException {
        if (startPoint.isHorizontal(endPoint) || startPoint.isVertical(endPoint)) {
            points = new ArrayList<>(Arrays.asList(startPoint, endPoint));
            this.id = -1;
        } else {
            throw new IOException("wrong direction");
        }
        this.length = this.length();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public List<Point> getPoints() {
        return points;
    }

    public int length() {
        return (int) points.get(0).distanceTo(points.get(1));
    }

    @Override
    public String toString() {
        return ("t " + id + " " + points.get(0) + " -> " + points.get(1) + " " + length + "\n");
    }
}