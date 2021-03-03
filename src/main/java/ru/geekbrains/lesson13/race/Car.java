package ru.geekbrains.lesson13.race;

import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private final Race race;
    private final int speed;
    private final String name;
    private static CyclicBarrier cb;
    private static boolean firstCome = false;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;

        cb = new CyclicBarrier(CARS_COUNT);
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");

            if (cb.getNumberWaiting() == CARS_COUNT - 1)
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

            cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);


                if (i == race.getStages().size() - 1 && !firstCome) {
                    firstCome = true;
                    System.out.println(this.name + " - WIN");
                }
            }

            if (cb.getNumberWaiting() == CARS_COUNT - 1)
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");

            cb.await();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
