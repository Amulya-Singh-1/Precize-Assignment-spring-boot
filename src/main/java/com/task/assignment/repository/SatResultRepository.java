package com.task.assignment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.task.assignment.entity.SatResult;

@Repository
public interface SatResultRepository extends JpaRepository<SatResult, Long> {
	
	// to get a record by name
	Optional<SatResult> findByName(String name);

	// to get list of all records by descending order of their score
    @Query("SELECT s FROM SatResult s ORDER BY s.satScore DESC")
    List<SatResult> findAllOrderBySatScoreDesc();

    // to delete a record by name
	void deleteByName(String name);
}
