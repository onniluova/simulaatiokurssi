package tehtavisto2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class tehtava1 {
    public static void main(String[] args) {
        // Oletetaan, että tässä on TVT22K-O-ryhmän iät
        int[] ages = {20, 21, 22, 23, 20, 21, 22, 23, 24, 25};
        int[] samples = new int[1000];
        Random random = new Random();

        // Laske kunkin iän esiintymistiheys
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int age : ages) {
            frequencyMap.put(age, frequencyMap.getOrDefault(age, 0) + 1);
        }

        // Muunna ikäjakauma kumulatiiviseksi jakaumaksi
        double[] cumulativeDistribution = new double[ages.length];
        double sum = 0;
        for (int i = 0; i < ages.length; i++) {
            sum += (double) frequencyMap.getOrDefault(ages[i], 0) / ages.length;
            cumulativeDistribution[i] = sum;
        }

        // Arvo 1000 ikää kumulatiivisen jakauman perusteella
        for (int i = 0; i < 1000; i++) {
            double randomValue = random.nextDouble();
            for (int j = 0; j < cumulativeDistribution.length; j++) {
                if (randomValue <= cumulativeDistribution[j]) {
                    samples[i] = ages[j];
                    break;
                }
            }
        }

        // Laske ja tulosta kunkin iän esiintymistiheys ja prosentuaalinen osuus
        Map<Integer, Integer> sampleFrequencyMap = new HashMap<>();
        for (int sampleAge : samples) {
            sampleFrequencyMap.put(sampleAge, sampleFrequencyMap.getOrDefault(sampleAge, 0) + 1);
        }

        System.out.println("Iät:");
        for (Map.Entry<Integer, Integer> entry : sampleFrequencyMap.entrySet()) {
            int age = entry.getKey();
            int count = entry.getValue();
            double percentage = 100.0 * count / samples.length;
            System.out.println("Ikä " + age + ": " + count + " kertaa, " + String.format("%.2f", percentage) + "%");
        }
    }
}