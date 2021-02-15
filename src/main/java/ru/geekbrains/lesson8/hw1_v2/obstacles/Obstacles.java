package ru.geekbrains.lesson8.hw1_v2.obstacles;

public class Obstacles {
    private final String obstacleName;
    private final int length;
    private final int height;
    private boolean passByJump = false;
    private boolean passByRun = false;

    public Obstacles(
            String obstacleName,
            boolean passByJump,
            boolean passByRun,
            int length,
            int height
    ) {
        this.obstacleName = obstacleName;
        this.passByJump = passByJump;
        this.passByRun = passByRun;
        this.length = length;
        this.height = height;
    }


    public String getObstacleName() {
        return obstacleName;
    }

    public boolean canPassByJump() {
        return passByJump;
    }

    public boolean canPassByRun() {
        return passByRun;
    }

    public boolean canPassByLength(int memberLength) {
        return memberLength <= length;
    }

    public boolean canPassByHeight(int memberHeight) {
        return memberHeight <= height;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }
}
