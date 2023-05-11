package notebook.controllers;

import notebook.data.Note;
import notebook.data.Repository;

import java.util.List;

public class NoteController {
    final Repository repository;

    public NoteController(Repository repository) {
        this.repository = repository;
    }

    public void saveNote(Note note) {repository.creatNote(note);}

    public Note readNote(Integer noteID) throws Exception {
        List<Note> notes = repository.getAllNotes();
        for (Note note : notes) {
            if (note.getId().equals(noteID)) {
                return note;
            }
        }
        throw new Exception(String.format("Note with ID = %d not found.", noteID));
    }
}
