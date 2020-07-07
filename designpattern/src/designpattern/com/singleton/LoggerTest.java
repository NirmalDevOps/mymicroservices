package designpattern.com.singleton;

public class LoggerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Logger log1=Logger.getInstance();
		Logger log2=Logger.getInstance();
		
		System.out.println(log1.hashCode()+"\n"+log2.hashCode());
		
		// Note Singleton class always have the same hashCode for all the object.

	}

}
