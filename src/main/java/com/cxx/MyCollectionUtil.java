package com.cxx;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: cxx
 * @Date: 2018/11/18 16:22
 * 集合工具类
 */
public class MyCollectionUtil {

    public static List<User> getUsers(){
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            users.add(new User(){{
                setAge(new Random().nextInt(100));
                setUserName("用户："+finalI);
            }});
        }
        return users;
    }

    //1.获取集合某个属性
    public static List<String> getUserNames(){
        List<User> list = getUsers();
        return list.stream().map(User::getUserName).collect(Collectors.toList());
    }

    //2.根据对象集合中某个属性去掉对象集合中重复对象,getAge去重属性
    public static List<User> distinctList(){
        List<User> list = getUsers();
        List<User> distinctList = list.stream().collect(Collectors.collectingAndThen(
                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(User::getAge))), ArrayList::new)
        );
        return distinctList;
    }

    //3.筛选list
    public static List<User> removeIf(){
        List<User> list = getUsers();
        list.removeIf(a -> a.getAge()> 65);
        return list;
    }

    //4.stream  这些API代表多个支持串行和并行聚集操作的元素
    public static void streamTest(){
        List<User> list = getUsers();
        //1.filter 遍历数据并检查其中的元素
        list.stream().filter(a -> a.getAge() > 20).collect(Collectors.toList());
        list.stream().filter(a -> {
            if (a.getAge()> 20 && a.getUserName().equals("cxx")){
                return true;
            }
            return false;
        }).collect(Collectors.toList());
        list.stream().filter(a -> (a.getAge() > 20 && a.getUserName().equals("cxx"))).collect(Collectors.toList());


        //2.Map 生成的是个一对一映射,for的作用
        list.stream().map(User::getAge).collect(Collectors.toList());
        list.stream().map(a -> a.getAge()).collect(Collectors.toList());


        //3.FlatMap 跟map差不多,更深层次的操作
        List<List<String>> lists = Arrays.asList(Arrays.asList("Jordan"),
                Arrays.asList("Kobe","James"),Arrays.asList("Durant","Curry")
        );
        lists.stream().flatMap(Collection::stream).map(str -> str.length()>2).count();


        //4.Reduce 类似递归,累加
        list.stream().map(User::getAge).reduce(0, (a, b) ->a + b);


        //5.Collect toList(),toSet(),toMap()
        list.stream().collect(Collectors.toSet());
        list.stream().collect(Collectors.toMap(User::getAge, User::getUserName));

        //6.distinct distinct基于Object.equals(Object)实现

    }


    //Optional 用来替换 null 值
    public static void optionalTest(){
        /**
         * Optional.of(T)，T为非空，否则初始化报错
         * Optional.ofNullable(T)，T为任意，可以为空
         * isPresent()，相当于 ！=null
         * ifPresent(T)，
         */
        //对象为空则打出 -
        User user = null;
        Optional<Object> o = Optional.of(new User());
        System.out.println(o.isPresent());

        Optional<User> user1 = Optional.ofNullable(user);
        System.out.println(user1.isPresent());

        //如果user不为空
        Optional.ofNullable(user).ifPresent(a -> {
            System.out.println(a.getAge());
        });

        //如果空，返回某个结果
        Optional.ofNullable(user).orElseGet(()-> {
            return null;
        });

        //如果空，抛异常
      /*  Optional.ofNullable(user).orElseThrow(() -> {
            throw new RuntimeException("参数不合法");
        });*/
    }

    public static void main(String[] args) {
        //getUserNames().forEach(System.out::println);
        //removeIf().forEach(System.out::println);
        //optionalTest();
        Supplier<User> user = User::new;
        user.get();
    }
}
