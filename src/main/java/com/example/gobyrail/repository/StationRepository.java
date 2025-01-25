package com.example.gobyrail.repository;

import com.example.gobyrail.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station,Integer> {
}
