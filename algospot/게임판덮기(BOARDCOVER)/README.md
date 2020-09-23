https://algospot.com/judge/problem/read/BOARDCOVER

문제
- 순서가 다르지만 같은 경우가 중복으로 선택될 수 있음

해결
- 항상 빈칸을 채울때 가장 앞의 건부터 처리 할 수 있도록 처리

	public static int explore(int emptyCnt) {
		if(emptyCnt == 0) return 1;
		
		int ans = 0;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(map[i][j] == 1) continue;
				for(int k = 0; k < 4; k++) {
					if(set(i, j, k, 1)) {
						ans += explore(emptyCnt-3);
					}
					set(i, j, k, -1);
				}
			}
		}
		return ans;
	}