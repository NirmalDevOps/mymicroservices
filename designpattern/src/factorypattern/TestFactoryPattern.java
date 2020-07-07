package factorypattern;

import java.util.Scanner;

public class TestFactoryPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		In the factory design pattern, Object always will be created based on input Type.
		
		Scanner in=new Scanner(System.in);
		
		System.out.println("what operation->add , sub , div ");
		String optr=in.next();
		
		System.out.println("Enter two number : ");
		double d1=in.nextDouble();
		double d2=in.nextDouble();
		FactoryCalculate fcal=new FactoryCalculate();
		fcal.getCalculate(optr).calculate(d1, d2);;
		

	}

}
