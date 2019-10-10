package ua.service;

import java.util.List;

@FunctionalInterface
public interface FilterShopService {
    List<String> getGroceryShopNumbers(int numberOfCashDesk);
}
