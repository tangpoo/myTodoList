package com.sparta.mytodolist.exception;

import lombok.Getter;

@Getter
public class NotMatchIdException extends RuntimeException{

    public NotMatchIdException(){
        super("ID가 일치하지 않습니다.");
    }
}
