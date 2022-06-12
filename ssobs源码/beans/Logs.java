package lab1.beans;

public class Logs {
    String userId;
    String times;
    String logContext;

    public Logs() {
        super();
    }

    public String getUserId() { return userId; }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getTimes() { return times; }
    public void setTimes(String times) { this.times = times; }
    public String getLogContext() {
        return logContext;
    }
    public void setLogContext(String logContext) {
        this.logContext = logContext;
    }
    public Logs(String userId,String times,String logContext) {
        super();
        this.times = times;
        this.userId = userId;
        this.logContext = logContext;
    }
}
