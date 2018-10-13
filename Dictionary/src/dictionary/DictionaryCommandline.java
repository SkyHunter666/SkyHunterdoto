/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import static dictionary.Dictionary.dsWord;
import java.util.Scanner;

/**
 *
 * @author hung
 */
public class DictionaryCommandline {
    
    public void showAllWords(){
       if(Dictionary.dsWord.isEmpty()){
       } else {
           System.out.println("No  | English 		| Vietnamese");
           int i = 1;
           for(Word w : Dictionary.dsWord){
               System.out.printf("%-4d", i);
               w.showWord();
               i++;
           }
        }
   }
   
   public void dictionaryBasic() {
       DictionaryManagement dic = new DictionaryManagement();
       dic.insertFromCommandline();
       this.showAllWords();
        
    
}
   
    public void dictionaryAdvanced() {
      DictionaryManagement dic = new DictionaryManagement();
      dic.insertFromFile();
      this.showAllWords();
      dic.dictionaryLookup();
   }
    
    void dictionarySearcher()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert a word ");
        String search = sc.nextLine();
        search = search.toLowerCase(); // chuyen ve chu thuong

        int i = 0;
        for (Word w : dsWord)
        {
            if (w.getWord_target().contains(search))
            {
                i++;
                if (i == 1)
                {
                    System.out.println("------------------Ket qua---------------------");
                    System.out.printf("%-5s| %-20s | Vietnamese\n", "No", "English");
                }
                System.out.printf("%-5d| %-20s | %s\n", i, w.getWord_target(), w.getWord_explain());
            } else {
            }
        }

        if (i == 0)
        {
            System.out.println("khong co tu " + search);
        }
    }
}
