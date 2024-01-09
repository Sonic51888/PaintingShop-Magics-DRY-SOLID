package ru.netology.auxiliaryInterface;

import ru.netology.PriceAndAmount;

import java.util.List;

public interface RecommendationSystemInterface {
    public void weRecommend(List<IntPriceAndAmount> listPAAProduct);//метод предоставляющий рекомендуемый товар
}
