package pl.edu.pg.eti.ksg.po.lab3.Entities2D;

import pl.edu.pg.eti.ksg.po.lab3.Entities3D.Point3D;

public class Point2D
{
    private final double x, y;

    public Point2D(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    public Point2D(Point2D p)
    {
        x = p.getX();
        y = p.getY();
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Point2D other)
            return y == other.y && x == other.x;
        return false;
    }

    @Override
    public int hashCode()
    {
        return 13 * Double.hashCode(x) + 17 * Double.hashCode(y) + 3;
    }

    @Override
    public String toString()
    {
       return "(" + x + "," + y + ")";
    }

    public static final Point2D O = new Point2D(0, 0);
    public static final Point2D E_X = new Point2D(1, 0);
    public static final Point2D E_Y = new Point2D(0, 1);

}
