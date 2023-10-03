package com.gt.basketballapp.exception;


public class CourtNotFoundException extends RuntimeException {
    public CourtNotFoundException(String identifier){
        super("court " + identifier + " not found");
    }
}
