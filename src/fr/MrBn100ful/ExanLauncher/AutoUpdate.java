package fr.MrBn100ful.ExanLauncher;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;


import fr.MrBn100ful.ExanLauncher.Test;




public class AutoUpdate {

	static Shutdown shutdown = new Shutdown();

	@SuppressWarnings("static-access")
	public static String[] AutoUpdate() throws IOException {
		
		

		String url = ("https://mrbn100ful.github.io/exanlauncher/version.txt");
		 String results = null;
		try {
			results = doHttpUrlConnectionAction(url);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		  
		if (!results.equals("1.3.1"
				+ "\n")){
			 try
			    {
			         URL urldownload = new URL("https://mrbn100ful.github.io/exanlauncher/exanlauncher.jar");
			         String path = Test.class.getProtectionDomain().getCodeSource().getLocation().getPath();
			         String decodedPath = URLDecoder.decode(path, "UTF-8");
			         System.out.println(decodedPath);
			         saveFile(urldownload,decodedPath);
			         shutdown.restartApplication(null);
			         System.out.println("[Debug] :  Update done !");
			    }
			    catch(IOException e)
			    {
			        e.printStackTrace();
			    }
			
		}
		
		return null;
	}
	
	public static void saveFile(URL url, String file) throws IOException {
	    System.out.println("opening connection");
	    InputStream in = url.openStream();
	    FileOutputStream fos = new FileOutputStream(new File(file));

	    System.out.println("reading file...");
	    int length = -1;
	    byte[] buffer = new byte[1024];
	    while ((length = in.read(buffer)) > -1) {
	        fos.write(buffer, 0, length);
	    }
	    
	    fos.close();
	    in.close();
	    System.out.println("file was downloaded");
	}
	private static String doHttpUrlConnectionAction(String desiredUrl)
			  throws Exception
			  {
			    URL url = null;
			    BufferedReader reader = null;
			    StringBuilder stringBuilder;

			    try
			    {

			      url = new URL(desiredUrl);
			      HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			      connection.setRequestMethod("GET");

			      connection.setReadTimeout(15*1000);
			      connection.connect();

			      reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			      stringBuilder = new StringBuilder();

			      String line = null;
			      while ((line = reader.readLine()) != null)
			      {
			        stringBuilder.append(line + "\n");
			      }
			      return stringBuilder.toString();
			    }
			    catch (Exception e)
			    {
			      e.printStackTrace();
			      throw e;
			    }
			    finally
			    {

			      if (reader != null)
			      {
			        try
			        {
			          reader.close();
			        }
			        catch (IOException ioe)
			        {
			          ioe.printStackTrace();
			        }
			      }
			    }
			  }
	
}
