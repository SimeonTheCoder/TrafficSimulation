package connectables;

import java.util.ArrayList;
import java.util.List;

public class Residential implements Connectable {
    private int index;

    private List<Connectable> connections;

    public Residential() {
        this.index = ConnectableIndex.CURRENT_INDEX++;

        connections = new ArrayList<Connectable>();
    }

    public Residential connect(Connectable road) {
        this.connections.add(road);
        road.getConnections().add(this);

        return this;
    }

    public void setConnections(List<Connectable> connections) {
        this.connections = connections;
    }

    @Override
    public int getType() {
        return 2; //connectables.Residential
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
