package connectables;

import java.util.List;

public interface Connectable {
    int getType();
    int getIndex();

    List<Connectable> getConnections();

    Connectable connect(Connectable road);
}
