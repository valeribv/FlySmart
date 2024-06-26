package bg.reachup.edu.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErrorDto {
    private Date timestamp;
    private List<String> errors = new ArrayList<>();

    private int status;

    public ErrorDto(Date timestamp, List<String> errors, int status) {
        this.timestamp = timestamp;
        this.errors = errors;
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
