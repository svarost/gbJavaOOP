package notebook.data;

public class Note {
    static Integer count;
    Integer id;
    String title;
    String text;

    public Note() {
        if (count != null) {
            count = 0;
        } else count++;
        setId();
    }

    public Note(String title) {
        this();
        this.title = title;
    }

    public Note(String title, String text) {
        this();
        this.title = title;
        this.text = text;
    }

    void setId() {
        if (count.equals(null)) {
            id = 0;
        } else id += 1;
    }
}
