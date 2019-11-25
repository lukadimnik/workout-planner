package com.example.ExercisePlanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ExercisePlanner.domain.Exercise;
import com.example.ExercisePlanner.domain.ExerciseRepository;
import com.example.ExercisePlanner.domain.Workout;
import com.example.ExercisePlanner.domain.WorkoutRepository;

@SpringBootApplication
public class ExercisePlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExercisePlannerApplication.class, args);
	}

	@Bean
	public CommandLineRunner exerciseDemo(ExerciseRepository exRepository, WorkoutRepository workRepository) {
		return (args) -> {

			workRepository.save(new Workout("Workout 1"));
			workRepository.save(new Workout("Workout 2"));

			exRepository.save(new Exercise("Bench Press", 22, 19, 30, workRepository.findByName("Workout 1")));
			exRepository.save(new Exercise("Squats", 22, 19, 30, workRepository.findByName("Workout 1")));
			exRepository.save(new Exercise("Bench Press", 22, 19, 30, workRepository.findByName("Workout 2")));

		};
	}
}