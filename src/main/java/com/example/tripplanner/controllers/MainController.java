package com.example.tripplanner.controllers;

import com.example.tripplanner.beans.Line;
import com.example.tripplanner.beans.Station;
import com.example.tripplanner.lib.CustomEdge;
import com.example.tripplanner.lib.StationsGraph;
import com.example.tripplanner.repositories.LineRepository;
import com.example.tripplanner.repositories.LineStationRepository;
import com.example.tripplanner.repositories.StationRepository;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MainController {

    @JsonSerialize
    public class EmptyJsonResponse {
    }

    @Autowired
    LineRepository lineRepository;

    @Autowired
    StationRepository stationRepository;

    @Autowired
    LineStationRepository lineStationRepository;

    @Autowired
    StationsGraph stationsGraph;

    @GetMapping("/lines")
    List<Line> getAllLines() {
        return lineRepository.findAll();
    }

    @GetMapping("/lines/{id}")
    ResponseEntity<Object> getLineById(@PathVariable(name = "id") int id) {
        Optional<Line> line = lineRepository.findById(id);
        return ResponseEntity.ok(line.isPresent() ? line.get() : new EmptyJsonResponse());
    }

    @GetMapping("/stations")
    List<Station> getAllStations() {
        return stationRepository.findAll();
    }

    @GetMapping("/stations/{id}")
    ResponseEntity<Object> getStationById(@PathVariable(name = "id") int id) {
        Optional<Station> station = stationRepository.findById(id);
        return ResponseEntity.ok(station.isPresent() ? station.get() : new EmptyJsonResponse());
    }

    @GetMapping(value = "/from/{from}/to/{to}", produces = "application/json")
    public String getShortestPath(@PathVariable int from, @PathVariable int to) {
        System.out.println(from + ", " + to);
        return stationsGraph.getShortestPath(from, to).toString();
    }

}
