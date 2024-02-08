package org.example;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

class JacksonTest {
    ObjectMapper objectMapper = new ObjectMapper();

    Chat retrieveInfoFromJson() throws IOException {

        try {
            // Deserialize JSON from file into Chat object
            Chat chat = objectMapper.readValue(new File("input.json"), Chat.class);

            // Access individual messages
            for (Message message : chat.getMessages()) {
                // Retrieve text, sender, date, and emoji
                String text = message.getText();
                String sender = message.getSender();
                String date = message.getDate();
                String emoji = message.getEmoji();

                // Print retrieved information
                System.out.println("Message Text: " + text);
                System.out.println("Sender: " + sender);
                System.out.println("Date: " + date);
                System.out.println("Emoji: " + emoji);
                System.out.println();
            }
            return chat;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    void writeChatToFile(Chat chat) {
        // Create an ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();
        String outputPath = "output.json";

        try {
            // Write the chat object to the file in JSON format
            objectMapper.writeValue(new File(outputPath), chat);

            System.out.println("Chat data has been written to " + outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}