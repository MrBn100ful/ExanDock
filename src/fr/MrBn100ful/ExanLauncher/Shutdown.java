package fr.MrBn100ful.ExanLauncher;

import java.io.IOException;

public class Shutdown {
	
	public void shutdown() throws RuntimeException, IOException {
		String shutdownCommand;
		shutdownCommand = "shutdown.exe -s -t 0";
		Runtime.getRuntime().exec(shutdownCommand);
		System.out.println("Debug shutdown run");
		System.exit(0);
	}

	public void restart() throws RuntimeException, IOException {
		String shutdownCommand;
		shutdownCommand = "shutdown.exe -r -t 0";
		Runtime.getRuntime().exec(shutdownCommand);
		System.out.println("Debug restart run");
		System.exit(0);
	}

}
