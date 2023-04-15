package notebook.data;

import java.util.List;

public interface FileOperation {
    String readAllLines();
    void saveAllLines(List<String> lines);
}
