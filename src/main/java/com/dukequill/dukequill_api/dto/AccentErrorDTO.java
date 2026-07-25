package com.dukequill.dukequill_api.dto;

public class AccentErrorDTO {
    private String word;
    private String suggestion;
    private int position;

    public AccentErrorDTO(String word, int position, String suggestion){
        this.word = word;
        this.position = position;
        this.suggestion = suggestion;
    }
    
    public String getWord(){
        return word;
    }

    public String getSuggestion(){
        return suggestion;
    }

    public int getPosition(){
        return position;
    }
    
    public void setWord(String word){
        this.word = word;
    }

    public void setSuggestions(String suggestion){
        this.suggestion = suggestion;
    }

    public void setPosition(int position){
        this.position = position;
    }

}
