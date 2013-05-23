package daemon.plugin.maven;

public final class InitializationScriptConfiguration {
    private final ApplicationConfiguration applicationConfiguration;
    private final DaemonConfiguration daemonConfiguration;
    private final TargetSystemConfiguration targetSystemConfiguration;
    private final String daemonJarName;

    public InitializationScriptConfiguration(ApplicationConfiguration applicationConfiguration,
                                             DaemonConfiguration daemonConfiguration,
                                             TargetSystemConfiguration targetSystemConfiguration, String daemonJarName) {
        this.applicationConfiguration = applicationConfiguration;
        this.daemonConfiguration = daemonConfiguration;
        this.targetSystemConfiguration = targetSystemConfiguration;
        this.daemonJarName = daemonJarName;
    }

    public ApplicationConfiguration getApplicationConfiguration() {
        return applicationConfiguration;
    }

    public DaemonConfiguration getDaemonConfiguration() {
        return daemonConfiguration;
    }

    public TargetSystemConfiguration getTargetSystemConfiguration() {
        return targetSystemConfiguration;
    }

    public String getDaemonJarName() {
        return daemonJarName;
    }
}
