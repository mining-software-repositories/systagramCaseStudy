package study.systagram;

import arcatch.ArCatchAPI;
import arcatch.dsl.compartment.grammar.Compartment;
import arcatch.dsl.rule.common.Criticality;
import arcatch.dsl.rule.common.DesignRule;

public class App 
{
	private static Compartment systagram;
	private static Compartment controller;
	private static Compartment service;
	private static Compartment repository;
	private static Compartment model;
	private static Compartment util;
	private static Compartment security;
    
    private static void checkRules() {	
    	DesignRule rule1_check_NoCA = ArCatchAPI
		.ruleBuilder()
		.antiDrift()
		.criticality(Criticality.WARNING)
		.compartiment(systagram)
		.constrainedTo("NoCA = 0.0")
		.build();
    	
    	DesignRule rule2_check_NoCI = ArCatchAPI
				.ruleBuilder()
				.antiDrift()
				.criticality(Criticality.WARNING)
				.compartiment(systagram)
				.constrainedTo("NoCI = 0.0")
				.build();
    	
    	DesignRule rule3_check_NoCRN = ArCatchAPI
				.ruleBuilder()
				.antiDrift()
				.criticality(Criticality.WARNING)
				.compartiment(systagram)
				.constrainedTo("NoCRN = 0.0")
				.build();
    	
    	DesignRule rule4_check_NoEH = ArCatchAPI
				.ruleBuilder()
				.antiDrift()
				.criticality(Criticality.WARNING)
				.compartiment(systagram)
				.constrainedTo("NoEH = 0.0")
				.build();
    	
    	DesignRule rule5_check_NoDR = ArCatchAPI
				.ruleBuilder()
				.antiDrift()
				.criticality(Criticality.WARNING)
				.compartiment(systagram)
				.constrainedTo("NoDR = 0.0")
				.build();
    	
    	DesignRule rule6_check_NoGR = ArCatchAPI
				.ruleBuilder()
				.antiDrift()
				.criticality(Criticality.WARNING)
				.compartiment(systagram)
				.constrainedTo("NoGH = 0.0")
				.build();
    
    	DesignRule rule7_check_NoGS = ArCatchAPI
				.ruleBuilder()
				.antiDrift()
				.criticality(Criticality.WARNING)
				.compartiment(systagram)
				.constrainedTo("NoGS = 0.0")
				.build();
    	
    	DesignRule rule8_check_NoNPB = ArCatchAPI
				.ruleBuilder()
				.antiDrift()
				.criticality(Criticality.WARNING)
				.compartiment(systagram)
				.constrainedTo("NoNPB = 0.0")
				.build();
    	
    	DesignRule rule9_check_NoOCA = ArCatchAPI
				.ruleBuilder()
				.antiDrift()
				.criticality(Criticality.WARNING)
				.compartiment(systagram)
				.constrainedTo("NoOCA = 0.0")
				.build();
    	DesignRule rule10_check_NoOC = ArCatchAPI
				.ruleBuilder()
				.antiDrift()
				.criticality(Criticality.WARNING)
				.compartiment(systagram)
				.constrainedTo("NoOC = 0.0")
				.build();
    	DesignRule rule11_check_NoSF = ArCatchAPI
				.ruleBuilder()
				.antiDrift()
				.criticality(Criticality.WARNING)
				.compartiment(systagram)
				.constrainedTo("NoSF = 0.0")
				.build();
    	DesignRule rule12_check_NoSKS = ArCatchAPI
				.ruleBuilder()
				.antiDrift()
				.criticality(Criticality.WARNING)
				.compartiment(systagram)
				.constrainedTo("NoSKS = 0.0")
				.build();
    	
    	// Abstractness violation
    	DesignRule rule13_check_Abstractness_violation = ArCatchAPI
				.ruleBuilder()
				.antiDrift()
				.criticality(Criticality.WARNING)
				.compartiment(systagram)
				.constrainedTo("(Ce / (Ce + Ca)) <= 0.3")
				.build();
    	
    	//Large Class according PMD tool: https://github.com/pmd/pmd/blob/master/pmd-java/src/main/java/net/sourceforge/pmd/lang/java/rule/design/DataClassRule.java
    	DesignRule rule14_check_Large_Class = ArCatchAPI
				.ruleBuilder()
				.antiDrift()
				.criticality(Criticality.WARNING)
				.compartiment(systagram)
				.constrainedTo("(((NoM + NoA) > 3) & (WMC < 31)) | (((NoM + NoA) > 5) & (WMC < 47))")
				.build();
    	//TooManyFields
    	DesignRule rule15_check_TooManyFields = ArCatchAPI
				.ruleBuilder()
				.antiDrift()
				.criticality(Criticality.WARNING)
				.compartiment(systagram)
				.constrainedTo("NoA > 15")
				.build();
    	
    	//TooManyMethods
    	DesignRule rule16_check_TooManyMethods = ArCatchAPI
				.ruleBuilder()
				.antiDrift()
				.criticality(Criticality.WARNING)
				.compartiment(systagram)
				.constrainedTo("NoM > 10")
				.build(); 
    	
		DesignRule ruleX1_check_controller = ArCatchAPI.ruleBuilder()
				.antiErosion()
				.criticality(Criticality.HIGH)
				.compartiment(controller)
				.mustCall(service, model, util)
				.build();
				
		DesignRule ruleX2_check_service = ArCatchAPI.ruleBuilder()
				.antiErosion()
				.criticality(Criticality.HIGH)
				.compartiment(service)
				.mustCall(repository, model)
				.build();
		
		
		DesignRule ruleX3_check_repository = ArCatchAPI.ruleBuilder()
				.antiErosion()
				.criticality(Criticality.HIGH)
				.compartiment(repository)
				.mustCall(model)
				.build();

    	
		ArCatchAPI.addRule(rule1_check_NoCA);	
		ArCatchAPI.addRule(rule2_check_NoCI);
		ArCatchAPI.addRule(rule3_check_NoCRN);		
		ArCatchAPI.addRule(rule4_check_NoEH);
		ArCatchAPI.addRule(rule5_check_NoDR);				
		ArCatchAPI.addRule(rule6_check_NoGR);
		ArCatchAPI.addRule(rule7_check_NoGS);
		ArCatchAPI.addRule(rule8_check_NoNPB);
		ArCatchAPI.addRule(rule9_check_NoOCA);		
		ArCatchAPI.addRule(rule10_check_NoOC);
		ArCatchAPI.addRule(rule11_check_NoSF);
		ArCatchAPI.addRule(rule12_check_NoSKS);						
		ArCatchAPI.addRule(rule13_check_Abstractness_violation);		
		ArCatchAPI.addRule(rule14_check_Large_Class);
		ArCatchAPI.addRule(rule15_check_TooManyFields);		
		ArCatchAPI.addRule(rule16_check_TooManyMethods);	
		ArCatchAPI.addRule(ruleX1_check_controller);
		ArCatchAPI.addRule(ruleX2_check_service);
		ArCatchAPI.addRule(ruleX3_check_repository);
		ArCatchAPI.check();
	}
	
