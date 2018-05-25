package date;

public class ExceptionQueueFull extends Exception{
  public ExceptionQueueFull(){}
  public ExceptionQueueFull(String mag) {
      System.out.println(mag);
  }
}
