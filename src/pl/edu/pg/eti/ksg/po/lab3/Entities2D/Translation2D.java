package pl.edu.pg.eti.ksg.po.lab3.Entities2D;

public class Translation2D implements Transformation2D
{
    private final double dX, dY;

    public Translation2D(double dX, double dY)
    {
        this.dX = dX;
        this.dY = dY;
    }

    @Override
    public Transformation2D getInverseTransformation()
    {
        return new Translation2D(-dX, -dY);
    }

    @Override
    public Point2D transform(Point2D p)
    {
        return new Point2D(p.getX() + dX, p.getY() + dY);
    }

    public double getdX()
    {
        return dX;
    }

    public double getdY()
    {
        return dY;
    }

    @Override
    public String toString()
    {
        return "Translacja o wektor (" + dX + "," + dY + ")";
    }
}
