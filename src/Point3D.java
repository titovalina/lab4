public class Point3D extends Point2D {
    private final double z;

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "{" + getX() + "; " + getY() + "; " + z + "}";
    }
}