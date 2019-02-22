import helpers.Reader;
import implementations.HashedSymbolTree;
import implementations.LinkedSymbolTable;

public class Main {

    public static String[] getWords() {
        String path = "/src/works.txt";
        String[] fullFile = Reader.readFile(path);
        return Reader.cleanWords(fullFile);
    }

    public static void main(String[] args) {
        testHashedSymbolTable();
    }

    public static void testLinkedSymbolTable() {
        LinkedSymbolTable list = new LinkedSymbolTable();
        String[] words = getWords();
        System.out.println("There are " + words.length + " words");
        for (int i = 0; i < words.length; i++) {
            if (i % 10000 == 0) {
                System.out.println("Finished " + i + " iterations");
            }
            list.addWord(words[i]);
        }
        System.out.println(list.getList());
    }

    public static void testHashedSymbolTable() {
        HashedSymbolTree list = new HashedSymbolTree();
        String[] words = getWords();
        System.out.println("There are " + words.length + " words");
        for (int i = 0; i < words.length; i++) {
            if (i % 10000 == 0) {
                System.out.println("Finished " + i + " iterations");
            }
            list.addWord(words[i]);
        }
        System.out.println(list.getMap());
    }

}
