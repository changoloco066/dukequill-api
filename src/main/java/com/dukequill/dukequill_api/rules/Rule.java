package com.dukequill.dukequill_api.rules;

import java.util.List;
import com.dukequill.dukequill_api.lexer.Token;

public interface Rule {
    List<RuleViolation> check(List<Token> tokens);
    String getRuleName();
}
