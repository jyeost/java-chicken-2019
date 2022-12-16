package view;

import domain.*;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Table inputTableNumber() {
        try {
            System.out.println("## 주문할 테이블을 선택하세요.");
            return TableRepository.getTable(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputTableNumber();
        }
    }

    public static MainFunction chooseMainFunction() {
        try {
            System.out.println("## 원하는 기능을 선택하세요.");
            return MainFunction.validate(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return chooseMainFunction();
        }
    }

    public static void inputGetOrder(Order order) {
        try {
            System.out.println(System.lineSeparator() + "## 등록할 메뉴를 선택하세요.");
            Menu menu = MenuRepository.getMenu(scanner.nextLine());
            System.out.println(System.lineSeparator() + "## 메뉴의 수량을 입력하세요.");
            String menuCnt = scanner.nextLine();
            order.addOrder(menu, menuCnt);
        } catch (CountException e){
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputGetOrder(order);
        }
    }
}
