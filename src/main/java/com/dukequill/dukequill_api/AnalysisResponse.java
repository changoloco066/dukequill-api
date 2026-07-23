package com.dukequill.dukequill_api;

import java.util.List;

import com.dukequill.dukequill_api.dto.AccentErrorDTO;
import com.dukequill.dukequill_api.dto.RuleViolationDTO;
import com.dukequill.dukequill_api.dto.SpellErrorDTO;

public class AnalysisResponse {
    private List<SpellErrorDTO> spellErrors;
    private List<RuleViolationDTO> ruleViolations;
    private List<AccentErrorDTO> accentErrors;

    // constructor 
    AnalysisResponse(List<SpellErrorDTO> spellErrors, List<RuleViolationDTO> ruleViolations, List<AccentErrorDTO> accentErrors ){
        this.spellErrors = spellErrors;
        this.ruleViolations = ruleViolations;
        this.accentErrors = accentErrors;
    }

    // getters
    public List<SpellErrorDTO> getSpellErrors(){
        return spellErrors;
    }

    public List<RuleViolationDTO> getRuleViolations(){
        return ruleViolations;
    }

    public List<AccentErrorDTO> getAccentErrors(){
        return accentErrors;
    }

    // setters
    public void setSpellErrors(List<SpellErrorDTO> spellErrors) {
        this.spellErrors = spellErrors;
    }

    public void setRuleViolations(List<RuleViolationDTO> ruleViolations) {
        this.ruleViolations = ruleViolations;
    }

    public void setAccentErrors(List<AccentErrorDTO> accentErrors) {
        this.accentErrors = accentErrors;
    }

}