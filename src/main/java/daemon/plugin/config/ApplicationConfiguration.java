package daemon.plugin.config;

public final class ApplicationConfiguration {

    /**
     * @parameter
     *      expression="${name}"
     *      default-value="${project.artifactId}"
     * @readonly
     */
    private String applicationName;

    /**
     * @parameter
     *      expression="${version}"
     *      default-value="${project.version}"
     * @readonly
     */
    private String applicationVersion;

    /**
     * @parameter
     *      expression="${scriptName}"
     *      default-value="${project.artifactId}"
     * @readonly
     */
    private String scriptName;


    public String getApplicationName() {
        return applicationName;
    }

    public String getApplicationVersion() {
        return applicationVersion;
    }

    public String getScriptName() {
        return scriptName;
    }
}
