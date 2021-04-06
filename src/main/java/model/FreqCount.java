package model;

import data.Word;

import java.util.*;

public class FreqCount {
    public static List<Word> count(String arr[]){
        List<Word> countList = new ArrayList<>();
        Map<String, Word> countMap = new HashMap<String, Word>();
        int n = arr.length;
        boolean visited[] = new boolean[n];

        Arrays.fill(visited, false);
        for (int i = 0; i < n; i++) {

            if (visited[i] == true || "".equals(arr[i]))
                continue;

            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i].equals(arr[j])) {
                    visited[j] = true;
                    count++;
                }
            }
            System.out.println(arr[i] + " " + count);
            countList.add(new Word(arr[i], count));
        }
        return countList;
        }
    }
