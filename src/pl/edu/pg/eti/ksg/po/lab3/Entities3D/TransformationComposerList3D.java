package pl.edu.pg.eti.ksg.po.lab3.Entities3D;

import pl.edu.pg.eti.ksg.po.lab3.exception.NoInverseTransformationException;

import java.util.ArrayList;

public class TransformationComposerList3D implements Transformation3D
{
    ArrayList<Transformation3D> trans = new ArrayList<Transformation3D>();

    public TransformationComposerList3D(ArrayList<Transformation3D> trans)
    {
        this.trans.addAll(trans);
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
        var reversed = new ArrayList<Transformation3D>();
        for(int i = trans.size() - 1; i > 0; i--)
            reversed.add(trans.get(i).getInverseTransformation());
        return new TransformationComposerList3D(reversed);
    }
}
