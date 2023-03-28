package pl.edu.pg.eti.ksg.po.lab3.Entities3D;

import pl.edu.pg.eti.ksg.po.lab3.Entities2D.Point2D;

public class Point3D extends Point2D
{
    private final double z;

    public Point3D(double x, double y, double z)
    {
        super(x, y);
        this.z = z;
    }
    public Point3D(Point3D p)
    {
        super(p.getX(), p.getY());
        z = p.getZ();
    }

    public double getZ()
    {
        return z;
    }

    @Override
    public String toString()
    {
        return String.format("(%.1f,%.1f,%.1f)",this.getX(), this.getY(), this.getZ());
    }
}
