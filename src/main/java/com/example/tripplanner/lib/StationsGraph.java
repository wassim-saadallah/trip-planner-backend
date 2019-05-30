package com.example.tripplanner.lib;

import com.example.tripplanner.beans.LineStation;
import com.example.tripplanner.beans.Station;
import com.example.tripplanner.repositories.LineRepository;
import com.example.tripplanner.repositories.LineStationRepository;
import com.example.tripplanner.repositories.StationRepository;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StationsGraph {

    private SimpleGraph<Station, CustomEdge> graph = new SimpleGraph<>(CustomEdge.class);
    StationRepository stationRepository;
    LineRepository lineRepository;
    LineStationRepository lineStationRepository;

    @Autowired
    public StationsGraph(StationRepository stationRepository, LineRepository lineRepository,
            LineStationRepository lineStationRepository) {
        this.stationRepository = stationRepository;
        this.lineRepository = lineRepository;
        this.lineStationRepository = lineStationRepository;

        initGraph();

    }

    public SimpleGraph<Station, CustomEdge> getGraph() {
        return graph;
    }

    public Map<Integer, List<LineStation>> getStationsByLine() {

        List<LineStation> lineStations = lineStationRepository.findAll();

        System.out.println(lineStations.size());
        return lineStations.stream().distinct().sorted(Comparator.comparingInt(LineStation::getPosition))
                .collect(Collectors.groupingBy(LineStation::getLineID));
    }

    public void initGraph() {
        List<Station> stationList = stationRepository.findAll();
        // hash map for faster access
        Map<Integer, Station> stationMap = new HashMap<>();
        for (Station station : stationList) {
            stationMap.put(station.getId(), station);
            graph.addVertex(station);
        }

        for (List<LineStation> lineStations : getStationsByLine().values()) {
            for (int i = 0; i < lineStations.size() - 1; i++) {
                Station src = stationMap.get(lineStations.get(i).getStationID());
                Station target = stationMap.get(lineStations.get(i + 1).getStationID());
                if (src != target)
                    graph.addEdge(src, target);
            }
        }
        System.out.println("********************************************");
        graph.edgesOf(stationList.get(36)).forEach(System.out::println);
        System.out.println("********************************************");
    }

    public List<CustomEdge> getShortestPath(int fromID, int toID) {
        DijkstraShortestPath<Station, CustomEdge> shortestPath = new DijkstraShortestPath<>(graph);
        GraphPath<Station, CustomEdge> path = shortestPath.getPath(stationRepository.getOne(fromID), stationRepository.getOne(toID));
        return path.getEdgeList();
    }
}
