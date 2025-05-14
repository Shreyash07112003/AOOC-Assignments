package LibraryManagement;

public class Member {
    private String name;
    private int memberId;

    // Constructor
    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    // Display member details
    public void display() {
        System.out.println("Member Name : " + name);
        System.out.println("Member ID   : " + memberId);
    }
}
