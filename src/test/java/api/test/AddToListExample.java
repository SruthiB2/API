package api.test;

public class AddToListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object obj[][] = new Object[2][3];
		//{{1,"t1","b1"},{2,"t2","b2"},{3,"t3","b3"}};
		Object obj2[][] = new Object[2][3];
		int num = 0;
		for (int i = 0; i < obj.length; i++) {
			for (int j = 0; j<3; j++ ) {
				obj[i][j] = num;
				num++;
				obj2[i][j] = obj[i][j];
			}
		}
		for (int i = 0; i < obj.length; i++) {
			for (int j = 0; j<3; j++ ) {
		System.out.println(obj2[i][j]);
			}
		}
	}

}
