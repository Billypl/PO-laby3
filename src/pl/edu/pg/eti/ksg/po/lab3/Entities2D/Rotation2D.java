package pl.edu.pg.eti.ksg.po.lab3.Entities2D;

import pl.edu.pg.eti.ksg.po.lab3.exception.NoInverseTransformationException;

import static java.lang.Math.*;

public class Rotation2D implements Transformation2D
{
    private final double angle;

    public Rotation2D(double angle)
    {
        this.angle = Math.toRadians(angle);
    }

    public double getAngle()
    {
        return angle;
    }

    @Override
    public String toString()
    {
        return "Rotacja " + angle + " stopni";
    }

    @Override
    public Point2D transform(Point2D p)
    {
        double x = p.getX() * cos(angle) + p.getY() * sin(angle);
        double y = -p.getX() * sin(angle) + p.getY() * cos(angle);
        return new Point2D(round(x), round(y));
    }

    @Override
    public Transformation2D getInverseTransformation() throws NoInverseTransformationException
    {
        return null;
    }
}
