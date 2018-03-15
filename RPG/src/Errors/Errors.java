package Errors;

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
			System.out.println("Erreur Errors.java createNewFile");
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
			System.out.println("Erreur Errors.java writeError");
		}
	}
	public void close(){
		try{
			output.close();
		}catch(Exception e){
			
		}
	}
	}
