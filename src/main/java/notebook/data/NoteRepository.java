package notebook.data;

import java.util.List;

public interface NoteRepository {
    List<Note> getAllNotes();
    String creatNote(Note note);
    String updateNote(Note note);
    void deleteNote(Note note);
}
