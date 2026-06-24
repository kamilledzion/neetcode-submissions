class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int studZeroCount = 0;
        int studOneCount = 0;
         for (int s = 0; s < students.length; s++) {
            if (students[s] == 0) {
                studZeroCount++;
            } else {
                studOneCount++;
            }
         }
         for (int s = 0; s < sandwiches.length; s++) {
            if (sandwiches[s] == 0 && studZeroCount > 0) {
                studZeroCount--;
            } else if (sandwiches[s] == 1 && studOneCount > 0) {
                studOneCount--;
            } else {
                break;
            }
        }
        return studZeroCount + studOneCount;
    }
}