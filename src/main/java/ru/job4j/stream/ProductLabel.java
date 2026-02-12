package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .filter(n -> n.getDaysLeft() >= 0 && n.getDaysLeft() <= 3)
                .map(n -> {
                    Label label = new Label(n.getName(), n.getPrice() / 2);
                    return label.toString();
                })
                .collect(Collectors.toList());
    }
}