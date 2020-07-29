import java.util.*;

/**
 * AlgoExpert
 * Airport Connections
 *
 * Question:
 * You are given a list of airports (three-letter codes like 'JFK'),
 * a list of routes (one-way flights from one airport to another like ['JFK', 'SFO']),
 * and a starting airport.
 * Write a function that returns the minimum number of airport connections (one-way flights)
 * that need to be added in order for someone to be able to reach any airport in the list,
 * starting at the starting airport. Note that the connections don't have to be direct;
 * it's okay if an airport can only be reached from the starting airport by stopping at other airports first.
 *
 * # Add, edit, or remove tests in this file.
 * # Treat it as your playground!
 *
 * import program
 * import unittest
 *
 *
 * AIRPORTS = [
 *     "BGI",
 *     "CDG",
 *     "DEL",
 *     "DOH",
 *     "DSM",
 *     "EWR",
 *     "EYW",
 *     "HND",
 *     "ICN",
 *     "JFK",
 *     "LGA",
 *     "LHR",
 *     "ORD",
 *     "SAN",
 *     "SFO",
 *     "SIN",
 *     "TLV",
 *     "BUD",
 * ]
 *
 * STARTING_AIRPORT = "LGA"
 *
 *
 * class TestProgram(unittest.TestCase):
 *     def test_case_1(self):
 *         routes = []
 *         self.assertTrue(
 *             program.airportConnections(AIRPORTS, routes, STARTING_AIRPORT) == 17
 *         )
 *
 *     def test_case_2(self):
 *         routes = [["LGA", "DSM"], ["LGA", "ORD"], ["LGA", "EYW"]]
 *         self.assertTrue(
 *             program.airportConnections(AIRPORTS, routes, STARTING_AIRPORT) == 14
 *         )
 *
 *     def test_case_3(self):
 *         routes = [
 *             ["LGA", "DSM"],
 *             ["DSM", "ORD"],
 *             ["LGA", "EYW"],
 *             ["EYW", "JFK"],
 *             ["EYW", "EWR"],
 *             ["JFK", "ICN"],
 *         ]
 *         self.assertTrue(
 *             program.airportConnections(AIRPORTS, routes, STARTING_AIRPORT) == 11
 *         )
 *
 *     def test_case_4(self):
 *         routes = [
 *             ["LGA", "DSM"],
 *             ["DSM", "ORD"],
 *             ["LGA", "EYW"],
 *             ["EYW", "JFK"],
 *             ["EYW", "EWR"],
 *             ["JFK", "ICN"],
 *             ["LGA", "ICN"],
 *             ["ICN", "ORD"],
 *             ["ICN", "EWR"],
 *             ["JFK", "DSM"],
 *         ]
 *         self.assertTrue(
 *             program.airportConnections(AIRPORTS, routes, STARTING_AIRPORT) == 11
 *         )
 *
 *     def test_case_5(self):
 *         routes = [
 *             ["LGA", "DSM"],
 *             ["DSM", "ORD"],
 *             ["LGA", "EYW"],
 *             ["EYW", "JFK"],
 *             ["EYW", "EWR"],
 *             ["JFK", "ICN"],
 *             ["LGA", "ICN"],
 *             ["ICN", "ORD"],
 *             ["ICN", "EWR"],
 *             ["JFK", "DSM"],
 *             ["ICN", "JFK"],
 *             ["ORD", "DSM"],
 *             ["DSM", "LGA"],
 *             ["JFK", "LGA"],
 *             ["JFK", "HND"],
 *         ]
 *         self.assertTrue(
 *             program.airportConnections(AIRPORTS, routes, STARTING_AIRPORT) == 10
 *         )
 *
 *     def test_case_6(self):
 *         routes = [
 *             ["LGA", "DSM"],
 *             ["DSM", "ORD"],
 *             ["LGA", "EYW"],
 *             ["EYW", "JFK"],
 *             ["EYW", "EWR"],
 *             ["JFK", "ICN"],
 *             ["LGA", "ICN"],
 *             ["ICN", "ORD"],
 *             ["ICN", "EWR"],
 *             ["JFK", "DSM"],
 *             ["ICN", "JFK"],
 *             ["ORD", "DSM"],
 *             ["DSM", "LGA"],
 *             ["JFK", "LGA"],
 *             ["JFK", "HND"],
 *             ["SFO", "SIN"],
 *             ["SFO", "CDG"],
 *             ["SFO", "LHR"],
 *             ["LHR", "DEL"],
 *             ["DEL", "BGI"],
 *             ["DEL", "DOH"],
 *             ["DOH", "SAN"],
 *         ]
 *         self.assertTrue(
 *             program.airportConnections(AIRPORTS, routes, STARTING_AIRPORT) == 3
 *         )
 *
 *     def test_case_7(self):
 *         routes = [
 *             ["LGA", "DSM"],
 *             ["DSM", "ORD"],
 *             ["EYW", "JFK"],
 *             ["EYW", "EWR"],
 *             ["JFK", "ICN"],
 *             ["LGA", "ICN"],
 *             ["ICN", "ORD"],
 *             ["ICN", "EWR"],
 *             ["JFK", "DSM"],
 *             ["ICN", "JFK"],
 *             ["ORD", "DSM"],
 *             ["DSM", "LGA"],
 *             ["JFK", "LGA"],
 *             ["JFK", "HND"],
 *             ["SFO", "SIN"],
 *             ["SFO", "CDG"],
 *             ["SFO", "LHR"],
 *             ["LHR", "DEL"],
 *             ["DEL", "BGI"],
 *             ["DEL", "DOH"],
 *             ["DOH", "SAN"],
 *         ]
 *         self.assertTrue(
 *             program.airportConnections(AIRPORTS, routes, STARTING_AIRPORT) == 4
 *         )
 *
 *     def test_case_8(self):
 *         routes = [
 *             ["LGA", "DSM"],
 *             ["SIN", "BGI"],
 *             ["SIN", "CDG"],
 *             ["SIN", "DEL"],
 *             ["SIN", "DOH"],
 *             ["SIN", "DSM"],
 *             ["SIN", "EWR"],
 *             ["SIN", "EYW"],
 *             ["SIN", "HND"],
 *             ["SIN", "ICN"],
 *             ["SIN", "JFK"],
 *             ["SIN", "LHR"],
 *             ["SIN", "ORD"],
 *             ["SFO", "SIN"],
 *             ["SFO", "SAN"],
 *         ]
 *         self.assertTrue(
 *             program.airportConnections(AIRPORTS, routes, STARTING_AIRPORT) == 3
 *         )
 *
 *     def test_case_9(self):
 *         routes = [
 *             ["LGA", "DSM"],
 *             ["DSM", "ORD"],
 *             ["SIN", "BGI"],
 *             ["SIN", "CDG"],
 *             ["CDG", "DEL"],
 *             ["DEL", "DOH"],
 *             ["DEL", "CDG"],
 *             ["DEL", "EWR"],
 *             ["HND", "ICN"],
 *             ["ICN", "JFK"],
 *             ["JFK", "LGA"],
 *             ["JFK", "SFO"],
 *             ["EYW", "LHR"],
 *             ["SFO", "ORD"],
 *             ["SFO", "LGA"],
 *         ]
 *         self.assertTrue(
 *             program.airportConnections(AIRPORTS, routes, STARTING_AIRPORT) == 6
 *         )
 *
 *     def test_case_10(self):
 *         routes = [
 *             ["LGA", "DSM"],
 *             ["DSM", "ORD"],
 *             ["SIN", "BGI"],
 *             ["SIN", "CDG"],
 *             ["CDG", "DEL"],
 *             ["DEL", "DOH"],
 *             ["DEL", "CDG"],
 *             ["DEL", "EWR"],
 *             ["HND", "ICN"],
 *             ["ICN", "JFK"],
 *             ["JFK", "LGA"],
 *             ["JFK", "SFO"],
 *             ["EYW", "LHR"],
 *             ["SFO", "ORD"],
 *             ["SFO", "LGA"],
 *             ["SFO", "SIN"],
 *             ["CDG", "EYW"],
 *             ["LGA", "SAN"],
 *         ]
 *         self.assertTrue(
 *             program.airportConnections(AIRPORTS, routes, STARTING_AIRPORT) == 3
 *         )
 *
 *     def test_case_11(self):
 *         routes = [
 *             ["LGA", "DSM"],
 *             ["DSM", "ORD"],
 *             ["SIN", "BGI"],
 *             ["SIN", "CDG"],
 *             ["CDG", "DEL"],
 *             ["DEL", "DOH"],
 *             ["DEL", "CDG"],
 *             ["DEL", "EWR"],
 *             ["HND", "ICN"],
 *             ["ICN", "JFK"],
 *             ["JFK", "LGA"],
 *             ["JFK", "SFO"],
 *             ["EYW", "LHR"],
 *             ["SFO", "ORD"],
 *             ["SFO", "LGA"],
 *             ["SFO", "SIN"],
 *             ["CDG", "EYW"],
 *             ["ORD", "HND"],
 *             ["HND", "SAN"],
 *             ["LGA", "TLV"],
 *             ["LGA", "BUD"],
 *         ]
 *         self.assertTrue(
 *             program.airportConnections(AIRPORTS, routes, STARTING_AIRPORT) == 0
 *         )
 *
 *     def test_case_12(self):
 *         routes = [
 *             ["DSM", "ORD"],
 *             ["ORD", "BGI"],
 *             ["BGI", "LGA"],
 *             ["SIN", "CDG"],
 *             ["CDG", "DEL"],
 *             ["DEL", "DOH"],
 *             ["DOH", "SIN"],
 *             ["EWR", "HND"],
 *             ["HND", "ICN"],
 *             ["ICN", "JFK"],
 *             ["JFK", "LGA"],
 *             ["EYW", "LHR"],
 *             ["LHR", "SFO"],
 *             ["SFO", "SAN"],
 *             ["SAN", "EYW"],
 *         ]
 *         self.assertTrue(
 *             program.airportConnections(AIRPORTS, routes, STARTING_AIRPORT) == 6
 *         )
 *
 *     def test_case_13(self):
 *         routes = [
 *             ["DSM", "ORD"],
 *             ["ORD", "BGI"],
 *             ["BGI", "LGA"],
 *             ["SIN", "CDG"],
 *             ["CDG", "DEL"],
 *             ["DEL", "DOH"],
 *             ["DOH", "SIN"],
 *             ["EWR", "HND"],
 *             ["HND", "ICN"],
 *             ["ICN", "JFK"],
 *             ["JFK", "LGA"],
 *             ["EYW", "LHR"],
 *             ["LHR", "SFO"],
 *             ["SFO", "SAN"],
 *             ["SFO", "ORD"],
 *             ["SAN", "EYW"],
 *         ]
 *         self.assertTrue(
 *             program.airportConnections(AIRPORTS, routes, STARTING_AIRPORT) == 6
 *         )
 *
 *     def test_case_14(self):
 *         routes = [
 *             ["DSM", "ORD"],
 *             ["ORD", "BGI"],
 *             ["BGI", "LGA"],
 *             ["SIN", "CDG"],
 *             ["CDG", "DEL"],
 *             ["DEL", "DOH"],
 *             ["DOH", "SIN"],
 *             ["EWR", "HND"],
 *             ["HND", "ICN"],
 *             ["ICN", "JFK"],
 *             ["JFK", "LGA"],
 *             ["EYW", "LHR"],
 *             ["LHR", "SFO"],
 *             ["SFO", "SAN"],
 *             ["SFO", "DSM"],
 *             ["SAN", "EYW"],
 *         ]
 *         self.assertTrue(
 *             program.airportConnections(AIRPORTS, routes, STARTING_AIRPORT) == 5
 *         )
 *
 *     def test_case_15(self):
 *         routes = [
 *             ["DSM", "ORD"],
 *             ["ORD", "BGI"],
 *             ["BGI", "LGA"],
 *             ["SIN", "CDG"],
 *             ["CDG", "SIN"],
 *             ["CDG", "BUD"],
 *             ["DEL", "DOH"],
 *             ["DEL", "CDG"],
 *             ["TLV", "DEL"],
 *             ["EWR", "HND"],
 *             ["HND", "ICN"],
 *             ["HND", "JFK"],
 *             ["ICN", "JFK"],
 *             ["JFK", "LGA"],
 *             ["EYW", "LHR"],
 *             ["LHR", "SFO"],
 *             ["SFO", "SAN"],
 *             ["SFO", "DSM"],
 *             ["SAN", "EYW"],
 *         ]
 *         self.assertTrue(
 *             program.airportConnections(AIRPORTS, routes, STARTING_AIRPORT) == 3
 *         )
 *
 *  This is Graph problem, why? Consider "airports" as Vertices and "routes" as edges of the graph
 *  And we don't know yet how they are connected, to make the connection or see the visibility
 *  draw graph for each airport and its associated routes
 *
 *  As there is no define depth and routes can be directional that why it is Graph and we are going
 *  to use DepthFirstSearch which is fast and have O(V+E) complexity
 *
 *  example:
 *  airports [a, b, c, d]
 *  routes [ac,bc, db, da,ca]
 */
