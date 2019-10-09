package com.epam.spring.loggers;

import com.epam.spring.events.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {

    private String path;
    private String encoding;
    private File logfile;

    FileEventLogger(String path, String encoding){
        this.path = path;
        this.encoding = encoding;
    }

    private void init() throws IOException {
        this.logfile = new File(path);
        if(!logfile.canWrite()){
            throw new IOException("Can't write file");
        }
    }

    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(logfile, event.toString(), encoding);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
