package prac;

import java.util.Arrays;
import java.util.Scanner;

public class study05_4 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("입력할 정수의 개수: ");
		int num = scan.nextInt();
		int input_n = 0, search_n = 0;
		
		int[] arr = new int[num];
		
		for(int i = 0; i < num; i++) {
			System.out.print("정수 값 #" + (i+1) + ": ");
			arr[i] = scan.nextInt();
		}
		
		Arrays.sort(arr);
		System.out.print("탐색할 정수 값: ");
		search_n = scan.nextInt();
		System.out.println(search_n + "가 있는 인덱스 번호: " + Arrays.binarySearch(arr, search_n));
		System.out.println("정렬된 배열: " + Arrays.toString(arr));
		
		System.out.print("비교할 배열의 크기: ");
		
		int[] arr2 = new int[num];
		
		for(int i = 0; i < num; i++) {
			System.out.print("정수 값 #" + (i+1) + ": ");
			arr[i] = scan.nextInt();
		}
		
		
		
		
	}
}
