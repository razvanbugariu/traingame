package edu.kit.informatik.RailwaySystem;
import edu.kit.informatik.RollingStock.TrainList;

import java.io.IOException;
import java.util.*;

public class RailwaySystem {

    private List<Track> route;
    private Map<Point, Set<Point>> adjacent;
    private TrainList train;

    public RailwaySystem() {
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
            adjacent = track.getAdjacent();
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
                //adauga la lista de adiacenta punctele adiacente punctului adaugat
                for (Point point : track.getPoints()) {
                    if (adjacent.containsKey(point)) {
                        for (Point adjPoint : track.getAdjacent().get(point)) {
                            adjacent.get(point).add(adjPoint);
                        }
                    }
                }

            } else {
                throw new IOException();
            }
        }
    }

    public void removeTrack(int id) {}

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
