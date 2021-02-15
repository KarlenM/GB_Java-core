package ru.geekbrains.lesson8.hw1_v2.obstacles;

public class Wall extends Obstacles {
    public Wall(int height) {
        super(
                "wall",
                true,
                false,
                -1,
                height
        );
    }
}
