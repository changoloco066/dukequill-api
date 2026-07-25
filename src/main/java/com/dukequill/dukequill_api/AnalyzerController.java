package com.dukequill.dukequill_api;

import org.springframework.web.bind.annotation.*;
import com.dukequill.dukequill_api.lexer.Lexer;
import com.dukequill.dukequill_api.dictionary.Dictionary;
import com.dukequill.dukequill_api.dto.AccentErrorDTO;
import com.dukequill.dukequill_api.dto.RuleViolationDTO;
import com.dukequill.dukequill_api.analyzer.SpellChecker;
import com.dukequill.dukequill_api.analyzer.SpellErrors;
import com.dukequill.dukequill_api.analyzer.MorphAnalyzer;
import com.dukequill.dukequill_api.analyzer.AccentChecker;
import com.dukequill.dukequill_api.analyzer.AccentViolations;
import com.dukequill.dukequill_api.rules.RuleEngine;
import com.dukequill.dukequill_api.rules.RuleViolation;
import com.dukequill.dukequill_api.lexer.Token;
import com.dukequill.dukequill_api.dto.SpellErrorDTO;


import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api")
public class AnalyzerController {

    private final Lexer lexer;
    private final Dictionary dictionary;
    private final SpellChecker checker;
    private final RuleEngine ruleEngine;
    private final AccentChecker accentChecker;

    public AnalyzerController() throws Exception {
        lexer = new Lexer();
        dictionary = new Dictionary();
        dictionary.loadDictionary();
        MorphAnalyzer morphAnalyzer = new MorphAnalyzer();
        checker = new SpellChecker(dictionary, morphAnalyzer);
        ruleEngine = new RuleEngine(morphAnalyzer);
        accentChecker = new AccentChecker();
    }

    @PostMapping("/analyze")
    public AnalysisResponse analyze(@RequestBody String text) throws Exception {
        
        List<Token> tokens = lexer.analyze(text);
        List<SpellErrors> spellErrors = checker.check(tokens);
        List<RuleViolation> ruleViolation = ruleEngine.check(tokens);
        List<AccentViolations> accentErrors = accentChecker.check(text);

        List<AccentErrorDTO> accentDTOs = new ArrayList<>();
        for(AccentViolations a : accentErrors) {
            accentDTOs.add(new AccentErrorDTO(
                a.getOriginalText(),
                a.getFromPos(),
                a.getSuggestedReplacements()
            ));
        }

        List<RuleViolationDTO> ruleDTOs = new ArrayList<>();
        for(RuleViolation r: ruleViolation){
            ruleDTOs.add(new RuleViolationDTO(
                r.getRuleName(),
                r.getMessage(),
                r.getLine(),
                r.getPosition()
            ));
        }

        List<SpellErrorDTO> spellDTOs = new ArrayList<>();
        for(SpellErrors s : spellErrors){   
            spellDTOs.add(new SpellErrorDTO(
                s.getLexeme(),
                s.getPosition(),
                s.getLine(),
                checker.getSuggestions(s.getLexeme())
            ));
        }
        return new AnalysisResponse(spellDTOs, ruleDTOs, accentDTOs);
    }
}