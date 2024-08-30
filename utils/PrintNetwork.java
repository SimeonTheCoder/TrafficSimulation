package utils;

import connectables.Connectable;

import java.util.ArrayList;
import java.util.List;

public class PrintNetwork {
    public static List<Integer> visited = new ArrayList<>();
    public static List<Connectable> unique = new ArrayList<>();

    public static List<Connectable> extractNodes(Connectable network) {
        if(!visited.contains(network.getIndex())) {
            unique.add(network);
            visited.add(network.getIndex());
        }

        network.getConnections().forEach(c -> {
            if(!visited.contains(c.getIndex())) {
                unique.add(c);
                visited.add(c.getIndex());

                extractNodes(c);
            }
        });

        return unique;
    }

    public static void printConnections(List<Connectable> nodes) {
        for (Connectable node : nodes) {
            for (Connectable connection : node.getConnections()) {
                System.out.println(NodeName.name(node) + "," + NodeName.name(connection));
            }
        }
    }
}
