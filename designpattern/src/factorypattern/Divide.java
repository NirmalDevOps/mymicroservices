package factorypattern;

public class Divide implements Calculate {

	@Override
	public void calculate(double d1, double d2) {
		// TODO Auto-generated method stub
		try {
		System.out.println("Divide of num1 "+d1+"\tand num2 "+d2 +" is: "+(d1/d2));
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
