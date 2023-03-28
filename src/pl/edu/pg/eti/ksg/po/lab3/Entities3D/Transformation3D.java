package pl.edu.pg.eti.ksg.po.lab3.Entities3D;

import pl.edu.pg.eti.ksg.po.lab3.Entities2D.Point2D;
import pl.edu.pg.eti.ksg.po.lab3.exception.NoInverseTransformationException;

public interface Transformation3D
{
    Point3D transform(Point3D p);
    Transformation3D getInverseTransformation() throws NoInverseTransformationException;
}



