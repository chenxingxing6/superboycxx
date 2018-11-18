package com.cxx;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: cxx
 * @Date: 2018/11/18 15:13
 * @Desc: 切割器
 */
public class Slicer {


    /**
     * 将list按照指定的大小切割成多个list
     *
     * @param list  list
     * @param gap   分片大小
     * @param <T>   数据类型
     * @return      List<List<T>>
     */
    public static <T> List<List<T>> slice(List<T> list, int gap){
        Objects.requireNonNull(list);
        if (gap <=0){
            throw new IllegalArgumentException("分片大小应该大于0");
        }
        int size = list.size();
        if (gap >= size){
            List<List<T>> result = new ArrayList<>();
            result.add(list);
            return result;
        }
        int num = size / gap;
        int remainder = size % gap;
        num += remainder == 0 ? 0:1;
        List<List<T>> result = new ArrayList<>(num+1);
        for (int i = 0; i < num; i++) {
            int from = i*gap;
            int to = i == num-1 && remainder !=0 ? from+remainder: from+gap;
            List<T> temp = new ArrayList<>(list.subList(from, to));
            result.add(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <=17 ; i++) {
            list.add(i+"");
        }
        List<List<String>> slice = slice(list, 4);
        for (List<String> slouse : slice) {
            slouse.forEach(e -> {
                System.out.print(e +" ");
            });
            System.out.println();
        }
    }
}
