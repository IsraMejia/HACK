public class Primi{
	public static void main (String[] args){
		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		int n3 = Integer.parseInt(args[2]);
		if(n1<n2 && n2<n3){
			System.out.println(n3 + " Es el mayor");
		}else{
			if(n1<n2&& n3<n2){
			System.out.println(n2+ " Es el mayor");
			}else{
				if(n2<n1 && n3<n1){
				System.out.println(n1+ " Es el mayor");
				}else{
				System.out.println("Ingrese numeros distintos para decirle cual es el mayor");
				}
			}	
		}

	}

}
