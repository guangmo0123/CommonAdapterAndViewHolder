package billy.snxi.mycommonadapterandviewholder.bean;

public class Bean {
    private String title;
    private String desc;
    private String date;
    private String phone;

    public Bean() {
    }

    public Bean(String title, String desc, String date, String phone) {
        this.title = title;
        this.desc = desc;
        this.date = date;
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
