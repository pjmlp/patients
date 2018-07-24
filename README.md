# Overview

This is my solution to a programing exercise from a job interview.

# Description

The problem was described as follows:

A doctor has asked to create a patients simulation, that allows to simulate the future patients’ state,
based on their current state and a list of drugs they take.

The patients can have one of these states:

* F: Fever
* H: Healthy
* D: Diabetes
* T: Tuberculosis
* X: Dead

In the simulator drugs are provided to all patients as a set. This possible set of values is:

* As: Aspirin
* An: Antibiotic
* I: Insulin
* P: Paracetamol

Drugs are able to change states depending on a set of pre-defined rules, as follows:

* Aspirin cures Fever;
* Antibiotic cures Tuberculosis;
* Insulin prevents diabetic subject from dying, does not cure Diabetes;
* If insulin is mixed with antibiotic, healthy people catch Fever;
* Paracetamol cures Fever;
* Paracetamol kills subject if mixed with aspirin;

## Input examples

### First parameter

List of patients' health status codes, separated by a comma. e.g. *“D,F,F”*.

### Second parameter

List of drugs codes to be applied to all patients, separated by a comma, e.g. *“As,I”*.

## Output

The result should be sent to stdout, following on the following format:

*F:NP,H:NP,D:NP,T:NP,X:NP*

Where:

* F, H, D, T, X are patients’ health status codes;
* NP is a number of patients for a given state;

E.g. *“F:0,H:2,D:0,T:0,X:1”* means there are two healthy patients and one that is dead.

## Examples

```
$ java -jar patients.jar D,D
F:0,H:0,D:0,T:0,X:2
$
$ java -jar patients.jar  F P
F:0,H:1,D:0,T:0,X:0

```

# Building

Just make use of the Gradle build file or call the usual Gradle wrapper files that will take care of downloading
the required version.

Given that the solution makes use of Java 10, you will need at least version 4.8.1 from Gradle.
