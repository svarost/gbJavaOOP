package notebook.data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperationTXT implements FileOperation {
    private String dirName;

    public FileOperationTXT(String dirName) {
        this.dirName = String.valueOf(new File(getClass().getClassLoader().getResource(dirName).getFile()));
        try (FileWriter writer = new FileWriter(dirName, true)) {
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String readFile(File file) {
        List<String> lines = new ArrayList<>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return String.join(System.lineSeparator(), lines);
    }


    @Override
    public void saveFile(Note note) {
        try (FileWriter writer =
                     new FileWriter(dirName + note.getTitle() + ".txt", false)) {
            writer.write(note.getText());
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
