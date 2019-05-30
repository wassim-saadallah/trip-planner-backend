package com.example.tripplanner.repositories;

import com.example.tripplanner.beans.Line;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LineRepository extends JpaRepository<Line,Integer> {
}
