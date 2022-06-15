package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertex {


	@Test
	public void createOrg(){
		// TODO Auto-generated method stub
		System.out.println("test1");
		System.out.println("test2");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals("A", "B");

		System.out.println("test3");
		System.out.println("test4");
		
		soft.assertAll();//soft assert will not work without assert all it will run all methods and gives error also
		
	}
	@Test
	public void modifyOrg() {
		System.out.println("test5");
		System.out.println("test6");
	
		System.out.println("test8");
		System.out.println("test2");
	}

}
