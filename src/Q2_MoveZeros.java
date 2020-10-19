import java.util.ArrayList;

/**
 * 나머지 숫자는 순서 그대로
 * 모든 0은 가장 뒤로
 */
public class Q2_MoveZeros {

    public static void main(String[] args) {
        InputArray inputArray = new InputArray(new int[]{0, 3, 2, 0, 8, 5, 0, 0, 2, 2, 3, 1, 24, 300});
        Long startTime = System.currentTimeMillis();
        solve1(inputArray);
        Long endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println("solve1 spent : " + (endTime - startTime) / 1000.0);

        startTime = System.currentTimeMillis();
        solve2(inputArray);
        endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println("solve2 spent : " + (endTime - startTime) / 1000.0);
    }

    /**
     * solution by me
     *
     * @param inputArray
     */
    public static void solve1(InputArray inputArray) {
        ArrayList<Integer> tmpList = new ArrayList<>();
        /* 0이 아닌 수의 갯수 */
        int cnt = 0;


        for (int i = 0; i < inputArray.arr.length; i++) {
            if (inputArray.arr[i] != 0) {
                tmpList.add(inputArray.arr[i]);
                cnt++;
            }
        }

        for (int i = 0; i < inputArray.arr.length - cnt; i++) {
            tmpList.add(0);
        }

        for (int i = 0; i < tmpList.size(); i++) {
            System.out.print(tmpList.get(i));
        }
    }

    /**
     * solution by inflearn
     *
     * @param inputArray
     */
    public static void solve2(InputArray inputArray) {
        int index = 0;

        for (int i = 0; i < inputArray.arr.length; i++) {
            if (inputArray.arr[i] != 0) {
                inputArray.arr[index] = inputArray.arr[i];
                index++;
            }
        }

        while (index < inputArray.arr.length) {
            inputArray.arr[index] = 0;
            index++;
        }

        for (int i = 0; i < inputArray.arr.length; i++) {
            System.out.print(inputArray.arr[i]);
        }
    }
}

class InputArray {

    public int[] arr;

    InputArray(int[] arr) {
        this.arr = arr;
    }
}