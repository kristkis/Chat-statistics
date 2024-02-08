package org.example;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {
        JacksonTest prepareFile = new JacksonTest();
        Chat messageList = null;
        try {
            messageList = prepareFile.retrieveInfoFromJson();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //prepareFile.writeChatToFile(messageList);
    }
}