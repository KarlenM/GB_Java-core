package ru.geekbrains.lesson8.hw2.Library;

public class LibraryRooms {
    private final String roomName;
    private final int maxNoise;
    private int roomNoise = 0;
    protected Journal journal;
    protected BookArchive bookArchive;

    public LibraryRooms(String roomName, int capacity, int maxNoise) {
        this.roomName = roomName;
        this.maxNoise = maxNoise;
        this.journal = new Journal(capacity);

        this.bookArchive = new BookArchive(10);
        bookArchive.createArchive(this);
    }

    public void addNewVisitor(Visitors visitor) {
        this.roomNoise += visitor.getNoiseVolume();

        journal.signNewVisitor(this, visitor);
    }

    public void removeVisitor(Visitors visitor) {
        this.roomNoise -= visitor.getNoiseVolume();

        journal.removeVisitor(visitor);
    }

    public boolean isNoisyInRoom() {
        return roomNoise > maxNoise;
    }

    public String getRoomName() {
        return roomName;
    }
}
