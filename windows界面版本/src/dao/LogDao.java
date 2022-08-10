package dao;
import beans.Logs;

import java.util.List;

public interface LogDao {
    public List<Logs> queryLog(String userId);
    public void addLog(Logs log);
}
