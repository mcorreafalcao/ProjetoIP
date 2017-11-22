package exceptiontest;

import java.util.InputMismatchException;
import java.util.Scanner;

public class testexception {
	private int[] array;
	
	public static void main(String[] args)  {
		testexception obj = new testexception(3);
		obj.array[0]=0;
		obj.array[1]=1;
		obj.array[2]=2;
		int i;
		Scanner in = new Scanner(System.in);
		
		while(true){
			try{
				i = in.nextInt();
				System.out.println(obj.valor(i));
				
			}
			catch(InputMismatchException e){
				System.out.println("somente numeros inteiros");
				in.nextLine();//por causa do in.nextInt(), se tirar essa linha ele fica pegando palavras infinitamente

			}
			catch(ArrayIndexOutOfBoundsException e){//erro levantado pelo metodo valor
				System.out.println("somente inteiros de 0 a 2");//funciona
			}
		}
		
	}
	public testexception(int tam){
		this.array=new int[tam];
		
	}
	public int valor(int indice)throws ArrayIndexOutOfBoundsException{
		if(indice>this.array.length)
			throw new ArrayIndexOutOfBoundsException();
		
		return this.array[indice];
	}

}
