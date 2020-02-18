package edu.kit.informatik.RollingStock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RollingStockList {

    protected List<RollingStock> rollingStocks;

    RollingStockList() {
        rollingStocks = new ArrayList<RollingStock>();
    }

    public void addEngine(EngineType type, String classId, String name, int length, boolean couplingFront,
                             boolean couplingBack) throws IOException {
        rollingStocks.add(new Engine(type, classId, name, length, couplingFront, couplingBack));
    }

    public String listEngines() {
        String str = "";
        for (RollingStock engine : rollingStocks) {
            if (engine instanceof Engine)
                str += engine.toString() + "\n";
        }
        return str;
    }

    public void addCoach(CoachType type, int length, boolean couplingFront, boolean couplingBack) throws IOException {
        rollingStocks.add(new Coach(type, length, couplingFront, couplingBack));
    }

    public String listCoaches() {
        String str = "";
        for (RollingStock coach : rollingStocks) {
            if (coach instanceof Coach) {
                str += coach.toString() + "\n";
            }
        }
        return str;
    }

    public void addTrainSet(String classId, String name, int length, boolean couplingFront, boolean couplingBack) throws IOException {
        rollingStocks.add(new TrainSet(classId, name, length, couplingFront, couplingBack));
    }

    public String listTrainSets() {
        String str = "";
        for (RollingStock trainSet : rollingStocks) {
            if (trainSet instanceof TrainSet) {
                str += trainSet.toString() + " ";
            }
        }
        return str;
    }

    //cum pot sa printez in cazul asta o eroare(format incorect, id nu a fost gasit)
    public void removeRollingStock(String id) {
        rollingStocks.removeIf(element -> (element.getId().equals(id)) && (element.trainId == -1));
    }

    public RollingStock getRollingStock(String rollingStockId) throws IOException {
        for (RollingStock rollingStock : rollingStocks) {
            if (rollingStock.getId().equals(rollingStockId)) {
                return rollingStock;
            }
        }
        throw new IOException("Error, rolling stock with ID " + rollingStockId + " not found");
    }

    @Override
    public String toString() {
        String str = "";
        for (RollingStock rollingStock : rollingStocks) {
            str += rollingStock.toString() + " ";
        }
        return str;
    }


}
