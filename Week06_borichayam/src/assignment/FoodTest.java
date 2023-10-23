package assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

enum Type {
	MEAT, FISH, OTHER
} // 열거형 상수집합을 정의하는 데이터 유형

public class FoodTest {
	public static void main(String[] args) {
		// 뷔페 식당의 메뉴를 Food 객체로 생성
        List<Food> menu = new ArrayList<>();
        menu.add(new Food("Salad", true, 150, Type.OTHER));
        menu.add(new Food("Chicken", false, 350, Type.MEAT));
        menu.add(new Food("Broccoli", true, 50, Type.OTHER));
        menu.add(new Food("Salmon", false, 300, Type.FISH));
        menu.add(new Food("Carrot", true, 40, Type.OTHER));
        menu.add(new Food("Vegetable Juice", true, 350, Type.OTHER));

        // 칼로리가 300 이하이고 채식 요리에 해당하는 음식만 필터링
        List<String> VegetarianDietFoods = menu.stream()
                .filter(food -> food.isVege() && food.getCalories() <= 300)
                .map(Food::getName)
                .collect(Collectors.toList());

        // 결과 출력
        System.out.println("칼로리가 300 이하이고 채식 요리인 음식: " + VegetarianDietFoods);
	}
}
