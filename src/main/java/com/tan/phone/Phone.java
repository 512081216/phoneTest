package com.tan.phone;

import java.util.*;

public class Phone  {

    private static Map<Integer, List<String>> LETTER_MAP = new HashMap<Integer, List<String>>();

    static {
        LETTER_MAP.put(0, null);
        LETTER_MAP.put(1, null);
        LETTER_MAP.put(2, Arrays.asList("a","b","c"));
        LETTER_MAP.put(3, Arrays.asList("d","e","f"));
        LETTER_MAP.put(4, Arrays.asList("g","h","i"));
        LETTER_MAP.put(5, Arrays.asList("j","k","l"));
        LETTER_MAP.put(6, Arrays.asList("m","n","o"));
        LETTER_MAP.put(7, Arrays.asList("p","q","r","s"));
        LETTER_MAP.put(8, Arrays.asList("t","u","v"));
        LETTER_MAP.put(9, Arrays.asList("w","x","y","z"));
    }

    /**
     * 转换
     **/
    public List<String> convert(int [] arr){
        List<String> letterList = new ArrayList<String>();
        // 获取映射列表
        List<List<String>> mappingList = getMappingList(arr);
        if (mappingList.size() != 0){
            // 只有一个直接返回
            if (mappingList.size() == 1){
                return mappingList.get(0);
            }
            // 多个时求组合
            for (int i = 0; i < mappingList.size()-1; i++){
                List<String> tempLetterList = new ArrayList<String>();
                List<String> letterList2 = mappingList.get(i+1);
                if (i==0){
                    letterList = new ArrayList(mappingList.get(0));
                }
                for (int j = 0; j < letterList.size(); j++) {
                    for (int k = 0 ; k <letterList2.size(); k++){
                        tempLetterList.add(letterList.get(j) + letterList2.get(k));
                    }
                }
                letterList = tempLetterList;
            }

        }
        return letterList;
    }

    /**
     * 获取映射列表
     **/
    private List<List<String>> getMappingList(int [] arr){
        List<List<String>> mappingList = new ArrayList();
        if (arr.length != 0){
            List<Integer> tempList = new ArrayList();
            for (int i = 0; i < arr.length; i++){
                if (arr[i] != 0 && arr[i] != 1){
                    if (arr[i] > 99){
                        throw new RuntimeException("array digits can not more than 99");
                    }
                    // 如果存在十位数，把个位和十位拆分
                    if (arr[i] > 10){
                        tempList.add((arr[i] % 10));
                        tempList.add((arr[i] % 100)/10);
                    }else {
                        tempList.add((arr[i]));
                    }
                }
            }
            for (int i = 0; i < tempList.size(); i++){
                mappingList.add(LETTER_MAP.get(tempList.get(i)));
            }
        }
        return mappingList;
    }
}
