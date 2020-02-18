package edu.kit.informatik.RailwaySystem;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

abstract class Track implements Comparable<Track> {

    protected int id;
    abstract void setId(int id);
    abstract int getId();
    abstract List<Point> getPoints();
    abstract int length();
    abstract HashMap<Point, Set<Point>> getAdjacent();

    @Override
    public int compareTo(Track track) {
        if (this.id < track.getId())
            return 1;
        else if (this.id == track.getId())
            return 0;
        else
            return -1;
    }
}
