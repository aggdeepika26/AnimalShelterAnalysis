package be.intecbrussel.animalShelter.service;

import be.intecbrussel.animalShelter.model.Animal;
import be.intecbrussel.animalShelter.model.SortOrFindType;
import be.intecbrussel.animalShelter.repository.AnimalRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class AnimalService {
    private AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public void sortAnimalShelter(SortOrFindType sortType){
        List<Animal> animalList = animalRepository.getAnimals();

        switch (sortType) {
            case AGE -> sortAnimalsByAge(animalList);
            case NAME -> sortAnimalsByName(animalList);
        }

        System.out.println();
    }

    public void sortAnimalsByName(List<Animal> animalList){
        animalList.sort(Comparator.comparing(Animal::getName));
    }

    public void sortAnimalsByAge(List<Animal> animalList){
        animalList.sort(Comparator.comparing(Animal::getAge));
    }



    public Optional checkAnimalPresentInListOrNot(Animal animal)
    {
        List<Animal> animalList = animalRepository.getAnimals();

        Optional<Animal> animalOptional = animalList.stream()
                    .filter(a -> a.getId()==(animal.getId())&& a.getName().equals(animal.getName()))
                    .findFirst();
        if (animalOptional.isEmpty())
           {
                addAnimal(animal);
           }

        return animalOptional;
    }

    private void addAnimal(Animal animal)
    {
        List<Animal> animalList = animalRepository.getAnimals();
        animalList.add(animal);
        animalList.forEach(System.out::println);
    }
}