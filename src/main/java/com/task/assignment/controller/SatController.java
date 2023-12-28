package com.task.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.assignment.entity.SatResult;
import com.task.assignment.service.SatServiceImpl;

@RestController
@RequestMapping("/api/satResults")
public class SatController {

	@Autowired
	private SatServiceImpl satService;

	@PostMapping("/insert")
	public ResponseEntity<SatResult> insertData(@RequestBody SatResult Sat) {
		SatResult insertedResult = satService.insertData(Sat);
		return new ResponseEntity<>(insertedResult, HttpStatus.CREATED);
	}

	@GetMapping("/viewAll")
	public ResponseEntity<List<SatResult>> getAllData() {
		List<SatResult> allData = satService.getAllData();
		return new ResponseEntity<>(allData, HttpStatus.OK);
	}

	@GetMapping("/getRank/{name}")
	public ResponseEntity<Integer> getRank(@PathVariable(name="name") String studentName) {
		int rank = satService.getRank(studentName);
		if (rank != -1) {
			return new ResponseEntity<>(rank, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/updateScore/{name}/{newScore}")
	public ResponseEntity<SatResult> updateScore(@PathVariable(name = "name") String name,
			@PathVariable(name = "newScore") Integer newScore) {
		SatResult updatedResult = satService.updateScore(name, newScore);
		if (updatedResult != null) {
			return new ResponseEntity<>(updatedResult, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/delete/{name}")
	public ResponseEntity<String> deleteRecord(@PathVariable(name="name") String studentName) {
		String msg=satService.deleteRecord(studentName);
		return new ResponseEntity<>( msg,HttpStatus.OK);
	}
}
