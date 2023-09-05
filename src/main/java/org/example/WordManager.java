package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class WordManager {
        Scanner s = new Scanner(System.in);
        WordCRUD wordCRUD;
        WordManager(){ wordCRUD = new WordCRUD(s);}
        public int selectMenu(){
            System.out.print("""
                    *** 영단어 마스터 ***
                    ********************
                    1. 모든 단어 보기
                    2. 수준별 단어 보기
                    3. 단어 검색
                    4. 단어 추가
                    5. 단어 수정
                    6. 단어 삭제
                    7. 파일 저장
                    0. 나가기
                    ********************
                    => 원하는 메뉴는?\s""");
            return s.nextInt();
        }


        public void start() {

            boolean state = true;
            while(state){
                int input = selectMenu();
                switch (input){
                    case 1: wordCRUD.listAll();
                        break;
                    case 2:
                    case 3:
                    case 4: wordCRUD.add();
                        break;
                    case 5: wordCRUD.updateWord();
                        break;
                    case 6: wordCRUD.deleteWord();
                        break;
                    case 7:
                    case 0:
                    default:
                        state = false;
                        break;
                }

            }
        }
    }

