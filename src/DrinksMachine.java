import Helper.Drinks;
import java.util.Scanner;

public class DrinksMachine {

    public static void printMenuDrink() {
        for (int i = 0; i < Drinks.values().length; i++) {
            System.out.print((i + 1) + "." + Drinks.values()[i].name() + "; ");
        }
        System.out.println("9. Завершити замовлення;");
    }

    public static void drinkMachine() {
        Scanner scanner = new Scanner(System.in);
        int[] orders = new int[Drinks.values().length];
        double totalCost = 0;

        System.out.println("Виберіть напій за номером:");
        printMenuDrink();

        while (true) {
            try { // Google допоміг. щоб не було помилки якщо замість Цифри з меню ввести щось інше
                int choice = scanner.nextInt();
                if (choice == 9) {
                    System.out.println("Всього Ви замовили:");
                    for (Drinks drink : Drinks.values()) {
                        int count = orders[drink.ordinal()];
                        if (count > 0) {
                            System.out.println(drink.name() + ": " + count);
                        }
                    }
                    System.out.println("Загальна сума замовлення: " + totalCost);
                    break;
                } else if (choice >= 1 && choice <= Drinks.values().length) {
                    Drinks selectedDrink = Drinks.values()[choice - 1];
                   // double drinkPrice = 0;
                    double DrinkPrice = Drinks.getPrice();

//                    switch (selectedDrink) {
//                        case COFFEE:
//                            drinkPrice = DrinksPrise.COFFEE_PRICE;
//                            break;
//                        case TEA:
//                            drinkPrice = DrinksPrise.TEA_PRICE;
//                            break;
//                        case LEMONADE:
//                            drinkPrice = DrinksPrise.LEMONADE_PRICE;
//                            break;
//                        case MOJITO:
//                            drinkPrice = DrinksPrise.MOJITO_PRICE;
//                            break;
//                        case MINERAL_WATER:
//                            drinkPrice = DrinksPrise.MINERAL_WATER_PRICE;
//                            break;
//                        case COLA:
//                            drinkPrice = DrinksPrise.COLA_PRICE;
//                            break;
//                    }
                    totalCost += drinkPrice;
                    orders[selectedDrink.ordinal()]++;
                    System.out.println("Ваше замовлення: " + selectedDrink.name() + ", Ціна: " + drinkPrice);
              //      printMenuDrink();
                } else {
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Введіть Номер з Меню.");
                scanner.nextLine();
                printMenuDrink();
                }
        }
    }
}
