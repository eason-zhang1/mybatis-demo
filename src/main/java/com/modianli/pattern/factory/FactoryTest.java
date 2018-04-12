package com.modianli.pattern.factory;

public class FactoryTest {

  public static void main(String[] args) throws Exception {

	//1. simple factory pattern
	BusTool busTool = BusToolFactory.getBusTool("car");
	busTool.goOut();
	busTool = BusToolFactory.getBusTool("train");
	busTool.goOut();

	System.out.println("===========================================");
	//2.method factory pattern
	BusTool2Factory busTool2Factory = new CarBusTool2Factory();
	busTool2Factory.getBusTool().goOut();

	System.out.println("===========================================");
	//3.abstract factory pattern
	BusTool3Factory factory = new BusTool3Factory();
	factory.getCar().goOut();
  }
}

interface BusTool {

  void goOut();
}

class Car implements BusTool {

  @Override
  public void goOut() {
	System.out.println("出门开车");
  }
}

class Train implements BusTool {

  @Override
  public void goOut() {
	System.out.println("出门坐火车");
  }
}

class BusToolFactory {

  public static BusTool getBusTool(String name) {
	if ("car".equals(name)) {
	  return new Car();
	} else if ("train".equals(name)) {
	  return new Train();
	} else {
	  return null;
	}
  }
}

/***
 * ======================
 *
 */
interface BusTool2Factory {

  BusTool getBusTool();
}

class CarBusTool2Factory implements BusTool2Factory {

  @Override
  public BusTool getBusTool() {
	return new Car();
  }
}

class TrainBusTool2Factory implements BusTool2Factory {

  @Override
  public BusTool getBusTool() {
	return new Train();
  }
}

/***
 * ======================
 *
 */

abstract class AbstractBusTool3Factory {

  abstract BusTool getCar();

  abstract BusTool getTran();
}

class BusTool3Factory extends AbstractBusTool3Factory {

  @Override
  BusTool getCar() {
	return new Car();
  }

  @Override
  BusTool getTran() {
	return new Train();
  }
}



