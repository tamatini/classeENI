package fr.eni.classeni.bll;

public class BLLException extends Exception {
  public BLLException () {
    super();
  }

  public BLLException (String msg) {
    super(msg);
  }

  public BLLException (String msg, Throwable cause) {
    super(msg, cause);
  }
}
