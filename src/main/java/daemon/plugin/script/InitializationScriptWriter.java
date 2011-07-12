package daemon.plugin.script;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class InitializationScriptWriter {
    private final InitializationScript initializationScript;

    public InitializationScriptWriter(InitializationScript initializationScript) {
        this.initializationScript = initializationScript;
    }

    public void writeToExecutableFile(File outputDirectory) throws IOException {
        File outputFile = new File(outputDirectory, initializationScript.getFileName());
        outputFile.setExecutable(true);
        outputFile.setReadable(true);
        FileUtils.writeStringToFile(outputFile, initializationScript.getContentAsString());
    }
}
