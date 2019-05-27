package back.bean;

public class SysNote {
    int id;
    String time;
    String content;

    public SysNote(){}

    public SysNote(int id, String time, String content) {
        this.id = id;
        this.time = time;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

