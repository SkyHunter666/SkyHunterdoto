/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

/**
 *
 * @author hung
 */

import static dictionary.Dictionary.dsWord;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;


public class DictionaryManagement {
    
    
   
    
    
        public void insertFromCommandline(){
        Scanner sc = new Scanner(System.in, "utf-8");
        System.out.println("-----Thêm từ vào từ điển-------");
        System.out.print("Nhập số  từ muốn thêm: ");
        int sl = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < sl; i++) {
            System.out.print("Nhập từ muốn thêm: ");
            String target = sc.nextLine();
            System.out.print("Nhập nghĩa Tiếng Việt: ");
            String explain = sc.nextLine();
            Dictionary.dsWord.add(new Word(target, explain));
        } 
        
        System.out.println("Đã thêm thành công");
    }
    
    @SuppressWarnings("empty-statement")
         public void insertFromFile(){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("dictionaries.txt"), "UTF-8"));
            
            String line;
            line = br.readLine();
;
             while (line != null) {
                 if (!line.contains("\t")) {
                    line = br.readLine();
                    continue;
                }
                Word w = new Word(line);
                Dictionary.dsWord.add(w);
                line = br.readLine();
            }
             br.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            System.out.println("Error " + ex);
        } catch (IOException ex) {
            System.out.println("Error " + ex);
        }
    }
         
         public void dictionaryLookup(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập từ cần tìm :");
        String s = sc.nextLine();
        for (Word w : Dictionary.dsWord) {
            if (w.getWord_target().equals(s)) {
                w.showWord();
                return;
            }
        }
        System.out.println("Không tìm thấy từ yêu cầu !!!");
    }
         
         
        public void dictionaryExportToFile() {
        BufferedWriter bw = null;
        try {
            String fileName = null;
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
            for (Word ele : Dictionary.dsWord) {
                bw.write(ele.getWord_explain() + "\t" + ele.getWord_target());
                bw.newLine();
            }
            bw.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            System.out.println("Error " + ex);
        } catch (IOException ex) {
            System.out.println("Error " + ex);
        }
        
        
    }
        void EditWord()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao tu can sua: ");
        String search = sc.nextLine();
        search = search.toLowerCase();
        boolean found;
        found = false;
        for (Word w : dsWord)
        {
            if (w.getWord_target().equals(search))
            {
                found = true;
                String temp;
                System.out.print("nhap tu moi: ");
                temp = sc.nextLine();
                w.setWord_target(temp);
                System.out.print("nhap nghia moi: ");
                temp = sc.nextLine();
                w.setWord_explain(temp);
                break;
            }
        }
        if (!found)
        {
            System.out.println("khong tim thay tu " + search);
        }
    }
        
        void DeleteWord()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap tu can xoa: ");
        String search = sc.nextLine();
        search = search.toLowerCase();
        boolean found = false;
        for (Word w : dsWord)
        {
            if (w.getWord_target().equalsIgnoreCase(search))
            {
                found = true;
                dsWord.remove(w);
                System.out.println("da xoa tu " + search);
                break;
            }
        }
        if (!found)
        {
            System.out.println("khong co tu " + search);
        }
    }
        
        
        
        
         
}
