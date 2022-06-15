package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.comcast.generic_utilities.Excel_Utilities;

public class DataProviderWithoutDDtTest {
	@Test(dataProvider ="bookTicketDataProvider")
	private void bookTicket(String src,String dest,String ticket) {
  System.out.println("source is " +src +" destination is " +dest+ " number of tickets is "+ ticket);
		// TODO Auto-generated method stub
		

	}
	@DataProvider
	public Object[][] bookTicketDataProvider() throws Throwable
	{
		Excel_Utilities ex= new Excel_Utilities();
		
		String src1 = ex.getExcelData("Sheet1", 5, 1);
		String dest1 = ex.getExcelData("Sheet1", 6, 1);
		String tickets1 = ex.getExcelData("Sheet1", 5, 2);
		
		
		String src2 = ex.getExcelData("Sheet1", 5, 1);
		String dest2 = ex.getExcelData("Sheet1", 7, 1);
		String tickets2 = ex.getExcelData("Sheet1", 6, 2);
		
		String src3 = ex.getExcelData("Sheet1", 5, 1);
		String dest3 = ex.getExcelData("Sheet1", 8, 1);
		String tickets3 = ex.getExcelData("Sheet1", 7, 2).toString();
		
		
		Object[][] objarr= new Object[3][3];
		objarr[0][0]=src1;
		objarr[0][1]=dest1;
		objarr[0][2]=tickets1;
		
		
		objarr[1][0]=src2;
		objarr[1][1]=dest2;
		objarr[1][2]=tickets2;
		
		objarr[2][0]=src3;
		objarr[2][1]=dest3;
		objarr[2][2]=tickets3;
		return objarr;
		
//		Object[][] objarr= new Object[3][3];
//		objarr[0][0]="Bangalore";
//		objarr[0][1]="Mysore";
//		objarr[0][2]=10;
//		
//		
//		objarr[1][0]="Bangalore";
//		objarr[1][1]="goa";
//		objarr[1][2]=20;
//		
//		objarr[2][0]="Bangalore";
//		objarr[2][1]="kerala";
//		objarr[2][2]=30;
//		return objarr;
		
		
	}

}
