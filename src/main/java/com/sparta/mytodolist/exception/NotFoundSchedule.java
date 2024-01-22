package com.sparta.mytodolist.exception;

public class NotFoundSchedule extends RuntimeException{
    public NotFoundSchedule() {
        super("글이 존재하지 않습니다.");
    }
}
