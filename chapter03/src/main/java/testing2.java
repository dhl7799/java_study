import java.util.*;
import java.util.stream.*;

public class testing2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] arr = {3,4,5,2,8};
		//주어진 배열을 스트림에 넣어준다.
		//IntStream integerStream = Arrays.stream(arr);

		//이제 이렇게 만들어진 스트림에 원하는 연산을 해주면 된다.
		//int maxValue = integerStream.max().getAsInt();
		//여기에서 getAsInt()라는 코드에 의문이 생길수도 있다.
		//스트림의 경우 max()가 끝나고 반환되는 값의 타입은 OptionalInt이다.
		//Optional이라는 객체는 여러가지 에러를 잡아주기 위해 존재한다.
		//지금 우리에게 필요한 것은 정수이므로 getAsInt()를 통해 정수로 얻으면 된다.
		//double avg = (integerStream.average().getAsDouble());

		//이건 평균을 구하는 코드인데, 순서대로 따라하면 에러가 발생한다.
		//stream has already been operated upon or closed
		//즉 스트림은 만들고 나면 한 번 사용하고 버려지는 것이다.
		//원본 배열은 그대로 있을테니 원한다면 스트림을 새로 만들어서 평균을 구하자.
		//IntStream integerStream2 = Arrays.stream(arr);
		//double avg2 = (integerStream2.average().getAsDouble());
		//System.out.println(avg); // 4.4가 잘 출력된다!
		int[] arrayA = {10,20};
		int[] arrayB = {5,15};
		int minA = Arrays.stream(arrayA).min().getAsInt();
        int minB = Arrays.stream(arrayB).min().getAsInt();
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 2; i <= minA; i++) {
            if(minA % i == 0) set.add(i);
        }
        for(int i = 2; i <= minB; i++) {
            if(minB % i == 0) set.add(i);
        }
        for(int a : set)
        	System.out.println(a);
	}

}
