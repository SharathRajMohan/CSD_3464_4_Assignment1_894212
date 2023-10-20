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
