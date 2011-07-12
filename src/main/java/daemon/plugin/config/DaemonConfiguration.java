package daemon.plugin.config;

public final class DaemonConfiguration {
    /**
     * @parameter
     *      expression="${user}"
     *      default-value="root"
     * @readonly
     */
    private String daemonUser;

    /**
     * @parameter
     *      expression="${delay}"
     *      default-value=20
     * @readonly
     */
    private long delayInMillis;

    public String getDaemonUser() {
        return daemonUser;
    }

    public long getDelayInMillis() {
        return delayInMillis;
    }
}
