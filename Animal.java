import java.util.HashMap;
import java.util.Map;

//Using your files. Don't fix what ain't broke.
public class Animal {

    // Animal Class attributes
    private String animalName;
    private String species;
    private int age;
    private String sex;
    private String Color;
    private String birthday;

    // Create a static attribute that belongs to the Animal class.
    public static int numOfAnimals = 0;
    private static Map<String, Integer> speciesCount = new HashMap<>(); // best way to track Species

    // Animal Class constructors.
    public Animal(String name, String aSpecies, int anAge, String aSex, String aColor, String anBirthSeason) {
        System.out.println("\n A new Animal object was created.\n");

        // Create initial values for the class attributes.
        animalName = name;
        species = aSpecies;
        age = anAge;
        sex = aSex;
        Color = aColor;
        birthday = anBirthSeason;

        numOfAnimals++;

        speciesCount.put(species, speciesCount.getOrDefault(species, 0) + 1);

    }

    public Animal() {
        System.out.println("\n A new Animal object was created.\n");
        numOfAnimals++;
    }

    // Getters and Setters for each attribute (optional, but recommended for good practice)
    public String getName() {
        return animalName;
    }

    public void setName(String name) {
        this.animalName = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecies() {
        return species;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public static int getSpeciesCount(String species) {
        return speciesCount.getOrDefault(species, 0);
    }
}

 class Hyena extends Animal{

    public static void sound() {
        System.out.println("Hyena laughing"); // just an animal noise
    }

}

class Lion extends Animal{

    public static void sound() {
        System.out.println("Lion roaring");// just an animal noise
    }

}

class Tiger extends Animal{

    public static void sound() {
        System.out.println("Tiger growling");// just an animal noise
    }

}

class Bear extends Animal{

    public static void sound() {
        System.out.println("Bear growling");
    }// just an animal noise

}
