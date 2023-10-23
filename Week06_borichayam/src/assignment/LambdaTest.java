package assignment;

interface ArrayProcessing {
	double apply(double[] array);
}

public class LambdaTest {
	
	// 1. 주어진 배열에서 최대값을 계산
	public static final ArrayProcessing maxer = array -> {
        double max = array[0];
        for (double number : array) {
            if (number > max) {
                max = number;
            }
        }
        return max;
	};
	
	// 2. 주어진 배열에서 최소값을 계산
	public static final ArrayProcessing miner = array -> {
		double min = array[0];
        for (double number : array) {
            if (number < min) {
            	min = number;
            }
        }
        return min;
	};
	
	// 3. 주어진 배열에서 평균값을 계산
	public static final ArrayProcessing sumer = array -> {
		double sum = 0;
		for (double number : array) {
            sum += number;
        } 
		return sum/array.length;
	};
	
	public static void main(String[] args) {
		// 주어진 배열
        double[] numbers = { 10.5, 5.2, 8.9, 3.7, 15.1 };
		
		double maxResult = maxer.apply(numbers);
        System.out.println("최대값: " + maxResult);
        
        double minResult = miner.apply(numbers);
        System.out.println("최소값: " + minResult);
        
        double avgResult = sumer.apply(numbers);
        System.out.println("평균값: " + avgResult);
	}
}
