package cn.srt.arrays;
/**
 * for(int i=0;i<10;i++)     ��0������ 
 * for(int i=0;i<arr01.length;i++)
 * 
 * User[] arr03=new User[3];
		arr03[0]=new User(1001,"Ƚ����");
		arr03[1]=new User(1002,"Ƚ����1");
		arr03[2]=new User(1003,"Ƚ����2");     User���� �������������  ����� ��Щ����ĵ�ַ
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
		
		for(int i=0;i<10;i++) {         //ѭ����ʼ��
			arr01[i]=10*i;
		}
		
		for(int i=0;i<10;i++) {               //����
			System.out.println(arr01[i]);
		}
		
		User[] arr03=new User[3];
		arr03[0]=new User(1001,"Ƚ����");
		arr03[1]=new User(1002,"Ƚ����1");
		arr03[2]=new User(1003,"Ƚ����2");
		
		for(int i=0;i<3;i++) {         //ѭ����ʼ��
			System.out.println(arr03[i].getName());;
		}
	}
}
