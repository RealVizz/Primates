# Primates

It is a program which simulates a typical scenario in an sanctuary.

## Installation

Install JAVA version 11 and JUnit 4 dependencies for a smooth working of the program. 

## List of features
1. Create a Sanctuary, Isolation, Enclosure, Animal (Monkey as of now).
2. Add and remove Sanctuary, Isolation, Enclosure, Animal (Monkey as of now).
3. Report about the animals (Monkey as of now) in the sanctuary.
4. Lookup for a particular species (of a Monkey) in the isolation.
5. Yield a sign for an enclosure.
6. Produce a shopping list for the sanctuary animals.

## How to run JAR file
Running the jar file is easy, run command in shell/bash/cmd  --> "java -jar 'Project 1.jar' " and no other arguments are needed. This  will generate a dry run demonstration for the program.

## How to use the program
The program have several functionality, almost all of its functionality are utilized via an object of SANCTUARY Class. This object internally governs the entire program as for user, the in built functionalities are already handled via sanctuary class.
User can add/remove and Isolation/Enclosure/Animal and do operations on them via method calls over desired object.

## Example
A dry run demo file is included in the "/res" folder of the directory, with name "TEST RUN.txt" .


## Design/Model  changes
There are 2 version of the design, the version 2 is the latest and final version of it.
In the later version, the UML is simplified to un lengthen and reduce the complexity of the program.
The classes are de-segregated and merged in order to achieve this without loosing any practical advantages.

## Assumptions
1. Number of Isolation and Enclosure are 0 initially.
2. Every Monkey must be added with it's species to be known at least.
3. There will be no negative values ever.
4. Monkeys do not die them self and there are no fires or earthquakes :) .

## Limitations
No limitations (Considering the given problem statement).

