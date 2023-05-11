package notebook.data;

import java.io.File;

import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RepositoryFile implements Repository {
    private File dirOperation;
    private File[] filesOperation;
    private FileOperation fileOperation;


    public RepositoryFile(String dir, FileOperation fileOperation) {
        dirOperation = new File(getClass().getClassLoader().getResource(dir).getFile());
        filesOperation = dirOperation.listFiles();
        this.fileOperation = fileOperation;
    }

    @Override
    public List<Note> getAllNotes() {
        List<Note> notes = new ArrayList<>();
        for (File file : filesOperation) {
            Note note = new Note(FilenameUtils.removeExtension((file.getName())));
            note.setText(fileOperation.readFile(file));
        }
        return notes;
    }


    @Override
    public List<Integer> getIDNotes() {
        List<Integer> ids = new ArrayList<>();
        for (Note note : getAllNotes()) {
            ids.add(note.getId());
        }
        return ids;
    }

    @Override
    public List<String> getTitleNotes() {
        List<String> titles = new ArrayList<>();
        for (File file : filesOperation) {
            titles.add(FilenameUtils.removeExtension(file.getName()));
        }
        return titles;
    }

    @Override
    public String creatNote(Note note) {
        List<String> noteTitles = getTitleNotes();
        if (!noteTitles.contains(note.getTitle())) {
            try {
                fileOperation.saveFile(note);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return "Note saved!";
    }

    @Override
    public String updateNote(Note note) {
        File noteFile;
        for (File file : filesOperation) {
            if (file.getName().equals(note.getTitle() + ".txt"));
            noteFile = file;
        }


        return null;
    }

    @Override
    public void deleteNote(Note note) {

    }
}
