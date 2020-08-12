package com.revature.fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Driver {
	
	private final String FILE_NAME = "files/myfile.csv";
	
	private FileOutputStream fos = null;
	private FileInputStream fis = null;
	
	private FileReader fr = null;
	private FileWriter fw = null;
	
	private BufferedReader br = null;
	private BufferedWriter bw = null;

	public static void main(String[] args) {

		Driver d = new Driver();
		
		try {
			d.fosExample();
			d.fisExample();
			d.fileReaderWriterExample();
			d.bufferedReaderWriterExample();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fosExample() throws IOException {
		
		try {
			
			fos = new FileOutputStream(FILE_NAME);
			
			char rand = 0;
			
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 7; j++) {
					rand = (char) (Math.random() * 26 + 'a');
					
					fos.write((byte) rand);
					
					if(j < 6) {
						fos.write((byte) ',');
					}
				}
				
				fos.write((byte) '\n');
			}
		} finally {
			fos.close();
		}
	}
	
	public void fisExample() throws IOException {
		try {
			
			fis = new FileInputStream(FILE_NAME);
			
			byte buffer;
			// While reading, if the value is -1, then we have reached the end of the file
			
			while((buffer = (byte) fis.read()) != -1) {
				char c = (char) buffer;
				
				if(c == ',') {
				} else if(c == '\n') {
					System.out.println();
				} else {
					System.out.print(c);
				}
			}
		} finally {
			fis.close();
		}
	}
	
	public void fileReaderWriterExample() throws IOException {
		
		/*
		 * The FileReader/Writer process contents 2 bytes at a time,
		 * whereas the FileInput/OutputStreams process only 1 byte at a time
		 */
		
		try {
			 fr = new FileReader(FILE_NAME);
			 fw = new FileWriter("files/myfile.upper.csv");
			 
			 int buffer;
			 
			 while((buffer = fr.read()) != -1) {
				 if(Character.isLowerCase(buffer)) {
					 fw.write(buffer - 32);
				 } else {
					 fw.write(buffer);
				 }
			 }
		} finally {
			fr.close();
			fw.close();
		}
	}
	
	public void bufferedReaderWriterExample() throws IOException {
		
		/*
		 * BufferedReaders/Writers can process entire Strings at a time, not just 1 or 2 bytes
		 */
		
		try {
			br = new BufferedReader(new FileReader(FILE_NAME));
			bw = new BufferedWriter(new FileWriter("files/myfile.writer.csv"));
			
			String line = "";
			
			while((line = br.readLine()) != null) {
				bw.write(line.replaceAll("a", "REDACTED") + "\n");
			}
		} finally {
			br.close();
			bw.close();
		}
	}
}
