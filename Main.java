import connectables.Building;
import connectables.Connectable;
import connectables.Residential;
import connectables.Road;
import pathing.Navigator;
import pathing.Path;
import utils.PrintNetwork;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Road road = new Road();
//
//        road.connect(
//                new Residential()
//            )
//            .connect(
//                    new Road()
//                        .connect(
//                                new Building()
//                        )
//            )
//            .connect(
//                    new Road()
//                        .connect(
//                                new Road()
//                                    .connect(
//                                            new Residential()
//                                    )
//                        )
//            );

//        Residential road = new Residential();
//
//        Building building = new Building();
//        road.connect(new Road().connect(new Road().connect(building)).connect(new Road().connect(building)).connect(building));

        Residential road1 = new Residential();
        Building building1 = new Building();

        road1.connect(new Road()
                .connect(new Road()
                        .connect(building1))
                .connect(new Road()
                        .connect(building1))
                .connect(building1));

// Additional connections to reach around 20 nodes
        Building building2 = new Building();
        Building building3 = new Building();
        Road road2 = new Road();
        Road road3 = new Road();

        road1.connect(road2
                .connect(new Road()
                        .connect(building2))
                .connect(new Road()
                        .connect(building3))
                .connect(building2));

        road2.connect(road3
                .connect(new Road()
                        .connect(building3))
                .connect(new Road()
                        .connect(building2))
                .connect(building3));

        List<Connectable> nodes = PrintNetwork.extractNodes(road1);

        PrintNetwork.printConnections(nodes);

        Navigator navigator = new Navigator(nodes);
//        navigator.path(nodes.get(1), nodes.get(6));

        List<Path> paths = new ArrayList<>();

        List<Integer> amounts = new ArrayList<>();

        for(int i = 0; i < nodes.size(); i ++) {
            amounts.add(0);

            if(nodes.get(i).getType() == 0) continue;

            for(int j = 0; j < nodes.size(); j ++) {
                if (i == j) continue;
                if(nodes.get(j).getType() == 0) continue;

                Path path = navigator.path(nodes.get(i), nodes.get(j));
                paths.add(path);

//                path.path.forEach(e -> {
//                    System.out.print(e + " ");
//                });
//                System.out.println();
            }
        }

        for(int k = 0; k < 1000; k ++) {
            for (int i = 0; i < nodes.size(); i++) {
                if (nodes.get(i).getType() == 0) continue;

                for (int j = 0; j < nodes.size(); j++) {
                    if (i == j) continue;
                    if (nodes.get(j).getType() == 0) continue;

                    Path path = navigator.path(nodes.get(i), nodes.get(j));
                    paths.add(path);

//                    path.path.forEach(e -> {
//                        System.out.print(e + " ");
//                    });
//                    System.out.println();
                }
            }
        }

        for (Path path : paths) {
            amounts.set(path.path.get(0), amounts.get(path.path.get(0)) + 1);
        }

        System.out.println(amounts);

        for(int i = 0; i < 6; i ++) {
            for (Path path : paths) {
                if(path.path.size() <= i + 1) {
                    amounts.set(path.path.get(path.path.size() - 1), 0);
                    continue;
                }

                amounts.set(path.path.get(i), amounts.get(path.path.get(i)) - 1);
                amounts.set(path.path.get(i + 1), amounts.get(path.path.get(i + 1)) + 1);
            }

            System.out.println(amounts);
        }
    }
}
