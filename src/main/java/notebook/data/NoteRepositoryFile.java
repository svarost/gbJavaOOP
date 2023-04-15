package notebook.data;

import java.util.ArrayList;
import java.util.List;

public class NoteRepositoryFile implements NoteRepository {
    private FileOperation fileOperation;


    public NoteRepositoryFile(FileOperation fileOperation) {
        this.fileOperation = fileOperation;

    }

    @Override
    public List<Note> getAllNotes() {
        List<Note> notes = new ArrayList<>();
        List<String>

        return null;
    }

    @Override
    public String creatNote(Note note) {
        return null;
    }

    @Override
    public String updateNote(Note note) {
        return null;
    }

    @Override
    public void deleteNote(Note note) {

    }
}
