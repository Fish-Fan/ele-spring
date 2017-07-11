package com.ele.dto;

/**
 * Created by Administrator on 2017/7/10 0010.
 */
public class UserLogin extends UserRegister{
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "status=" + status +
                '}';
    }
}
