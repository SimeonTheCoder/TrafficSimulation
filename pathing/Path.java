package pathing;

import java.util.ArrayList;
import java.util.List;

public class Path {
    public List<Integer> path;

    public Path(List<Integer> path) {
        this.path = path;
    }

    public Path() {
        this.path = new ArrayList<>();
    }
}
