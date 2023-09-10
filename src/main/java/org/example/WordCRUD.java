package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{
    ArrayList<Word> list;

    Scanner s = new Scanner(System.in);
    WordCRUD(Scanner s){
        list = new ArrayList<>();
        this.s = s;
    }
    public void FileReader(){
        try{
            BufferedReader buf = new BufferedReader(new FileReader("dictionary.txt"));
            String line = null;
            int count = 0;
            while(true){
                line = buf.readLine();
                if(line == null) break;
                String data[] = line.split("\\|");
                int level = Integer.parseInt(data[0]);
                String word = data[1];
                String meaning = data[2];
                list.add(new Word(0,level,word,meaning));
                count++;
            }
            buf.close();
            System.out.println("===> " + count + "개 로딩 완료!!!");
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
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
            if(word.contains(keyword)) {
                System.out.print((j + 1) + " ");
                System.out.println(list.get(i).toString());
                idlist.add(i);
                j++;
            }
        }
        System.out.println("--------------------------------");

        return idlist;
    }

    @Override // search
    public void listAll(int slevel) {
        int j = 0;
        System.out.println("--------------------------------");
        for(int i=0; i<list.size(); i++){
            int level = list.get(i).getLevel();
            if(level == slevel) {
                System.out.print((j + 1) + " ");
                System.out.println(list.get(i).toString());
                j++;
            }
        }
        System.out.println("--------------------------------");

    }
    @Override // search
    public void search(String keyword) {
        int j = 0;
        System.out.println("--------------------------------");
        for(int i=0; i<list.size(); i++){
            String word = list.get(i).getWord();
            if(word.contains(keyword)) {
                System.out.print((j + 1) + " ");
                System.out.println(list.get(i).toString());
                j++;
            }
        }
        System.out.println("--------------------------------");

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
        System.out.print("=> 삭제할 단어 검색: ");
        String keyword = s.next();
        ArrayList<Integer> idlist = this.listAll(keyword);
        System.out.print("=> 삭제할 번호 선택: ");
        int id = s.nextInt();
        s.nextLine();
        System.out.print("==> 정말로 삭제하시겠습니까?(Y/n)  ");
        String ans = s.next();
        s.nextLine();
        if(ans.equalsIgnoreCase("y")){
            list.remove((int)idlist.get(id-1));
            System.out.println("단어가 삭제되었습니다. ");
        }
        else
            System.out.println("취소되었습니다. ");
    }

    public void levelList() {
        System.out.print("=> level 입력: ");
        listAll(s.nextInt());
    }

    public void searchWord() {
        System.out.print("=> 검색할 단어 입력: ");
        String keyword = s.next();
        search(keyword);
    }
}
