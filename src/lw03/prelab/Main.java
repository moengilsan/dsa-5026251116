package lw03.prelab;

package lw03.prelab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("===== Problem 1 =====");

        List<String> playlist = new ArrayList<>();

        Scanner scanner1 = new Scanner(
            new File("src/lw03/prelab/playlist.txt")
        );

        while (scanner1.hasNextLine()) {

            String line = scanner1.nextLine();

            if (line.startsWith("ADD ")) {

                String song = line.substring(4);

                playlist.add(song);

            } else if (line.startsWith("INSERT ")) {

                String remaining = line.substring(7);

                int spacePosition = remaining.indexOf(" ");

                String indexText = remaining.substring(0, spacePosition);

                int index = Integer.parseInt(indexText);

                String song = remaining.substring(spacePosition + 1);

                playlist.add(index, song);

            } else if (line.startsWith("REMOVE ")) {

                String song = line.substring(7);

                playlist.remove(song);
            }
        }

        scanner1.close();

        System.out.println("Total songs: " + playlist.size());

        for (int i = 0; i < playlist.size(); i++) {

            System.out.println((i + 1) + ": " + playlist.get(i));
        }


        System.out.println();
        System.out.println("===== Problem 2 =====");

        Set<String> participants = new LinkedHashSet<>();

        int duplicateCount = 0;

        Scanner scanner2 = new Scanner(
            new File("src/lw03/prelab/participants.txt")
        );

        while (scanner2.hasNextLine()) {

            String name = scanner2.nextLine();

            if (participants.contains(name)) {

                duplicateCount++;

            } else {

                participants.add(name);
            }
        }

        scanner2.close();

        System.out.println("Unique participants: " + participants.size());

        int participantNumber = 1;

        for (String name : participants) {

            System.out.println(participantNumber + ". " + name);

            participantNumber++;
        }

        System.out.println("Duplicate registrations: " + duplicateCount);

        System.out.println();
        System.out.println("===== Problem 3 =====");

        Map<String, Integer> inventory = new LinkedHashMap<>();

        int failedSales = 0;

        Scanner scanner3 = new Scanner(
            new File("src/lw03/prelab/inventory.txt")
        );

        while (scanner3.hasNextLine()) {

            String line = scanner3.nextLine();

            String[] parts = line.split(" ");

            String type = parts[0];

            String product = parts[1];

            int quantity = Integer.parseInt(parts[2]);

            if (type.equals("ADD")) {

                if (inventory.containsKey(product)) {

                    int currentStock = inventory.get(product);

                    inventory.put(
                        product,
                        currentStock + quantity
                    );

                } else {

                    inventory.put(product, quantity);
                }

            } else if (type.equals("SELL")) {

                if (inventory.containsKey(product)) {

                    int currentStock = inventory.get(product);

                    if (currentStock >= quantity) {

                        inventory.put(
                            product,
                            currentStock - quantity
                        );

                    } else {

                        failedSales++;
                    }

                } else {

                    failedSales++;
                }
            }
        }

        scanner3.close();

        for (String product : inventory.keySet()) {

            int stock = inventory.get(product);

            System.out.println(product + ": " + stock);
        }

        System.out.println("Failed sales: " + failedSales);
    }
}