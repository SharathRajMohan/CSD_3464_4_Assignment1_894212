import java.util.Scanner;


public class Main {

    public static double getVerifiedDouble(){
        Scanner myScan = new Scanner(System.in);
        double value;
        do {
            try {
                value= myScan.nextDouble();
                break;
            }
            catch (Exception ex){
                System.out.println("You seem to have entered an invalid option!");
                myScan.nextLine();
            }
        } while (true);
        return value;
    }
    public static void main(String[] args) {
        // Variables & Objects
        Scanner myScan = new Scanner(System.in);
        int noOfTriangles;
        System.out.println("Assignment1: Geometry");
        do {
            System.out.println("Enter number of triangles:");
            try {
                noOfTriangles = myScan.nextInt();
                break;
            }
            catch (Exception ex){
                System.out.println("You seem to have entered an invalid option!");
                myScan.nextLine();
            }
        } while (true);

        Triangle[] triangles = new Triangle[noOfTriangles];

        for(int i=0;i<noOfTriangles;i++){

            System.out.println(" Enter the points of triangle "+i+1);

            System.out.print("Enter x-coordinate for vertex 1: ");
            double x1 = getVerifiedDouble();

            System.out.print("Enter y-coordinate for vertex 1: ");
            double y1 = getVerifiedDouble();

            System.out.print("Enter x-coordinate for vertex 2: ");
            double x2 = getVerifiedDouble();

            System.out.print("Enter y-coordinate for vertex 2: ");
            double y2 = getVerifiedDouble();

            System.out.print("Enter x-coordinate for vertex 3: ");
            double x3 = getVerifiedDouble();

            System.out.print("Enter y-coordinate for vertex 3: ");
            double y3 = getVerifiedDouble();

            triangles[i] = new Triangle(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3));

        }

        System.out.println("\nTriangles created:");
        for (Triangle triangle : triangles) {
            System.out.println(triangle);
        }

        System.out.println("\nCheck if a point lies inside any of the triangle or not:");
        System.out.print("Enter x-coordinate for a point: ");
        double x1 = getVerifiedDouble();

        System.out.print("Enter y-coordinate for a point: ");
        double y1 = getVerifiedDouble();
        Point exPoint = new Point(x1,y1);
        for (Triangle triangle : triangles) {
            if(triangle.isInside(exPoint)) {
                System.out.println("The Point "+exPoint+" lies inside the triangle {"+triangle.a+
                        triangle.b+triangle.c+" }\n");
            }else {
                System.out.println("The point lies outside the triangle{"+triangle.a+
                        triangle.b+triangle.c+"\n");
            }
        }

    }
}