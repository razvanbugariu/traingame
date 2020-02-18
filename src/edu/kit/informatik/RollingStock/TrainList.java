package edu.kit.informatik.RollingStock;

import java.io.IOException;
import java.util.*;

public class TrainList {

    private int id;
    private Map<Integer, ArrayList<RollingStock>> trains;
  //  private RollingStockList rollingStockList;

    public TrainList() {
        trains = new HashMap<>();
       // rollingStockList = new RollingStockList();
    }

    //imi trebuie metoda asta?
    public int getId() {
        int i = 1;
        for (int trainId : trains.keySet()) {
            if (trainId != i)
                return i;
            else
                i++;
        }
        return i;
    }

    private RollingStock getLastRollingStockAdded(int trainId) throws IOException {
        if (!trains.containsKey(trainId)) {
            throw new IOException("the train with ID " + trainId + " does not exist");
        } else {
            return getLast(trains.get(trainId));
        }
    }

    public static <T> T getLast(List<T> list) {
        return list != null && !list.isEmpty() ? list.get(list.size() - 1) : null;
    }

    //mai verifica daca unul din elemente e trainSet, at trebuie sa coincida classId
    //daca TrainList ramane aici pot accesa direct atributele din RollingStock fara get
    public void addTrain(int trainId, RollingStock rollingStock) throws IOException {
        if (!trains.containsKey(trainId)) {
            trains = new HashMap<>();
            rollingStock.setTrainId(trainId);
            trains.put(trainId, new ArrayList<>(Arrays.asList(rollingStock)));
        } else if (rollingStock.getTrainId() != -1) {
            throw new IOException("the object with ID " + rollingStock.getId() + " is already part of train with ID "
                    + rollingStock.getTrainId());
        } else if (!getLastRollingStockAdded(trainId).getCouplingBack()) {
            throw new IOException("you can not add a rolling stock because the last rolling stock added does not have"
                    + "a valide coupling");
        } else if (!rollingStock.getCouplingFront()) {
            throw new IOException("you can not add the object " + rollingStock.getId() + " because it does not have a "
                    + "valide coupling");
        } else {
            rollingStock.setTrainId(trainId);
            trains.get(trainId).add(rollingStock);
        }
    }


    // este deja pe sine? atunci stergel si de pe sine
    public void removeTrain(int trainID) throws IOException {
        if (!trains.containsKey(trainID)) {
            throw new IOException("the train you are trying to remove does not exist");
        } else {
            trains.remove(trainID);
        }
    }

    private String getValues(int trainId) {
        String str = "";
        for (RollingStock rollingStock : trains.get(trainId)) {
            str += rollingStock.getId() + " ";
        }
        return str.substring(0, str.length() - 1);
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 1; i < trains.size(); i++) {
            if (trains.containsKey(i)) {
                str += i + " " + getValues(i) + "\n";
            }
        }
        return str;
    }
}
