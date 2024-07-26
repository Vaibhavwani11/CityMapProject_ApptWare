import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import java.util.*;

class City {
    String name;
    double latitude;
    double longitude;

    public City(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}

class Road {
    City city1;
    City city2;
    int lanes;

    public Road(City city1, City city2, int lanes) {
        this.city1 = city1;
        this.city2 = city2;
        this.lanes = lanes;
    }
}

class CityMap {
    public static void main(String[] args) {
        System.setProperty("org.graphstream.ui", "swing");

        List<City> cities = generateCities(100);
        List<Road> roads = generateRoads(cities);

        Graph graph = new SingleGraph("City Map");

        for (City city : cities) {
            Node node = graph.addNode(city.name);
            node.setAttribute("ui.label", city.name);
        }

        int edgeCount = 0;
        for (Road road : roads) {
            String edgeId = "Edge_" + edgeCount++;
            Edge edge = graph.addEdge(edgeId, road.city1.name, road.city2.name, true);
            edge.setAttribute("ui.label", road.lanes + " lanes");
            switch (road.lanes) {
                case 4:
                    edge.setAttribute("ui.style", "fill-color: red; size: 4px;");
                    break;
                case 3:
                    edge.setAttribute("ui.style", "fill-color: orange; size: 3px;");
                    break;
                case 2:
                    edge.setAttribute("ui.style", "fill-color: yellow; size: 2px;");
                    break;
                case 1:
                    edge.setAttribute("ui.style", "fill-color: green; size: 1px;");
                    break;
            }
        }

        graph.display();
    }

    private static List<City> generateCities(int numberOfCities) {
        List<City> cities = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < numberOfCities; i++) {
            String name = "City" + i;
            double latitude = -90 + 180 * rand.nextDouble();
            double longitude = -180 + 360 * rand.nextDouble();
            cities.add(new City(name, latitude, longitude));
        }

        return cities;
    }

    private static List<Road> generateRoads(List<City> cities) {
        List<Road> roads = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < cities.size(); i++) {
            City city1 = cities.get(i);
            City city2 = cities.get(rand.nextInt(cities.size()));
            while (city1 == city2) {
                city2 = cities.get(rand.nextInt(cities.size()));
            }
            int lanes = rand.nextInt(4) + 1; // Random lanes between 1 and 4
            roads.add(new Road(city1, city2, lanes));
        }

        return roads;
    }
}
