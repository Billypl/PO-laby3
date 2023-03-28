package pl.edu.pg.eti.ksg.po.lab3;

import pl.edu.pg.eti.ksg.po.lab3.Entities2D.*;
import pl.edu.pg.eti.ksg.po.lab3.exception.NoInverseTransformationException;


public class Main
{
    public static void main(String[] args)
    {
        test2D();
    }

    static void test2D()
    {
        var point = new Point2D(1,1);
        var r = new Rotation2D(90);
        var s = new Scaling2D(2,0.2);
        var t = new Translation2D(3,5);
        var trC = new TransformationComposer2D(new Transformation2D[]{r,s,t});
        point = trC.transform(point);
        System.out.println(point);
    }

    static void testInstruction()
    {
        try
        {
            Point2D p1 = Point2D.E_X;
            System.out.println(p1);
            Transformation2D tr = new Translation2D(5, 6);
            System.out.println(tr);
            Point2D p2 = tr.transform(p1);
            System.out.println(p2);
            Transformation2D trr = tr.getInverseTransformation();
            System.out.println(trr);
            Point2D p3 = trr.transform(p2);
            System.out.println(p3);

        }
        catch (NoInverseTransformationException ex)
        {
            ex.printStackTrace();
        }
        System.out.println();

        try
        {
            Point2D p1 = new Point2D(2, 2);
            System.out.println(p1);
            Transformation2D tr2 = new Scaling2D(5, 4);
            System.out.println(tr2);
            Point2D p2 = tr2.transform(p1);
            System.out.println(p2);
            Transformation2D trr2 = tr2.getInverseTransformation();
            System.out.println(trr2);
            Point2D p3 = trr2.transform(p2);
            System.out.println(p3);
        }
        catch (NoInverseTransformationException ex)
        {
            ex.printStackTrace();
        }
        System.out.println();

        try
        {
            Point2D p1 = new Point2D(2, 2);
            Transformation2D tr2 = new Scaling2D(5, 0);
            System.out.println(tr2);
            System.out.println(p1);
            Point2D p2 = tr2.transform(p1);
            System.out.println(p2);
            Transformation2D trr2 = tr2.getInverseTransformation();
            System.out.println(trr2);
            Point2D p3 = trr2.transform(p2);
            System.out.println(p3);
        }
        catch (NoInverseTransformationException ex)
        {
            ex.printStackTrace();
        }
        System.out.println();


    }

}
