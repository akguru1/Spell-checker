import java.util. *;

class Main {
    public static void main(String[] args) {
        SpellChecker checker = new SpellChecker();

        System.out.print("Enter a word to spell check or q to quit: ");
        Scanner scan = new Scanner(System. in);
        String word = scan.nextLine();
        while (!word.equals("q")) {
            Result linearResult = checker.linearSpellCheck(word);
            System.out.println("Linear Search: "+linearResult.Count());

            //System.out.println("Number of words checked using linear search: " + linearResult.count());
            if (linearResult.isFound()) // replace the condition with linearResult.found()
                System.out.println(word + " is spelled correctly!");
            else 
                System.out.println(word + " is misspelled!");

            
            Result  binaryResult = checker.binarySpellCheck(word);
            System.out.println("Binary Search: "+binaryResult.Count());
            //System.out.println("Number of words checked using binary search: " + binaryResult.count());
            if (binaryResult.isFound()) // replace the condition with binaryResult.found()
                System.out.println(word + " is spelled correctly!");
            else 
                System.out.println(word + " is misspelled!");
            
            System.out.print("\nEnter a word to spell check or q to quit: ");
            word = scan.nextLine();
        }
        scan.close();
    }
}
