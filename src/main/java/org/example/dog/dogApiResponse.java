package org.example.dog;

import java.util.List;

public class dogApiResponse {
    List<String> message;
    String status;


    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


