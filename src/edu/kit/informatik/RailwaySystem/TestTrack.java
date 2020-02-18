package edu.kit.informatik.RailwaySystem;

import java.io.IOException;

public class TestTrack {
    public static void main(String[] args) {
        RailwaySystem r = new RailwaySystem();
        try {

            r.addTrack(new NormalTrack(new Point(1 , 1) , new Point(5, 1)));
            r.addTrack(new Switch(new Point(5,1), new Point(8, 1), new Point(5,3)));
            //r.addTrack(new NormalTrack(new Point(10, 10), new Point(10, 11)));
            //r.addTrack(new NormalTrack(new Point(5, 3), new Point(8, 1)));
            r.addTrack(new NormalTrack(new Point(10, 1), new Point(8,1)));
            Switch sw = new Switch(new Point(10, -3), new Point(10, 1),new Point(12, -3));
            r.addTrack(sw);
            sw.setSwitch(new Point(12, -3));

            r.addTrack(new NormalTrack(new Point(10, -3), new Point(1, -3)));
            r.addTrack(new NormalTrack(new Point(1, -3), new Point(1, 1)));
            r.addTrack(new NormalTrack(new Point(5, 3), new Point(10, 3)));
            r.addTrack(new NormalTrack(new Point(10, 3), new Point(12, 3)));
            r.addTrack(new Switch(new Point(12, 3), new Point(12, - 3), new Point(14, 3)));
            r.addTrack(new NormalTrack(new Point(14, -1), new Point(14, 3)));
            System.out.println(r.toString());
        } catch (IOException e) {
            System.out.println("nup");
        }
    }

}
