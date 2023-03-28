package pl.edu.pg.eti.ksg.po.lab3.Entities3D;

import pl.edu.pg.eti.ksg.po.lab3.exception.NoInverseTransformationException;

public class Translation3D implements Transformation3D
{
    private final double dX, dY, dZ;

    public Translation3D(double dX, double dY, double dZ)
    {
        this.dX = dX;
        this.dY = dY;
        this.dZ = dZ;
    }

    @Override
    public Point3D transform(Point3D p)
    {
        return new Point3D(
                p.getX() + dX,
                p.getY() + dY,
                p.getZ() + dZ
        );
    }

    @Override
    public Transformation3D getInverseTransformation() throws NoInverseTransformationException
    {
        return new Translation3D(-dX, -dY, -dZ);
    }

    public double getdX()
    {
        return dX;
    }

    public double getdY()
    {
        return dY;
    }

    public double getdZ()
    {
        return dZ;
    }

}
