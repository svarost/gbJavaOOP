package notebook.data;

import java.util.List;

public interface Repository {
    List<Note> getAllNotes();
    List<String> getTitleNotes();
    List<Integer> getIDNotes();
    String creatNote(Note note);
    String updateNote(Note note);
    void deleteNote(Note note);
}
