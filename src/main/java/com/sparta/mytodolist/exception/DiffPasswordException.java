package com.sparta.mytodolist.exception;

import lombok.Getter;

@Getter
public class DiffPasswordException extends RuntimeException{
    public DiffPasswordException() {
        super("비밀번호가 일치하지 않습니다.");
    }
}
