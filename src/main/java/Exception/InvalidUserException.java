package Exception;

public class InvalidUserException extends BaseException{

   public InvalidUserException(String message) {
      super(message);
      //TODO Auto-generated constructor stub
   }

   public InvalidUserException(String message, Throwable cause) {
      super(message, cause);
   }
   
}
