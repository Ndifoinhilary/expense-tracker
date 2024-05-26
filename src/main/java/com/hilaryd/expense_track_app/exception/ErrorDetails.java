package com.hilaryd.expense_track_app.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
public class ErrorDetails {
    private LocalDateTime localDateTime;
    private String message;
    private String errorCode;
    private String details;
}
