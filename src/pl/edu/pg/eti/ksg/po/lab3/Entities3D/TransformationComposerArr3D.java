package pl.edu.pg.eti.ksg.po.lab3.Entities3D;

import pl.edu.pg.eti.ksg.po.lab3.exception.NoInverseTransformationException;

public class TransformationComposerArr3D implements Transformation3D
{
    Transformation3D[] trans;

    public TransformationComposerArr3D(Transformation3D[] trans)
    {
        this.trans = new Transformation3D[trans.length];
        for (int i = 0; i < trans.length; i++)
            this.trans[i] = trans[i];
    }


    @Override
    public Point3D transform(Point3D p)
    {
        var result = new Point3D(p);
        for (var tr : trans)
            result = tr.transform(result);
        return result;
    }

    @Override
    public Transformation3D getInverseTransformation() throws NoInverseTransformationException
    {
        var reversed = new Transformation3D[trans.length];
        for (int i = 0; i < trans.length; i++)
            reversed[i] = trans[trans.length - i - 1].getInverseTransformation();
        return new TransformationComposerArr3D(reversed);
    }
}
