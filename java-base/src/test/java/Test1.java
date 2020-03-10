import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Test1
 *
 * @author chenghongguo
 * @date 2020/2/18
 * @since 1.0.0
 */
public class Test1 {

    @Test
    public void test1() {
        String s = "123|abc";
        String[] split = s.split("\\|");
        System.out.println(split[0] + "=" + split[1]);
    }

    @Test
    public void test2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 5);
        List<Integer> collect = list.stream().filter(i -> i > 6).collect(Collectors.toList());
        System.out.println(collect);
        collect.addAll(new ArrayList<>());
    }

    @Test
    public void testTags() {
        String filePath = "e:\\a.txt";
        File file = new File(filePath);
        Map<String, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] names = line.split(",");
                set.add(names[0].toUpperCase());
                if (map.containsKey(names[1])) {
                    System.out.println("name[1]=" + names[1]);
                } else {
                    map.put(names[1].toUpperCase(), names[0]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("----------------");
        System.out.println(set.size() + ", " + map.keySet().size());
        System.out.println("---------------------");
        if (!map.isEmpty()) {
            map.forEach((k, v) -> System.out.println(k + "=" + v));
        }
    }
}
