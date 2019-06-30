public class Primitivos{
	public static void main (String[] args){
		int[] num = new int[2];
		//Integer[] num = new Integer[2];
		int i=0;
		for(i = 0; i<3 ; i++)
			num[i] = Integer.parseInt(args[i]);
		for(i = 0; i<3 ; i++)
			System.out.println(num[i]);
		
		if(num[0]<num[2] && num[1]<num[2]){
			System.out.println(num[2] + "Es el mayor");
		}else{
			if(num[0]<num[1] && num[2]<num[1]){
			System.out.println(num[1] + "Es el mayor");
			}else{
				if(num[1]<num[0] && num[2]<num[0]){
				System.out.println(num[0] + "Es el mayor");
				}else{
				System.out.println("Ingrese numeros distintos para decirle cual es el mayor");
				}
			}	
		}
	}

}
