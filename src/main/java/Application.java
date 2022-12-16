import domain.*;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView.printMain(MainFunction.print());
        MainFunction mainFunction = InputView.chooseMainFunction();
        if (mainFunction == MainFunction.REGISTER_ORDER) orderMenu();
        if (mainFunction != MainFunction.QUIT) main(args);

    }

    private static void orderMenu() {
        OutputView.printTables(TableRepository.tables());
        Table table = InputView.inputTableNumber();

        Order order = OrderRepository.getOrder(table);
        if (order == null) order = new Order(table);

        OutputView.printMenus(MenuRepository.menus());
        InputView.inputGetOrder(order);

        OrderRepository.add(order);
        // System.out.println("주문 목록 크기"+OrderRepository.orders().size());
    }
}
