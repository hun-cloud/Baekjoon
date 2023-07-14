import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
            int answer = 0;
            Arrays.sort(people);

            for (int i = people.length-1, start = 0; i >= 0; i--) {
                
                if(i == start) {
                    answer++;
                    break;
                }
                                
                if (people[i] + people[start] > limit) {
                    answer++;
                } else {
                    answer++;
                    if (i - start == 1) break;
                    start++;
                }

            }
            return answer;
    }
}