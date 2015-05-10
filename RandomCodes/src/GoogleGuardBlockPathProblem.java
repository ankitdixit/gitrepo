/*The text of question below is exactly given by Google interviewer. So they are owner of the text  and I am just quoting them. I am not the author of the text below:

"
Imagine a museum floor that looks like this:

.#.G.
..#..
G....
..#..

G == Museum Guard --> input 0
# == obstruction/impassable obstacle --> input 1
. == empty space --> input 2

Write a piece of code that will find the nearest guard for each open floor space. Diagonal moves are not allowed.  The output should convey this information:

2#1G1
12#12
G1223
12#34

You may choose how you want to receive the input and output. For example, you may use a 2-d array, as depicted here, or you may use a list of points with features, if you deem that easier to work with, as long as the same information is conveyed.

"
 */
public class GoogleGuardBlockPathProblem {
	public static void main(String args[]) throws InterruptedException {
		// input grid
		int[][] grid = new int[][] { { 2, 1, 2, 0, 2 }, { 2, 2, 1, 2, 2 },
				{ 0, 2, 2, 2, 2 }, { 2, 2, 1, 2, 2 } };

		// array to store final thing
		int[][] minDist = new int[4][5];
		for (int i = 0; i < minDist.length; i++) {
			for (int j = 0; j < minDist[i].length; j++) {
				if (grid[i][j] == 0) {
					minDist[i][j] = 0;
				} else {
					minDist[i][j] = 20000;
				}
			}
		}

		printArray(minDist);
		for (int iterationCount = 0; iterationCount < 20; iterationCount++) {
			for (int i = 0; i < minDist.length; i++) {
				for (int j = 0; j < minDist[i].length; j++) {
					if (grid[i][j] == 2) {
						// SCAN ALL NEIGHBOURS
						if ((j > 0) && grid[i][j - 1] != 1
								&& minDist[i][j] > minDist[i][j - 1] + 1) {
							minDist[i][j] = minDist[i][j - 1] + 1;
						}
						if ((j < minDist[i].length - 1) && grid[i][j + 1] != 1
								&& minDist[i][j] > minDist[i][j + 1] + 1) {
							minDist[i][j] = minDist[i][j + 1] + 1;
						}
						if ((i > 0) && grid[i - 1][j] != 1
								&& minDist[i][j] > minDist[i - 1][j] + 1) {
							minDist[i][j] = minDist[i - 1][j] + 1;
						}
						if ((i < minDist.length - 1) && grid[i + 1][j] != 1
								&& minDist[i][j] > minDist[i + 1][j] + 1) {
							minDist[i][j] = minDist[i + 1][j] + 1;
						}
					}
				}
			}
			printArray(minDist);
		}
		printArray(minDist);
	}

	public static void printArray(int[][] arr) {
		System.out.println("-----------------------------");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("-----------------------------");
	}
}
