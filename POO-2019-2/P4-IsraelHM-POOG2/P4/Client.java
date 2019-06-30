import java.io.*;  
import java.net.*;  

public class Client {  
	public static void main(String[] args) {  
		try{      
			Socket s=new Socket("192.168.2.4",6666);  
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
			dout.writeUTF("Hello Server");  
			dout.flush();  
			dout.close();  
			s.close();  
		}catch(Exception e){System.out.println(e);}  
	}  
} 
/*El cliente le manda una cadena de caracteres al servidor */