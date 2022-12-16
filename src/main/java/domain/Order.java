package domain;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private final Table table;
    private final Map<Menu, Integer> MenuAndCount;

    public Order(Table table) {
        this.table = table;
        this.MenuAndCount = new HashMap<>();
    }

    public void addOrder(Menu menu, String menuCnt) throws CountException {
        validateMenuCnt(menuCnt);
        if (MenuAndCount.containsKey(menu))
            MenuAndCount.put(menu, MenuAndCount.get(menu) + Integer.parseInt(menuCnt));
        if (!MenuAndCount.containsKey(menu)) MenuAndCount.put(menu, Integer.parseInt(menuCnt));
        System.out.println(MenuAndCount.keySet().toString() + MenuAndCount.values());
    }

    private void validateMenuCnt(String menuCnt) throws CountException {
        try {
            Integer.parseInt(menuCnt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 메뉴 수량은 숫자로 입력해주세요.");
        }
        if (sumMenuCnt()==99) throw new CountException("[ERROR] 현재 "+table.toString()+"테이블에서 이미 99개를 주문하였기 때문에 추가 주문이 불가능 합니다." );
        if (Integer.parseInt(menuCnt) < 1 || sumMenuCnt() + Integer.parseInt(menuCnt) > 99)
            throw new IllegalArgumentException("[ERROR] 현재 "+table.toString()+"테이블에서 주문한 개수는 " + (sumMenuCnt() + Integer.parseInt(menuCnt)) + "개이며, 한테이블당 주문 가능 개수는 1~99 입니다.");
    }

    private int sumMenuCnt() {
        int cnt = 0;
        for (Menu menu : MenuAndCount.keySet()) {
            cnt += MenuAndCount.get(menu);
        }
        return cnt;
    }

    public boolean having(Table table) {
        return this.table.equals(table);
    }

    /*@Override
    public boolean equals(Object obj) {
        Table table = (Table) obj;
        return this.table.equals(table);
    }*/
}
