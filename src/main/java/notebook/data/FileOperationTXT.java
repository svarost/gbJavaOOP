package notebook.data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperationTXT implements FileOperation {
    private File dir = new File(getClass().getClassLoader().getResource("txtDir").getFile());
    private String fileName;

    public FileOperationTXT(String fileName) {
        this.fileName = "" + fileName;
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String readAllLines() {
        List<String> lines = new ArrayList<>();
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
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
    public void saveAllLines(List<String> lines) {
        try (FileWriter writer =  new FileWriter(fileName, false)) {
            for (String line : lines) {
                writer.write(line);
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<String> listNotes() {

    }
}
