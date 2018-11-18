### 常用的一些工具类
1.Slicer 将list按照指定大小切割成多个list
2.java8 lambda对集合操作
```html
#Intermediate （中间方法）：中间操作允许流保持打开的状态，并允许直接调用后续方法
（1）filter（Predicate p）：返回全部使Predicate返回true的元素。
（2）mapToXxx（ToXxxFunction mapper）：对每一个流中的元素按复写ToXxxFunction的方法进行一对一的转换。
（3）peek（Consumer c）：类似于forEach操作。返回流于原有流包含相同的元素。该方法主要用于调试。
（4）distinct（）：该方法用于排序流中所有重复的元素。
（5）sorted（）：该方法用于保证流中的元素在后续的访问中处于有序的状态。
（6）limit（long maxSize）：该方法用于保证对流的后续元素访问中最大允许访问的元素个数。


#Terminal （末端方法）：末端操作时对流的最终操作，当对某个Stream执行末端方法后，该流将无法继续使用
（1）forEach（Consumer c）：遍历元素对每一个元素执行c操作。
（2）toArray（）：将流中的所有元素转换成为一个数组。
（3）reduce（）：合并流中的元素。
（4）min（）：返回流中的最小的元素。
（5）max（）：返回流中的最大的元素。
（6）count（）：返回流中的元素的数量。
（7）anyMatch（Predicate p）：判断流中是否至少包含一个元素符合p。
（8）noneMatch（Predicate p）：判断流中是否没有包含一个元素符合p。
（9）allMatch（Predicate p）：判断流中是否所有元素都符合p。
（10）findAny（）：返回流中的任意一个元素。
```