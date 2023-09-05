package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{
    ArrayList<Word> list;

    Scanner s = new Scanner(System.in);
    WordCRUD(Scanner s){
        list = new ArrayList<>();
        this.s = s;
    }

    @Override
    public void listAll() {
        System.out.println("--------------------------------");
        for(int i=0; i<list.size(); i++){
            System.out.print((i+1) + " ");
            System.out.println(list.get(i).toString());
        }
        System.out.println("--------------------------------");
    }

    @Override // search
    public ArrayList<Integer> listAll(String keyword) {
        ArrayList<Integer> idlist = new ArrayList<>();
        int j = 0;
        System.out.println("--------------------------------");
        for(int i=0; i<list.size(); i++){
            String word = list.get(i).getWord();
            if(!word.contains(keyword)) continue;
            System.out.print((j+1) + " ");
            System.out.println(list.get(i).toString());
            idlist.add(i);
            j++;
        }
        System.out.println("--------------------------------");

        return idlist;
    }

    @Override
    public void add() {
        System.out.print("=> 난이도(1,2,3) & 새 단어 입력: ");
        int level = s.nextInt();
        String word = s.next();
        s.nextLine();
        System.out.print("뜻 입력: ");
        String meaning = s.nextLine();

        Word input = new Word(0, level,word, meaning);
        list.add(input);

        System.out.println("새 단어가 단어장에 추가되었습니다 !!! ");
    }
    @Override
    public void updateWord(){
        System.out.print("=> 수정할 단어 검색: ");
        String keyword = s.next();
        ArrayList<Integer> idlist = this.listAll(keyword);
        System.out.print("=> 수정할 번호 선택: ");
        int id = s.nextInt();
        s.nextLine();
        System.out.print("뜻 입력: ");
        String meaning = s.nextLine();

        Word word = list.get(idlist.get(id-1));
        word.setMeaning(meaning);
        System.out.println("단어가 수정되었습니다.");
    }
    @Override
    public void deleteWord() {
    }
}
