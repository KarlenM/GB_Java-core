package ru.geekbrains.lesson6;

public class Dog extends Animal {
    private final String ANIMAL_TYPE = "Dog";
    private static int dogsQuantity = 0;

    public Dog(String animalName, int maxRun, int maxSwim) {
        super(animalName, maxRun, maxSwim);

        ++dogsQuantity;
    }

    @Override
    void run(int meters) {
        String actionString;

        if(canDoAction(getMaxRun())) {
            actionString = meters > getMaxRun()
                    ? ANIMAL_TYPE + " " + getAnimalName() + " can't run that much"
                    : ANIMAL_TYPE + " " + getAnimalName() + " run " + meters + " meters";
        }

        else
            actionString = ANIMAL_TYPE + " " + getAnimalName() + " can't run";

        System.out.println(actionString);
    }

    @Override
    void swim(int meters) {
        String actionString;

        if(canDoAction(getMaxSwim())) {
            actionString = meters > getMaxSwim()
                    ? ANIMAL_TYPE + " " + getAnimalName() + " can't swim that much"
                    : ANIMAL_TYPE + " " + getAnimalName() + " swim " + meters + " meters";
        }

        else
            actionString = ANIMAL_TYPE + " " + getAnimalName() + " can't swim";

        System.out.println(actionString);
    }

    @Override
    String getAnimalQuantity() {
        return ANIMAL_TYPE + "'s quantity: " + dogsQuantity;
    }

    @Override
    String getType() {
        return ANIMAL_TYPE;
    }
}
