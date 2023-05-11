package notebook.data;

import java.io.File;
import java.io.IOException;

public interface FileOperation {
    String readFile(File file);
    void  saveFile(Note note) throws IOException;
}
