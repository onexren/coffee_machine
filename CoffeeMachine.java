package machine;

import java.util.Scanner;

public class CoffeeMachine {

    private int mlWater;
    private int mlMilk;
    private int grBeans;
    private int numberOfCups;
    private int inMoney;

    CoffeeMachine (int mlWater, int mlMilk, int grBeans, int numberOfCups, int inMoney) {
        this.mlWater = mlWater;
        this.mlMilk = mlMilk;
        this.grBeans = grBeans;
        this.numberOfCups = numberOfCups;
        this.inMoney = inMoney;
    }

    public void takeIngredientsForCoffee(int mlWater, int mlMilk, int grBeans, int inMoney) {
        this.mlWater -= mlWater;
        this.mlMilk -= mlMilk;
        this.grBeans -= grBeans;
        this.numberOfCups -- ;
        this.inMoney += inMoney;
    }

    protected void PrintCoffeeMachineInfo() {
        System.out.println("The coffee machine has:");
        System.out.println(this.mlWater + " ml of water");
        System.out.println(this.mlMilk + " ml of milk");
        System.out.println(this.grBeans + " g of coffee beans");
        System.out.println(this.numberOfCups + " disposable cups");
        System.out.println("$" + this.inMoney + " of money");
        System.out.println();
    }

    protected void Fill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        this.mlWater += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        this.mlMilk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        this.grBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        this.numberOfCups += scanner.nextInt();
        System.out.println();
    }

    protected void Take() {
        System.out.println("I gave you $" + this.inMoney);
        System.out.println();
        this.inMoney = 0;
    }

    protected boolean checkIngredientsForCoffee(int oneCupWater, int oneCupMilk, int oneCupBeans, int numberOfCupsToMake) {
        int numberOfCupsCanMake;

        if (this.mlWater < oneCupWater || this.mlMilk < oneCupMilk || this.grBeans < oneCupBeans) {
            if (this.mlWater < oneCupWater) {
                System.out.println("Sorry, not enough water!");
            }
            if (this.mlMilk < oneCupMilk) {
                System.out.println("Sorry, not enough milk!");
            }
            if (this.grBeans < oneCupBeans) {
                System.out.println("Sorry, not enough beans!");
            }
            if (this.numberOfCups < numberOfCupsToMake) {
                System.out.println("Sorry, not enough cups!");
            }
            numberOfCupsCanMake = 0;
        } else {
            int min = Integer.MAX_VALUE;
            if (oneCupWater != 0) {
                min = mlWater / oneCupWater;
            }
            if (oneCupMilk != 0) {
                if (mlMilk / oneCupMilk < min) {
                    min = mlMilk / oneCupMilk;
                }
            }
            if (grBeans != 0) {
                if (grBeans / oneCupBeans < min) {
                    min = grBeans / oneCupBeans;
                }
            }
            numberOfCupsCanMake = min;
        }
        if (numberOfCupsCanMake < numberOfCupsToMake) {
            //System.out.printf("No, I can make only %d cup(s) of coffee\n", numberOfCupsCanMake);
            return false;
        } else if (numberOfCupsCanMake == numberOfCupsToMake) {
            //System.out.println("Yes, I can make that amount of coffee");
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        } else {
            //System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)\n", numberOfCupsCanMake - numberOfCupsToMake);
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        }
    }

}
