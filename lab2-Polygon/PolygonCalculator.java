import java.util.*;

// step 1: define the interface
interface Polygon {
    double area();
    double perimeter();
}

// step 2: implement a base class for a specific shape
class Triangle implements Polygon {
    protected double a, b, c; // three sides

    public Triangle(double a, double b, double c) {
        this.a = a; this.b = b; this.c = c;
    }

    @Override
    public double area() {
        double s = perimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c)); 
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }
}

class Quadrilateral implements Polygon {
    protected double a, b, c, d;

    public Quadrilateral(double a, double b, double c, double d) {
        this.a = a; this.b = b; this.c = c; this.d = d;
    }

    @Override
    public double area() {
        double s = perimeter() / 2;
        return Math.sqrt((s - a) * (s - b) * (s - c) * (s - d));
    }

    @Override
    public double perimeter() {
        return a + b + c + d;
    }
}

class RegularPolygon implements Polygon {
    protected int n;     // number of sides
    protected double side;

    public RegularPolygon(int n, double side) {
        this.n = n; this.side = side;
    }

    @Override
    public double area() {
        return (n * side * side) / (4 * Math.tan(Math.PI / n));
    }

    @Override
    public double perimeter() {
        return n * side;
    }
}

// Concrete classes
class Pentagon extends RegularPolygon {
    public Pentagon(double side) { super(5, side); }
}

class Hexagon extends RegularPolygon {
    public Hexagon(double side) { super(6, side); }
}

class Octagon extends RegularPolygon {
    public Octagon(double side) { super(8, side); }
}

// subclasses
class IsoscelesTriangle extends Triangle {
    public IsoscelesTriangle(double equalSide, double base) {
        super(equalSide, equalSide, base);
    }
}

class EquilateralTriangle extends Triangle {
    public EquilateralTriangle(double side) {
        super(side, side, side);
    }
}

class Rectangle extends Quadrilateral {
    protected double length, width;

    public Rectangle(double length, double width) {
        super(length, width, length, width);
        this.length = length; this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }
}

class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }
}

// main class for user interface
public class PolygonCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Polygon polygon = null;

        while (true) {
            System.out.println("\nChoose a polygon:");
            System.out.println("1. Triangle");
            System.out.println("2. Isosceles Triangle");
            System.out.println("3. Equilateral Triangle");
            System.out.println("4. Quadrilateral");
            System.out.println("5. Rectangle");
            System.out.println("6. Square");
            System.out.println("7. Pentagon");
            System.out.println("8. Hexagon");
            System.out.println("9. Octagon");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.print("Enter three sides: ");
                    polygon = new Triangle(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter equal side and base: ");
                    polygon = new IsoscelesTriangle(sc.nextDouble(), sc.nextDouble());
                    break;
                case 3:
                    System.out.print("Enter side length: ");
                    polygon = new EquilateralTriangle(sc.nextDouble());
                    break;
                case 4:
                    System.out.print("Enter four sides: ");
                    polygon = new Quadrilateral(sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
                    break;
                case 5:
                    System.out.print("Enter length and width: ");
                    polygon = new Rectangle(sc.nextDouble(), sc.nextDouble());
                    break;
                case 6:
                    System.out.print("Enter side length: ");
                    polygon = new Square(sc.nextDouble());
                    break;
                case 7:
                    System.out.print("Enter side length: ");
                    polygon = new Pentagon(sc.nextDouble());
                    break;
                case 8:
                    System.out.print("Enter side length: ");
                    polygon = new Hexagon(sc.nextDouble());
                    break;
                case 9:
                    System.out.print("Enter side length: ");
                    polygon = new Octagon(sc.nextDouble());
                    break;
                default:
                    System.out.println("Invalid choice!");
                    continue;
            }

            System.out.println("Perimeter: " + polygon.perimeter());
            System.out.println("Area: " + polygon.area());
        }

        sc.close();
    }
}
