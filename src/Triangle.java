public class Triangle {
    Point a;
    Point b;
    Point c;

    double sideab;
    double sideac;
    double sidecb;

    double perimeter;
    boolean isIsoceles;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;

        this.sideab = calculateDistanceBetweenPoints(a.x,a.y,b.x,b.y);
        this.sideac = calculateDistanceBetweenPoints(a.x,a.y,c.x,c.y);
        this.sidecb = calculateDistanceBetweenPoints(c.x,c.y,b.x,b.y);

        this.perimeter = perimeter(sideab,sideac,sidecb);
        this.isIsoceles = isIsoceles(sideab,sideac,sidecb);
    }

    public double calculateDistanceBetweenPoints(
            double x1,
            double y1,
            double x2,
            double y2) {
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }

    public double perimeter(double a, double b, double c){
        return a+b+c;
    }

    public boolean isIsoceles(double sideab, double sideac, double sidecb){
        if (sideab == sideac || sideac == sidecb || sidecb == sideab ) {
            System.out.println("Isoceles Triangle Found...");
            return true;
        } else {
            return false;
        }
    }

    // Extra Section to check if a point is in the triangle or not

    // calc Area from points method
    static double area(Point a, Point b, Point c) {
        return Math.abs((a.x*(b.y-c.y) + b.x*(c.y-a.y)+ c.x*(a.y-b.y))/2.0);
    }
    // Check if point lies inside the triangle or not.
    boolean isInside(Point o)
    {
        /* Calculate area of triangle ABC */
        double A = area (this.a,this.b,this.c);

        /* Calculate area of triangle PBC */
        double A1 = area (o, this.b, this.c);

        /* Calculate area of triangle PAC */
        double A2 = area (this.a, o, this.c);

        /* Calculate area of triangle PAB */
        double A3 = area (this.a, this.b, o);

        /* Check if sum of A1, A2 and A3 is same as A */
        return (A == A1 + A2 + A3);
    }

    @Override
    public String toString() {
        return "Triangle { " +
                "point 1=" + a +
                ", point 2=" + b +
                ", point 3=" + c +
                "\n"+
                "Perimeter: "+perimeter+
                "\n"+
                "IsIscoceles: "+isIsoceles+
                " }";
    }
}
