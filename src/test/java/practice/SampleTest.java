package practice;

import org.testng.annotations.Test;


public class SampleTest {
	

	@Test()
	
	 public void createContactTest() {
		
		//int x=1/0;
		 System.out.println("contact created");
	
	 }
	@Test(dependsOnMethods = "createContactTest")
	public void modifyContactTest() {
	
		System.out.println("contact modified");
	}
	@Test(dependsOnMethods = "modifyContactTest")
	public void deleteContactTest() {
		System.out.println("contact deleted");
	}
	
	
}


