# Day 2 - Pages 103-154

## Concepts
1. Concatenation Operator
2. Pre and Post Decrement/Increment
3. Java Operators
4. Bitwise, Logical, Assignment, and the Ternary Operator
---
### Concatenation Operator
- The `+` operator is the only overloaded operator in Java.
- It concatenates strings and adds digits.

        String archonAge = "Lesser" + "Lord" + "Kusanali" + ":" + 250 + 250;   
        // Lesser Lord Kusanali:250250
        String realArchonAge = 250 + 250 + ":" + "Lesser" + "Lord" + "Kusanali";
        // 500:Lesser Lord Kusanali
- Java reads from left to right. If the first values are strings, the succeeding numbers gets treated as a string.
---
### Pre and Post Decrement/Increment
1. Pre-Increment 

        int x = 1;
        System.out.println(++x); 
        // prints 2
        // x = 2
2. Pre-Decrement

        int x = 1;
        System.out.println(--x); 
        // prints 0
        // x = 0
3. Post-Increment

        int x = 1;
        System.out.println(x++); 
        // prints 1
        // x = 2
4. Post-Decrement

        int x = 1;
        System.out.println(x--); 
        // prints 1
        // x = 0

Challenge:

    int x = 10;
    System.out.println(x++);
    System.out.println(x);
    System.out.println(++x);

Result:

    10  // print current value of x then add 1
    11  // print current value of x
    12  // add 1 and print the value of x after
---
### Java Operators
- Arithmetic Operators
    - `/`, `*`, `%`, `-`, `+`
    - max(int, datatype a, datatype b)
        - if operating between smaller datatypes (short, byte), int will be the datatype
        - however, if operating between larger datatypes (long, float, double), the datatype will be the highest datatype
    - Arithmetic Exception
        - runtime exception
        - can only be thrown by integral types
        - only `/` and `%` throws this exception, like dividing by 0
- Relational Operators
    - `>`, `<`, `>=`, `<=`
    - compares actual values of primitive types, except boolean
    - cannot compare Strings as they are objects
    - returns boolean
    - cannot be nested
- Equality Operators
    - `!=`, `==`
    - compares memory addresses between objects, such as Strings
    - compares actual values between primitive values
    - returns boolean
- `instanceof` Operator
    - checks if an object is from a certain class
    - Example:

            Scanner scanner = new Scanner(System.in);
            System.out.println(scanner instanceof Scanner); // true
---
### Bitwise, Logical, Assignment, and the Ternary Operator
- Bitwise Operators
    - `|`, `&`, `^`, `~`
    - can be used for any integral values and boolean (except for `~`)
- Logical Operators
    - `||`, `&&`, `!`
    - can only be used for boolean values or expressions
    - Short-Circuit Behavior 
        - `||` -  skips succeeding conditions if a true condition is met
        - `&&` -  skips succeeding conditions if a false condition is met
- Assignment Operator
    - `=`
    - Types of assignment:
        1. Simple Assignment

                int x = 0;
        2. Chained Assignment

                int a;
                int b=a=2;  // a = 2 and b = 2
                int x = 2, y = 3, z = 4;
        3. Compound Assignment

                int x = 0;
                x += 1; // x = 1
            - `+=`, `-=`, `/=`, `*=`, `%=`
            - `|=`, `&=`, `^=`
            - `>>=`, `<<=`, `>>>=`
- Ternary Operator
    - `?:`
    - Syntax: 
        - `datatype variable = (boolean_expression) ? value1 : value2;`
        - the variable gets assigned with value1 if the boolean expression is true and it will be assigned with value2 if false