package a;

public class Test {
	public static void LCS(String x, String y) {
		int m = x.length();
		int n = y.length();
		int[][] c = new int[m + 1][n + 1];
		int[][] b = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			c[i][0] = 0;
		}
		for (int i = 0; i <= n; i++) {
			c[0][i] = 0;
		}
		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++) {
				if (x.charAt(i-1) == y.charAt(j-1)) {
					c[i][j] = c[i - 1][j - 1]+1;
					b[i][j] = 1;
				} else {
					if (c[i][j - 1] >= c[i - 1][j]) {
						c[i][j] = c[i][j - 1];
						b[i][j] = 2;
					} else {
						c[i][j] = c[i - 1][j];
						b[i][j] = 3;
					}
				}
			}
		char[] str = new char[c[m][n]];
		int pointer = str.length - 1;
		int pos1=m;
		int pos2=n;
		while(pos1>0 && pos2>0){
			switch(b[pos1][pos2]){
				case 1:
					str[pointer]=x.charAt(pos1-1);
					pointer--;
					pos1--;
					pos2--;
					break;
				case 2:
					pos2--;
					break;
				case 3:
					pos1--;
					break;
			}
		}
		for(int i=0;i<str.length;i++){
			System.out.print(str[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Test.LCS("ACCGGTCGAGTGCGCGGAAGCCGGCCGAA","GTCGTTCGGAATGCCGTTGCTCTGTAAA");
	}
}
