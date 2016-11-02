package fr.MrBn100ful.ExanLauncher;


import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.List;

public class Shutdown {
	
	public void shutdown() throws RuntimeException, IOException {
		String shutdownCommand;
		shutdownCommand = "shutdown.exe -s -t 0";
		Runtime.getRuntime().exec(shutdownCommand);
		System.out.println("[Debug] :  shutdown run");
		System.exit(0);
	}

	public void restart() throws RuntimeException, IOException {
		String shutdownCommand;
		shutdownCommand = "shutdown.exe -r -t 0";
		Runtime.getRuntime().exec(shutdownCommand);
		System.out.println("[Debug] :  restart run");
		System.exit(0);
	}

	public static final String SUN_JAVA_COMMAND = "sun.java.command";

	public static void restartApplication(Runnable runBeforeRestart) throws IOException {
	try {
	String java = System.getProperty("java.home") + "/bin/java";
	List<String> vmArguments = ManagementFactory.getRuntimeMXBean().getInputArguments();
	StringBuffer vmArgsOneLine = new StringBuffer();
	for (String arg : vmArguments) {
	if (!arg.contains("-agentlib")) {
	vmArgsOneLine.append(arg);
	vmArgsOneLine.append(" ");
	}
	}
	final StringBuffer cmd = new StringBuffer("\"" + java + "\" " + vmArgsOneLine);
	String[] mainCommand = System.getProperty(SUN_JAVA_COMMAND).split(" ");
	if (mainCommand[0].endsWith(".jar")) {
	cmd.append("-jar " + new File(mainCommand[0]).getPath());
	} else {
	cmd.append("-cp \"" + System.getProperty("java.class.path") + "\" " + mainCommand[0]);
	}
	for (int i = 1; i < mainCommand.length; i++) {
	cmd.append(" ");
	cmd.append(mainCommand[i]);
	}
	Runtime.getRuntime().addShutdownHook(new Thread() {
	@Override
	public void run() {
	try {
	Runtime.getRuntime().exec(cmd.toString());
	} catch (IOException e) {
	e.printStackTrace();
	}
	}
	});
	if (runBeforeRestart!= null) {
	runBeforeRestart.run();
	}
	System.exit(0);
	} catch (Exception e) {
	throw new IOException("Error while trying to restart the application", e);
	}
	}

}
