public class Q4_DailyTemperature {

    public static void main(String[] args) {
        Q4_DailyTemperature a = new Q4_DailyTemperature();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] answer = a.dailyTemperatures(temperatures);
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int tmp = 0;
            for (int j = i + 1; j < temperatures.length; j++) {
                tmp++;
                if (temperatures[i] < temperatures[j]) {
                    answer[i] = tmp;
                    break;
                }
            }
        }
        return answer;
    }
}
