/**
 * this class has two methods sortInsertion and
 * sortSelection.
 */

class Solution {

	/**
	 * this method takes interger array as parameter
	 * and returns interger array after sorting.
	 * The time complexity of this method in best case is O(N)
	 * and in the worest case is O(N^2)
	 * @param arr its an integer array
	 * @return arr which is sorted
	 */
		public int[] sortInsertion(final int[] arr) {
			// fill you code Here
			int n = arr.length;
			for (int i = 1; i < n; i++) {
				for (int j = i; j > 0; j--) {
					if (arr[j] < arr[j - 1]) {
						int temp = arr[j];
						arr[j] = arr[j - 1];
						arr[j - 1] = temp;
					} else {
						break;
					}
				}
			}
			return arr;
		}
	/**
	 * this method takes interger array as parameter.
	 * and returns interger as output.
	 * The time complexity of this method in both best
	 * and worst cases is O(N^2)
	 * @param  arr it is an integer array
	 * @return arr which is sorted
	 */
		public int[] sortSelection(final int[] arr) {
			// fill you code Here
			int n = arr.length;
			for (int i = 0; i < n; i++) {
				int min = i;
				for (int j = i + 1; j < n; j++) {
					if (arr[j] < arr[min]) {
						min = j;
					}
				}
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
			return arr;
		}
	}
