import helpers.Reader;
import implementations.BalancedTreeSymbolTable;
import implementations.HashedSymbolTree;
import implementations.LinkedSymbolTable;

public class Main {

    public static String[] getWords() {
        String path = "/src/works.txt";
        String[] fullFile = Reader.readFile(path);
        return Reader.cleanWords(fullFile);
    }

    public static void main(String[] args) {
        testBalancedTreeSymbolTable();
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
        HashedSymbolTree tree = new HashedSymbolTree();
        String[] words = getWords();
        System.out.println("There are " + words.length + " words");
        for (int i = 0; i < words.length; i++) {
            if (i % 10000 == 0) {
                System.out.println("Finished " + i + " iterations");
            }
            tree.addWord(words[i]);
        }
        System.out.println(tree.getMap());
    }

    public static void testBalancedTreeSymbolTable() {
        String[] temp = new String[]{"G", "E", "J", "H", "I", "O", "S"};
        BalancedTreeSymbolTable tree = new BalancedTreeSymbolTable(temp[0]);
        for (int i = 1; i < temp.length; i++) {
            tree.drawTree();
            tree.getRoot().insert(temp[i]);
        }
        tree.drawTree();
    }

}
