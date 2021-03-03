/*
    1. Перенести приведенный ниже код в новый проект, где мы организуем гонки.

    1. Все участники должны стартовать одновременно, несмотря на разное время  подготовки.

    2. В тоннель не может одновременно заехать больше половины участников (условность).

    3. Попробуйте все это синхронизировать.

    4. Первый участник, пересекший финишную черту, объявляется победителем (в момент пересечения этой самой черты).

    5. Победитель должен быть только один (ситуация с 0 или 2+ победителями недопустима).

    6. Когда все завершат гонку, нужно выдать объявление об окончании.

    7. Можно корректировать классы (в том числе конструктор машин) и добавлять объекты
    классов из пакета java.util.concurrent.
 */

package ru.geekbrains.lesson13;

import ru.geekbrains.lesson13.race.Car;
import ru.geekbrains.lesson13.race.Race;
import ru.geekbrains.lesson13.race.Road;
import ru.geekbrains.lesson13.race.Tunnel;

public class Main {
    private static final int CARS_COUNT = 5;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Race race = new Race(
                new Road(60),
                new Tunnel(CARS_COUNT / 2),
                new Road(40)
        );

        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        try {
            for (Car car : cars) {
                new Thread(car).start();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
