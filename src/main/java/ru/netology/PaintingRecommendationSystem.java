package ru.netology;

import ru.netology.auxiliaryInterface.IntPriceAndAmount;
import ru.netology.auxiliaryInterface.RecommendationSystemInterface;

import java.util.List;
import java.util.Random;

public class PaintingRecommendationSystem implements RecommendationSystemInterface {
    @Override
    public void weRecommend(List<IntPriceAndAmount> listPAAProduct) {
        int randomIndexProductForRecommendation;
        Random random = new Random();
        randomIndexProductForRecommendation = random.nextInt(listPAAProduct.size() + 1) - 1;
        System.out.println("Рекомендация специально для вас: " +
                listPAAProduct.get(randomIndexProductForRecommendation).getProduct().getBrand() + " " +
                listPAAProduct.get(randomIndexProductForRecommendation).getProduct().getNameProduct());
    }
}
