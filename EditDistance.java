
import java.util.Arrays;

public class EditDistance {

	public static int distance(String s1, String s2) {
		int dmatrix[][] = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i <= s1.length(); i++) {
			dmatrix[i][0] = i;
		}
		for (int i = 0; i <= s2.length(); i++) {
			dmatrix[0][i] = i;
		}
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				int values[] = new int[3];
				values[0] = dmatrix[i - 1][j] + 1;
				values[1] = dmatrix[i][j - 1] + 1;
				values[2] = dmatrix[i - 1][j - 1]
						+ (s1.charAt(i-1) == s2.charAt(j-1) ? 0 : 1);
				Arrays.sort(values);
				dmatrix[i][j] = values[0];
			}
		}
		return dmatrix[s1.length()][s2.length()];
	}

	public static void main(String[] args) {
		System.out.println(distance("cats", "fast"));
	}

}
