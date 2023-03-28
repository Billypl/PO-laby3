package pl.edu.pg.eti.ksg.po.lab3.Entities2D;

import pl.edu.pg.eti.ksg.po.lab3.exception.NoInverseTransformationException;

public interface Transformation2D
{
    Point2D transform(Point2D p);
    Transformation2D getInverseTransformation() throws NoInverseTransformationException;
}

