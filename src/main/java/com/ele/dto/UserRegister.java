package com.ele.dto;

/**
 * Created by Administrator on 2017/7/10 0010.
 */
public class UserRegister {
    private String msgUsername;
    private String msgPassword;
    private String msg;

    public String getMsgUsername() {
        return msgUsername;
    }

    public void setMsgUsername(String msgUsername) {
        this.msgUsername = msgUsername;
    }

    public String getMsgPassword() {
        return msgPassword;
    }

    public void setMsgPassword(String msgPassword) {
        this.msgPassword = msgPassword;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "UserRegister{" +
                "msgUsername='" + msgUsername + '\'' +
                ", msgPassword='" + msgPassword + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
