package com.task.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.assignment.customException.StudentExistsException;
import com.task.assignment.entity.SatResult;
import com.task.assignment.repository.SatResultRepository;

import jakarta.transaction.Transactional;

@Service
public class SatServiceImpl implements SatService{

	 @Autowired
	 private SatResultRepository satResultRepository;
	
	 // to add a student
	 @Override
	 public SatResult insertData(SatResult satResult) {
		 Optional<SatResult> existingResult=satResultRepository.findByName(satResult.getName());
		 if(existingResult.isPresent()) {
			 throw new StudentExistsException("The Student already exists");
		 }
	     // Calculate passed based on the condition
		 satResult.setPassed(satResult.getSatScore() > 30 ? "Pass" : "Fail" );
	     return satResultRepository.save(satResult);
	 }
	
	 // to get a list of all the students
	 @Override
	 public List<SatResult> getAllData() {
	     return satResultRepository.findAll();
	 }
	
	 // to get rank according to their SAT score
	 @Override
	 public int getRank(String name) {
	     List<SatResult> allResults = satResultRepository.findAllOrderBySatScoreDesc();
	     for (int i = 0; i < allResults.size(); i++) {
	         if (allResults.get(i).getName().equals(name)) {
	             return i + 1;
	         }
	     }
	     return -1; 
	 }
	
	 // to update score of a particular student
	 @Override
	 public SatResult updateScore(String name, int newScore) {
	     Optional<SatResult> optionalSatResult = satResultRepository.findByName(name);
	     if (optionalSatResult.isPresent()) {
	         SatResult satResult = optionalSatResult.get();
	         satResult.setSatScore(newScore);
	         satResult.setPassed(newScore > 30 ? "Pass" : "Fail" );
	         return satResultRepository.save(satResult);
	     }
	     return null; 
	 }
	
	 // to delete record of a student
	 @Override
	 @Transactional
	 public String deleteRecord(String name) {
		 Optional<SatResult> existingResult=satResultRepository.findByName(name);
		 // checking if the student exists in db or not
		 if(existingResult.isEmpty()) {
			 return "The Student doesn't exists";
		 }
	     satResultRepository.deleteByName(name);
	     return "Student Record deleted successfully";
	 }
}
	

