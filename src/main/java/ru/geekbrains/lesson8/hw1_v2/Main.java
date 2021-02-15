package ru.geekbrains.lesson8.hw1_v2;

import ru.geekbrains.lesson8.hw1_v2.members.Human;
import ru.geekbrains.lesson8.hw1_v2.members.Robot;
import ru.geekbrains.lesson8.hw1_v2.members.Cat;
import ru.geekbrains.lesson8.hw1_v2.obstacles.Obstacles;
import ru.geekbrains.lesson8.hw1_v2.obstacles.RunningTrack;
import ru.geekbrains.lesson8.hw1_v2.obstacles.Wall;

public class Main {
    public static void main(String[] args) {
        Obstacles[] obstacles = new Obstacles[2];
        obstacles[0] = new RunningTrack(11);
        obstacles[1] = new Wall(50);

        Object[] members = new Object[3];
        members[0] = new Human("Jeff", 10, 10);
        members[1] = new Robot("R2D2", 100, 50);
        members[2] = new Cat("Tom", 10, 100);


        for (Object member : members) {
            System.out.println();

            for (Obstacles obstacle : obstacles) {
                if(member instanceof Human) {
                    if(!((Human) member).run(obstacle))
                        break;

                    if(!((Human) member).jump(obstacle))
                        break;
                }

                if(member instanceof Robot) {
                    if(!((Robot) member).run(obstacle))
                        break;

                    if(!((Robot) member).jump(obstacle))
                        break;
                }

                if(member instanceof Cat) {
                    if(!((Cat) member).run(obstacle))
                        break;

                    if(!((Cat) member).jump(obstacle))
                        break;
                }
            }
        }
    }
}
