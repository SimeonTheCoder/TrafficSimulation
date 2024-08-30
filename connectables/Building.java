package connectables;

import java.util.ArrayList;
import java.util.List;

public class Building implements Connectable {
    private int index;

    private List<Connectable> connections;

    public Building() {
        this.index = ConnectableIndex.CURRENT_INDEX++;

        connections = new ArrayList<Connectable>();
    }

    public void setConnections(List<Connectable> connections) {
        this.connections = connections;
    }

    public Building connect(Connectable road) {
        this.connections.add(road);
        road.getConnections().add(this);

        return this;
    }

    @Override
    public int getType() {
        return 1; //Business
    }

    @Override
    public int getIndex() {
        return this.index;
    }

    @Override
    public List<Connectable> getConnections() {
        return connections;
    }
}
