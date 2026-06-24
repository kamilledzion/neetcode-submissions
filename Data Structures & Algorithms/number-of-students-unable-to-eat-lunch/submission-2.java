class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> stud = new ArrayDeque<>();
        int ss = 0;
        for (int s = 0; s < students.length; s++) {
            if (students[s] == sandwiches[ss]) {
                ss++;
            } else {
                stud.add(students[s]);
            }
        }
        var left = stud.size() * stud.size();
        while (stud.size() > 0 && left > 0) {
            var curr = stud.poll();
            if (curr == sandwiches[ss]) {
                ss++;
            } else {
                stud.add(curr);
            }
            left--;
        }
        return stud.size();
    }
}