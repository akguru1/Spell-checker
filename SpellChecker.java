import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util. *;

public class SpellChecker {
    private ArrayList<String> dictionary;

    public SpellChecker() {
        dictionary = new ArrayList<String>(130000);
        try {
            readLines("dictionary.txt");
        } catch (IOException e) {
            // Print out the exception that occurred
            System.out.println("Unable to access " + e.getMessage());
        }

    }

    /**
   * This uses linear search to find o(dictionary in the dictionary ArrayList and also
   * prints out the number words in dictionarys checked. If not foundo(dictionary is misspelled.
   */
    public Result linearSpellCheck(String word) {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++) {
            count++;
            if (word.equals(dictionary.get(i))) {
                return new Result(count, true);
            }

        }
        return new Result(count, false);

    }

    /**
   * Modify this code so that it uses a binary search
   */
    public Result binarySpellCheck(String word) {
        int count = 0;
        int left = 0;
        int right = dictionary.size() - 1;
        while (left <= right) {
            count++;
            int middle = (left + right) / 2;
            if (word.compareTo(dictionary.get(middle)) < 0) {
                right = middle - 1;
            } else if (word.compareTo(dictionary.get(middle)) > 0) {
                left = middle + 1;
            } else {
                return new Result(count,true);
            }
        }
        return  new Result(count,false);
    }

    private void readLines(String filename)throws IOException {
        FileReader fileReader = new FileReader(filename);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = null;

        while ((line = bufferedReader.readLine()) != null) {
            dictionary.add(line);
        }

        bufferedReader.close();

    }

}
