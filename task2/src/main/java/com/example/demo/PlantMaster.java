package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity


public class PlantMaster {
@Id

private String FullName;

private int DOB;



public String getFullName() {
	return FullName;
}
public void setFullName(String fullName) {
	FullName = fullName;
}
public int getDOB() {
	return DOB;
}
public void setDOB(int dOB) {
	DOB = dOB;
}

@Override
public String toString() {
	return "PlantMaster [FullName=" + FullName + ", DOB=" + DOB + "]";
}

	

}
