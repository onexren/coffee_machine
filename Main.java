package machine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);
        while (true) {
            System.out.println("Write action (buy, fill, remaining, take, exit):");
            String action = scanner.nextLine();
            switch (action) {
                case "buy": {
                    boolean back = false;
                    while (!back) {
                        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                        String coffeeType = scanner.nextLine();
                        switch (coffeeType) {
                            case "1": {
                                if (coffeeMachine.checkIngredientsForCoffee(250,0,16,1)) {
                                    coffeeMachine.takeIngredientsForCoffee(250, 0, 16, 4);
                                }
                                back = true;
                                break;
                            }
                            case "2": {
                                if (coffeeMachine.checkIngredientsForCoffee(350,75,20,1)) {
                                    coffeeMachine.takeIngredientsForCoffee(350, 75, 20, 7);
                                }
                                back = true;
                                break;
                            }
                            case "3": {
                                if (coffeeMachine.checkIngredientsForCoffee(200,100,12,1)) {
                                    coffeeMachine.takeIngredientsForCoffee(200, 100, 12, 6);
                                }
                                back = true;
                                break;
                            }
                            case "back": {
                                back = true;
                                break;
                            }
                            default: {
                                System.out.println("Unknown command, try again");
                                break;
                            }
                        }
                    }
                    break;
                }
                case "fill": {
                    coffeeMachine.Fill();
                    break;
                }
                case "take": {
                    coffeeMachine.Take();
                    break;
                }
                case "remaining": {
                    coffeeMachine.PrintCoffeeMachineInfo();
                    break;
                }
                case "exit": {
                    System.exit(0);
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }
}
