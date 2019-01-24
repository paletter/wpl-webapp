package com.paletter.wlp;

import com.paletter.easy.web.server.EWSRunner;
import com.paletter.easy.web.server.config.EWSConfig;

public class App {

	public static void main(String[] args) {
		
		EWSConfig.port = 8080;
		EWSConfig.bioMode();
		EWSConfig.resourcesPath = "html/";
		EWSConfig.httpHandlerThreadSize = 1024;
		EWSConfig.annotationMappingMode("com.paletter.wlp.service");
		
		EWSRunner.run();
	}
}
