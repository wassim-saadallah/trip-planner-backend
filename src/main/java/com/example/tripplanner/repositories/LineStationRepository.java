package com.example.tripplanner.repositories;

import com.example.tripplanner.beans.LineStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineStationRepository extends JpaRepository<LineStation, Integer> {
}
