# Day 2 pages 42-102
## Sections
1. Java Program Basic Structure
2. Java Identifiers, Keywords, and Datatypes
---
### Java Program Basic Structure
- It can have multiple classes but one public class at most, with the same name as the source file.
- Pascal-Case Naming Convention 
    - used for naming classes in Java
    - the first letter of every word is in uppercase
    - ex. JavaProgram
- One-Class-per-File Convention - one class per source file for readability
- Java Comments
    1. Single-Line Comments

            // This is a single-line comment
    2. Multiline Comments

            /*
                This is a
                multiline comment
            */
    3. Javadoc Comments

            /**
            * @title: Javadoc Comment
            * @description: Show a javadoc comment
            * @author: Elano, Jethro B.
            */
- Package - an encapsulation mechanism that bundles related classes and interfaces into a single module for resolving naming conflicts, modularity, and security
    - Stucture: `package domaintype.organization.module.submodule;`
            
            package com.unc.oop.activities;
- the  `main()` method
    - used by JVM to know where to start in executing the program
    - Structure: `modifiers void main(String[] parameters)`
    - Common Structure: 
    
            public static void main(String[] args)
        - `public` - accessible outside the class
        - `static` - can be used without an object
        - `void` - doesn't return anything
        - `String[] args` - array of Strings
    - Other valid variations:

            static public void main(String[] args)
            public static synchronize strictfp void main(String[] args)
            public static final void main(String[] args)
            public static void main(String... args)
    
    - Quiz

            Tell if valid or invalid main() methods.
            1. public static void main(String args){ }
            2. public syncronized final strictfp void
            main(String[] args){ }
            3. public static void main(String… args){ }
            4. public static int main(String[] args){ }
            5. public static syncronized final strictfp void
            main(String… args){ }
            6. public static void main(String… args){ }
            7. public void main(String args[]){ }
            8. static public void main(String[] args){ }
            9. public static syncronized void main(String[] a){ }
            10. static public final main(String []june){ }
        - Answers
        
                1. invalid, the parameter isn't an array of Strings
                2. invalid, no `static` keyword and wrong spelling of `synchronized` keyword
                3. valid, parameter as var-args
                4. invalid, the main method isn't expected to return anything
                5. invalid, wrong spelling of `synchronized` keyword
                6. valid, parameter as var-args
                7. invalid, no `static` keyword
                8. valid, this is accepted by JVM
                9. invalid, wrong spelling of `synchronized` keyword
                10. invalid, no returntype
### Java Identifiers, Keywords, and Datatypes
- Identifiers 
    - names in Java (classes, variables, objects, etc.)
    - Rules:
        - accepts a-z and A-Z characters, digits, `_`, and `$`
        - doesn't start in digit
        - case-sensitive 
        - doesn't accept keywords
- Keywords - words that serve specific purposes in Java, such as keywords for;
    1. Datatypes - `int`, `boolean`, and etc.
    2. Exception Handling - `try`, `catch`, and etc.
    3. Flow Control - `for`, `while`, and etc.
    4. Objects 
    5. Classes - `synchronized`, `strictfp`, and etc.
    6. the `void` return type
    7. Unused (`const`and `goto`)
    8. Reserved Literals - `null`, `true`, and `false`
    9. Modifiers - `public`, `static`, and etc.
    10. I forgot
- Datatypes
    - Integer:
        
        | Data Type | Bit size | Value Range | Default Value |
        | --- | --- | --- | --- | 
        | `byte` | 8 | -2^7 - 2^7-1 | 0 | 
        | `short` | 16 | -2^15 - 2^14-1 | 0 | 
        | `int` | 32 | -2^31 - 2^30-1 | 0 |
        | `long` | 64 | -2^63 - 2^62-1 | `0L` |
    - Floating Point:
        | Data Type | Bit size | Default Value |
        | --- | --- | --- | --- | 
        | `float` | 32-bit IEEE 754 | `0.0F` | 
        | `double` | 64-bit IEEE 754|  0.0 | 
    - Boolean: `boolean` - `false` is the default value
    - Character: `char` - a 16-bit Unicode character
