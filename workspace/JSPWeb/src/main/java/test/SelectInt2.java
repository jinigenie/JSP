package test;

import java.util.Arrays;

public class SelectInt2 {

	public static int[]	setSizeArray(int[] arr, int size) {

		int[] newArr = Arrays.copyOf(arr, size);
		return newArr;

	}

	public static void main(String[] args) {

		String[] arr = {"75h", "123", "457", "a789", "ggg0", "fgd49", "ddd", "444"};
		int[] arr2 = new int[arr.length];
		int cnt = 0;

		for(int i = 0; i < arr.length; i++) {
			try {

				arr2[cnt] = Integer.parseInt(arr[i]);
				cnt++;

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
						arr2[cnt] = Integer.parseInt(sb.toString());
						cnt++;
						arr2[cnt++] = Integer.parseInt(sb.toString());

					}
				} catch (Exception e2) {

					arr2 = setSizeArray(arr2, cnt+1);
					arr2[cnt] = Integer.parseInt(sb.toString());
					cnt++;
					arr2 = setSizeArray(arr2, cnt+1);
					arr2[cnt++] = Integer.parseInt(sb.toString());
					
				}
			} catch (Exception e3) {
				arr2 = setSizeArray(arr2, cnt+1);
				arr2[cnt] = Integer.parseInt(arr[i]);
			}
		}
		System.out.println(Arrays.toString(arr2));
	}
}