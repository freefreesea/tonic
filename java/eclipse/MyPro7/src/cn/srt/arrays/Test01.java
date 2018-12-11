package cn.srt.arrays;
/**
 * for(int i=0;i<10;i++)     从0到长度 
 * for(int i=0;i<arr01.length;i++)
 * 
 * User[] arr03=new User[3];
		arr03[0]=new User(1001,"冉子用");
		arr03[1]=new User(1002,"冉子用1");
		arr03[2]=new User(1003,"冉子用2");     User数组 存的是引用类型  存的是 这些对象的地址
 * @author tonic
 *
 */
public class Test01 {
	public static void main(String[] args) {
		int[] arr01=new int[10];
		String[] arr02=new String[5];
	
		
		arr01[0]=13;
		arr01[1]=15;
		arr01[2]=13;
		
		for(int i=0;i<10;i++) {         //循环初始化
			arr01[i]=10*i;
		}
		
		for(int i=0;i<10;i++) {               //遍历
			System.out.println(arr01[i]);
		}
		
		User[] arr03=new User[3];
		arr03[0]=new User(1001,"冉子用");
		arr03[1]=new User(1002,"冉子用1");
		arr03[2]=new User(1003,"冉子用2");
		
		for(int i=0;i<3;i++) {         //循环初始化
			System.out.println(arr03[i].getName());;
		}
	}
}
