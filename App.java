import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Using your files. Don't fix what ain't broke.

public class App {
    public static void main(String[] args) {
        System.out.println("\n\n Welcome to My Zoo Program\n\n");
        System.out.println("\n Number of animals is: " + Animal.numOfAnimals);

        // local variables
        String name;
        String species;
        String sex;
        String color;
        String birthInfo;
        String abirthyear;
        int birthyear;
        int age;

        // ArrayList of Animal objects
        ArrayList<Animal> animals = new ArrayList<>();

        // Open an external file, parse it line by line, and get age and species
        String filePath = "/Users/angel/IdeaProjects/Java Zoo/src/arrivingAnimals.txt";
        File file = new File(filePath);


        try (Scanner scanner = new Scanner(file)) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            // Age is in the first element of the array named parts
            String[] parts = line.split(", ");

            // Check if the line has at least 1 part
            if (parts.length >= 1) {
                String ageAndSpecies = parts[0];
                System.out.println("ageAndSpecies: " + ageAndSpecies );

                // Get age out of 'ageAndSpecies'
                String[] theParts = ageAndSpecies.split(" ");
                for (int i=0; i<5; i++) {
                    System.out.println("theParts[" + i + "] is " + theParts[i]);
                }
                String ageThingy = parts[1];
                String[] ageParts = ageThingy.split(" ");

                age = Integer.parseInt(theParts[0]);
                birthyear = 2024-age;
                abirthyear = String.valueOf(birthyear);
                species = theParts[4];
                sex = theParts[3];
                color = parts[2];
                birthInfo = ageParts[2] +"-" + abirthyear;

                // Create a new animal object.
                Animal myAnimal = new Animal("name needed", species, age, sex, color, birthInfo);

                // Add the new Animal object to the ArrayList of Animals
                animals.add(myAnimal);
            }
            System.out.println("\n Number of animals is: " + Animal.numOfAnimals);
        }
    } catch (FileNotFoundException e) {
        System.out.println("File not found: " + filePath);
        e.printStackTrace();
    }

        // now creating a text file named newAnimals that contains info about the animals
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("newAnimals.txt")))) {
            for (Animal animal : animals) {
                System.out.println(animal);
                System.out.println("Animal name: " + animal.getName() + ", Age: " + animal.getAge() + ", Species: " + animal.getSpecies() + ", Sex: " + animal.getSex() + ", Color: " + animal.getColor() + ", BirthInfo: " + animal.getBirthday());

                // writes to the file
                writer.println("Animal name: " + animal.getName() + ", Age: " + animal.getAge() + ", Species: " + animal.getSpecies() + ", Sex: " + animal.getSex() + ", Color: " + animal.getColor() + ", BirthInfo: " + animal.getBirthday());
            }
            System.out.println();
            System.out.println("Total number of new animals is: " + Animal.numOfAnimals);

            // writes the number of animals to the file
            System.out.println();
            writer.println("Total number of new animals is: " + Animal.numOfAnimals);

            // now for each species
            System.out.println("Number of Hyenas is: " + Animal.getSpeciesCount("hyena"));// Hyena
            writer.println("Number of Hyenas is: " + Animal.getSpeciesCount("hyena"));// writes the number of animals to the file

            System.out.println("Number of Tigers is: " + Animal.getSpeciesCount("tiger"));// Tiger one
            writer.println("Number of Tigers is: " + Animal.getSpeciesCount("tiger"));// writes the number of animals to the file

            System.out.println("Number of Lions is: " + Animal.getSpeciesCount("lion"));// Lion one
            writer.println("Number of Lions is: " + Animal.getSpeciesCount("lion"));// writes the number of animals to the file

            System.out.println("Number of Bears is: " + Animal.getSpeciesCount("bear") );// Bear one
            writer.println("Number of Bears is: " + Animal.getSpeciesCount("bear"));// writes the number of animals to the file

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println( );
        Hyena.sound();
        Bear.sound();
        Tiger.sound();
        Lion.sound();

    }

}
