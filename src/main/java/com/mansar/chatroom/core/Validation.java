package com.mansar.chatroom.core;

public final class Validation {
    public static final String PASSWORD = "/^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,30}$/";
    private Validation() {}
}
