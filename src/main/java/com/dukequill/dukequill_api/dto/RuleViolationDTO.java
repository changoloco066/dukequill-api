package com.dukequill.dukequill_api.dto;

public class RuleViolationDTO {
    private String rule;
    private String message;
    private int line;
    private int position;

    RuleViolationDTO(String rule, String message, int line, int position){
        this.rule = rule;
        this.message = message;
        this.line = line;
        this.position = position;
    }

    public String getRule(){
        return rule;
    }

    public String getMessage(){
        return message;
    }

    public int getLine(){
        return line;
    }

    public int getPosition(){
        return position;
    }

    public void setRule(String rule){
        this.rule = rule;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public void setLine(int line){
        this.line = line;
    }

    public void setPosition(int position){
        this.position = position;
    }

}
