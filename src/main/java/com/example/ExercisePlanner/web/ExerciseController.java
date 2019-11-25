package com.example.ExercisePlanner.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.ExercisePlanner.domain.Exercise;
import com.example.ExercisePlanner.domain.ExerciseRepository;
import com.example.ExercisePlanner.domain.Workout;
import com.example.ExercisePlanner.domain.WorkoutRepository;

@Controller
public class ExerciseController {
	@Autowired
	private ExerciseRepository exRepository;
	@Autowired
	private WorkoutRepository workRepository;

	@RequestMapping(value = { "/", "/exerciselist" })
	public String index(Model model) {
		model.addAttribute("exercises", exRepository.findAll());
		return "exerciselist";
	}

	@RequestMapping(value = { "/workoutlist" })
	public String index2(Model model) {
		model.addAttribute("workouts", workRepository.findAll());
		model.addAttribute("exercises", exRepository.findAll());
		return "workoutlist";
	}

	// delete an exercise
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteExercise(@PathVariable("id") Long exerciseId, Model model) {
		exRepository.deleteById(exerciseId);
		return "redirect:../exerciselist";
	}

	// delete workout
	@RequestMapping(value = "/deleteworkout/{id}", method = RequestMethod.GET)
	public String deleteWorkout(@PathVariable("id") Long workoutId, Model model) {
		workRepository.deleteById(workoutId);
		return "redirect:../workoutlist";
	}

	// add a new exercise
	@RequestMapping(value = "/add")
	public String addExercise(Model model) {
		model.addAttribute("exercise", new Exercise());
		model.addAttribute("workouts", workRepository.findAll());
		return "addexercise";
	}

	// add a new workout
	@RequestMapping(value = "/addworkout")
	public String addWorkout(Model model) {
		model.addAttribute("workout", new Workout());
		return "addworkout";
	}

	// Edit an exercise
	@RequestMapping(value = "/edit/{id}")
	public String addExercise(@PathVariable("id") Long exerciseId, Model model) {
		model.addAttribute("exercise", exRepository.findById(exerciseId));
		model.addAttribute("workouts", workRepository.findAll());
		return "editexercise";
	}
	
	// Edit workout
		@RequestMapping(value = "/editworkout/{id}")
		public String addWorkout(@PathVariable("id") Long workoutId, Model model) {
			model.addAttribute("workout", workRepository.findById(workoutId));
			return "editworkout";
		}

	// save a new exercise
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Exercise exercise) {
		exRepository.save(exercise);
		return "redirect:exerciselist";
	}

	// save a new workout
	@RequestMapping(value = "/saveworkout", method = RequestMethod.POST)
	public String saveWorkout(Workout workout) {
		workRepository.save(workout);
		return "redirect:workoutlist";
	}
}