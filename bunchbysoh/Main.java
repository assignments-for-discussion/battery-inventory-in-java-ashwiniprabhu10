package bunchbysoh;

public class Main {
//nested class giving numbers of healthy,exchange,failed batteries.
    static class CountsBySoH {
        public int healthy = 0;
        public int exchange = 0;
        public int failed = 0;
    }

    static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
        CountsBySoH counts = new CountsBySoH();//creating an object of CountsBySoH class

        for (int presentCapacity : presentCapacities) {
            // Calculate state of health (SoH)
            double soh = calculateSoH(presentCapacity);

            // Classifying the battery based on its SoH
            if (soh > 80 && soh <= 100) {
                // The number of healthy battery
                counts.healthy++;
            } else if (soh >= 62 && soh <= 80) {
                // The number of exchange battery
                counts.exchange++;
            } else {
                //The number of failed battery
                counts.failed++;
            }
        }

        return counts;
    }

    static double calculateSoH(int presentCapacity) {
        // Assuming all batteries have a rated capacity of 120Ah
        int ratedCapacity = 120;

        // Calculating the state of health (SoH) for the batteries
        return (presentCapacity * 100.0) / ratedCapacity;
    }

    static void testBucketingByHealth() {
        System.out.println("Counting batteries by SoH...\n");
        int[] presentCapacities = {113, 116, 80, 95, 92, 70};
        CountsBySoH counts = countBatteriesByHealth(presentCapacities);
        assert(counts.healthy == 2);
        assert(counts.exchange == 3);
        assert(counts.failed == 1);
        System.out.println("Done counting :)\n");
    }

    public static void main(String[] args) {
        testBucketingByHealth();
    }
}
