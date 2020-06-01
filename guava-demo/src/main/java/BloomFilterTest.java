import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Assert;
import org.junit.Test;

/**
 * BloomFilterTest
 *
 * @author chenghongguo
 * @date 2020/4/14
 * @since 1.0.0
 */
public class BloomFilterTest {

    @Test
    public void test1() {
        BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), 500, 0.01);

        filter.put(1);
        filter.put(2);
        filter.put(3);

        Assert.assertTrue(filter.mightContain(1));
        Assert.assertTrue(filter.mightContain(2));
        Assert.assertTrue(filter.mightContain(3));

        Assert.assertFalse(filter.mightContain(100));


    }
}
