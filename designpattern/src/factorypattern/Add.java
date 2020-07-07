package factorypattern;

public class Add implements Calculate {

	@Override
	public void calculate(double d1, double d2) {
		// TODO Auto-generated method stub
		System.out.println("Addition of num1 "+d1+"\tand num2 "+d2 +" is: "+(d1+d2));

	}

}
