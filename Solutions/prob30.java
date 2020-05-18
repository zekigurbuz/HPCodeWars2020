import java.util.*;
import java.io.*;

public class prob30 {
	public static void main(String[] args) throws Exception {
		new prob30().run();
	}
	char[][] mat;
	boolean[][] cur;
	int[][] treenum;
	HashSet<String> states;
	int n;
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		n = file.nextInt();
		mat = new char[n][];
		cur = new boolean[n][n];
		states = new HashSet<>();
		for(int i = 0; i < n; i++) mat[i] = file.next().toCharArray();
		treenum = new int[n][n];
		brute(0);
		for(boolean[] b : cur) {
			for(boolean bb : b) System.out.print(bb ? '#' : '.');
			System.out.println();
		}
	}
	public boolean brute(int i) {
		if(i != 0 && !states.add(i + Arrays.toString(treenum[i-1]))) return false;
		int[] ctreenum = treenum[i];
		for(int map = 0; map < 1 << n; map++) {
			boolean ok = true;
			for(int j = 0; ok && j < n; j++) {
				cur[i][j] = (map & 1 << j) != 0;
				if(mat[i][j] != '?') ok &= cur[i][j] == (mat[i][j] == '#');
			}
			if(!ok) continue;
			int curt = 1, curf = -1;
			for(int j = 0; j < n; j++)
				if(cur[i][j]) {
					if(j == 0 || cur[i][j-1] != cur[i][j]) ctreenum[j] = curt++;
					else ctreenum[j] = ctreenum[j-1];
				} else {
					if(j == 0 || cur[i][j-1] != cur[i][j]) ctreenum[j] = curf--;
					else ctreenum[j] = ctreenum[j-1];
				}
			if(i != 0) {
				int[] ptreenum = treenum[i-1];
				if(i == n-1) {
					int maxp = 0, maxn = 0;
					for(int j : ptreenum)
						if(j < 0) maxn = Math.max(maxn,-j);
						else maxp = Math.max(maxp,j);
					int[] ppar = new int[maxp+1], npar = new int[maxn+1];
					for(int j = 1; j < ppar.length; j++)
						ppar[j] = j;
					for(int j = 1; j < npar.length; j++)
						npar[j] = j;
					boolean curseg = !cur[i][0];
					boolean noloop = true;
					boolean norandom = true;
					int curpar = 1;
					for(int j = 0; noloop && norandom && j < n; j++) {
						if(cur[i][j] != curseg) {
							norandom &= curpar != -1;
							curseg = cur[i][j];
							curpar = -1;
						}
						if(curpar == -1 && cur[i-1][j] == curseg) {
							if(curseg) curpar = ppar[ptreenum[j]];
							else curpar = npar[-ptreenum[j]];
						} else if(cur[i-1][j] == curseg) {
							int ov = -1;
							if(curseg) ov = ppar[ptreenum[j]];
							else ov = npar[-ptreenum[j]];
							noloop &= ov != curpar;
							if(curseg) {
								for(int k = 1; k <= maxp; k++)
									if(ppar[k] == ov) ppar[k] = curpar;
							} else {
								for(int k = 1; k <= maxn; k++)
									if(npar[k] == ov) npar[k] = curpar;
							}
						}
					}
					norandom &= curpar != -1;
					boolean allsame = true;
					for(int j = 2; j < ppar.length; j++)
						allsame &= ppar[j] == ppar[1];
					for(int j = 2; j < npar.length; j++)
						allsame &= npar[j] == npar[1];
					if(noloop && allsame && norandom) return true;
				} else {
					HashMap<Integer,Integer> m = new HashMap<>();
					HashSet<Integer> hs = new HashSet<>();
					for(int j = 0; j < n; j++) {
						hs.add(ptreenum[j]);
						if(ctreenum[j] < 0 == ptreenum[j] < 0) {
							if(m.containsKey(ptreenum[j])) {
								int nv = m.get(ptreenum[j]);
								int ov = ctreenum[j];
								if(nv == ov) ok = false;
								for(int k = 0; k < n; k++)
									if(ctreenum[k] == ov)
										ctreenum[k] = nv;
							} else m.put(ptreenum[j], ctreenum[j]);
						}
					}
					if(hs.size() == m.size() && ok)
						if(brute(i+1)) return true;
				}
			} else if(brute(i+1)) return true;
		}
		return false;
	}
	boolean[][] vis;
	public boolean check() {
		vis = new boolean[mat.length][mat.length];
		int cnt = 0;
		boolean ok = true;
		for(int i = 0; i < mat.length; i++)
			for(int j = 0; j < mat.length; j++)
				if(!vis[i][j]) {
					cnt++;
					ok &= dfs(i,j,-1,cur[i][j]);
				}
		return cnt == 2 && ok;
	}
	int[] dr = {-1,1,0,0};
	int[] dc = {0,0,1,-1};
	public boolean dfs(int r, int c, int d, boolean val) {
		if(r < 0 || c < 0 || r >= mat.length || c >= mat[0].length) return true;
		if(cur[r][c] != val) return true;
		if(vis[r][c]) return false;
		vis[r][c] = true;
		boolean res = true;
		for(int dd = 0; dd < 4; dd++)
			if(dd != d) res &= dfs(r+dr[dd], c+dc[dd], dd^1, val);
		return res;
	}
}
