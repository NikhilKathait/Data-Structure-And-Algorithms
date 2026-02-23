import java.util.*;

public class worldLadder2DSAContest {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> dict) {

        ArrayList<ArrayList<String>> result = new ArrayList<>();

        // If start == end case
        if (start.equals(end)) {
            ArrayList<String> path = new ArrayList<>();
            path.add(start);
            result.add(path);
            return result;
        }

        Set<String> wordSet = new HashSet<>(dict);

        // If end not present, no solution
        if (!wordSet.contains(end)) {
            return result;
        }

        Map<String, List<String>> parents = new HashMap<>();

        Set<String> currentLevel = new HashSet<>();
        currentLevel.add(start);

        boolean found = false;

        while (!currentLevel.isEmpty() && !found) {

            wordSet.removeAll(currentLevel);
            Set<String> nextLevel = new HashSet<>();

            for (String word : currentLevel) {

                char[] arr = word.toCharArray();

                for (int i = 0; i < arr.length; i++) {
                    char original = arr[i];

                    for (char c = 'a'; c <= 'z'; c++) {

                        // Avoid same word generation
                        if (c == original) continue;

                        arr[i] = c;
                        String newWord = new String(arr);

                        if (wordSet.contains(newWord)) {

                            nextLevel.add(newWord);

                            parents.putIfAbsent(newWord, new ArrayList<>());
                            parents.get(newWord).add(word);

                            if (newWord.equals(end)) {
                                found = true;
                            }
                        }
                    }

                    arr[i] = original;
                }
            }

            currentLevel = nextLevel;
        }

        if (!found) return result;

        backtrack(end, start, parents, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(String word, String start,
                           Map<String, List<String>> parents,
                           ArrayList<String> path,
                           ArrayList<ArrayList<String>> result) {

        path.add(word);

        if (word.equals(start)) {
            ArrayList<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            result.add(temp);
        } else {
            if (parents.containsKey(word)) {
                for (String parent : parents.get(word)) {
                    backtrack(parent, start, parents, path, result);
                }
            }
        }

        path.remove(path.size() - 1);
    }
}
