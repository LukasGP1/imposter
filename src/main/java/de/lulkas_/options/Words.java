package de.lulkas_.options;

import de.lulkas_.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Words {
    private static final Map<String, String> PLACES = new HashMap<>();
    private static final Map<String, String> JOBS = new HashMap<>();
    private static final Map<String, String> ANIMALS = new HashMap<>();
    private static final Map<String, String> FOOD = new HashMap<>();
    private static final Map<String, String> TOYS = new HashMap<>();
    private static final Map<String, String> MOVIES = new HashMap<>();
    private static final Map<String, String> OBJECTS = new HashMap<>();
    private static final Map<String, String> LOCATIONS = new HashMap<>();
    private static final Map<String, String> CONCEPTS = new HashMap<>();

    public enum Category {
        Places,
        Jobs,
        Animals,
        Food,
        Toys,
        Movies,
        Objects,
        Locations,
        Concepts
    }

    public static Map.Entry<String, String> getWord(Category category) {
        return Utils.getRandom(new ArrayList<>(mapFromCategory(category).entrySet()));
    }

    private static Map<String, String> mapFromCategory(Category category) {
        switch (category) {
            case Places -> {
                return PLACES;
            }
            case Jobs -> {
                return JOBS;
            }
            case Animals -> {
                return ANIMALS;
            }
            case Food -> {
                return FOOD;
            }
            case Toys -> {
                return TOYS;
            }
            case Movies -> {
                return MOVIES;
            }
            case Objects -> {
                return OBJECTS;
            }
            case Locations -> {
                return LOCATIONS;
            }
            case Concepts -> {
                return CONCEPTS;
            }
        }
        return new HashMap<>();
    }

    public static void init() {
        PLACES.put("School", "homework");
        PLACES.put("Hospital", "nurse");
        PLACES.put("Airport", "luggage");
        PLACES.put("Supermarket", "trolley");
        PLACES.put("Cinema", "popcorn");
        PLACES.put("Swimming Pool", "goggles");
        PLACES.put("Subway", "ticket");
        PLACES.put("Library", "books");
        PLACES.put("Beach", "sand");
        PLACES.put("Restaurant", "menu");
        PLACES.put("Zoo", "cage");
        PLACES.put("Train Station", "platform");
        PLACES.put("Amusement Park", "rollercoaster");
        PLACES.put("Post Office", "stamp");
        PLACES.put("Museum", "exhibit");
        PLACES.put("Hotel", "reception");
        PLACES.put("Bank", "money");
        PLACES.put("Classroom", "chalkboard");
        PLACES.put("Church", "prayer");
        PLACES.put("Factory", "machines");

        JOBS.put("Doctor", "stethoscope");
        JOBS.put("Teacher", "homework");
        JOBS.put("Chef", "knife");
        JOBS.put("Firefighter", "hose");
        JOBS.put("Pilot", "cockpit");
        JOBS.put("Police Officer", "handcuffs");
        JOBS.put("Actor", "script");
        JOBS.put("Mechanic", "wrench");
        JOBS.put("Dentist", "tooth");
        JOBS.put("Farmer", "tractor");
        JOBS.put("Scientist", "lab");
        JOBS.put("Musician", "instrument");
        JOBS.put("Waiter", "tray");
        JOBS.put("Librarian", "shelf");
        JOBS.put("Photographer", "camera");
        JOBS.put("Lawyer", "court");
        JOBS.put("Journalist", "interview");
        JOBS.put("Construction Worker", "helmet");
        JOBS.put("Plumber", "pipe");
        JOBS.put("Electrician", "wire");

        ANIMALS.put("Dog", "bark");
        ANIMALS.put("Cat", "whiskers");
        ANIMALS.put("Elephant", "trunk");
        ANIMALS.put("Giraffe", "neck");
        ANIMALS.put("Penguin", "ice");
        ANIMALS.put("Lion", "roar");
        ANIMALS.put("Kangaroo", "pouch");
        ANIMALS.put("Horse", "saddle");
        ANIMALS.put("Rabbit", "carrot");
        ANIMALS.put("Snake", "slither");
        ANIMALS.put("Dolphin", "ocean");
        ANIMALS.put("Monkey", "banana");
        ANIMALS.put("Bear", "cave");
        ANIMALS.put("Zebra", "stripes");
        ANIMALS.put("Owl", "night");
        ANIMALS.put("Tiger", "jungle");
        ANIMALS.put("Frog", "jump");
        ANIMALS.put("Sheep", "wool");
        ANIMALS.put("Cow", "milk");
        ANIMALS.put("Wolf", "howl");

        FOOD.put("Pizza", "cheese");
        FOOD.put("Apple", "fruit");
        FOOD.put("Bread", "toast");
        FOOD.put("Chocolate", "sweet");
        FOOD.put("Rice", "white");
        FOOD.put("Cheese", "melt");
        FOOD.put("Banana", "peel");
        FOOD.put("Burger", "bun");
        FOOD.put("Pasta", "sauce");
        FOOD.put("Ice Cream", "cold");
        FOOD.put("Egg", "yolk");
        FOOD.put("Carrot", "orange");
        FOOD.put("Steak", "grill");
        FOOD.put("Salad", "lettuce");
        FOOD.put("Soup", "bowl");
        FOOD.put("Cake", "birthday");
        FOOD.put("Chicken", "roast");
        FOOD.put("Fish", "bone");
        FOOD.put("Watermelon", "seed");
        FOOD.put("Fries", "salt");

        TOYS.put("Teddy Bear", "hug");
        TOYS.put("Lego", "blocks");
        TOYS.put("Swing", "playground");
        TOYS.put("Puzzle", "pieces");
        TOYS.put("Ball", "kick");
        TOYS.put("Paint Box", "colors");
        TOYS.put("Clay", "shape");
        TOYS.put("Toy Car", "wheels");
        TOYS.put("Doll", "dress");
        TOYS.put("Yo-Yo", "string");
        TOYS.put("Kite", "wind");
        TOYS.put("Slide", "ladder");
        TOYS.put("Building Blocks", "stack");
        TOYS.put("Water Gun", "squirt");
        TOYS.put("Marbles", "glass");
        TOYS.put("Train Set", "track");
        TOYS.put("Board Game", "dice");
        TOYS.put("Action Figure", "hero");
        TOYS.put("Stuffed Animal", "soft");
        TOYS.put("Jump Rope", "skip");

        MOVIES.put("Harry Potter", "wand");
        MOVIES.put("Star Wars", "space");
        MOVIES.put("Frozen", "ice");
        MOVIES.put("SpongeBob", "pineapple");
        MOVIES.put("Stranger Things", "upside");
        MOVIES.put("The Simpsons", "yellow");
        MOVIES.put("Avengers", "superhero");
        MOVIES.put("Batman", "cape");
        MOVIES.put("Shrek", "swamp");
        MOVIES.put("Toy Story", "toys");
        MOVIES.put("The Lion King", "savanna");
        MOVIES.put("Jurassic Park", "dinosaur");
        MOVIES.put("Spider-Man", "web");
        MOVIES.put("Finding Nemo", "fish");
        MOVIES.put("Minions", "banana");
        MOVIES.put("Game of Thrones", "throne");
        MOVIES.put("The Matrix", "code");
        MOVIES.put("Winnie the Pooh", "honey");
        MOVIES.put("Moana", "ocean");
        MOVIES.put("Coco", "guitar");

        OBJECTS.put("Chair", "sit");
        OBJECTS.put("Phone", "call");
        OBJECTS.put("Key", "lock");
        OBJECTS.put("Lamp", "light");
        OBJECTS.put("Mirror", "reflection");
        OBJECTS.put("Toothbrush", "bristles");
        OBJECTS.put("Scissors", "cut");
        OBJECTS.put("Backpack", "zipper");
        OBJECTS.put("Glasses", "vision");
        OBJECTS.put("Pen", "ink");
        OBJECTS.put("Clock", "time");
        OBJECTS.put("Bottle", "water");
        OBJECTS.put("Table", "legs");
        OBJECTS.put("Book", "pages");
        OBJECTS.put("Remote", "buttons");
        OBJECTS.put("Candle", "wax");
        OBJECTS.put("TV", "screen");
        OBJECTS.put("Computer", "keyboard");
        OBJECTS.put("Blanket", "warm");
        OBJECTS.put("Ruler", "measure");

        LOCATIONS.put("Germany", "Berlin");
        LOCATIONS.put("France", "Paris");
        LOCATIONS.put("Japan", "Tokyo");
        LOCATIONS.put("Brazil", "Rio");
        LOCATIONS.put("New York", "Statue");
        LOCATIONS.put("Paris", "Eiffel");
        LOCATIONS.put("Rome", "Colosseum");
        LOCATIONS.put("London", "Big Ben");
        LOCATIONS.put("Australia", "Sydney");
        LOCATIONS.put("Canada", "Maple");
        LOCATIONS.put("China", "Great Wall");
        LOCATIONS.put("Mexico", "Taco");
        LOCATIONS.put("India", "Taj");
        LOCATIONS.put("Russia", "Moscow");
        LOCATIONS.put("Egypt", "Pyramid");
        LOCATIONS.put("South Africa", "Safari");
        LOCATIONS.put("Italy", "Pizza");
        LOCATIONS.put("Spain", "Flamenco");
        LOCATIONS.put("Greece", "Olympics");
        LOCATIONS.put("Thailand", "Temple");

        CONCEPTS.put("Freedom", "liberty");
        CONCEPTS.put("Love", "heart");
        CONCEPTS.put("Fear", "dark");
        CONCEPTS.put("Time", "clock");
        CONCEPTS.put("Happiness", "smile");
        CONCEPTS.put("Memory", "past");
        CONCEPTS.put("Justice", "court");
        CONCEPTS.put("Peace", "dove");
        CONCEPTS.put("Courage", "brave");
        CONCEPTS.put("Truth", "honest");
        CONCEPTS.put("Friendship", "bond");
        CONCEPTS.put("Hope", "light");
        CONCEPTS.put("Dream", "sleep");
        CONCEPTS.put("Wisdom", "old");
        CONCEPTS.put("Strength", "power");
        CONCEPTS.put("Faith", "belief");
        CONCEPTS.put("Patience", "wait");
        CONCEPTS.put("Charity", "give");
        CONCEPTS.put("Kindness", "help");
        CONCEPTS.put("Loyalty", "trust");
    }
}
