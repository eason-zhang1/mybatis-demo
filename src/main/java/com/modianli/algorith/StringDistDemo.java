package com.modianli.algorith;

import java.util.Arrays;
import java.util.BitSet;

public class StringDistDemo {

  public static void main(String[] args) {

	System.out.println(
		containChars("afabadfaeawefzngadfwefoasvnasoffadjfwpeiofaweoifawiofejawoifejiawefweofawifowjfopwjhfiwphfowiph"));

	int[] arr = new int[]{2, 56, 8, 4, 7, 8, 234, 7, 1, 4, 567, 95};
	insertionSort(arr);
	selectionSort(arr);
	bubbleSort(arr);
  }

  /**
   * 字符串去重
   */
  public static String containChars(String str) {
	BitSet set = new BitSet();
	for (char c : str.toCharArray()) {
	  set.set(c, true);
	}

	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < set.size(); i++) {
	  if (set.get(i)) {
		sb.append((char) i);
	  }
	}

	return sb.toString();
  }

  /**
   * 快速插入排序  ==> 希尔排序(不稳定)
   * ①. 从第一个元素开始，该元素可以认为已经被排序
   * ②. 取出下一个元素，在已经排序的元素序列中从后向前扫描
   * ③. 如果该元素（已排序）大于新元素，将该元素移到下一位置
   * ④. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
   * ⑤. 将新元素插入到该位置后
   * ⑥. 重复步骤②~⑤
   *
   * 平均时间复杂度	最好情况	最坏情况	空间复杂度
   * O(n²)			O(n²)	O(n²)	O(1)
   */
  public static void insertionSort(int[] arr) {
	for (int i = 1; i < arr.length; i++) {
	  int tmp = arr[i];
	  for (int j = i - 1; j > -1; j--) {
		if (arr[j] > tmp) {
		  arr[j + 1] = arr[j];
		  arr[j] = tmp;
		} else {
		  break;
		}
	  }
	}

	System.out.println(Arrays.toString(arr));
  }

  /**
   * 选择排序
   *
   * ①. 从待排序序列中，找到关键字最小的元素；
   * ②. 如果最小元素不是待排序序列的第一个元素，将其和第一个元素互换；
   * ③. 从余下的 N - 1 个元素中，找出关键字最小的元素，重复①、②步，直到排序结束。
   *
   * 平均时间复杂度	最好情况	最坏情况	空间复杂度
   * O(n²)			O(n²)	O(n²)	O(1)
   */
  public static void selectionSort(int[] arr) {
	for (int i = 0; i < arr.length - 1; i++) {
	  int min = arr[i];
	  for (int j = i + 1; j < arr.length; j++) {
		if (arr[j] < min) {
		  min = arr[j];
		}

		arr[i] = min;
	  }
	}

	System.out.println(Arrays.toString(arr));
  }

  /**
   * 堆排序
   */
  public static void heapSort(int[] arr) {

  }

  /**
   * 冒泡排序
   */
  public static void bubbleSort(int[] arr) {
    for(int i = 0; i < arr.length; i ++){
      for(int j = 0; j < arr.length - i - 1; j ++){
        if(arr[j] > arr[j + 1]){
          int tmp = arr[j + 1];
          arr[j + 1] = arr[j];
          arr[j] = tmp;
		}
	  }
	}

	System.out.println(Arrays.toString(arr));
  }


}
