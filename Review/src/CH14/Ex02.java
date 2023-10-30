package CH14;

interface ArrayProcessing {
	double apply(double[] array);
}

public class Ex02 {
	// 주어진 배열에서 최대값을 계산하는 람다식
	public static final ArrayProcessing maxer = array -> {
		double max = 0;
		for (double n:array) {
			if (n > max) {
				max = n;
			}
		}
		return max;
	};
	// 주어진 배열에서 최소값을 계산하는 람다식
	public static final ArrayProcessing miner = array -> {
		double min = array[0];
		for (double n:array) {
			if (n < min) {
				min = n;
			}
		}
		return min;
	};
	// 주어진 배열에서 평균값을 계산하는 람다식
	public static final ArrayProcessing sumer = array -> {
		double sum = 0;
		for (double n:array) {
			sum += n;
		}
		return sum/array.length;
	};
	
	public static void main(String[] args) {
		double[] numbers = { 10.5, 5.2, 8.9, 3.7, 15.1 };
		
		double maxResult = maxer.apply(numbers);
        System.out.println("최대값: " + maxResult);
        
        double minResult = miner.apply(numbers);
        System.out.println("최소값: " + minResult);
        
        double avgResult = sumer.apply(numbers);
        System.out.println("평균값: " + avgResult);
	}

	private static int size(double[] array) {
		// TODO Auto-generated method stub
		return 0;
	}

}
