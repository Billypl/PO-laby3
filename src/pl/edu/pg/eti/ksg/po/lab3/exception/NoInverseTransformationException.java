package pl.edu.pg.eti.ksg.po.lab3.exception;

public class NoInverseTransformationException extends Exception
{
    public NoInverseTransformationException()
    {
        // Niejawne wywołanie konstruktora klasy nadrzędnej
        // super();
    }

    // Konstruktor przyjmujący jako parametr tekst opisujący błąd
    public NoInverseTransformationException(String message)
    {
        super(message);
    }

    /*
     * Konstruktor przyjmujący jako parametr referencje do innego
     * wyjątku, który spowodował błąd
     */
    public NoInverseTransformationException(Throwable cause)
    {
        super(cause);
    }

    /*
     * Konstruktor przyjmujący jako parametr tekst opisujący błąd
     * oraz wyjątek, który spowodował błąd.
     */
    public NoInverseTransformationException(String message, Throwable cause)
    {
        super(message, cause);
    }
}

