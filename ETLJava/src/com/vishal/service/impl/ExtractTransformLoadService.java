package com.vishal.service.impl;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.vishal.domain.FileWordCounter;
import com.vishal.domain.Transformer;
import com.vishal.service.IfcExtractTransformLoadService;

public class ExtractTransformLoadService implements IfcExtractTransformLoadService {

	@Override
	public void transformAndLoadFiles(String fromPath, String toPath){
		List<String> absoluteFilePaths = absoluteFilePathsAt(fromPath);
		for (String filePath : absoluteFilePaths) {
			transformAndLoad(new File(filePath), toPath);
		}
	}
	
	private void transformAndLoad(File file, String toPath) {
		try {
			String outputFilePath = toPath +file.getName();
			writeFileToOutputFolder(file, outputFilePath);
			
			Transformer transformer = new FileWordCounter(file, outputFilePath);
			transformer.Transform();
			transformer.load();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeFileToOutputFolder(File file, String outputFilePath) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		PrintWriter writer = new PrintWriter(outputFilePath, "UTF-8");
		String line;
		while ((line = reader.readLine()) != null) {
			writer.println(line);           
		}
		writer.close();
		reader.close();
	}

	private List<String> absoluteFilePathsAt(String path) {

		File folder = new File(path);
		File[] files = folder.listFiles();
		List<String> filePaths = new ArrayList<String>();
		if (files == null) {
			System.out.println("No Files found at given path");
			return filePaths;
		}
		for (File file : files) {
			if (file.isFile()) {
				filePaths.add(file.getAbsolutePath());
			}
		}
		return filePaths;
	}


}
