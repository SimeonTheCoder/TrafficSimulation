package connectables;

import java.util.ArrayList;
import java.util.List;

public class Road implements Connectable {
    private int speed;
    private int index;

    private List<Connectable> connections;

    public Road(int speed) {
        this.index = ConnectableIndex.CURRENT_INDEX++;

        this.speed = speed;
        connections = new ArrayList<>();
    }

    public Road() {
        this.index = ConnectableIndex.CURRENT_INDEX++;

        this.speed = 1;
        connections = new ArrayList<>();
    }

    public Road connect(Connectable road) {
        this.connections.add(road);
        road.getConnections().add(this);

        return this;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public List<Connectable> getConnections() {
        return connections;
    }

    public void setConnections(List<Connectable> connections) {
        this.connections = connections;
    }

    @Override
    public int getType() {
        return 0; //connectables.Road
    }

    @Override
    public int getIndex() {
        return this.index;
    }
}
