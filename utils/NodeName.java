package utils;

import connectables.Connectable;

public class NodeName {
    public static String name(Connectable connectable) {
        return connectable.getClass().getSimpleName() + connectable.getIndex();
    }
}
