Feature: Dashboard of AI Fusion Center Application

  Background: User is Logged In
  Given user is on dashboard page
    

  @test1
  Scenario: clinical
    When Open clinical Co-pilot
    Given Switch to child windows
    Then validate the main page
    Then login 
    Then validate the clinical page "UNLOCKING INSIGHTS"
    #Then delete the document
    #Then edit the document
    #Then Edit the document and then click cancel
    #Then download the document in doc management
    #Then generate the document for "Abacavir & HIV"
    #Then click on download
    #Then click on cancel logout
    Then click on confirm logout
    Given Switch to main windows
    Then move to dashboard page
    
    
  @test2
  Scenario: echo-docs
  	When Open echo-docs
  	Given Switch to child windows
  	Then validate the echo main page
  	Then accept terms & condition
  	Then login 
  	Then validate the echoDocs "Explore Tensai's Generative AI"
  	Then Logout of echoDocs
  	Given Switch to main windows
    Then move to dashboard page
  	
  @test3
  Scenario Outline: KB System
  	When open KB System
  	Given Switch to child windows
  	Then validate the KB system "2000066666"
  	Then provide the credentials "<userId>" and "<password>"
  	Then accept terms & condition
  	And clicks on submit
  	Then logout from KB
  	
  	Examples:
  	
  	|userId         |password              |
  	|2000066666			|GenAI@hex#2024				 |
  	|1000099999			|GenAI@hex#2024				 |
  	|1000088888 		|GenAI@hex#2024				 |
  	|1000077777 		|GenAI@hex#2024				 |
  	|1000066666 		|GenAI@hex#2024				 |
  
  @test4
  Scenario: legal co-pilot
  	When open legal
  	Given Switch to child windows
  	Then validate the legal main page
  	Then login 
  	Then validate the legal co-pilot "LEGAL MANOEUVRING"
  	Then logout of legal
  	Given Switch to main windows
    Then move to dashboard page
  	
  @test5
  Scenario: PES
  	When open pes
  	Given Switch to child windows
  	Then validate the PES main page
  	Then login 
  	Then validate PES "Project" 
  	Then logout of pes
    Given Switch to main windows
    Then move to dashboard page
  	
  @test6
  Scenario: SQL Query Generator
  	When open SQl generator
  	Given Switch to child windows
  	Then validate the SQL Query Generator main page
  	Then login 
  	Then validate SQL Query Generator "SQL Query Generator"
  	Then logout of sql generator
  	Given Switch to main windows
    Then move to dashboard page
  	
  @test7
  Scenario: TensaiGPT
  	When open TensaiGPT
  	Given Switch to child windows
  	Then validate the TensaiGPT main page
  	Then login 
  	Then validate TensaiGPT 
  	Then logout of TensaiGPT
  	Given Switch to main windows
    Then move to dashboard page
    
    
  @test8
  Scenario: Ticket Analyser
  	When open Ticket Analyzer
  	Given Switch to child windows
  	Then validate the Ticket Analyser main page
  	Then login 
  	Then validate on Ticket Analyzer
  	Then logout of Ticket Analyzer
		And login with cred "1000055555" and "Hexaware@123"
		And click on submit
		Then validate on Ticket Analyzer
		Then logout of Ticket Analyzer
		
   
  
  	
   
     
   
  
      

