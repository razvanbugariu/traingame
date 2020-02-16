package edu.kit.informatik.Track;
import edu.kit.informatik.RollingStock.Train;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Route {

    private NormalTrack track;
    private Switch aSwitch;
    private List<Track> route;
    private Train train;

    public Route() {
        route = new ArrayList<>();
    }

    public int getId() {
        int i = 1;
        for (Track track: route) {
            if (i == track.getId()) {
                i++;
            } else {
                return i;
            }
        }
        return i;
    }

    public void addTrack(Track track) throws IOException {
        if (route.isEmpty()) {
            track.setId(getId());
            route.add(track);
        } else {
            int count = 0;
            boolean connection = false;
            for (Track element : route) {
                for (Point point : element.getPoints()) {
                    for (Point trackPoint : track.getPoints()) {
                        if (point.equals(trackPoint)) {
                            count++;
                        }
                    }
                    if (count == 1) {
                        connection = true;
                    } else {
                        count = 0;
                    }
                }
            }
            if (connection) {
                track.setId(getId());
                route.add(track);
            } else {
                throw new IOException();
            }
        }
    }

    public void removeTrack(int id) {
        route.removeIf(track -> track.getId() == id);
    }

    @Override
    public String toString() {
        String str = "";
        Collections.sort(route);
        for (Track track: route) {
            str += track.toString();
        }
        return str;
    }

}
