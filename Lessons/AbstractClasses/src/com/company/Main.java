package com.company;

/*
- No all methods need to be abstract - this is one of the differences betwen an abstract class and an interface
- Abstract class can't be directly instantiated, it needs regular class that extends abstract class
- Our Abstract Bird Class extends Abstract Animal Class, and as we know not all birds are flying we transform Bird Class in Abstract Class
and insert in it another abstract method fly();. By creating a new Class Parrot, and extending Abstract Class Bird, we automatically extends and
Animal Abstract Class, without overiding it's method, because we can just override only Bird method...



                                    * Abstract Class vs an Interface
- Abstract class can have member variables that are inherited, somthing that can't be done in interface
- Interfaces can have variables but they're all public static final variables, which essentially are gonna be constant values that should
never change with a static scope. They have to be static, because non static variables require an instance, and of course you can't instantiate
an interface.
- Interfaces also cannot have construcros but abstract classes can.
- All methods over the interface are automatically public, whereas the methods of an abstract class can have any visibility.
- Abstract classes can have defined methods, ie methods with an implementation, whereas all methods in an intergace are abstract,

            Abstract Class
- Abstract classes are similar to interfaces. You cannot instantiate them, and they may contain a mix of methods declared with or without an
implementation.
- However, with Abstract classes, you can declare fields thar are not static and final, and define public, protected and private concrete methods
- An abstract class can extend only one parent class buy it can implement multiple interfaces.
- When an Abstract class is subclassed, the subclass usualy provides implementations for all of the abstract methods in its parent class.
- However , if it does not, then the subclass must also be declared abstract.

        Use an Abstract Class when:
- You want to share code among several closely related classes(Animal - with fileds name, age, ...)
- You expect classes that extend you abstract class to have many common methods or fields or required acces modifers other than public(protected,private)
- You want to declare non static or non final fields(for example name, age), this enables you to define methods tha can access and modify the state
of an object(getName,setName)
- When you have a requirement for your base class to provide a default implementation of certain methods but other methods should be open to
begin overridden by child classes.
- Summary: The purpose of an Abstract class is to provide a common definiton of a base class that multiple derived classes can share

======================================
            Interface
- An interface is just the declaration of methods of an Class, it's not the implementation.
- In an Inteeface, we define what kind of operation an object can perform. These operations are defined by the classes that implement the Interface
- Interfaces form a contract between the class and the outside world, and this contract is enforced at build time by the compiler.
- You cannot instantiate them, and they may contain a mix of methods declared with or without an implementation. All methods in interfaces are automatically
public and abstract.
- An interface can extend another interface.
- Interfaces are more flexible and can deal with a lot more stress on the design of you program than the implementation.
- By introducing interfaces into your program, you are really introduce points of variation at which you can plug in different implementations for that
interface. An interfaces primary purpose is abstraction, decoupling that "what" from the "how"
- Since Java 8 interfaces can contain default methods. In other words methods with implementation. The keyword default is used(mostly for backwards
compatibility), and static methods as well before Java 8 that was not possible.
- Since Java 9 an Interface can also contain private methods(commonly used when two default methods in an Interface share common code)

            Use an Interface  when:
- You expect that unrelated classes will implement your interface. For example, the interfaces Comparable and Cloneable are implemented by manual
unrelated classes.
- You want to specify the behavior of a particular data type, but you are not concerned about who implements its behavior.
- You want to separate different behavior.
- The collections API is an excellent example, we have the List interface and implementations ArrayList and LinkedList
- The JDBC API is another excellent example. It exist of almost only interfaces. The concrete implementations are provided as " JDBC drivers". This
enables you to write all the JDBC code independent of the database(DB) vendor.

 */

public class Main {

    public static void main(String[] args) {
	// write your code here
        Dog dog = new Dog("Yorkie");
        dog.breathe();
        dog.eat();

        Parrot parrot = new Parrot("Australian rigneck");
        parrot.breathe();
        parrot.eat();
        parrot.fly();

        Pinguin pinguin = new Pinguin("Emperor");
        pinguin.fly();
    }
}
