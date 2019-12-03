package com.example.ExercisePlanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ExercisePlanner.domain.Exercise;
import com.example.ExercisePlanner.domain.ExerciseRepository;
import com.example.ExercisePlanner.domain.User;
import com.example.ExercisePlanner.domain.UserRepository;
import com.example.ExercisePlanner.domain.Workout;
import com.example.ExercisePlanner.domain.WorkoutRepository;

@SpringBootApplication
public class ExercisePlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExercisePlannerApplication.class, args);
	}

	@Bean
	public CommandLineRunner exerciseDemo(ExerciseRepository exRepository, WorkoutRepository workRepository, UserRepository userRepository) {
		return (args) -> {

			workRepository.save(new Workout("Fat Burn"));
			workRepository.save(new Workout("Strength Training"));

			exRepository.save(new Exercise("Push Ups", 22, 19, 30, workRepository.findByName("Fat Burn")));
			exRepository.save(new Exercise("Squats", 22, 19, 30, workRepository.findByName("Strength Training")));
			exRepository.save(new Exercise("Bench Press", 22, 19, 30, workRepository.findByName("Strength Training")));

			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);
		};
	}
}