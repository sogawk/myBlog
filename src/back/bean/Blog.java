package back.bean;

public class Blog {
    int id;
    int userId;
    String title;
    String concent;
    String sign;
    String kind;
    int allowView;
    String creatTime;
    int views;
    int kindId;
    int signId;

    public Blog() {
    }

    public Blog(int id, int userId, String title, String concent, String sign, String kind, int allowView, String creatTime, int views, int kindId, int signId) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.concent = concent;
        this.sign = sign;
        this.kind = kind;
        this.allowView = allowView;
        this.creatTime = creatTime;
        this.views = views;
        this.kindId = kindId;
        this.signId = signId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getConcent() {
        return concent;
    }

    public void setConcent(String concent) {
        this.concent = concent;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getAllowView() {
        return allowView;
    }

    public void setAllowView(int allowView) {
        this.allowView = allowView;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getKindId() {
        return kindId;
    }

    public void setKindId(int kindId) {
        this.kindId = kindId;
    }

    public int getSignId() {
        return signId;
    }

    public void setSignId(int signId) {
        this.signId = signId;
    }
}