public class AirportConnectionProblem {
    private static String[] airports = new String[]{"BGI",
            "CDG",
            "DEL",
            "DOH",
            "DSM",
            "EWR",
            "EYW",
            "HND",
            "ICN",
            "JFK",
            "LGA",
            "LHR",
            "ORD",
            "SAN",
            "SFO",
            "SIN",
            "TLV",
            "BUD"};
    static String startingAirport = "LGA";

    public static void main(String[] args) {
        //ans: 17
        String[][] routes = new String[][]{};
        int no = getNumberOfRequiredNewConnections(airports, routes, startingAirport);
        assert (no == 17);
        //ans: 14
        routes = new String[][]{{"LGA", "DSM"}, {"LGA", "ORD"}, {"LGA", "EYW"}}; //ans: 14
        no = getNumberOfRequiredNewConnections(airports, routes, startingAirport);
        assert (no == 14);

        //ans: 11
        routes =new String[][]{{"LGA", "DSM"},{"DSM", "ORD"},{"LGA", "EYW"},{"EYW", "JFK"},{"EYW", "EWR"},{"JFK", "ICN"}};
        no = getNumberOfRequiredNewConnections(airports, routes, startingAirport);
        assert (no == 11);

        //ans: 11
       routes = new String[][]{{"LGA", "DSM"},{"DSM", "ORD"},{"LGA", "EYW"},{"EYW", "JFK"},{"EYW", "EWR"},{"JFK", "ICN"},{"LGA", "ICN"},{"ICN", "ORD"},{"ICN", "EWR"},{"JFK", "DSM"}};
        no = getNumberOfRequiredNewConnections(airports, routes, startingAirport);
        assert (no == 11);

        //ans: 10
       routes = new String[][]{{"LGA", "DSM"},{"DSM", "ORD"},{"LGA", "EYW"},{"EYW", "JFK"},{"EYW", "EWR"},{"JFK", "ICN"},{"LGA", "ICN"},{"ICN", "ORD"},{"ICN", "EWR"},{"JFK", "DSM"},{"ICN", "JFK"},{"ORD", "DSM"},{"DSM", "LGA"},{"JFK", "LGA"},{"JFK", "HND"}};
        no = getNumberOfRequiredNewConnections(airports, routes, startingAirport);
        assert (no == 10);

       //ans: 6
       routes= new String[][]{{"LGA", "DSM"},{"DSM", "ORD"},{"SIN", "BGI"},{"SIN", "CDG"},{"CDG", "DEL"},{"DEL", "DOH"},{"DEL", "CDG"},{"DEL", "EWR"},{"HND", "ICN"},{"ICN", "JFK"},{"JFK", "LGA"},{"JFK", "SFO"},{"EYW", "LHR"},{"SFO", "ORD"},{"SFO", "LGA"}};
        no = getNumberOfRequiredNewConnections(airports, routes, startingAirport);
        assert (no == 6);

       //ans:3
        routes = new String[][]{{"LGA", "DSM"},{"DSM", "ORD"},{"SIN", "BGI"},{"SIN", "CDG"},{"CDG", "DEL"},{"DEL", "DOH"},{"DEL", "CDG"},{"DEL", "EWR"},{"HND", "ICN"},{"ICN", "JFK"},{"JFK", "LGA"},{"JFK", "SFO"},{"EYW", "LHR"},{"SFO", "ORD"},{"SFO", "LGA"},{"SFO", "SIN"},{"CDG", "EYW"},{"LGA", "SAN"}};
        no = getNumberOfRequiredNewConnections(airports, routes, startingAirport);
        assert (no == 3);

        //ans: 0
        routes = new String[][]{{"LGA", "DSM"},{"DSM", "ORD"},{"SIN", "BGI"},{"SIN", "CDG"},{"CDG", "DEL"},{"DEL", "DOH"},{"DEL", "CDG"},{"DEL", "EWR"},{"HND", "ICN"},{"ICN", "JFK"},{"JFK", "LGA"},{"JFK", "SFO"},{"EYW", "LHR"},{"SFO", "ORD"},{"SFO", "LGA"},{"SFO", "SIN"},{"CDG", "EYW"},{"ORD", "HND"},{"HND", "SAN"},{"LGA", "TLV"},{"LGA", "BUD"}};
        no = getNumberOfRequiredNewConnections(airports, routes, startingAirport);
        assert (no == 0);

        //ans: 6
        routes = new String[][]{{"DSM", "ORD"},{"ORD", "BGI"},{"BGI", "LGA"},{"SIN", "CDG"},{"CDG", "DEL"},{"DEL", "DOH"},{"DOH", "SIN"},{"EWR", "HND"},{"HND", "ICN"},{"ICN", "JFK"},{"JFK", "LGA"},{"EYW", "LHR"},{"LHR", "SFO"},{"SFO", "SAN"},{"SAN", "EYW"}};
        no = getNumberOfRequiredNewConnections(airports, routes, startingAirport);
        assert (no == 6);

        //ans: 6
        routes = new String[][]{{"DSM", "ORD"},{"ORD", "BGI"},{"BGI", "LGA"},{"SIN", "CDG"},{"CDG", "DEL"},{"DEL", "DOH"},{"DOH", "SIN"},{"EWR", "HND"},{"HND", "ICN"},{"ICN", "JFK"},{"JFK", "LGA"},{"EYW", "LHR"},{"LHR", "SFO"},{"SFO", "SAN"},{"SFO", "ORD"},{"SAN", "EYW"}};
        no = getNumberOfRequiredNewConnections(airports, routes, startingAirport);
        assert (no == 6);

        //ans: 5
        routes = new String[][]{{"DSM", "ORD"},{"ORD", "BGI"},{"BGI", "LGA"},{"SIN", "CDG"},{"CDG", "DEL"},{"DEL", "DOH"},{"DOH", "SIN"},{"EWR", "HND"},{"HND", "ICN"},{"ICN", "JFK"},{"JFK", "LGA"},{"EYW", "LHR"},{"LHR", "SFO"},{"SFO", "SAN"},{"SFO", "DSM"},{"SAN", "EYW"}};
        no = getNumberOfRequiredNewConnections(airports, routes, startingAirport);
        assert (no == 5);

        //ans: 3
        routes = new String[][]{{"DSM", "ORD"},{"ORD", "BGI"},{"BGI", "LGA"},{"SIN", "CDG"},{"CDG", "SIN"},{"CDG", "BUD"},{"DEL", "DOH"},{"DEL", "CDG"},{"TLV", "DEL"},{"EWR", "HND"},{"HND", "ICN"},{"HND", "JFK"},{"ICN", "JFK"},{"JFK", "LGA"},{"EYW", "LHR"},{"LHR", "SFO"},{"SFO", "SAN"},{"SFO", "DSM"},{"SAN", "EYW"}};
        no = getNumberOfRequiredNewConnections(airports, routes, startingAirport);
        assert (no == 3);

    }

