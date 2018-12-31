package com.dataht.event.model.view;

public class Message {

    private String msg;

    public Message() {
    }

    public Message(String msg) {
        this.msg = msg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        return msg != null ? msg.equals(message.msg) : message.msg == null;
    }

    @Override
    public int hashCode() {
        return msg != null ? msg.hashCode() : 0;
    }

    public String getMsg() {

        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
