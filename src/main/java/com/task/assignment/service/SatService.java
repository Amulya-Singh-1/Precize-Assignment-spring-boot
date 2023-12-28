package com.task.assignment.service;

import java.util.List;

import com.task.assignment.entity.SatResult;

public interface SatService {
	SatResult insertData(SatResult satResult);
    List<SatResult> getAllData();
    int getRank(String name);
    SatResult updateScore(String name, int newScore);
    String deleteRecord(String name);
}
