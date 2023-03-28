package pl.edu.pg.eti.ksg.po.lab3.Entities2D;

import pl.edu.pg.eti.ksg.po.lab3.exception.NoInverseTransformationException;

public class TransformationComposer2D implements Transformation2D
{
    Transformation2D[] trans;

    public TransformationComposer2D(Transformation2D[] trans)
    {
        this.trans = new Transformation2D[trans.length];
        for(int i = 0; i < trans.length; i++)
            this.trans[i] = trans[i];
    }

    @Override
    public Point2D transform(Point2D p)
    {
        var result = new Point2D(p.getX(), p.getY());
        for(var tr : trans)
            result = tr.transform(result);
        return result;
    }

    @Override
    public Transformation2D getInverseTransformation() throws NoInverseTransformationException
    {
        var reversed = new Transformation2D[this.trans.length];
        for(int i = 0; i < reversed.length; i++)
            reversed[i] = this.trans[this.trans.length - i - 1];
        return new TransformationComposer2D(reversed);
    }
}
