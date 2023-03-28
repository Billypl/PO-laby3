package pl.edu.pg.eti.ksg.po.lab3.Entities2D;

import pl.edu.pg.eti.ksg.po.lab3.exception.NoInverseTransformationException;

public class Scaling2D implements Transformation2D
{
    private final double scaleX, scaleY;
    public Scaling2D(double scaleX, double scaleY) {
        this.scaleX = scaleX;
        this.scaleY = scaleY;
    }
    @Override
    public Transformation2D getInverseTransformation() throws
            NoInverseTransformationException {
        if(scaleX == 0 || scaleY == 0)
            throw new NoInverseTransformationException("Brak transformacji odwrotnej. " +
                    "Przynajmniej jeden z czynników skalowania jest równy 0.");

        return new Scaling2D(1/ scaleX,1/ scaleY);
    }
    @Override
    public Point2D transform(Point2D p) {
        return new Point2D(scaleX * p.getX(), scaleY * p.getY());
    }
    public double getScaleX() {
        return scaleX;
    }
    public double getScaleY() {
        return scaleY;
    }
    @Override
    public String toString() {
        return "Skalowanie "+ scaleX +"x oraz "+ scaleY +"y";
    }

}
