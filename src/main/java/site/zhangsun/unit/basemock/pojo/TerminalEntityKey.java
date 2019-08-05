package site.zhangsun.unit.basemock.pojo;

public class TerminalEntityKey {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }
}
