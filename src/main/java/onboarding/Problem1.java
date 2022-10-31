package onboarding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

         if(((pobi.get(1) - pobi.get(0)) != 1) || ((crong.get(1) - crong.get(0)) != 1)){ // 예외사항
             System.out.println("answer: " + -1);
             return -1;
         }else{
             // 연산결과(list)
             List<Integer> pobi_result = calculation(pobi);
             List<Integer> crong_result = calculation(crong);

             // 연산 결과 중 최대값
             int p = pobi_result.get(0);
             int c = crong_result.get(0);

             // 조건 처리
             if(p >= c){
                 if(p == c) answer = 0; // 무승부
                 else answer = 1; // 포비 승
             }else answer = 2; // 크롱 승

             return answer;
         }

    }

    public static List calculation(List<Integer> people) { // 왼쪽 및 오른쪽 페이지 번호로 연산(+,*)한 결과

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            int num = people.get(i); // 페이지
            List<Integer> num_list = new ArrayList<>(); // 페이지 숫자 분리
            int sum = 0;
            int mul = 1; // 곱하기니까 1로 초기화

            // 페이지 자리수로 분리하여 list에 넣기
            while(num > 0) {
                num_list.add(num % 10);
                num /= 10;
            }

            // 분리된 숫자로 연산
            for(int j = 0; j < num_list.size(); j++){
                sum += num_list.get(j);
                mul *= num_list.get(j);
            }

            result.add(sum);
            result.add(mul);

        }
        // 내림차순 정렬
        Collections.sort(result, Collections.reverseOrder());

        return result;
    }

}