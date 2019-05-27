package back.bean;

public class Comment {
    int id;
    int tableId;
    int userId;
    String content;

    public Comment(){}

    public Comment(int id, int tableId, int userId, String content) {
        this.id = id;
        this.tableId = tableId;
        this.userId = userId;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
