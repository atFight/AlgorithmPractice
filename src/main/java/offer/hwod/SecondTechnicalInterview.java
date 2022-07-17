package offer.hwod;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SecondTechnicalInterview {

    /*
    * 数组求交集
    * 输出nums1和nums2的交集
    * */

    @Test
    public void fun() {

        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};

        Set<Integer> record = new HashSet<>();
        Set<Integer> ret = new HashSet<>();
        for (int num : nums1) {
            record.add(num);
        }

        for (int num : nums2) {
            if (record.contains(num)) {
                ret.add(num);
            }
        }
        System.out.println(ret);
    }


}
