package daemon.plugin.script;

import java.text.MessageFormat;

import lombok.extern.log4j.Log4j;

@Log4j
public class InitializationScript {
	public static final String USER = "user";
	public static final String APPLICATION_NAME = "applicationName";
	public static final String APPLICATION_VERSION = "applicationVersion";
	public static final String APPLICATION_MAIN_CLASS = "mainClass";
	public static final String APPLICATION_ARGUMENTS = "applicationArguments";

	public static final String TARGET_SYSTEM_APPLICATION_LOCATION = "targetSystemApplicationLocation";
	public static final String TARGET_SYSTEM_DAEMON_JAR_LOCATION = "targetSystemDaemonJarLocation";
	public static final String TARGET_SYSTEM_JAVA_HOME = "targetSystemJavaHome";

	public static final String DAEMON_JAR_NAME = "daemonJarName";
	public static final String DELAY = "delay";

	private final String fileName;
	private final String contentAsString;

	public InitializationScript(String fileName, String contentAsString) {
		this.fileName = fileName;
		this.contentAsString = contentAsString;
	}

	public String getFileName() {
		log.info(MessageFormat.format("obteniendo FileName: {0}", fileName));
		return fileName;
	}

	public String getContentAsString() {
		return contentAsString;
	}
}
