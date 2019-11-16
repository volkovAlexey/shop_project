package ua.service;

import java.util.List;

@FunctionalInterface
public interface FilterShopService {
    List<String> getGroceryShopPhoneNumbers(int numberOfCashDesk);
}