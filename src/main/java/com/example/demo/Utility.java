package com.example.demo;

public class Utility {

    // 3. Code Smell: 유틸리티 클래스인데 생성자가 public임 (인스턴스화 방지 필요)
    public Utility() { }

    // 4. Bug & Smell: 동일한 조건문 중복 및 무의미한 코드
    public void checkValue(int x) {
        if (x > 10) {
            System.out.println("Greater than 10");
        } else if (x > 10) { // 똑같은 조건 (절대 실행 안 됨)
            System.out.println("This is unreachable");
        }
    }

    // 5. Duplication: 아래와 똑같은 메서드를 또 만듦
    public void processData() {
        System.out.println("Processing...");
        System.out.println("Done.");
    }

    public void processDataAgain() {
        System.out.println("Processing...");
        System.out.println("Done.");
    }
}