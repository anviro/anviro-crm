package org.anviro.crm.common.beans.authentication;

import java.util.Date;

public class LogBean {

    private Long id;
    private String username;
    private String message;
    private Date date;

    public LogBean() {
    }

    public LogBean(Long id, String username, String message, Date date) {
        this.id = id;
        this.username = username;
        this.message = message;
        this.date = date;
    }

    public LogBean(String username, String message, Date date) {
        this.username = username;
        this.message = message;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
