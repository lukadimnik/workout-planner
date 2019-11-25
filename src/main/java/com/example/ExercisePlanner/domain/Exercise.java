package com.example.ExercisePlanner.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Exercise {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private int sets;
	private int reps;
	private int rest;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "workoutid")
	private Workout workout;

	public Exercise() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Exercise(String name, int sets, int reps, int rest, Workout workout) {
		this.name = name;
		this.sets = sets;
		this.reps = reps;
		this.rest = rest;
		this.workout = workout;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getReps() {
		return reps;
	}

	public void setReps(int reps) {
		this.reps = reps;
	}

	public int getSets() {
		return sets;
	}

	public void setSets(int sets) {
		this.sets = sets;
	}

	public Workout getWorkout() {
		return workout;
	}

	public void setWorkout(Workout workout) {
		this.workout = workout;
	}

	public int getRest() {
		return rest;
	}

	public void setRest(int rest) {
		this.rest = rest;
	}

	@Override
	public String toString() {
		return "Exercise id= " + id + ", name= " + name + ", sets= " + sets + ", reps= " + reps + ", rest " + rest;
	}
}