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
        var noSand = 0;
        while (stud.size() > 0 && noSand < sandwiches.length - ss) {
            var curr = stud.poll();
            if (curr == sandwiches[ss]) {
                ss++;
                noSand = 0;
            } else {
                stud.add(curr);
                noSand++;
            }
        }
        return stud.size();
    }
}