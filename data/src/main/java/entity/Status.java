package entity;

/**
 * Created by Imant on 27.05.17.
 */
public enum Status {
    FREE("free"), BLOCKED("blocked");

    private String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
