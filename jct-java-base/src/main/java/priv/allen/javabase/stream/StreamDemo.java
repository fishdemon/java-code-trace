package priv.allen.javabase.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * java 1.8 新特性 stream api 用法
 * 參考：  https://www.cnblogs.com/shenlanzhizun/p/6027042.html
 */
public class StreamDemo {
    // 双大括号赋值
    static List<User> userList = new ArrayList<User>() {{
        add(new User(1, "allen", 12));
        add(new User(2, "amy", 45));
        add(new User(3, "json", 39));
        add(new User(4, "jack", 18));
        add(new User(5, "june", 20));
        add(new User(6, "lacy", 20));
    }};

    // 中间操作：过滤筛选
    public static void testFilter() {
        System.out.println("==============1===============");
        // filter 过滤：根据条件过滤，允许用多个filter 多次过滤
        List<User> users  = userList.stream().filter((u) -> u.age > 20).collect(Collectors.toList());
        users.forEach(System.out::println);

        System.out.println("==============2===============");
        users  = userList.stream().filter((u) -> u.age >12).filter((u) -> u.age < 45).collect(Collectors.toList());
        users.forEach(System.out::println);

        System.out.println("==============3===============");
        // distinct 去重：比较两个对象的 equals 方法, 对上一个返回流中的所有对象进行去重
        users  =userList.stream().filter(u -> u.age > 2).distinct().collect(Collectors.toList());
        users.forEach(System.out::println);

        System.out.println("==============4===============");
        // limit 限制: 取流中的前n个元素
        users  =userList.stream().limit(2).collect(Collectors.toList());
        users.forEach(System.out::println);

        System.out.println("==============5===============");
        // skip 跳过: 跳过流中的前n个元素
        users  =userList.stream().skip(2).collect(Collectors.toList());
        users.forEach(System.out::println);
    }

    // 中间操作：映射
    public static void testMap() {
        System.out.println("==============1===============");
        // map 映射操作
        List<String> names = userList.stream().map(User::getName).collect(Collectors.toList());
        names.forEach(System.out::println);

        List<Integer> ages = userList.stream().map(User::getAge).collect(Collectors.toList());
        ages.forEach(System.out::println);

        System.out.println("==============2===============");
        // 输出每个 user name 的所有组成字符,
        List<String[]> strs = userList.stream()
                .map(user -> user.getName().split(""))
                .collect(Collectors.toList());
        strs.forEach(strings -> System.out.println(Arrays.toString(strings)));

        System.out.println("==============3===============");
        // flatmap , 扁平化处理，比如將 List<String[]> -> List<String>
        // 输出所有 user name 的不重复组成字符
        List<String> chars = userList.stream()
                .map(user -> user.getName().split("")) // 将 user name 分割成字符数组，返回 List<String[]>
                .flatMap(Arrays::stream) // 将所有的字符数组扁平化为一个大的字符列表，返回 List<String>
                .distinct() // 对 List<String> 进行去重操作
                .collect(Collectors.toList());
        chars.forEach(System.out::print);
    }

    // 终端操作：查找
    public static void testFind() {
        System.out.println("==============1===============");
        // allMatch: 用于测试流中所有的元素是否都满足条件，只要有一个满足，则返回 false
        boolean isMatch = userList.stream().allMatch(u -> u.getAge() > 20);
        System.out.println(isMatch);

        System.out.println("==============2===============");
        // anyMatch: 用于检测流中是否有一个或多个满足条件，如果有，返回 true
        isMatch = userList.stream().anyMatch(u -> u.getAge() > 20);
        System.out.println(isMatch);

        System.out.println("==============3===============");
        // anyMatch: 用于检测流中是否不存在满足条件的元素，如果不存在，返回 true
        isMatch = userList.stream().noneMatch(u -> u.getAge() > 20);
        System.out.println(isMatch);

        System.out.println("==============4===============");
        // findFirst: 返回第一个元素
        Optional<User> res = userList.stream().findFirst();
        User user =  res.get();
        System.out.println(user.toString());

        System.out.println("==============5===============");
        // findAny： 返回任意一个元素，但是对于顺序流来说， findFirst 与 findAny 是一样的。。。
        // 对于 parallelStream 并行流来说，findAny会比较好
        res = userList.stream().findAny();
        user =  res.get();
        System.out.println(user.toString());
    }