    private static int getNumberOfRequiredNewConnections(String[] airports, String[][] routes, String selectedAirport){
        //Steps
        //1. first create graph from given information ie airport vs routes
        Map<String, Airport> airportGraph = new HashMap<>();
        for(String airport:airports){
            airportGraph.put(airport, new Airport(airport));
        }
        for(String[] route:routes){
            String airport = route[0];
            String connectedAirport = route[1];
            if(airportGraph.containsKey(airport)){
                airportGraph.get(airport).directConnectedAirports.add(new Airport(connectedAirport));
            }else{
                Airport airport1 = new Airport(airport);
                airport1.directConnectedAirports.add(new Airport(connectedAirport));
                airportGraph.put(airport, airport1);
            }
        }
        //2. Find out all unreachable airport from the selected airport
        List<Airport> unreachableAirport = new ArrayList<>();
        Map<String, Airport> visitedAirport = new HashMap<>();
        depthFirstSearch(airportGraph, selectedAirport, visitedAirport);
        for(String airport:airports){
            if(visitedAirport.containsKey(airport))
                continue;
            Airport airport1 = new Airport(airport);
            airport1.directConnectedAirports = airportGraph.get(airport).directConnectedAirports;
            unreachableAirport.add(airport1);
        }
        //3. Marking the all unreachable airport to check how many direct or indirect connections they have
        for(Airport airport: unreachableAirport){
            Map<String, Airport> notReachableAirport = new HashMap<>();
            depthFirstSearchForUnreachableAirports(airportGraph, airport, notReachableAirport, new HashMap<>());
            airport.allReachableAirport = new ArrayList<>(notReachableAirport.values());
        }
        //4. Return minimum number of new connections required
        //Order by max count of unreachable airports
        Comparator<Airport> compareByUnreachableAirportsCount = (o1, o2) -> (o2.allReachableAirport.size() - o1.allReachableAirport.size());

        Collections.sort(unreachableAirport, compareByUnreachableAirportsCount);
        int numberOfNewConnections = 0;
        Set<String> travseredAirport = new HashSet<>();
        for(Airport airport: unreachableAirport){
            if(travseredAirport.contains(airport.name)){
                continue;
            }
            numberOfNewConnections++;
            travseredAirport.add(airport.name);
            for(Airport connections: airport.allReachableAirport){
                travseredAirport.add(connections.name);
            }
        }
        System.out.println("Connections required "+ numberOfNewConnections);

        return numberOfNewConnections;
    }

