package factorypattern;

public class FactoryCalculate {
	
	public Calculate getCalculate(String inputType) {
		
		Calculate calObj = null;
		if(inputType.equalsIgnoreCase("add"))
			calObj=new Add();
		if(inputType.equalsIgnoreCase("sub"))
			calObj=new Subtract();
		if(inputType.equalsIgnoreCase("div"))
			calObj=new Divide();
		return calObj;
		
	}

}
