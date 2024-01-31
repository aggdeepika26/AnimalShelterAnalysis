package be.intecbrussel.animalShelter;

import be.intecbrussel.animalShelter.model.Animal;
import be.intecbrussel.animalShelter.model.SortOrFindType;
import be.intecbrussel.animalShelter.repository.AnimalRepository;
import be.intecbrussel.animalShelter.service.AnimalService;

import java.util.Optional;
import java.util.Scanner;

public class AnimalShelterApp {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("sort");
        System.out.println("add");
        System.out.println("find");
        System.out.println();
        System.out.println("What do you want to do today?");
       // System.out.println("[sort] Sort the animals in the shelter.");
        String input = scanner.nextLine();
        handleUserRequest(input);
        System.out.println("debug");


    }

    private static void handleUserRequest(String input) {
        switch(input) {
            case "sort" -> sortShelter();
            case "add" -> handleAddInfoOfAnimal();
            default -> System.out.println("Invalid input");
        }
    }

    private static void sortShelter() {
        Scanner scanner = new Scanner(System.in);
        SortOrFindType sortType;
        System.out.println("Do you wanna sort by [age] or [name] ?");
        String sortInput = scanner.nextLine();
        if (sortInput.equals("name"))
            sortType = SortOrFindType.NAME;
        else if (sortInput.equals("age"))
            sortType = SortOrFindType.AGE;
        else
        {
            System.out.println("Invalid sorting type");
            return;
        }

        AnimalService animalService = new AnimalService(new AnimalRepository());
        animalService.sortAnimalShelter(sortType);
        System.out.println("Ok sir");
    }

    private static void handleAddInfoOfAnimal()
    {
        //Animal animal = new Animal(1, "Bobby", 52);
        Animal animal = new Animal(5,"Sheru", 6);
        AnimalService animalService = new AnimalService(new AnimalRepository());
        Optional animalAvailability = animalService.checkAnimalPresentInListOrNot(animal);
        if (animalAvailability.isPresent())
        {
            System.out.println("Sorry animal already available present");
        }
        else
        {
            System.out.println("Animal Added");
        }
    }



}