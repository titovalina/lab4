public final class LineUtils {

    private LineUtils() {}

    public static <T extends Point2D> void shiftLineX(Line<T> line) {
        T start = line.getStartPoint();
        T end = line.getEndPoint();

        double offsetStart = start.getX() >= 0 ? 10 : -10;
        double offsetEnd = end.getX() >= 0 ? 10 : -10;

        if (start instanceof Point3D && end instanceof Point3D) {
            Point3D s = (Point3D) start;
            Point3D e = (Point3D) end;
            line.setStartPoint((T) new Point3D(s.getX() + offsetStart, s.getY(), s.getZ()));
            line.setEndPoint((T) new Point3D(e.getX() + offsetEnd, e.getY(), e.getZ()));
        } else {
            line.setStartPoint((T) new Point2D(start.getX() + offsetStart, start.getY()));
            line.setEndPoint((T) new Point2D(end.getX() + offsetEnd, end.getY()));
        }
    }
}