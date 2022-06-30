package com.patternhub.java8features.java8scenariofiltersexample;

import java.util.Arrays;

public class Testing {
    public static AdvancedFilter advancedFilter= new AdvancedFilter();
    public static AdvancedFilter startsWithAdvancedFilter= new AdvancedFilter();

    static {
//        advancedFilter.setProgram(new FiledFilter("EQ","equals"));
        //advancedFilter.setProduct(new FiledFilter("IOI","equals"));
//        startsWithAdvancedFilter.setProgram(new FiledFilter("EQ","equals"));
//        startsWithAdvancedFilter.setProgram(new FiledFilter("q","contains"));
        advancedFilter.setProgram(Arrays.asList("SQ","LQ"));
        advancedFilter.setProgram(Arrays.asList("IOI","TQ"));
    }
    public static void main(String[] args) {
        RuleService ruleService = new RuleService();
        //ruleService.getAllFilteredRules(advancedFilter);
        ruleService.getAllFilteredRules(advancedFilter);
    }
}


