package study.systagram;

import arcatch.ArCatchAPI;
import arcatch.dsl.compartment.grammar.Compartment;
import arcatch.dsl.rule.common.Criticality;

public class App 
{
	private static Compartment systagram;
	
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
    
    private static void checkRules() {		
		ArCatchAPI.addRule(ArCatchAPI
				.ruleBuilder()
				.antiDrift()
				.criticality(Criticality.WARNING)
				.compartiment(systagram)
				.constrainedTo("NoCA = 0.0")
				.build());	
		
		ArCatchAPI.addRule(ArCatchAPI
				.ruleBuilder()
				.antiDrift()
				.criticality(Criticality.WARNING)
				.compartiment(systagram)
				.constrainedTo("NoCI = 0.0")
				.build());
		
		ArCatchAPI.addRule(ArCatchAPI
				.ruleBuilder()
				.antiDrift()
				.criticality(Criticality.WARNING)
				.compartiment(systagram)
				.constrainedTo("NoCRN = 0.0")
				.build());		
		
		ArCatchAPI.addRule(ArCatchAPI
				.ruleBuilder()
				.antiDrift()
				.criticality(Criticality.WARNING)
				.compartiment(systagram)
				.constrainedTo("NoEH = 0.0")
				.build());
		
		ArCatchAPI.addRule(ArCatchAPI
				.ruleBuilder()
				.antiDrift()
				.criticality(Criticality.WARNING)
				.compartiment(systagram)
				.constrainedTo("NoDR = 0.0")
				.build());				
		
		ArCatchAPI.addRule(ArCatchAPI
				.ruleBuilder()
				.antiDrift()
				.criticality(Criticality.WARNING)
				.compartiment(systagram)
				.constrainedTo("NoGH = 0.0")
				.build());
		
		ArCatchAPI.addRule(ArCatchAPI
				.ruleBuilder()
				.antiDrift()
				.criticality(Criticality.WARNING)
				.compartiment(systagram)
				.constrainedTo("NoGS = 0.0")
				.build());
		
		ArCatchAPI.addRule(ArCatchAPI
				.ruleBuilder()
				.antiDrift()
				.criticality(Criticality.WARNING)
				.compartiment(systagram)
				.constrainedTo("NoNPB = 0.0")
				.build());
		
		ArCatchAPI.addRule(ArCatchAPI
				.ruleBuilder()
				.antiDrift()
				.criticality(Criticality.WARNING)
				.compartiment(systagram)
				.constrainedTo("NoOCA = 0.0")
				.build());		
		
		ArCatchAPI.addRule(ArCatchAPI
				.ruleBuilder()
				.antiDrift()
				.criticality(Criticality.WARNING)
				.compartiment(systagram)
				.constrainedTo("NoOC = 0.0")
				.build());
		
		ArCatchAPI.addRule(ArCatchAPI
				.ruleBuilder()
				.antiDrift()
				.criticality(Criticality.WARNING)
				.compartiment(systagram)
				.constrainedTo("NoSF = 0.0")
				.build());
		
		ArCatchAPI.addRule(ArCatchAPI
				.ruleBuilder()
				.antiDrift()
				.criticality(Criticality.WARNING)
				.compartiment(systagram)
				.constrainedTo("NoSKS = 0.0")
				.build());						
		
		// Abstractness violation
		ArCatchAPI.addRule(ArCatchAPI
				.ruleBuilder()
				.antiDrift()
				.criticality(Criticality.WARNING)
				.compartiment(systagram)
				.constrainedTo("(Ce / (Ce + Ca)) <= 0.3")
				.build());
		
		//Large Class according PMD tool: https://github.com/pmd/pmd/blob/master/pmd-java/src/main/java/net/sourceforge/pmd/lang/java/rule/design/DataClassRule.java
		ArCatchAPI.addRule(ArCatchAPI
				.ruleBuilder()
				.antiDrift()
				.criticality(Criticality.WARNING)
				.compartiment(systagram)
				.constrainedTo("(((NoM + NoA) > 3) & (WMC < 31)) | (((NoM + NoA) > 5) & (WMC < 47))")
				.build());
				
		//TooManyFields according PMD tool: ttps://github.com/pmd/pmd/blob/master/pmd-java/src/main/java/net/sourceforge/pmd/lang/java/rule/design/TooManyFieldsRule.java
		ArCatchAPI.addRule(ArCatchAPI
				.ruleBuilder()
				.antiDrift()
				.criticality(Criticality.WARNING)
				.compartiment(systagram)
				.constrainedTo("NoA > 15")
				.build());		
		
		//TooManyMethods according PMD tool: https://pmd.github.io/pmd-6.19.0/pmd_rules_java_design.html#toomanymethods
		ArCatchAPI.addRule(ArCatchAPI
				.ruleBuilder()
				.antiDrift()
				.criticality(Criticality.WARNING)
				.compartiment(systagram)
				.constrainedTo("NoM > 10")
				.build());		
		
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

		ArCatchAPI.addCompartment(systagram);		
		
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

		ArCatchAPI.addCompartment(systagram);		
		
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

		ArCatchAPI.addCompartment(systagram);		
		
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

		ArCatchAPI.addCompartment(systagram);		
		
		checkRules();
	}

	
}
