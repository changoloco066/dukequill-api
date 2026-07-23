package com.dukequill.dukequill_api.dto;
import java.util.List;

public class SpellErrorDTO {
    private String word;
    private int line;
    private int position;
    private List<String> suggestions;

    SpellErrorDTO(String word, int line, int position, List<String> suggestions){
        this.word = word;
        this.line = line;
        this.position = position;
        this.suggestions = suggestions;
    }

    public String getWord(){
        return word;
    }

    public int getLine(){
        return line;
    }

    public int getPosition(){
        return position;
    }

    public List<String> getSuggestions() {
        return suggestions;
    }

    public void setWord(String word) { 
        this.word = word; 
    }

    public void setLine(int line) { 
        this.line = line; 
    }

    public void setPosition(int position) { 
        this.position = position; 
    }

    public void setSuggestions(List<String> suggestions) { 
        this.suggestions = suggestions; 
    }
    
}
