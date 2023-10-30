package CH14;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum Type {
	MEAT, FISH, OTHER
} // 열거형 상수집합을 정의하는 데이터 유형

public class Ex03 {
	public static void main(String[] args) {
		ArrayList<Food> foodAL = new ArrayList<Food>();
		
		foodAL.add(new Food("연어", false, 150, Type.FISH));
        foodAL.add(new Food("치킨", false, 300, Type.MEAT));
        foodAL.add(new Food("토마토", true, 25, Type.OTHER));
        foodAL.add(new Food("스테이크", false, 500, Type.MEAT));
        foodAL.add(new Food("새우", false, 100, Type.FISH));
        foodAL.add(new Food("샐러드", true, 50, Type.OTHER));
        foodAL.add(new Food("닭가슴살", false, 200, Type.MEAT));
        foodAL.add(new Food("바나나", true, 120, Type.OTHER));
        foodAL.add(new Food("토피", true, 350, Type.OTHER));
        foodAL.add(new Food("아보카도", true, 400, Type.OTHER));
        
        List<Food> Vegetarian300AL = foodAL.stream()
        		.filter(v -> v.isVege() && v.getCalories() <= 300)
        		.collect(Collectors.toList());
        
        // 결과 출력
        System.out.println(Vegetarian300AL);
	}
}
