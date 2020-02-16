package edu.kit.informatik.Track;

import java.util.List;

abstract class Track implements Comparable<Track> {
    private int id;
    abstract void setId(int id);
    abstract int getId();
    abstract List<Point> getPoints();
    abstract int length();

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
