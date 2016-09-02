package blog.services;

/**
 * Created by bzhou on 02/09/16.
 */
public interface NotificationService {
    void addInfoMessage(String msg);
    void addErrorMessage(String msg);
}
