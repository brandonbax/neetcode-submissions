class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;

        for (int pile: piles) {
            maxPile = Math.max(maxPile, pile);
        }

        int left = 1;
        int right = maxPile;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canConsume(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;

    }

    private boolean canConsume(int[] piles, int h, int k) {
        int time = 0;

        for (int i = 0; i < piles.length; i++) {
            time += Math.ceil((double) piles[i] / (double) k);

            if (time > h) {
                return false;
            }
        }

        return true;
    }
}
