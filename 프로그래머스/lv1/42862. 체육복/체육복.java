import java.util.Arrays;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
            Arrays.sort(lost);
            Arrays.sort(reserve);

            int answer = n;

            for (int i = 0; i < lost.length; i++) {
                for (int j = 0; j < reserve.length; j++) {
                    if (lost[i] == reserve[j]) {
                        lost[i] = -3;
                        reserve[j] = -1;
                        break;
                    }
                }
            }

            for (int i = 0; i < lost.length; i++) {
                for (int j = 0; j < reserve.length; j++) {
                    if (lost[i] != -3) {
                        if (lost[i] - 1 == reserve[j]) {
                            lost[i] = -3;
                            reserve[j] = -1;
                            break;
                        }
                        if (lost[i] + 1 == reserve[j]) {
                            lost[i] = -3;
                            reserve[j] = -1;
                            break;
                        }
                    }
                }
            }
            for (int lostStu : lost) {
                if (lostStu != -3) answer--;
            }
            System.out.println("answer = " + answer);
            return answer;
    }
}