package daemon.plugin.maven;

import static org.mockito.BDDMockito.given;

import java.util.Collections;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.DirectFieldAccessor;

@RunWith(MockitoJUnitRunner.class)
public class JsvcMojoTest {

	@Mock
	private MavenProject mavenProject;

	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();

	private JsvcMojo jsvcMojo;

	@Before
	public void setUp() throws Exception {
		jsvcMojo = new JsvcMojo();

		DirectFieldAccessor directFieldAccessor = new DirectFieldAccessor(
		        jsvcMojo);
		directFieldAccessor.setPropertyValue("mavenProject", mavenProject);
		directFieldAccessor.setPropertyValue("projectBuildDirectory",
		        temporaryFolder.newFolder("target"));

	}

	@Test(expected = MojoExecutionException.class)
	public void shouldThrowExceptionOnCommonsDaemonArtifactNotFound()
	        throws Exception {
		given(mavenProject.getArtifactMap()).willReturn(
		        Collections.<String, Artifact> emptyMap());
		jsvcMojo.execute();
	}
}
