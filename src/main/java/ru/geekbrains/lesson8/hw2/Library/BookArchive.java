package ru.geekbrains.lesson8.hw2.Library;

import ru.geekbrains.lesson7.Colorize;

import java.util.Random;

public class BookArchive {
    private Books[] books;
    private int quantity;
    private String[] booksList = {
            "R P N Singh - Politics of Opportunism",
            "Akkitham Achuthan Namboodri - Malayalam poetry",
            "Margaret Atwood - The Testaments",
            "Jokha Alharthi - Celestial Bodies",
            "Vasdev Mohi - Cheque book",
            "Richard Powers - The Overstory",
            "PM Narendra Modi - The Braille edition of the book Exam Warriors",
            "Viswanathan Anand and Susan Ninan - Mind-Master",
            "Hemant Karkare's daughter Jui Karkare - Hemant Karkare: A Daughter’s Memoir",
            "Chief Justice of India (CJI) Ranjan Gogoi - Courts of India",
            "Karkare's Daughter Jui Karkare - Hemant Karkare: A Daughter’s Memoir",
            "Prime Minister Narendra Modi - Braille Edition of ‘Exam Warriors’",
            "Shri N Chandrasekaran - Bridgital Nation",
            "Neha J Hiranandani - Girl Power: Indian Women Who Broke The Rules",
            "Roopa Pai - From Leeches to Slug Glue: 25 Explosive Ideas that Made (and Are Making) Modern Medicine",
            "‘150 Years of Celebrating the Mahatma–the South African Legacy’ - Fakir Hassen",
            "Rahul Agarwal and Bharathi S Pradhan - Turbulence and Triumph: The Modi Years",
            "Ministry of fisheries - Handbook on Fisheries Statistics - 2018",
            "Vikram Sampath -  Savarkar: Echoes from a forgotten past, 1883-1924",
            "Indian Diaspora Club - Glorious Diaspora-Pride of India",
            "Habiburahman, Sophie Ansel - First They Erased Our Name: A Rohingya Speaks",
            "Peter Baker - Obama: The Call of History",
            "Iqbal Chand Malhotra and Maroof Raza - Kashmir’s untold story: Declassification",
            "Satyarth Nayak - “Sridevi: Girl Woman Superstar”",
            "Department of Biotechnology (DBT) and Persistent Systems - Manav",
            "St James House and the History of Parliament Trust - ‘The Commonwealth at 70: From Westminster to the World’",
            "Adi Shankaracharya - Vivekadeepini",
            "Venkaiah Naidu - Listening, Learning and Leading",
            "Baba Ramdev - 'My Life, My Mission'",
            "Meenakshi Lekhi - 'The New Delhi Conspiracy'",
            "Tridip Suhrud - ‘The Diary of Manu Gandhi’",
            "Sushil Kumar - A Prime Minister to Remember- Memories of a Military Chief",
            "Adi Shankaracharya - Vivekadeepini",
            "Anupam Kher - “Lessons Life Taught Me Unknowingly”.",
            "Ashis Ray - “Cricket World Cup: The Indian Challenge”",
            "Dr. A.P.J. Abdul Kalam - My Journey",
            "Dr. Bibek Debroy - Making of New India",
            "Dr. Krishna Saksena - Whispers of Time",
            "Dr. Y.V. Reddy - Indian Fiscal Federalism",
            "Jairam Ramesh - ‘Chequered Brillance: The Many Lives of V K Krishna Menon’",
            "Kamlesh Patel Alias Daaji - ‘Designing Destiny: The Heartfulness Way’",
            "Kamlesh Patil & Joshua Pollock - ‘The Heartfulness way: Heart-Based Meditations for Spiritual Transformation’",
            "Lamar Odom - Darkness to light",
            "Lieutenant General Ranbir Singh - Fire and Fury Corps -- Saga of Valour, Fortitude and Sacrifice',",
            "M Venkaiah Naidu - Quality, Accreditation, and Ranking – A Silent Revolution in the Offing in Indian Higher Education",
            "Malala Yousafzai - We are Displaced",
            "Manoshi Sinha Rawal - ‘Saffron Swords’",
            "Meenakshi Lekhi - “The New Delhi Conspiracy”",
            "Mool Chand Sharma - ‘Law, Justice and Judicial Power- Justice P N Bhagwati’s Approach’",
            "Mr. Suri - ‘Khooni Vaisakhi’",
            "Navin Chawla - ‘Every Vote Counts- The story of India’s Elections’",
            "Neeraj Jha, Vidhanshu Kumar - ‘Virat: The making of a Champion’",
            "P. Chidambaram - ‘Undaunted: Saving the Idea of India’",
            "R Uma Maheswari - From Possession to Freedom",
            "Raghuram Rajan - The Third Pillar",
            "Ruchir Sharma - ‘Undaunted: Saving the Idea of India’",
            "Saba Naqvi - Politics of Jugaad: The Coalition Handbook",
            "Shahid Afridi - Game Changer",
            "Sharad Dutt - ‘Kundan: Saigal’s Life & Music’",
            "Shri Harivansh and Shri Ravi Dutt Bajpai. - Chandra Shekhar - The Last Icon of Ideological Politics;",
            "Sonia Singh - ‘Defining India: Through Their Eyes’",
            "Vinit Goenka - 'Function of Data Sovereignty - The Pursuit of Supremacy'",
            "Valay Singh - ‘Ayodhya: City of Faith, City of Discord’",
    };

    public BookArchive(int quantity) {
        if (quantity > booksList.length)
            quantity = booksList.length;

        this.quantity = quantity;
        this.books = new Books[quantity];
    }

    public void createArchive(LibraryRooms libraryRooms) {
        for (int i = 0; i < books.length; i++) {
            String[] book = booksList[i].split(" - ");

            books[i] = new Books(book[1], book[0]);
        }

        System.out.println(
                Colorize.make(
                        "warning",
                        "Created archive with books"
                ) + " in Library: " + libraryRooms.getRoomName()
        );
    }

    public void giveBook(LibraryRooms libraryRoom, Visitors visitor) {
        if (isVisitorInLibraryRoom(libraryRoom, visitor)) {
            Random random = new Random();

            visitor.takeBook(books[random.nextInt(books.length)]);
        } else {
            System.out.println(
                    Colorize.make(
                            "error",
                            visitor.getVisitorName() + " not in Library room"
                    )
            );
        }
    }

    public boolean isVisitorInLibraryRoom(LibraryRooms libraryRoom, Visitors visitor) {
        return libraryRoom.journal.isVisitorAlreadySign(visitor);
    }
}
