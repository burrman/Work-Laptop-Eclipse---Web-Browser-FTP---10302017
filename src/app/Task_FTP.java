package app;

import java.io.IOException;
import java.util.TimerTask;

import FTP.FTP;
import FTP4J.FTPAbortedException;
import FTP4J.FTPDataTransferException;
import FTP4J.FTPException;
import FTP4J.FTPIllegalReplyException;
import fileHandling.FileManagement;

//create an instance of the FTP file transfer tools



public class Task_FTP extends TimerTask  
{
	private String server = "";
	private String user = "";
	private String password = "";
	private String fileName = "";
	
	
   public void run() 
   {
	   	// time the operation
	   	long startTime = System.currentTimeMillis();
	   	System.out.println("FTP task started! \n");
	   	
	   	
	   	try 
	   	{
			try {
				FTP.sendFTP(server, user, password, fileName);
			} catch (FTPException e) {
				e.printStackTrace();
			} catch (FTPIllegalReplyException e) {
				e.printStackTrace();
			} catch (FTPDataTransferException e) {
				e.printStackTrace();
			} catch (FTPAbortedException e) {
				e.printStackTrace();
			}
		} 
	   	catch (IOException e) 
	   	{
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println("IO exception caught in the timer task while calling the sendFTP() method! \n");
		}
	   	
	   	// display the operation execution time
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) + " milliseconds to transfer the data via FTP. \n");

	   FileManagement.DeleteFile(fileName, "");
	   

   } // end run()
   
   
   public void setServerInfo(String server, String user, String password, String fileName)
   {
	   this.server = server;
	   this.user = user;
	   this.password = password;
	   this.fileName = fileName;
   }

   
   
   
   
   
} // end class Task