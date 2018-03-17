package errors;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Errors {
	private File error;
	private FileWriter errorW;
	private BufferedWriter output;
	
	public Errors(){
		try{
			error = new File("ErrorsLog.txt");
			error.createNewFile();
			errorW = new FileWriter(error);
		}catch(Exception e){
			System.out.println("Error in 'Errors.java' : failed to create new file");
		}
	}
	public void writeError(String text){
		try{
			//errorW.write(text);	
			output = new BufferedWriter(errorW);
			output.write(text+"\n");
			output.flush();
			//output.close();
		}catch(Exception e){
			System.out.println("Error in 'Errors.java' : failed to write error");
		}
	}
	public void close(){
		try{
			output.close();
		}catch(Exception e){
			System.out.println("Error in 'Errors.java' : failed to close file");
		}
	}
}