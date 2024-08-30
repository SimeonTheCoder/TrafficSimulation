package pathing;

import connectables.Connectable;
import utils.Convertor;

import java.util.*;

public class Navigator {
    private Random random;

    private int fromIndex, toIndex;
    private int currIndex;

    private Stack<Integer> visited = new Stack<>();
    private HashMap<Integer, Connectable> network;

    public Navigator(HashMap<Integer, Connectable> network) {
        this.random = new Random();
        this.network = network;
    }

    public Navigator(List<Connectable> network) {
        this.random = new Random();
        this.network = Convertor.ConvertListToHashMap(network);
    }

    public Path path(Connectable from, Connectable to) {
        this.fromIndex = from.getIndex();
        this.toIndex = to.getIndex();

        this.currIndex = fromIndex;

        this.visited.clear();
        return path();
    }

    private Path path() {
        Path toReturn = null;

        this.visited.add(currIndex);

        if(this.currIndex == this.toIndex) {
            Path result = new Path();

            Arrays.stream(visited.toArray()).forEach(e -> {
                result.path.add((Integer) e);
            });

            this.visited.pop();

            return result;
        }

        int indexBefore = this.currIndex;

        for (Connectable connection : network.get(currIndex).getConnections()) {
            if(visited.contains(connection.getIndex())) continue;

            this.currIndex = connection.getIndex();

            Path result = path();
            if(result != null) {
                if(toReturn == null) {
                    toReturn = result;
                } else {
                    double probability = (result.path.size() - 1 + 0f) / (result.path.size() - 1 + 0f + toReturn.path.size() - 1 + 0f);

                    if(random.nextFloat() <= probability) toReturn = result;
                }
            }

            this.currIndex = indexBefore;
        }

        this.visited.pop();
        return toReturn;
    }
}