    // 规约操作
    public static void testConvention() {
        System.out.println("==============1===============");
        // 规约操作 sum : 计算总和
        int total = userList.stream().mapToInt(User::getAge).sum();
        System.out.println("total age: " + total);

        System.out.println("==============2===============");
        // 规约 reduce
        total = userList.stream().mapToInt(User::getAge).reduce(0, (a,b)->a+b);
        System.out.println("total age: " + total);

        System.out.println("==============3===============");
        // 进一步简化
        total = userList.stream().mapToInt(User::getAge).reduce(0, Integer::sum);
        System.out.println("total age: " + total);
    }

    // collectors 收集器规约操作
    public static void testCollectorsConvention() {
        // 求总数
        long count = userList.stream().collect(Collectors.counting());
        // 进一步简化
        count = userList.stream().count();

        // 求最大值
        Optional<User> orderUser = userList.stream().collect(Collectors.maxBy((u1, u2) -> u1.getAge()-u2.getAge()));
        orderUser = userList.stream().collect(Collectors.maxBy(Comparator.comparing(User::getAge)));

        // 求最小值
        Optional<User> youngestUser = userList.stream().collect(Collectors.minBy(Comparator.comparing(User::getAge)));

        // 求年龄总和
        int totalAge = userList.stream().collect(Collectors.summingInt(User::getAge));

        // 求年龄平均值
        double averageAge = userList.stream().collect(Collectors.averagingInt(User::getAge));

        // 一次性得到元素个数，总和，均指，最大值，最小值
        IntSummaryStatistics summaryStatistics = userList.stream().collect(Collectors.summarizingInt(User::getAge));

        // 字符串拼接
        String names = userList.stream().map(User::getName).collect(Collectors.joining());
        // 用逗号拼接字符串
        String namesWithComma = userList.stream().map(User::getName).collect(Collectors.joining(","));
    }

    // collectors 收集器分组/分区操作
    public static  void testGroup() {
        System.out.println("==============1===============");
        // list -> map
        Map<Integer, User> userMap = userList.stream().collect(Collectors.toMap(User::getId, user -> user));
        Map<Integer, String> nameMap = userList.stream().collect(Collectors.toMap(User::getId, user -> user.getName()));

        System.out.println("==============2===============");
        // groupby 进行数据分组
        Map<Integer,List<User>> userGroupingMap = userList.stream().collect(Collectors.groupingBy(User::getAge));

        System.out.println("==============3===============");
        // groupby 进行数据多级分组
        Map<Integer, Map<String, List<User>>> userGroupingMap2 = userList.stream().collect(
                Collectors.groupingBy(User::getAge,             // 一级分组, 按年龄
                        Collectors.groupingBy(User::getName))   // 二级分组, 按姓名
        );

        System.out.println("==============4===============");
        // groupby 进行分组统计
        // groupby 的第二个参数不是只能传递 goupingby 实现多级分组，还能传递 Collectors 的其他方法
        Map<Integer, Long> groupCount = userList.stream().collect(Collectors.groupingBy(User::getAge, Collectors.counting()));

        System.out.println("==============5===============");
        // partitioningBy 分区（可以看成是分组的特例，只分有两组）
        // 参数是条件语句，将结果分为两组，true / false
        Map<Boolean, List<User>> partitionMap = userList.stream().collect(Collectors.partitioningBy(u -> u.getAge() > 20));
        // 分区统计, 满足条件与不满足条件的个数统计
        Map<Boolean, Long> partitioinCount = userList.stream().collect(Collectors.partitioningBy(user -> user.getAge()>20, Collectors.counting()));
    }

    // 数组流操作
    public static void testArray() {
        String[] arr = new String[] {"1","2","3"};
        Stream<String> arrStream = Arrays.stream(arr);
        arrStream.forEach(System.out::println);


    }

    public static void main(String[] args) {
        testCollectorsConvention();
    }

    private static class User {
        private Integer id;
        private String name;
        private Integer age;

        public User() {
        }

        public User(Integer id, String name, Integer age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}


