package ru.geekbrains.lesson6;

public class Cat extends Animal {
    private final String ANIMAL_TYPE = "Cat";
    private static int catsQuantity = 0;

    public Cat(String animalName, int maxRun, int maxSwim) {
        super(animalName, maxRun, maxSwim);

        ++catsQuantity;
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
        return ANIMAL_TYPE + "'s quantity: " + catsQuantity;
    }

    @Override
    String getType() {
        return ANIMAL_TYPE;
    }
}
