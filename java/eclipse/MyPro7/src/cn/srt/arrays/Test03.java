package cn.srt.arrays;

public class Test03 {
	public static void main(String[] args) {
		//foreach  ���ڶ�ȡ,�����޸�
		int[] a=new int[4];
		for(int i=0;i<a.length;i++) {
			a[i]=100*i;
		}
		
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		for(int m:a) {
			System.out.println(m);
		}
	}
	
	
}
