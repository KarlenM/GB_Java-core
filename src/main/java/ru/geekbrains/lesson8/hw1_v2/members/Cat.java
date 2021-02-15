package ru.geekbrains.lesson8.hw1_v2.members;

import ru.geekbrains.lesson7.Colorize;
import ru.geekbrains.lesson8.hw1_v2.members.impl.Jumpable;
import ru.geekbrains.lesson8.hw1_v2.members.impl.Runnable;
import ru.geekbrains.lesson8.hw1_v2.obstacles.Obstacles;

public class Cat implements Runnable, Jumpable {
    private String catName = "Cat";
    private final int maxRunLength;
    private final int maxJumpHeight;

    public Cat(String robotName, int maxRunLength, int maxJumpHeight) {
        this.catName += " " + robotName;
        this.maxRunLength = maxRunLength;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public boolean run(Obstacles obstacles) {
        System.out.print(catName + " ");

        if(obstacles.canPassByRun() && obstacles.canPassByLength(maxRunLength)) {
            System.out.println(
                    Colorize.make(
                            "ok",
                            "successfully run over") +
                            " an obstacle " + obstacles.getObstacleName()
            );

            return true;
        }

        else if(!obstacles.canPassByRun()) {
            System.out.println(Colorize.make(
                    "error",
                    "can't pass " + obstacles.getObstacleName()
            ) + " by run");

            return true;
        }

        System.out.println(Colorize.make(
                "error",
                "can't run this much"
        ) + " on the " + obstacles.getObstacleName());

        return false;
    }

    @Override
    public boolean jump(Obstacles obstacles) {
        System.out.print(catName + " ");

        if(obstacles.canPassByJump() && obstacles.canPassByHeight(maxJumpHeight)) {
            System.out.println(
                    Colorize.make(
                            "ok",
                            "successfully jumped over") +
                            " an obstacle " + obstacles.getObstacleName()
            );

            return true;
        }

        else if(!obstacles.canPassByJump()) {
            System.out.println(Colorize.make(
                    "error",
                    "can't pass " + obstacles.getObstacleName()
            ) + " by jump");

            return true;
        }

        System.out.println(Colorize.make(
                "error",
                "can't jump this much"
        ) + " on the " + obstacles.getObstacleName());

        return false;
    }
}