    private static void depthFirstSearch(Map<String, Airport> airportGraph, String selectedAirport, Map<String, Airport> visitedAirports){
        if(visitedAirports.containsKey(selectedAirport)){
            return;
        }
        List<Airport> connectedAiports = airportGraph.get(selectedAirport).directConnectedAirports;
        Airport airport = new Airport(selectedAirport);
        airport.directConnectedAirports = connectedAiports;
        visitedAirports.put(selectedAirport, airport);
        for(Airport connection:connectedAiports){
            depthFirstSearch(airportGraph, connection.name, visitedAirports);
        }
    }

    private static void depthFirstSearchForUnreachableAirports(Map<String, Airport> airportGraph,
                                                               Airport selectedAirport,
                                                               Map<String, Airport> unreachableAirport,
                                                               Map<String, Airport> visitedAirport){
        if(visitedAirport.containsKey(selectedAirport.name)){
            return;
        }

        selectedAirport.directConnectedAirports = airportGraph.get(selectedAirport.name).directConnectedAirports;
        visitedAirport.put(selectedAirport.name, selectedAirport);
        unreachableAirport.put(selectedAirport.name, selectedAirport);
        for (Airport connectedAirport:selectedAirport.directConnectedAirports){
            depthFirstSearchForUnreachableAirports(airportGraph, connectedAirport, unreachableAirport, visitedAirport);
        }

    }

    static class Airport{
        String name;
        List<Airport> directConnectedAirports = new ArrayList<>();
        List<Airport> allReachableAirport = new ArrayList<>();
        public Airport(String name){ this.name = name;}
    }
}
