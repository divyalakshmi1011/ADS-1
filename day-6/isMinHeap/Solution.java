class Solution {
	/**
	 * Returns true if arr[i..n-1] represents a.
	 * max-heap
	 * @param arr array containing double type elements
	 * @return true if the arr is minPQ else false
	 */
	public static boolean isMinHeap(final double[] arr) {
		int n = arr.length;
		if (n == 0) {
			return false;
		}
		for (int i = 1; i < n / 2; i++) {
			if (arr[i] > arr[2 * i]) {
				return false;
			} else if (arr[i] > arr[2 * i + 1]) {
				return false;
			}
		}
		return true;
	}
}
