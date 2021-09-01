package org.open.challenges.zilingo;

import java.util.*;
import java.util.stream.Collectors;

public class ZilingoJune2019Test {
    public static void main(String[] args) {
        int n = 5;
        List<Integer> from = Arrays.asList(1, 1, 2, 2, 2);
        List<Integer> to = Arrays.asList(2, 2, 3, 3, 4);
        List<Integer> weight = Arrays.asList(1, 2, 1, 3, 3);

        System.out.println(countCandies(n, from, to, weight));
    }

    public static char slowestKey(List<List<Integer>> keyTimes) {
        char ch = ' ';
        int maxTime = 0, prev = 0, temp;

        for (List<Integer> row : keyTimes) {
            temp = row.get(1) - prev;
            if (temp > maxTime) {
                maxTime = temp;
                ch = (char) (row.get(0) + 97);
            }
            prev = row.get(1);
        }

        return ch;
    }

    public static int comparatorValue(List<Integer> a, List<Integer> b, int d) {
        int res = 0, j;

        for (Integer aValue : a) {
            for (j = 0; j < b.size(); j++) {
                if (Math.abs(aValue - b.get(j)) <= d) {
                    break;
                }
            }

            if (j == b.size()) {
                res++;
            }
        }

        return res;
    }

    public static int getMinimumUniqueSum(List<Integer> arr) {
        int res = 0, loop;
        boolean[] visited = new boolean[6001];
        for (Integer value : arr) {
            if (visited[value]) {
                loop = value;
                while (visited[loop]) {
                    loop++;
                }

                res += loop;
                visited[loop] = true;
            } else {
                res += value;
                visited[value] = true;
            }
        }

        return res;
    }

    public static int countCandies(int friends_nodes, List<Integer> friends_from, List<Integer> friends_to, List<Integer> friends_weight) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < friends_nodes; i++) {
            map.computeIfAbsent(friends_weight.get(i), HashSet::new).addAll(Arrays.asList(friends_from.get(i), friends_to.get(i)));
        }

        LinkedHashMap<Integer, Set<Integer>> sortedMap = map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue(Comparator.comparingInt(Set::size))))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));

        int res = 0, temp = 0, maxSize = -1;
        for (Map.Entry<Integer, Set<Integer>> entry : sortedMap.entrySet()) {
            if (maxSize == -1) {
                maxSize = entry.getValue().size();
            }

            if (maxSize != entry.getValue().size()) {
                break;
            }

            List<Integer> sortedList = entry.getValue().stream()
                    .sorted(Collections.reverseOrder())
                    .collect(Collectors.toList());

            if (sortedList.size() > 0) {
                temp = sortedList.get(0);
            }

            if (sortedList.size() > 1) {
                temp *= sortedList.get(1);
            }

            if (temp > res) {
                res = temp;
            }
        }

        return res;
    }
}
