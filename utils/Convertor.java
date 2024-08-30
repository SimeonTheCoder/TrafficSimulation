package utils;

import connectables.Connectable;

import java.util.HashMap;
import java.util.List;

public class Convertor {
    public static HashMap<Integer, Connectable> ConvertListToHashMap(List<Connectable> list) {
        HashMap<Integer, Connectable> network = new HashMap<>();

        list.forEach(e -> {
            network.put(e.getIndex(), e);
        });

        return network;
    }
}
