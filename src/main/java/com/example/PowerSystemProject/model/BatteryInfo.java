package com.example.PowerSystemProject.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="battery_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatteryInfo{
	
 
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Column(name="NAME")
private String name;

@Column(name="POSTCODE")
private double postcode;

@Column(name="CAPACITY")
private double capacity;







/*
public Battery() {}
	public Battery(String name, String postcode, double capacity) {
		// TODO Auto-generated constructor stub
		
	}
public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}

public String getPostcode() {
	return postcode;
}

public void setPostcode(String postcode) {
	this.postcode = postcode;
}

public double getCapacity() {
	return capacity;
}


public void setCapacity(double capacity) {
	this.capacity = capacity;
}


@Override
public String toString() {
	return "Battery [id=" + id + ", name=" + name + ", postcode=" + postcode + ", capacity=" + capacity + "]";
}

*/



}
