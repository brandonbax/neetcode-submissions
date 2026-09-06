class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;
        
        Car[] cars = new Car[n];
        for (int i = 0; i < n; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }

        // Sort cars by starting position in ascending order
        Arrays.sort(cars, (a, b) -> Integer.compare(a.pos, b.pos));

        int fleetCount = 0;
        double maxTime = 0.0; // Tracks the time of the slowest fleet ahead

        // Iterate backward: from the car closest to the target to the furthest
        for (int i = n - 1; i >= 0; i--) {
            // Calculate exact time to reach the target (continuous double, no Math.ceil)
            double time = (double) (target - cars[i].pos) / cars[i].spd;

            // If it takes longer for this car to reach the target than the fleet ahead,
            // it can never catch up. It forms a new fleet.
            if (time > maxTime) {
                maxTime = time; 
                fleetCount++;
            }
            // Else, time <= maxTime: it catches up and joins the fleet ahead, 
            // so fleetCount doesn't change and maxTime remains the same.
        }

        return fleetCount;
    }
}

class Car {
    int pos;
    int spd;

    public Car(int pos, int spd) {
        this.pos = pos;
        this.spd = spd;
    }
}