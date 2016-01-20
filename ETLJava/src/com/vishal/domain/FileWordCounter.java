package com.vishal.domain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class FileWordCounter implements Transformer{
	
	String outputFilePath = "";	
	File file = null;
	HashMap<String, Integer> wordCount = null;
	
	public FileWordCounter(File file, String outputFilePath){
		this.file=file;
		this.outputFilePath = outputFilePath;
	}

	@Override
	public void Transform() throws IOException{
		
		HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();

		FileInputStream fileInputStream = null;
		DataInputStream dataInputStream = null;
		BufferedReader reader = null;
		try {
			fileInputStream = new FileInputStream(file);
			dataInputStream = new DataInputStream(fileInputStream);
			reader = new BufferedReader(new InputStreamReader(dataInputStream));
			
			String line = null;
			while ((line = reader.readLine()) != null) {
				StringTokenizer tokenizer = new StringTokenizer(line, " .,\';():\"");
				while (tokenizer.hasMoreTokens()) {
					String word = tokenizer.nextToken().toLowerCase().trim();
					if (!wordCountMap.containsKey(word)) {
						wordCountMap.put(word, 1);
					} else {
						wordCountMap.put(word, wordCountMap.get(word) + 1);
					}
				}
			}
		} catch (Exception e) {
            e.printStackTrace();
		} finally {
			reader.close();
		}
        
		wordCount =  wordCountMap;
	}

	@Override
	public void load() {
		PrintWriter writer = null;
		try {
			File outputFile = new File(outputFilePath);
			writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFile, true)));
			writer.println();
			writer.println("********************SUMMARY*****************");
			writer.println();
			
			for (Entry<String, Integer> entry : wordCount.entrySet()) {
				writer.println(entry.getKey() + " --> " + entry.getValue());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}
		
	}
	
	
	
	
	
}
