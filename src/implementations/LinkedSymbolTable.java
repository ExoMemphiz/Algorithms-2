package implementations;

import helpers.Word;

import java.util.LinkedList;

public class LinkedSymbolTable {

    private LinkedList<Word> list;

    public LinkedSymbolTable() {
        list = new LinkedList<Word>();
    }

    public void addWord(String word) {
        boolean updatedWord = false;
        for (int i = 0; i < list.size(); i++) {
            Word w = list.get(i);
            if (w.getWord().equals(word)) {
                w.incrementCount();
                list.set(i, w);
                updatedWord = true;
                break;
            }
        }
        if (!updatedWord) {
            list.add(new Word(word));
        }
    }

    public LinkedList<Word> getList() {
        return list;
    }

}
