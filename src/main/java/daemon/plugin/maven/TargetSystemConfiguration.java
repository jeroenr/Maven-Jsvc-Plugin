package daemon.plugin.maven;

import java.io.File;

public final class TargetSystemConfiguration {

	/**
	 * @parameter expression="${javaHome}"
	 *            default-value="/usr/lib/jvm/java-6-sun"
	 * @readonly
	 */
	private File javaHome;

	/**
	 * @parameter expression="${applicationJarLocation}"
	 *            default-value="/var/lib/${project.artifactId}"
	 * @readonly
	 */
	private File applicationJarLocation;

	/**
	 * @parameter expression="${daemonJarLocation}" default-value="/usr/lib"
	 * @readonly
	 */
	private File daemonJarLocation;

	/**
	 * @parameter expression="${initializationScriptLocation}"
	 *            default-value="/etc/init.d/${project.artifactId}"
	 * @readonly
	 */
	private File initializationScriptLocation;

	public File getJavaHome() {
		return javaHome;
	}

	public File getApplicationJarLocation() {
		return applicationJarLocation;
	}

	public File getDaemonJarLocation() {
		return daemonJarLocation;
	}

	public File getInitializationScriptLocation() {
		return initializationScriptLocation;
	}
}
