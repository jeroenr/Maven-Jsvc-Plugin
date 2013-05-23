package daemon.plugin.maven;

public final class ApplicationConfiguration {

	/**
	 * @parameter expression="${name}" default-value="${project.artifactId}"
	 * @readonly
	 */
	private String name;

	/**
	 * @parameter expression="${version}" default-value="${project.version}"
	 * @readonly
	 */
	private String version;

	/**
	 * @parameter expression="${scriptName}"
	 *            default-value="${project.artifactId}"
	 * @readonly
	 */
	private String scriptName;

	/**
	 * @parameter expression="${mainClass}"
	 * @readonly
	 */
	private String mainClass;

	/**
	 * @parameter expression="${arguments}"
	 * @readonly
	 */
	private String arguments;

	public String getApplicationName() {
		return name;
	}

	public String getApplicationVersion() {
		return version;
	}

	public String getScriptName() {
		return scriptName;
	}

	public String getMainClass() {
		return mainClass;
	}

	public String getArguments() {
		return arguments;
	}
}
