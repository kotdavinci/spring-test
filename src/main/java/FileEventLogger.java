import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileEventLogger implements EventLogger {
    protected String fileName;
    protected File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }


    public void logEvent(Event event) {
        try {
//            init(); // this method invoke in bean, not here
            FileUtils.writeStringToFile(file, event.toString(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void init() throws IOException {
        this.file = new File(fileName);
        if (!file.canWrite()) throw new IOException("can't write");
    }
}
