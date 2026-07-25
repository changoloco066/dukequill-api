package com.dukequill.dukequill_api.analyzer;


import com.dukequill.dukequill_api.lexer.Token;
import com.dukequill.dukequill_api.lexer.TokenType;

public class SpellErrors {
    private final Token token;
 
    public SpellErrors(Token token) {
       this.token = token;
    }
 
  
    public String getLexeme() {
        return token.getLexeme();
    }

    public TokenType getType() {
        return token.getType();
    }

    public int getPosition() {
        return token.getPosition();
    }

    public int getLine() {
        return token.getLine();
    }

    @Override
    public String toString() {
        return token.getLexeme() + " | " + token.getType() + " | " + token.getPosition() + " | " + token.getLine();
    }
}
