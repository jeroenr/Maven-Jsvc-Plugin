package daemon.plugin.script;

import org.antlr.stringtemplate.StringTemplate;

import daemon.plugin.maven.ApplicationConfiguration;
import daemon.plugin.maven.DaemonConfiguration;
import daemon.plugin.maven.InitializationScriptConfiguration;
import daemon.plugin.maven.TargetSystemConfiguration;

public class InitializationScriptFactory {
	public static InitializationScript createInitializationScript(
	        StringTemplate template,
	        InitializationScriptConfiguration initializationScriptConfiguration) {
		DaemonConfiguration daemonConfiguration = initializationScriptConfiguration
		        .getDaemonConfiguration();
		final ApplicationConfiguration applicationConfiguration = initializationScriptConfiguration
		        .getApplicationConfiguration();
		final TargetSystemConfiguration targetSystemConfiguration = initializationScriptConfiguration
		        .getTargetSystemConfiguration();
		filterTemplate(template, daemonConfiguration, applicationConfiguration,
		        targetSystemConfiguration,
		        initializationScriptConfiguration.getDaemonJarName());

		return new InitializationScript(
		        applicationConfiguration.getScriptName(), template.toString());

	}

	private static void filterTemplate(StringTemplate template,
	        DaemonConfiguration daemonConfiguration,
	        ApplicationConfiguration applicationConfiguration,
	        TargetSystemConfiguration targetSystemConfiguration,
	        String daemonJarName) {
		template.setAttribute(InitializationScript.USER,
		        daemonConfiguration.getDaemonUser());
		template.setAttribute(InitializationScript.APPLICATION_NAME,
		        applicationConfiguration.getApplicationName());
		template.setAttribute(InitializationScript.APPLICATION_VERSION,
		        applicationConfiguration.getApplicationVersion());
		template.setAttribute(InitializationScript.APPLICATION_MAIN_CLASS,
		        applicationConfiguration.getMainClass());
		template.setAttribute(InitializationScript.APPLICATION_ARGUMENTS,
		        applicationConfiguration.getArguments());
		template.setAttribute(
		        InitializationScript.TARGET_SYSTEM_APPLICATION_LOCATION,
		        targetSystemConfiguration.getApplicationJarLocation());
		template.setAttribute(
		        InitializationScript.TARGET_SYSTEM_DAEMON_JAR_LOCATION,
		        targetSystemConfiguration.getDaemonJarLocation());
		template.setAttribute(InitializationScript.TARGET_SYSTEM_JAVA_HOME,
		        targetSystemConfiguration.getJavaHome());

		template.setAttribute(InitializationScript.DAEMON_JAR_NAME,
		        daemonJarName);
		template.setAttribute(InitializationScript.DELAY,
		        daemonConfiguration.getDelayInMillis());
	}
}
