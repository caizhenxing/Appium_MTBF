package BaseCase;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;

public class Browser extends TestCase{
	
public static AndroidDriver driver; 
	
	@Before
	public void setUp() throws Exception {
	           
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability("newCommandTimeout",1800000);//30mins
	    capabilities.setCapability("platformName", "Android");
//	     capabilities.setCapability("deviceName", "SORG7PEAIF8DOZRO");
	//  capabilities.setCapability("app", app.getAbsolutePath());
	    capabilities.setCapability("deviceName", "EIJZIVGASO9SWCIZ");       
	    capabilities.setCapability("platformVersion", "5.1");       
	    capabilities.setCapability("appPackage", "com.tencent.mtt");  
	    capabilities.setCapability("appActivity", "com.tencent.mtt.MainActivity");   
	    capabilities.setCapability("unicodeKeyboard", "True");  
	    capabilities.setCapability("resetKeyboard", "True");
	    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities); 
	    
	}
	
	 @After
	    public void tearDown() throws Exception {
	        driver.quit();
	    }
	 
	 public void testClearData(){
		 
		 driver.findElementByAccessibilityId("�˵�").click();
		 
		 driver.findElementByName("����").click();
		 
		 try{
	  		   Thread.sleep(3000);
	  	   }catch(Exception e){
	  		   System.out.print(e);
	  	   }	
		 
		 driver.swipe(600, 860, 600, 100, 3000);
		 
		 try{
	  		   Thread.sleep(1000);
	  	   }catch(Exception e){
	  		   System.out.print(e);
	  	   }		 
		 
		 driver.tap(1,300,760,500);
		 
		 try{
	  		   Thread.sleep(1000);
	  	   }catch(Exception e){
	  		   System.out.print(e);
	  	   }
			 
		 driver.tap(1,350,1120,500);
		 
		 try{Thread.sleep(1000);
	  	   }catch(Exception e){System.out.print(e);}
		 
		 driver.findElementByName("���").click();		 		 		 
	 }
	 
	 public void testBrowse(){
		 
		 driver.startActivity("com.tencent.mtt", "com.tencent.mtt.MainActivity");
		 
		 driver.findElementByAccessibilityId("�˵�").click();
		 
		 driver.findElementByAccessibilityId("��ǩ/��ʷ").click();
		 
		 try{Thread.sleep(1000);
	  	   }catch(Exception e){System.out.print(e);}
		 
		 driver.findElementByName("�ٶ�һ��").click();
		 
		 try{Thread.sleep(3000);
	  	   }catch(Exception e){System.out.print(e);}
		 
		 
	 }
	 
	 

}