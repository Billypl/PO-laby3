package pl.edu.pg.eti.ksg.po.lab3.Entities3D;

import pl.edu.pg.eti.ksg.po.lab3.exception.NoInverseTransformationException;

import static java.lang.Math.*;

public class RotationAX implements Transformation3D
{
    private final double alpha;
    private final String axis;

    public RotationAX(String axis, double alpha)
    {
        this.alpha = alpha;
        this.axis = axis;
    }
    @Override
    public Point3D transform(Point3D p)
    {
        return transform(axis, alpha, p);
    }
    public static Point3D transform(String axis, double alpha, Point3D p)
    {
        alpha = Math.toRadians(alpha);
        double x = 0;
        double y = 0;
        double z = 0;

        if (axis.equals("z"))
        {
            x = p.getX() * cos(alpha) - p.getX() * sin(alpha);
            y = p.getX() * sin(alpha) + p.getX() * cos(alpha);
            z = p.getZ();
        }
        else if (axis.equals("x"))
        {
            x = p.getX();
            y = p.getY() * cos(alpha) - p.getY() * sin(alpha);
            z = p.getZ() * sin(alpha) + p.getZ() * cos(alpha);
        }
        else if (axis.equals("y"))
        {
            x = p.getX() * cos(alpha) + p.getX() * sin(alpha);
            y = p.getY();
            z = -p.getZ() * sin(alpha) + p.getZ() * cos(alpha);
        }

        return new Point3D(x, y, z);
    }

    @Override
    public Transformation3D getInverseTransformation() throws NoInverseTransformationException
    {
        return new RotationAX(axis, -alpha);
    }

    public double getAlpha()
    {
        return alpha;
    }

    public String getAxis()
    {
        return axis;
    }
}
