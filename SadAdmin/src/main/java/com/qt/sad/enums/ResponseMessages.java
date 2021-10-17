/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.sad.enums;

/**
 *
 * @author LENOVO
 */
public enum ResponseMessages {
    DATA_ADDED("Data added successfully!"),
    DATA_UPDATED("Data updated successfully!"),
    DATA_DELETED("Data deleted successfully!"),
    OPERATION_FAILED("Operation Failed"),
    LOGIN_SUCCESS("Loged in succesfully"),
    LOGIN_FAILED("Incorrect username or password"),
    USER_NOT_FOUND("User not found"),
    BLOCKED_ACCOUNT("Your account is blocked because of multiple invalid attempts"),
    FILE_SAVED("File saved"),
    FILE_DELETED("File deleted"),
    FILE_UPDATED("File updated"),
    FILE_DOWNLOADED("File downloaded"),
    FILE_NOT_FOUND("File not found"),
    PROJECT_PATH("D:\\QaswaTech\\WORKSPACE\\files\\projects\\"),
    DATABASE_PATH("D:\\QaswaTech\\WORKSPACE\\files\\databases\\");

    private String responseMessages;

    private ResponseMessages(String responseMessages) {
        this.responseMessages = responseMessages;
    }

    public String getResponseMessages() {
        return responseMessages;
    }

    public void setResponseMessages(String responseMessages) {
        this.responseMessages = responseMessages;
    }

}
