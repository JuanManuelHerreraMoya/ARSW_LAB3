# Introduction to Spring and Configuration using annotations

## Part I - Basic workshop 

To illustrate the use of the Spring framework, and the development environment for its use through Maven (and NetBeans), the configuration of a text analysis application will be made, which makes use of a grammar verifier that requires a spelling checker. The grammar checker will be injected, at the time of execution, with the spelling checker required (for now, there are two available: English and Spanish).

1. Open the project sources in NetBeans.

2. Review the Spring configuration file already included in the project (src / main / resources). It indicates that Spring will automatically search for the 'Beans' available in the indicated package.

3. Making use of the Spring configuration based on annotations mark with the annotations @Autowired and @Service the dependencies that must be injected, and the 'beans' candidates to be injected -respectively-:

    1. GrammarChecker will be a bean, which depends on something like 'SpellChecker'.
    2. EnglishSpellChecker and SpanishSpellChecker are the two possible candidates to be injected. One must be selected, or another, but NOT both (there would be dependency resolution conflict). For now, have EnglishSpellChecker used. 
    
![](https://github.com/JuanManuelHerreraMoya/ARSW_LAB3/blob/master/GRAMMAR-CHECKER_/GRAMMAR-CHECKER/img/inye.PNG)

4. Make a test program, where an instance of GrammarChecker is created by Spring, and use it:

        public static void main(String[] args) {
          ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
          GrammarChecker gc=ac.getBean(GrammarChecker.class);
          System.out.println(gc.check("la la la "));
        }

NOTA: Para poder ejecutar estas pruebas debemos usar las siguientes lineas.

        mvn package
        mvn exec:java -Dexec.mainClass="edu.eci.arsw.springdemo.ui.Main"

Se vea lo siguiente
![](https://github.com/JuanManuelHerreraMoya/ARSW_LAB3/blob/master/GRAMMAR-CHECKER_/GRAMMAR-CHECKER/img/English.PNG)

## Part II

1. Modify the configuration with annotations so that the Bean 'GrammarChecker' now makes use of the SpanishSpellChecker class (so that GrammarChecker is injected with EnglishSpellChecker instead of SpanishSpellChecker.) Verify the new result.

Se tendra la siguiente configuracion 
![](https://github.com/JuanManuelHerreraMoya/ARSW_LAB3/blob/master/GRAMMAR-CHECKER_/GRAMMAR-CHECKER/img/spanish2.PNG)

Se obtendra el siguiente resultado
![](https://github.com/JuanManuelHerreraMoya/ARSW_LAB3/blob/master/GRAMMAR-CHECKER_/GRAMMAR-CHECKER/img/spanish.PNG)

# Cinema Book System

In this exercise we will build a class model for the logical layer of an application that allows managing the sale of cinema tickets for a prestigious company

![](https://github.com/JuanManuelHerreraMoya/ARSW_LAB3/blob/master/CINEMA%20I/CINEMA%20I/img/CinemaClassDiagram.png)

## Part I

1. Configure the application to work under a dependency injection scheme, as shown in the previous diagram. The above requires:

    1. Add the dependencies of Spring. 
    2. Add the Spring configuration. 
![](https://github.com/JuanManuelHerreraMoya/ARSW_LAB3/blob/master/CINEMA%20I/CINEMA%20I/img/cml.PNG)
    3. Configure the application -by means of annotations- so that the persistence scheme is injected at the moment of creation of the 'CinemaServices' bean. 
Hacemos uso de las siguientes etiquetas para que puedan ser inyectados los metodos de estas clases
![](https://github.com/JuanManuelHerreraMoya/ARSW_LAB3/blob/master/CINEMA%20I/CINEMA%20I/img/Spring.PNG)

2. Complete the getCinemaByName (), buyTicket (), and getFunctionsbyCinemaAndDate () operations. Implement everything required from the lower layers (for now, the available persistence scheme 'InMemoryCinemasPersistence') by adding the corresponding tests in 'InMemoryPersistenceTest'.

NOTA: Al ejecutar las pruebas se puede verificar que los metodos estan en correcta construccion.

3. For later queries, we want to implement two functionalities:

    1. A method 'getFunctionsbyCinemaAndDate' that allows to obtain all the functions of a certain cinema for a certain date. 
    2. Allow the purchase or reservation of tickets for a certain position of chairs in the room through the 'buyTicket' method. 

4. Make a program in which you create (through Spring) an instance of CinemaServices, and rectify the functionality of it: register cinemas, consult cinemas, obtain the functions of certain cinema, buy / book tickets, etc.

NOTA: Al ejecutar el metodo main, se evicencia la funcionalidad del punto 3 y 4, para ello debe usar los siguientes comandos:

       mvn package
       mvn exec:java -Dexec.mainClass="edu.eci.arsw.cinema.main.Main"

![](https://github.com/JuanManuelHerreraMoya/ARSW_LAB3/blob/master/CINEMA%20I/CINEMA%20I/img/main1.PNG)
![](https://github.com/JuanManuelHerreraMoya/ARSW_LAB3/blob/master/CINEMA%20I/CINEMA%20I/img/main2.PNG)

5. It is wanted that the consultations realize a filtering process of the films to exhibit, said filters look for to give him the facility to the user to see the most suitable films according to his necessity. Adjust the application (adding the abstractions and implementations that you consider) so that the CinemaServices class is injected with one of two possible 'filters' (or possible future filters). The use of more than one at a time is not contemplated:
    1. (A) Filtered by gender: Allows you to obtain only the list of the films of a certain genre (of a certain cinema and a certain date) (The genre enters by parameter). 
    2. (B) Filtering by availability: Allows you to obtain only the list of films that have more than x empty seats (of a certain cinema and a certain date) (The number of seats is entered per parameter).
   
 ![](https://github.com/JuanManuelHerreraMoya/ARSW_LAB3/blob/master/CINEMA%20I/CINEMA%20I/img/gender.PNG)
 ![](https://github.com/JuanManuelHerreraMoya/ARSW_LAB3/blob/master/CINEMA%20I/CINEMA%20I/img/filter2.PNG)

6. Add the corresponding tests to each of these filters, and test their operation in the test program, verifying that only by changing the position of the annotations -without changing anything else-, the program returns the list of films filtered in the manner (A ) or in the way (B).

NOTA: Para ejecutar las pruebas debe usar el siguiente comando:

        mvn test
        
![](https://github.com/JuanManuelHerreraMoya/ARSW_LAB3/blob/master/CINEMA%20I/CINEMA%20I/img/pruebas.PNG)

