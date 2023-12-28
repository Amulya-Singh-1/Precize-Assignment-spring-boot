package com.task.assignment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SatResult {

	@Id
    private String name;
    private String address;
    private String city;
    private String country;
    private String pincode;
    private int satScore;
    private String passed;

}
