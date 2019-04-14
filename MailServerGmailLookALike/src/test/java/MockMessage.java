
public class MockMessage {
	  private String message;

	   //Constructor
	   //@param message to be printed
	   public MockMessage(String message){
	      this.message = message;
	   }
	      
	   // prints the message
	   public String printMessage(){
	      System.out.println(message);
	      return message;
	   }   
}
