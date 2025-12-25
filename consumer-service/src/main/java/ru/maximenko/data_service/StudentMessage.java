package ru.maximenko.data_service;

import lombok.Data;
import java.time.Instant;

@Data
public class StudentMessage {
    private String fullName;
    private String passport;
    private Instant createdAt;
}
