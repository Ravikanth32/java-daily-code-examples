package com.patternhub.java8features.java8scenariofiltersexample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RuleService {
    public List<Rule> rules = new ArrayList<>();

    public RuleService() {
        init();
    }

    public void init() {
        Rule rule1 = new Rule("rule1", Arrays.asList("ALL", "EQ"), Arrays.asList("IOI", "ALL"));
        Rule rule2 = new Rule("rule2", Arrays.asList("AQ", "ALL"), Arrays.asList("DL", "OR"));
        Rule rule3 = new Rule("rule3", Arrays.asList("EQ", "GP"), Arrays.asList("IOI", "TQ"));
        Rule rule4 = new Rule("rule4", Arrays.asList("DP", "GP"), Arrays.asList("PL", "ALL"));
        Rule rule5 = new Rule("rule5", Arrays.asList("SQ", "LQ"), Arrays.asList("ALL", "OK"));
        Rule rule6 = new Rule("rule6", Arrays.asList("ALL", "ZQ"), Arrays.asList("IOI", "ALL"));
        Rule rule7 = new Rule("rule7", Arrays.asList("ALL"), Arrays.asList("IOI", "ALL"));
        Rule rule8 = new Rule("rule8", Arrays.asList("ALL"), Arrays.asList("IOI", "ALL"));
        rules.add(rule1);
        rules.add(rule2);
        rules.add(rule3);
        rules.add(rule4);
        rules.add(rule5);
        rules.add(rule6);
        rules.add(rule7);
        rules.add(rule8);
    }

    public List<Rule> getAllFilteredRules(AdvancedFilter advancedFilter) {
        System.out.println("Before Filter Size -> " + rules.size());
        Predicate<Rule> programPredicate = rule -> {
            FiledFilter program = advancedFilter.getProgram();
            if (program.getFilterOperator().equals("equals")) {
                System.out.println("-----------------> " + rule.getRuleName());
                return rule.getPrograms().stream()
                        .anyMatch(item -> {
                            System.out.println("Rule Programs Value " + item + " Filter Value " + program.getFilterValue()
                                    + " Condition " + (item.equalsIgnoreCase(program.getFilterValue()) || item.equalsIgnoreCase("ALL")));
                            return item.equalsIgnoreCase(program.getFilterValue()) || item.equalsIgnoreCase("all");
                        });
            }
            if (program.getFilterOperator().equals("starts")) {
                return rule.getPrograms().stream()
                        .anyMatch(item -> item.toLowerCase().startsWith(program.getFilterValue().toLowerCase()));
            }
            if (program.getFilterOperator().equals("contains")) {
                return rule.getPrograms().stream()
                        .anyMatch(item -> item.toLowerCase().contains(program.getFilterValue().toLowerCase()));
            }
            return true;
        };
        List<Rule> filteredRules = rules.stream()
                .filter(programPredicate).collect(Collectors.toList());
        System.out.println("Before Filter Size -> " + filteredRules.size());
        return filteredRules;
    }

}
