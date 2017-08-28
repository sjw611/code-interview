package ood.callcentre;

public class Driver {
	public static void main(String[] args) {
		CallCentre centre = new CallCentre();
		
		try {
			centre.dispatchCall(new Call(1, "Hello World"));
			centre.dispatchCall(new Call(2, "Hello World!"));
			centre.dispatchCall(new Call(3, "Hello World!!"));
			centre.dispatchCall(new Call(4, "Hello World!!!"));
		} catch (NoEmployeeAvailableException e) {
			e.printStackTrace();
		}
	}
}
