package BaseCase;

import static org.junit.Assert.*;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Contact{
	
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
	    capabilities.setCapability("appPackage", "com.android.contacts");  
	    capabilities.setCapability("appActivity", ".activities.PeopleActivity");   
	    capabilities.setCapability("unicodeKeyboard", "True");  
	    capabilities.setCapability("resetKeyboard", "True");
	    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities); 
	    
	}
	 @After
	 public void tearDown() throws Exception {
		 driver.quit();
		 }
	 
	 @Test
	 public void Contact01_ClearAll(){		 
		 driver.findElementByAccessibilityId("����ѡ��").click();
		 driver.findElementByName("ɾ����ϵ��").click();
		 driver.findElementById("com.android.contacts:id/select_items").click();
		 
		 try{Thread.sleep(1000);
	  	   }catch(Exception e){System.out.print(e);}
		 
		 driver.tap(1,380,210,500);  //ȫѡ��ť
		 
		 try{Thread.sleep(1000);
	  	   }catch(Exception e){System.out.print(e);}
		 
		 driver.findElementByName("ȷ��").click();
		 
		 driver.findElementById("android:id/button1").click();
		 
		 try{Thread.sleep(3000);
	  	   }catch(Exception e){System.out.print(e);}	 
	 }

	 @Test
	 public void Contact02_Creat(){		
		driver.findElementById("com.android.contacts:id/floating_action_button").click();		 
		 
		 WebElement name = driver.findElementByName("����");
		 name.click();
		 name.sendKeys("Abc");
		 
//		 driver.sendKeyEvent(66);   //ģ�ⷵ�ؼ�
		 driver.swipe(690, 500, 690, 50, 3000);
		 
		 //����绰����
		 WebElement number = driver.findElementByClassName("android.widget.EditText");
		 assertEquals("�绰", number.getText());
		 number.click();
		 number.sendKeys("10086");
		 
		 //���ȷ�ϰ�ť
		 driver.tap(1,50,100,1000);
		 
		 try{
  		   Thread.sleep(3000);
  	   }catch(Exception e){
  		   System.out.print(e);
  	   }		 
		 
		 driver.sendKeyEvent(4); //�㷵�ؼ�
		 
		 try{
	  		   Thread.sleep(1000);
	  	   }catch(Exception e){
	  		   System.out.print(e);
	  	   }	
		 
		 driver.sendKeyEvent(4);
		 
	}
	 
	 @Test
	 public void Contact03_Delete(){	
		driver.findElementByAccessibilityId("����ѡ��").click();  //����content-desc����Ԫ��
		driver.findElementByName("ɾ����ϵ��").click();
		driver.findElementByName("Abc").click();
		driver.findElementByName("ȷ��").click();
		driver.findElementById("android:id/button1").click();
		
		 try{
	  		   Thread.sleep(3000);
	  	   }catch(Exception e){
	  		   System.out.print(e);
	   }	
	}	
}
