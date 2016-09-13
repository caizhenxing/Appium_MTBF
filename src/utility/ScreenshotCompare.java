package utility;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.android.AndroidDriver;

public class ScreenshotCompare {
	
	public static File actualImage;

	
	//�Զ���ͼ������ͼƬ����������
	public static void takeScreenShotat(AndroidDriver driver,String testCaseName){  
		   try {   
			   String filePath = "D:\\Appium\\actual";
			   File path = new File(filePath);
			   if (!path.exists()) {  
		            path.mkdir(); // Ŀ¼�����ڵ�����£����׳��쳣  
		        }  
			   
			  	Date now = new Date(); 
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss");//���Է�����޸����ڸ�ʽ
				String time = dateFormat.format(now).toString();
			   
			  
			   
			    File pic = new File(filePath+"\\"+testCaseName+".jpg");
			    if (!pic.exists()) {
		            pic.createNewFile();  
		        }  
		        File f1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		        FileUtils.copyFile(f1,pic);    
		        
		        actualImage = new File(filePath+"\\"+testCaseName+".jpg");	
		        
		   }       
		   catch (IOException e) {e.printStackTrace();}  
		} 
	
	//��ȡ�����ѱ�����ļ�
	public static BufferedImage getImageFromFile(File f){
	    BufferedImage img = null;   
	    try {
	        img = javax.imageio.ImageIO.read(f);
	    }   
	    catch (IOException e) {
	        e.printStackTrace();
	    }
	    return img;
	 }
	
	
	//����ͼƬ�Ա�
	public static boolean sameAs(BufferedImage myImage,BufferedImage otherImage, double percent){
	    if (otherImage.getWidth() != myImage.getWidth()) {  
	       return false;    
	    }
	    if (otherImage.getHeight() != myImage.getHeight()) {
	       return false;
	    }
	    int width = myImage.getWidth(); 
	    int height = myImage.getHeight();   
	    int numDiffPixels = 0;  
	    for (int y = 0; y < height; y++) {
	        for (int x = 0; x < width; x++) {
	             if (myImage.getRGB(x, y) != otherImage.getRGB(x, y)) {
	             numDiffPixels++;
	             }
	        }
	    }   
	    double numberPixels = height * width;   
	    double diffPercent = numDiffPixels / numberPixels;  
	    return percent <= 1.0D - diffPercent;
	 }
	
	//��ȡͼƬ�ԱȽ��
	public static String getResult(File expectedImage){
    Boolean same;
    String result=null;


    try{
    		BufferedImage img1=getImageFromFile(actualImage);
    		BufferedImage img2=getImageFromFile(expectedImage);
    		same=sameAs(img1,img2,0.0);
    		result = String.valueOf(same);	
    	}
        catch (Exception e) {e.printStackTrace();}    
    return result;    
 }	

}
