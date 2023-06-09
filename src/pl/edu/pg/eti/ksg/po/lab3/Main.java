package pl.edu.pg.eti.ksg.po.lab3;

import pl.edu.pg.eti.ksg.po.lab3.Entities2D.*;
import pl.edu.pg.eti.ksg.po.lab3.Entities3D.*;
import pl.edu.pg.eti.ksg.po.lab3.exception.NoInverseTransformationException;

import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        //        test2D();
                test3D();
    }

    static void test3D()
    {
        var p1 = new Point3D(1, 1, 1);
        var p2 = new Point3D(1, 1, 1);
        var r = new Rotation3D(90, 90, 90);
        var rA = new RotationAX("x", 180);
        var tr = new Translation3D(4, 2, 0);

        var tab1 = new Transformation3D[]{r, rA, tr};
        var TrComp1 = new TransformationComposerArr3D(tab1);
        p1 = TrComp1.transform(p1);
        System.out.println("P1: " + p1);


        var tab2 = new ArrayList<Transformation3D>(Arrays.asList(r, rA, tr));
        var TrComp2 = new TransformationComposerList3D(tab2);
        p2 = TrComp2.transform(p2);
        System.out.println("P2: " + p2);

    }


    static void test2D()
    {
        var point = new Point2D(1, 1);
        var r = new Rotation2D(90);
        var s = new Scaling2D(2, 0.2);
        var t = new Translation2D(3, 5);
        var trC = new TransformationComposer2D(new Transformation2D[]{r, s, t});
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
