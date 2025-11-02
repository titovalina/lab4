public class Line<T extends Point2D> {
    private T startPoint;
    private T endPoint;

    public Line(T startPoint, T endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public T getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(T startPoint) {
        this.startPoint = startPoint;
    }

    public T getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(T endPoint) {
        this.endPoint = endPoint;
    }

    public int getLengthInt() {
        double dx = endPoint.getX() - startPoint.getX();
        double dy = endPoint.getY() - startPoint.getY();
        double dz = 0;
        if (startPoint instanceof Point3D && endPoint instanceof Point3D) {
            dz = ((Point3D) endPoint).getZ() - ((Point3D) startPoint).getZ();
        }
        return (int) Math.round(Math.sqrt(dx * dx + dy * dy + dz * dz));
    }

    @Override
    public String toString() {
        return "Линия " + "от " + startPoint + ", до " + endPoint;
    }
}