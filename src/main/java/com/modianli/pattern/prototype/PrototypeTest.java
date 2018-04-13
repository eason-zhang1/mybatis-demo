package com.modianli.pattern.prototype;

public class PrototypeTest {

  public static void main(String[] args) throws CloneNotSupportedException {

	Test t = new Test();
	System.out.println(t);
	Test t2 = (Test) t.clone();
	System.out.println(t2);

	System.out.println(t.getTargetObj());
	System.out.println(t2.getTargetObj());
  }
}

class Test implements Cloneable {

  private String name = "test";

  private TargetObj targetObj = new TargetObj();

  public TargetObj getTargetObj() {
	return targetObj;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
	return super.clone();
  }
}

class TargetObj {
  private String name ="target";
}