	private static void checkSystagram140(String projectPath) {
		ArCatchAPI.setConfiguration(ArCatchAPI
				.configurationBuilder()
				.projectNameAndVersion("Systagram", "1.4.0")
				.projectPath(projectPath)				
				.build());
		
		systagram = ArCatchAPI
				.compartmentBuilder()
				.compartment("systagram")
				.matching("br.ufc.great.sysadmin.systagram.*")
				.build();

		controller = ArCatchAPI
				.compartmentBuilder()
				.compartment("controller")
				.matching("br.ufc.great.sysadmin.controller.*")
				.build();
	
		service = ArCatchAPI
				.compartmentBuilder()
				.compartment("service")
				.matching("br.ufc.great.sysadmin.serfvice.*")
				.build();
				
		repository = ArCatchAPI
				.compartmentBuilder()
				.compartment("repository")
				.matching("br.ufc.great.sysadmin.repository.*")
				.build();
		
		model = ArCatchAPI
				.compartmentBuilder()
				.compartment("model")
				.matching("br.ufc.great.sysadmin.model.*")
				.build();
		
		util = ArCatchAPI
				.compartmentBuilder()
				.compartment("util")
				.matching("br.ufc.great.sysadmin.util.*")
				.build();
		
		security = ArCatchAPI
				.compartmentBuilder()
				.compartment("security")
				.matching("br.ufc.great.sysadmin.security.*")
				.build();
		
		ArCatchAPI.addCompartment(systagram);	
		ArCatchAPI.addCompartment(controller);
		ArCatchAPI.addCompartment(service);
		ArCatchAPI.addCompartment(repository);
		ArCatchAPI.addCompartment(model);
		ArCatchAPI.addCompartment(util);
		ArCatchAPI.addCompartment(security);
	
		checkRules();
	}

	private static void checkSystagram141(String projectPath) {
		ArCatchAPI.setConfiguration(ArCatchAPI
				.configurationBuilder()
				.projectNameAndVersion("Systagram", "1.4.1")
				.projectPath(projectPath)				
				.build());
		
		systagram = ArCatchAPI
				.compartmentBuilder()
				.compartment("systagram")
				.matching("br.ufc.great.sysadmin.systagram.*")
				.build();

		controller = ArCatchAPI
				.compartmentBuilder()
				.compartment("controller")
				.matching("br.ufc.great.sysadmin.controller.*")
				.build();
	
		service = ArCatchAPI
				.compartmentBuilder()
				.compartment("service")
				.matching("br.ufc.great.sysadmin.serfvice.*")
				.build();
				
		repository = ArCatchAPI
				.compartmentBuilder()
				.compartment("repository")
				.matching("br.ufc.great.sysadmin.repository.*")
				.build();
		
		model = ArCatchAPI
				.compartmentBuilder()
				.compartment("model")
				.matching("br.ufc.great.sysadmin.model.*")
				.build();
		
		util = ArCatchAPI
				.compartmentBuilder()
				.compartment("util")
				.matching("br.ufc.great.sysadmin.util.*")
				.build();
		
		security = ArCatchAPI
				.compartmentBuilder()
				.compartment("security")
				.matching("br.ufc.great.sysadmin.security.*")
				.build();
		
		ArCatchAPI.addCompartment(systagram);	
		ArCatchAPI.addCompartment(controller);
		ArCatchAPI.addCompartment(service);
		ArCatchAPI.addCompartment(repository);
		ArCatchAPI.addCompartment(model);
		ArCatchAPI.addCompartment(util);
		ArCatchAPI.addCompartment(security);

		checkRules();
	}

