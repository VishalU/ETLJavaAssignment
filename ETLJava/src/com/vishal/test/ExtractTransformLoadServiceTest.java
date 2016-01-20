package com.vishal.test;

import org.junit.Test;

import com.vishal.service.IfcExtractTransformLoadService;
import com.vishal.service.impl.ExtractTransformLoadService;

public class ExtractTransformLoadServiceTest {

	IfcExtractTransformLoadService service = new ExtractTransformLoadService();
	
	@Test
	public void executeProgram() {
		String fromPath = "/media/Assignment/SourceFolder";
		String toPath = "/media/Assignment/OutputFolder/";
		service.transformAndLoadFiles(fromPath, toPath);
	}

	
	
	
}
