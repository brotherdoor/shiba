
public class study {
	public static void main(String[] args) {
//		int count = 4;
//		for(int i = 0; i < 5; i++){
//			for(int j = 0; j < 5; j++){
//				if(j>=(count-i)){
//					System.out.print("*");
//				}
//				System.out.print(" ");
//			}
//			System.out.println();
//		}
		
//		for(int i=0; i<5; i++){
//			for(int j=0; j<4-i; j++){
//				System.out.print(" ");
//			}
//			for(int z=0; z<i+1; z++){
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		for(int i =1; i<6; i++){
			for(int j = 5-i; j>0; j--){
				System.out.print(" ");
			}
			for(int j = 0; j <i; j++){
				System.out.print("*");
			}
			System.out.println();
		}
		
		
	}

}
