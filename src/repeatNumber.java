public class repeatNumber {
    public int repeatedNumber(int[] A) {
        int n = A.length;

        int cand1 = 0, cand2 = 0, cnt1 = 0, cnt2 = 0;

        for(int num : A) {
            if (cand1 == num) {
                cnt1++;
            } else if (cand2 == num) {
                cnt2++;
            } else if (cnt1 == 0) {
                cand1 = num;
                cnt1 = 1;
            } else if (cnt2 == 0) {
                cand2 = num;
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;

        for (int num : A) {
            if (num == cand1) cnt1++;
            else if (num == cand2) cnt2++;
        }

        if (cnt1 > n / 3) return cand1;
        if (cnt2 > n / 3) return cand2;

        return -1;
    }
}
