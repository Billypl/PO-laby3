package pl.edu.pg.eti.ksg.po.lab3.Entities3D;

import pl.edu.pg.eti.ksg.po.lab3.exception.NoInverseTransformationException;

public class Rotation3D implements Transformation3D
{
    private final double alpha, beta, gamma;

    public Rotation3D(double alpha, double beta, double gamma)
    {
        this.alpha = alpha;
        this.beta = beta;
        this.gamma = gamma;
    }

    public static Point3D transform(Point3D p, double alpha, double beta, double gamma)
    {
        var point = new Point3D(p.getX(), p.getY(), p.getZ());
        point = RotationAX.transform("x", alpha, point);
        point = RotationAX.transform("y", beta, point);
        point = RotationAX.transform("z", gamma, point);
        return point;
    }

    @Override
    public Point3D transform(Point3D p)
    {
        return transform(p, alpha, beta, gamma);
    }

    @Override
    public Transformation3D getInverseTransformation() throws NoInverseTransformationException
    {
        return new Rotation3D(-alpha, -beta, -gamma);
    }
}
