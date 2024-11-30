import java.lang.Exception;
@SuppressWarnings("serial")
public class ZeroSizeException extends Exception
{
	public ZeroSizeException()
	{
		super("Can't take input for size zero.");
	}
}