	private static void checkSystagram150(String projectPath) {
		ArCatchAPI.setConfiguration(ArCatchAPI
				.configurationBuilder()
				.projectNameAndVersion("Systagram", "1.5.0")
				.projectPath(projectPath)				
				.build());
		
		systagram = ArCatchAPI
				.compartmentBuilder()
				.compartment("systagram")
				.matching("br.ufc.great.sysadmin.systagram.*")
				.build();

		controller = ArCatchAPI
				.compartmentBuilder()
				.compartment("controller")
				.matching("br.ufc.great.sysadmin.controller.*")
				.build();
	
		service = ArCatchAPI
				.compartmentBuilder()
				.compartment("service")
				.matching("br.ufc.great.sysadmin.serfvice.*")
				.build();
				
		repository = ArCatchAPI
				.compartmentBuilder()
				.compartment("repository")
				.matching("br.ufc.great.sysadmin.repository.*")
				.build();
		
		model = ArCatchAPI
				.compartmentBuilder()
				.compartment("model")
				.matching("br.ufc.great.sysadmin.model.*")
				.build();
		
		util = ArCatchAPI
				.compartmentBuilder()
				.compartment("util")
				.matching("br.ufc.great.sysadmin.util.*")
				.build();
		
		security = ArCatchAPI
				.compartmentBuilder()
				.compartment("security")
				.matching("br.ufc.great.sysadmin.security.*")
				.build();
		
		ArCatchAPI.addCompartment(systagram);	
		ArCatchAPI.addCompartment(controller);
		ArCatchAPI.addCompartment(service);
		ArCatchAPI.addCompartment(repository);
		ArCatchAPI.addCompartment(model);
		ArCatchAPI.addCompartment(util);
		ArCatchAPI.addCompartment(security);
			
		checkRules();
	}

	private static void checkSystagram151(String projectPath) {
		ArCatchAPI.setConfiguration(ArCatchAPI
				.configurationBuilder()
				.projectNameAndVersion("Systagram", "1.5.1")
				.projectPath(projectPath)				
				.build());
		
		systagram = ArCatchAPI
				.compartmentBuilder()
				.compartment("systagram")
				.matching("br.ufc.great.sysadmin.systagram.*")
				.build();

		controller = ArCatchAPI
				.compartmentBuilder()
				.compartment("controller")
				.matching("br.ufc.great.sysadmin.controller.*")
				.build();
	
		service = ArCatchAPI
				.compartmentBuilder()
				.compartment("service")
				.matching("serfvice")
				.build();
				
		repository = ArCatchAPI
				.compartmentBuilder()
				.compartment("repository")
				.matching("br.ufc.great.sysadmin.repository.*")
				.build();
		
		model = ArCatchAPI
				.compartmentBuilder()
				.compartment("model")
				.matching("br.ufc.great.sysadmin.model.*")
				.build();
		
		util = ArCatchAPI
				.compartmentBuilder()
				.compartment("util")
				.matching("br.ufc.great.sysadmin.uti.*l")
				.build();
		
		security = ArCatchAPI
				.compartmentBuilder()
				.compartment("security")
				.matching("br.ufc.great.sysadmin.security.*")
				.build();
		
		ArCatchAPI.addCompartment(systagram);	
		ArCatchAPI.addCompartment(controller);
		ArCatchAPI.addCompartment(service);
		ArCatchAPI.addCompartment(repository);
		ArCatchAPI.addCompartment(model);
		ArCatchAPI.addCompartment(util);
		ArCatchAPI.addCompartment(security);
		
		checkRules();
	}

    public static void main( String[] args )
    {
        System.out.println( "Analisando o código do systagram com o Arcatch 2.0..." );
        
        String projectPath = "./systagram/";
        
        checkSystagram140(projectPath + "v1-4-0/src/main/java");
        checkSystagram141(projectPath + "v1-4-1/src/main/java");
        checkSystagram150(projectPath + "v1-5-0/src/main/java");
        checkSystagram151(projectPath + "v1-5-1/src/main/java");
        System.out.println("Análise concluída.");
    }
	
}
