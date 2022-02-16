package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);
    static int waterStart = 400;
    static int milkStart = 540;
    static int beansStart = 120;
    static int cupsStart = 9;
    static int moneyStart = 550;
    
    static int water;
    static int milk;
    static int beans;
    static int cups;
    static int money;
    
    public static void main(String[] args) {
        while (actions()) {
        }
    }
    
    private static boolean actions() {
        boolean result = true;
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = scanner.next();
        if (action.equals("buy")) {
            buy();
        } else if (action.equals("fill")) {
            fill();
        }  else if (action.equals("take")) {
            take();
        } else if (action.equals("remaining")) {
            remaining();
        } else if (action.equals("exit")) {
            result = false;
        }
        return result;
    }
    
    private static void buy() {
        String top = "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:";
        System.out.println();
        System.out.println(top);
        String coffee = scanner.next();
        String supply = supply(coffee);
        if (!supply.equals("back")) {
            System.out.println(supply);
            System.out.println();
        }
    }
    
    private static void fill() {
        System.out.println();
        System.out.println("Write how many ml of water you want to add: ");
        waterStart = waterStart + scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milkStart = milkStart + scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        beansStart = beansStart + scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        cupsStart = cupsStart + scanner.nextInt();
        System.out.println();
    }
    
    private static void take() {
        System.out.println();
        System.out.printf("I gave you $%d\n", moneyStart);
        moneyStart = 0;
        System.out.println();
    }
    
    private static void remaining() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", waterStart);
        System.out.printf("%d ml of milk\n", milkStart);
        System.out.printf("%d g of coffee beans\n", beansStart);
        System.out.printf("%d disposable cups\n", cupsStart);
        System.out.printf("$%d of money\n\n", moneyStart);
    }
    
    private static String supply(String coffee) {
        String result = "I have enough resources, making you a coffee!";

        if (coffee.equals("1")) {
            moneyStart += 4;
            if (waterStart - 250 > 0) {
                waterStart -= 250;
            } else {
                result = "Sorry, not enough water";
            } 
            if (beansStart - 16 > 0 && !result.contains("Sorry,")) {
                beansStart -= 16;
            } else {
                result = "Sorry, not enough beans";
            }
            if (cupsStart - 1 > 0 && !result.contains("Sorry,")) {
                cupsStart -= 1;
            } else {
                result = "Sorry, not enough cup";
            }
            if (result.contains("Sorry,")) {
                moneyStart -= 4;
            } 
            
        } else if (coffee.equals("2")) {
            moneyStart += 7;
            if (waterStart - 350 > 0) {
                waterStart -= 350;
            } else {
                result = "Sorry, not enough water";
            }
            if (milkStart - 75 > 0 && !result.contains("Sorry,")) {
                milkStart -= 75;
            } else {
                result = "Sorry, not enough milk";
            }            
            if (beansStart - 20 > 0 && !result.contains("Sorry,")) {
                beansStart -= 20;
            } else {
                result = "Sorry, not enough beans";
            }
            if (cupsStart - 1 > 0 && !result.contains("Sorry,")) {
                cupsStart -= 1;
            } else {
                result = "Sorry, not enough cup";
            }
            if (result.contains("Sorry,")) {
                moneyStart -= 7;
            }        

        } else if (coffee.equals("3")) {
            moneyStart += 6;
            if (waterStart - 200 > 0) {
                waterStart -= 200;
            } else {
                result = "Sorry, not enough water";
            }
            if (milkStart - 100 > 0 && !result.contains("Sorry,")) {
                milkStart -= 100;
            } else {
                result = "Sorry, not enough milk";
            }            
            if (beansStart - 12 > 0 && !result.contains("Sorry,")) {
                beansStart -= 12;
            } else {
                result = "Sorry, not enough beans";
            }
            if (cupsStart - 1 > 0 && !result.contains("Sorry,")) {
                cupsStart -= 1;
            } else {
                result = "Sorry, not enough cup";
            }
            if (result.contains("Sorry,")) {
                moneyStart -= 6;
            }
               
        } else {
            result = "back";
        }
        return result;
    }
    
}