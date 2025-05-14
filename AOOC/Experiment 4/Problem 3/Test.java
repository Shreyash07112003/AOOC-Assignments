public class Test extends Student {
    protected int sub1;
    protected int sub2;

    public void setMarks(int sub1, int sub2) {
        this.sub1 = sub1;
        this.sub2 = sub2;
    }

    public int getSub1() {
        return sub1;
    }

    public int getSub2() {
        return sub2;
    }
}
