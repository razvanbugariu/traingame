package edu.kit.informatik.RailwaySystem;

import java.io.IOException;
import java.util.*;

public class NormalTrack extends Track {

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

    public HashMap<Point, Set<Point>> getAdjacent() {
        HashMap<Point, Set<Point>> adjacent = new HashMap<>();
        adjacent.put(points.get(0), new HashSet<>(Arrays.asList(points.get(1))));
        adjacent.put(points.get(1), new HashSet<>(Arrays.asList(points.get(0))));
        return adjacent;
    }


    @Override
    public String toString() {
        return ("t " + id + " " + points.get(0) + " -> " + points.get(1) + " " + length + "\n");
    }
}