package com.cxx;

import org.apache.commons.collections.CollectionUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: cxx
 * @Date: 2018/11/18 15:50
 * 排序工具类
 */
public class SortUtil {

    //使用Comparator的comparing
    public static void sortPlate0(List<User> users) {
        if (CollectionUtils.isNotEmpty(users)) {
            users.sort(Comparator.comparingInt(User::getAge).reversed());
        }
    }

    //如果age一样重，就得再找一个条件来进行排序(双重排序)
    public static void sortPlate1(List<User> users) {
        if (CollectionUtils.isNotEmpty(users)) {
            users.sort(Comparator.comparingInt(User::getAge).reversed().thenComparing(User::getUserName));
        }
    }


    //匿名内部类
    public static void sortPlate2(List<User> users) {
        if (CollectionUtils.isNotEmpty(users)) {
            users.sort(new Comparator<User>() {
                @Override
                public int compare(User o1, User o2) {
                    /**
                     * o1:1  o2:0
                     * o1 - o2 升序
                     * o2 - o1 降序
                     */
                    return o1.getAge() - o2.getAge();
                }
            });
        }
    }

    //使用Lambda表达式
    public static void sortPlate3(List<User> users) {
        if (CollectionUtils.isNotEmpty(users)) {
            users.sort((a, b) -> a.getAge() - b.getAge());
        }
    }



    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            users.add(new User(){{
                setAge(finalI);
            }});
        }
        users.forEach(System.out::println);
        sortPlate2(users);
        System.out.println();
        users.forEach(System.out::println);

    }
}