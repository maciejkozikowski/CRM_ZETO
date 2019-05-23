package oby_na_trzy.crm.resource;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class RestObject {

    private LocalDateTime timestamp;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
