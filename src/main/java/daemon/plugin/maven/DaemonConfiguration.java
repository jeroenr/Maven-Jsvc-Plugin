package daemon.plugin.maven;

public final class DaemonConfiguration {
	/**
	 * @parameter expression="${daemonUser}" default-value="root"
	 * @readonly
	 */
	private String daemonUser;

	/**
	 * @parameter expression="${delayInMillis}" default-value=20
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
