package com.company;

/*
    4 types of nested classes:
1.Static nested classes
2.Non-Static nested class (inner class)
3.Local class
4.Anonymous class(nested class without a class name)

1.Static nested class is mainly used to associate a class with its outer class
So in terms of behavior, you'd think of it as being identical to a top level class, but the difference is that it's packaged in its outer class
rather than in the package. So that really means that it cannot access the nonstatic methods or members of its outer class without first creating an
instance of that class.

3.Local classes are declared inside a block, such as a method or an if statemnt and their scope is restricted completely to that paticular block.
Local classes are used less often. Theoreticallym you could argue that they increase encapsulation because  they're already declared within the block
that uses them, but in practice, you probably not often that you'll need to or wana use one.


4. Anonymous class is also a local class, but it's got no name. They have to be declared and instatiated at the same time  because they haven't got a name.
And we've used what a local class has required only once . It's of even less use than the local class but in fact they're very common for
touching event handlers to use in an interface.

As if we do have serveral buttons that each would require a different on-click method. So using a local class might not be the better solution.
In other words if you got four or five buttons on the screen, chances are you don't want the exact same functionality to be called each time
that button is clicked.
 */


import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");

    public static void main(String[] args) {
//==========================================================================

        //Static nested class

//        Gearbox mcLaren = new Gearbox(6);
//        Gearbox.Gear first = mcLaren.new Gear(1, 12.3);
////        Gearbox.Gear second = new Gearbox.Gear(2, 15.4);
////        Gearbox.Gear third = new mcLaren.Gear(3, 17.8);
//        System.out.println(first.driveSpeed(1000));

//==========================================================================
        //Non-Static nested class(inner class

        GearBox mcLaren = new GearBox(6); //declaring outer class
        mcLaren.addGear(1,5.3);
        mcLaren.addGear(2,10.6);
        mcLaren.addGear(3,15.9);
        mcLaren.operateClutch(true);
        mcLaren.changeGear(1);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.weelSpeed(1000));
        mcLaren.changeGear(2);
        System.out.println(mcLaren.weelSpeed(3000));
        mcLaren.operateClutch(true);
        mcLaren.changeGear(3);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.weelSpeed(6000));


//===================================================================
        // local calss methodp could be pretty useful if you want to assign exactly the same object, say to several buttons, if u had several
        //buttons on the screen at the same time, for example:

        class ClickListener implements Button.OnClickListener {
            public ClickListener() {
                System.out.println("I've been attached");
            }

            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked");
            }
        }

        btnPrint.setOnClickListener(new ClickListener());
        listen();

//==========================================================================
        //anonymus class
        btnPrint.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked");
            }
        });


    }

    private static void listen() {
        boolean quit = false;
        while (!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    btnPrint.onClick();
            }
        }
    }






}

