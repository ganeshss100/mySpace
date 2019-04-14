
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MailTester {
	 String message = "Hello World";	
	 MockMessage messageUtil = new MockMessage(message);

	   @Test
	   public void testPrintMessage() {	  
	      assertEquals(message,messageUtil.printMessage());
	   }
}
