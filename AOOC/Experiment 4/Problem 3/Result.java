public class Result extends Test implements Sports {
    private int total;

    @Override
    public void set() {
        // Sports marks are already constant; no input needed.
        total = sub1 + sub2 + sMarks;
    }

    public void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Marks in Subject 1: " + sub1);
        System.out.println("Marks in Subject 2: " + sub2);
        System.out.println("Sports Marks: " + sMarks);
        System.out.println("Total Marks: " + total);
    }
}

