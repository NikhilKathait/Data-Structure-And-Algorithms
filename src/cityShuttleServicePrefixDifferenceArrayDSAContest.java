public class cityShuttleServicePrefixDifferenceArrayDSAContest {
    public static int canAccommodate(int[][] A, int B) {

        int[] diff = new int[1001];

        // Apply difference array logic
        for (int[] request : A) {

            int passengers = request[0];
            int pickup = request[1];
            int drop = request[2];

            diff[pickup] += passengers;
            diff[drop] -= passengers;
        }

        // prefix sum to check capacity
        int currentPassengers = 0;

        for (int i = 0; i <= 1000; i++) {

            currentPassengers += diff[i];

            if (currentPassengers > B) {
                return 0;
            }
        }

        return 1;
    }

}
