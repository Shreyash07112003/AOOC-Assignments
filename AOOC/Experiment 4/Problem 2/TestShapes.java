public class TestShapes {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(10, 5);
        Shape triangle = new Triangle(8, 6);

        System.out.println("Area of Rectangle: " + rectangle.area());
        System.out.println("Area of Triangle: " + triangle.area());
    }
}
