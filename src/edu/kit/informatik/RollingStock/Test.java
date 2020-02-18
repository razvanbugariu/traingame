package edu.kit.informatik.RollingStock;

import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        try {
            Coach ch = new Coach(CoachType.PASSENGER, 1, true, false);
            System.out.println(ch.toString());
            Coach ch2 = new Coach(CoachType.FREIGHT, 3, false, true);
            System.out.println(ch2);
            Coach ch3 = new Coach(CoachType.SPECIAL, 1, true, false);
            System.out.println(ch3.toString());

            Engine en = new Engine(EngineType.STEAM, "T3", "Emma", 1, false, true);
            Engine en2 = new Engine(EngineType.ELECTRICAL, "103", "118", 1, true, true);
            System.out.println(en.toString());
            System.out.println(en2.toString());

            TrainSet ts = new TrainSet("403", "145", 4, true, true);
            System.out.println(ts.toString());

            RollingStockList rollingStockList = new RollingStockList();
            rollingStockList.addCoach(CoachType.PASSENGER, 1, true, false);

            System.out.println(rollingStockList.toString());

            TrainList trains = new TrainList();
            trains.addTrain(1, rollingStockList.getRollingStock("W4"));

            System.out.println(rollingStockList.toString());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
