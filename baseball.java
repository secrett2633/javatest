import java.util.Random; // 랜덤 함수 이용을 위해 선언
import java.util.Scanner; // 값을 입력받아 이용하기 위해 선언

public class baseball { // baseball 이라는 클래스를 만듬

    public static void main(String[] args) { // baseball 클래스가 호출될때 실행되는 메인함수
        Scanner sc = new Scanner(System.in); // 스캐너로 값을 입력받을 수 있게 sc라는 변수로 저장
        Random rand = new Random(); // 랜덤함수를 사용할 수 있도록 rand 라는 변수로 저장
        int[] n = new int[3]; // 3개의 정수를 담을 수 있는 n 이라는 배열을 생성 (정답이 담길 배열)
        int[] guess = new int[3]; // 3개의 정수를 담을 수 있는 guess 라는 배열을 생성 (입력한 값이 담길 배열)
        boolean[] already = new boolean[10]; // 10개의 논리값을 담을 배열을 생성
        int strike, ball; // strike 와 ball 이라는 이름으로 정수형 변수 선언

        for (int i = 0; i < 10; i++) { // 0부터 시작하여 9에서 끝나며
            already[i] = false; // already 배열에 false로 모두 채워넣음
        }
        int count = 0; // count 를 0으로 초기화
        while (count < 3) {    // count가 3미만일때 실행되는 반복문
            int trial = rand.nextInt(10); // trial 이라는 변수에 0~9까지의 값을 랜덤으로 생성하여 저장
            if (!already[trial]) { // 이전에 같은 값이 생성되지 않았을때
                n[count] = trial; // n배열에 뽑은 값을 넣고
                already[trial] = true; // already 배열에 true를 넣어 앞서 사용한 if 문을 활용할 수 있게 하고
                count++; // count 값을 늘려 무한루프에 빠지지 않게 한다
            }
        }

        boolean finish = false; // finish 변수를 false 로 선언
        while (!finish) { // finish 가 false 일때 실행되는 반복문
            strike = ball = 0; // strike 와 ball 을 0 으로 초기화
            System.out.print("0~9 사이의 세 정수를 입력하세요. >>"); // command 에 0~9 사이의 세 정수를 입력하세요. >>를 표시
            for (int k = 0; k < 3; ++k) {  // k가 0으로 시작되며 2일때까지 실행되고 k가 증가한 상태로 반복함
                guess[k] = sc.nextInt(); // 입력받은 값을 guess 배열에 저장
                for (int j=0; j < 3; ++j) // j가 0으로 시작되며 2일때까지 실행되고 j가 증가한 상태로 반복함
                    if (guess[k] == n[j]) { // 입력받은값이 기존에 뽑은 정답과 일치할때
                        if (k==j) strike++; // k와 j 가 같을때 strike 값이 하나 오름
                        else ball++; // k 와 j 가 다를때 ball 값이 하나 오름
                    }
            }
            System.out.println(strike + " 스트라이크 " + ball + " 볼"); // strike(변수) + " 스트라이크 " + ball(변수) + " 볼" 를 command 에 표시
            if (strike == 3) // strike 가 3일때
                finish = true; // finish를 true 로 만들어 반복문을 종료시킴
        }
        sc.close(); // 스캐너를 종료시킴
        for (int j=0; j<3; ++j) // 3번반복하며
            System.out.print(n[j] + " "); // 정답을 하나씩 command 로 출력
        System.out.println(": 축하합니다! "); // : 축하합니다!를 command 로 이어 말하며 프로그램이 종료됨
    }
}