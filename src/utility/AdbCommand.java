package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdbCommand {
	
	static Thread t;
	
	public static void execCommand(String command) throws IOException {
	    Runtime runtime = Runtime.getRuntime();
	    Process proc = runtime.exec(command);
	    try {
	        if (proc.waitFor() != 0) {
	            System.err.println("exit value = " + proc.exitValue());
	        }
	        BufferedReader in = new BufferedReader(new InputStreamReader(
	                proc.getInputStream()));
	        StringBuffer stringBuffer = new StringBuffer();
	        String line = null;
	        while ((line = in.readLine()) != null) {
	            stringBuffer.append(line+" ");
	        }
	        System.out.println(stringBuffer.toString());
	 
	    } catch (InterruptedException e) {
	        System.err.println(e);
	    }finally{
	        try {
	            proc.destroy();
	        } catch (Exception e2) {
	        }
	    }
	}
	
	public static void takeScreenshot(){	  
		if(t==null){
			t = new Thread(){
				public void run(){
					try{
						execCommand("adb shell screencap -p /sdcard/screen.png");
						execCommand("adb pull /sdcard/screen.png D:\\Appium\\screenshot");
						execCommand("adb shell rm /sdcard/screen.png");
						
						renameFile("D:\\Appium\\screenshot\\screen.png");
						}catch(Exception e){
							e.printStackTrace();
						}
				}
			};
			t.start();
		}
		t = null;
	}

	 public static void renameFile(String oldFile)  
	            throws IOException {  
		 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");//���Է�����޸����ڸ�ʽ
		String time = dateFormat.format(new Date()).toString();
		String newName = "Screenshot-"+time+".png";
				
	        File oldfile = new File(oldFile);  
	        File newfile = new File(oldfile.getParent().concat(File.separator)  
	                .concat(newName));  
	        if (oldfile.isFile()) {  
	            oldfile.renameTo(newfile);  
	        } else {  
	            System.out.println("ָ�����ļ�����·������ " + oldFile);  
	        }  
	    }  
}
