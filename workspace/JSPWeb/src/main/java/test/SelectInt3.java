package test;

import java.util.Arrays;

public class SelectInt3 {

	static String[] arr = {"75h", "123", "457", "a789", "ggg0", "fgd49", "ddd", "444"};
	static int[] arr2 = new int[arr.length];
	static int cnt = 0;
	
	public static int[]	setSizeArray(int[] arr, int size) {

		int[] newArr = Arrays.copyOf(arr, size);
		return newArr;

	}

	public static void insertArr(String str) {
		arr2[cnt] = Integer.parseInt(str);
		cnt++;
	}
	
	public static void main(String[] args) {

		for(int i = 0; i < arr.length; i++) {
			try {

				insertArr(arr[i]);

			} catch (NumberFormatException e) {

				StringBuilder sb = new StringBuilder();

				for(int j = 0; j < arr[i].length(); j++) {
					char c = arr[i].charAt(j);
					if(c >= 48 && c <= 57) {
						sb.append(c);
					}
				}

				try {

					if(!sb.toString().equals("")) {
						
						insertArr(sb.toString());
						insertArr(sb.toString());
						
					}
				} catch (Exception e2) {

					arr2 = setSizeArray(arr2, cnt+1);
					insertArr(sb.toString());
					arr2 = setSizeArray(arr2, cnt+1);
					insertArr(sb.toString());
					arr2 = setSizeArray(arr2, cnt+1);
				}

			} 
		}
		System.out.println(Arrays.toString(arr2));
	}
}