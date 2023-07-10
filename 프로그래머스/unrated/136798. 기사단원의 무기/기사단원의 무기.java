class Solution {
        public int solution(int number, int limit, int power) {
            int answer = 0;
            for (int i = 1; i <= number; i++) {
                answer += getPower(i, limit, power);
            }
            return answer;
        }

        public int getPower(int i, int limit, int power) {
            int result = 0;
            double number = Math.sqrt(i);

            for (int j = 1; j < number; j++) {
                if (i % j == 0) {
                    result += 2;
                }
                if (result > limit) {
                    return power;
                }
            }
            
            if (i % number == 0) result++;
            
            return result > limit ? power : result;
        }
}