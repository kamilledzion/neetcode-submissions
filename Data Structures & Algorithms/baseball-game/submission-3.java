class Solution {
    public int calPoints(String[] operations) {
        int size = operations.length;
        int[] ans = new int[size];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (operations[i].equals("+")) {
                ans[index] = ans[index - 1] + ans[index - 2];
                index++;
            } else if (operations[i].equals("C")) {
                ans[index] = 0;
                --index;
            } else if (operations[i].equals("D")) {
                ans[index] = ans[index - 1] * 2;
                index++;
            } else {
                ans[index] = Integer.valueOf(operations[i]);
                index++;
            }
        }
        int res = 0;
        for (int i = 0; i < index; i++) {
            res += ans[i];
        }
        return res;
    }
}