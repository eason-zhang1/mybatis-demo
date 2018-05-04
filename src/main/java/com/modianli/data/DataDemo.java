package com.modianli.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DataDemo {

  static int lines = (int) (8 * Math.pow(10, 8)), max_int = (int) (5 * Math.pow(10, 6)), mask = 0x1f;
  static int[] tmp = new int[(lines >> 5) + 1];
  static Random random = new Random();

  public static void main(String[] args) throws Exception {

//	write();

	//如何将1000W条中的TOP N
	read();
  }

  public static void write() throws IOException {
	File file = new File("test.txt");
	if (!file.exists()) {
	  file.createNewFile();
	}

	Random random = new Random();
	BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
	for (int l = 1; l <= lines; l++) {
	  writer.write("" + random.nextInt(lines));
	  writer.newLine();
	  if (l % 10000 == 0) {
		writer.flush();
	  }
	}

	writer.close();
  }

  public static void read() throws Exception {
	TimeUnit.MINUTES.sleep(1);
    for (int i = 1; i < lines; i++) {
	  storeBit(random.nextInt(lines));
	}

	TimeUnit.MINUTES.sleep(3);
  }

  public static void storeBit(int num) {
    //当前数组坐标下的数据与新数据或运算并设置新值
	tmp[num >> 5] |= (1 << (num & mask));
  }
}
