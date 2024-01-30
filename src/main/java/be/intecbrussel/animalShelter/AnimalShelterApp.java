package be.intecbrussel.animalShelter;

import be.intecbrussel.animalShelter.model.SortType;
import be.intecbrussel.animalShelter.repository.AnimalRepository;
import be.intecbrussel.animalShelter.service.AnimalService;

import java.util.Scanner;

public class AnimalShelterApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want to do today?");
        System.out.println("[sort] Sort the animals in the shelter.");
        String input = scanner.nextLine();
        handleUserRequest(input);
        System.out.println("debug");
    }

    private static void handleUserRequest(String input) {
        switch(input) {
            case "sort" -> sortShelter();
            default -> System.out.println("Invalid input");
        }
    }

    private static void sortShelter() {
        Scanner scanner = new Scanner(System.in);
        SortType sortType;

        System.out.println("Do you wanna sort by [age] or [name] ?");
        String sortInput = scanner.nextLine();

        if (sortInput.equals("name")) sortType = SortType.NAME;
        else if (sortInput.equals("age")) sortType = SortType.AGE;
        else {
            System.out.println("Invalid sorting type");
            return;
        }

        AnimalService animalService = new AnimalService(new AnimalRepository());
        animalService.sortAnimalShelter(sortType);

        System.out.println("Ok sir");
    }
}