package ss06_inheritance.excercise.point2d_poin3d.model;

public class Point3D extends Poin2D {
    private float z;

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public Point3D() {
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }


    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        this.z = z;
    }

    public float[] getXYZ() {
        return new float[]{super.getX(), super.getY(), getZ()};
    }

    @Override
    public String toString() {
        return "Point3D{" +
                super.toString() + " " +
                "z = " + getZ() +
                '}';
    }
}
