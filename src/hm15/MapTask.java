package hm15;

import hm14.employee.Employee;

import java.util.*;

public class MapTask {
    public static List<String> getCityList(HashMap<String, String> map, String city) {
        ArrayList<String> logins = new ArrayList<>();

        if (!map.containsValue(city)) {
            return logins;
        }

        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (pair.getValue().equals(city)) {
                logins.add(pair.getKey());
            }
        }

        return logins;
    }

    public static HashMap<String, Integer> getNumberOfString(List<String> words) {
        HashMap<String, Integer> wordsCount = new HashMap<>();

        for (String word : words) {
            if (wordsCount.containsKey(word)) {
                wordsCount.replace(word, wordsCount.get(word) + 1);
            } else {
                wordsCount.put(word, 1);
            }
        }

        return wordsCount;
    }

    public static HashMap<String, Customer> getSortedCustomers(HashMap<String, Customer> customerMap, int from, int to) {
        HashMap<String, Customer> customers = new HashMap<>();

        for (Map.Entry<String, Customer> pair : customerMap.entrySet()) {
            if (pair.getValue().getAge() >= from && pair.getValue().getAge() < to) {
                customers.put(pair.getKey(), pair.getValue());
            }
        }

        return customers;
    }

    public static HashMap<Integer, HashSet<String>> letterGrouping(String text) {
        String[] words = text.split(" ");
        HashMap<Integer, HashSet<String>> groups = new HashMap<>();

        for (String word : words) {
            int count = word.length();

            if (groups.containsKey(count)) {
                groups.get(count).add(word);
            } else {
                HashSet<String> strings = new HashSet<>();
                strings.add(word);
                groups.put(count, strings);
            }
        }

        return groups;
    }

    public static long wordCounter(String text, String searchWord) {
        long counter = 0;
        String[] words = text.split(" ");

        for (String word : words) {
            if (word.equals(searchWord)) {
                counter++;
            }
        }

        return counter;
    }

    //  3. ???????????????? ??????????, ?????????????? ?????????????? ?? ?????????????? ?????? 10 ?????????? ?????????? ?????????????????????? ?? ???????????? ????????
    //  (?????????????? ?? ???????????????? ???????? ?????????????? ???? ??????????)
    public static HashMap<String, Long> getTop10Words(String text) {
        String[] words = text.split(" ");

        HashSet<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        HashMap<String, Long> wordsRating = new HashMap<>(uniqueWords.size());

        for (String string : uniqueWords) {
            wordsRating.put(string, wordCounter(text, string));
        }

        return sortByValue(wordsRating);
    }

    public static HashMap<String, Long> sortByValue(HashMap<String, Long> map) {
        HashMap<String, Long> sortedMap = new HashMap<>(map.size());
        ArrayList<Long> values = new ArrayList<>(map.values());
        Collections.sort(values, Collections.reverseOrder());

        for (int i = 0; i < 10; i++) {
            for (Map.Entry<String, Long> pair : map.entrySet()) {
                if (pair.getValue().equals(values.get(i))) {
                    sortedMap.put(pair.getKey(), pair.getValue());
                    if (sortedMap.size() == 10) break;
                }
            }
        }

        return sortedMap;
    }

    public static void main(String[] args) {
        // FIXME:: ?? ???????????????? ???? ???????????????????????? lambda ?????????????????? ?? stream API

        // TODO:: ???????????????? ?????????????????????? ??????????, ?????????????? ?????????????????? ???? ???????? ???????? (firstTaskMap) ?? ?????????? (city),
        //  ?????????????????? ?? ???????????????????? ???????????? (List) ??????????????, ?????????????? ?????????????????????????? ?????????????????????? ????????????

        HashMap<String, String> firstTaskMap = new HashMap<>();
        firstTaskMap.put("qwe", "??????????");
        firstTaskMap.put("asd", "??????????");
        firstTaskMap.put("zxc", "????????????");
        firstTaskMap.put("rty", "??????????");
        firstTaskMap.put("fgh", "??????????????");

        String city = "??????????";

        System.out.println(getCityList(firstTaskMap, city));

        // TODO:: ?????? ???????????? ???????? (words).
        //  ???????????????? ?????????????????????? ??????????, ?????????????? ?????????? ???????????????????? ???????????????????? ???????????????????? ????????
        //  ?? ???????? ???????? Map<String, Integer>, ?????? String - ?????????? ?? Integer - ???????????????????? ????????????????????

        List<String> words = new ArrayList<>();
        words.add("may");
        words.add("august");
        words.add("june");
        words.add("may");
        words.add("may");
        words.add("july");
        words.add("may");
        words.add("august");
        words.add("august");

        System.out.println(getNumberOfString(words));

        // TODO:: ???????? ???????? (customerMap).
        //  ???????????????? ?????????????????????? ??????????, ?????????????? ?????????????????? ???? ???????? ?????????????????? int from ?? int to ?? ????????????????????
        //  ?????????? ????????, ?? ?????????????? ???????????? ?????? ????????????????????, ?????????????? ?????????????? ?????????????????? ?? ?????????????????? [from, to)

        HashMap<String, Customer> customerMap = new HashMap<>();
        customerMap.put("1", new Customer("??????????", "1", 23));
        customerMap.put("2", new Customer("????????", "2", 17));
        customerMap.put("3", new Customer("????????????", "3", 48));
        customerMap.put("4", new Customer("??????????????", "4", 67));

        System.out.println(getSortedCustomers(customerMap, 23, 67));

        // TODO:: ?????????????? ???? ???????????? (text). ???? ???????????? ?????????? - ?????????????? ???????? ?????????? (?????????? ??????????????????????):
        //  1. ???????????????? ??????????, ?????????????????????? ???? ???????? ?????????? ?? ???????????????????????? ?????????????? ?????????????????????????? ?????????????? ?????????? ?? ????????????
        //  (Map<String, Long>, ?????? - ?????????? (String) - ??????????, ???????????????? (Long) - ?????????????? ??????????????????????????)
        //  2. ???????????????? ??????????, ?????????????? ???????????????? ?????? ?????????? ?? ???????????? ???? ???????????????????? ????????:
        //  ????????????????, ?? ???????? ???????????? ?????????????? ??????????: 3 - [the, war, jar, get, met...], ?? ???????????? 2 - [on, up, no, of...]
        //  (Map<Integer, ArrayList<String>>, ?????? - ?????????? (Integer) - ???????????????????? ????????, ???????????????? (ArrayList<String>) - ??????????)
        //  3. ???????????????? ??????????, ?????????????? ?????????????? ?? ?????????????? ?????? 10 ?????????? ?????????? ?????????????????????? ?? ???????????? ???????? (?????????????? ?? ???????????????? ???????? ?????????????? ???? ??????????)

        // ?? ???????????? ???????????????????? ???????????? ?????????? ?? ???????????????????? ??????????????
        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";

        System.out.println(wordCounter(text, "many"));
        System.out.println(letterGrouping(text));
        System.out.println(getTop10Words(text));
    }

}