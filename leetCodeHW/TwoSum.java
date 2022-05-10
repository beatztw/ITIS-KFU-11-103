package leetCodeHW;

import java.util.HashMap;

class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return null;
    }
// более быстрая реализация:
//    public int[] twoSum(int[] nums, int target) {
//        HashMap<Integer,Integer> map=new HashMap<>();
//        int[] array=new int[2];
//
//        for(int i=0;i<nums.length;i++){
//
//            if(map.containsKey(target-nums[i])){
//                array[0]=map.get(target-nums[i]);
//                array[1]=i;
//                return array;
//            }
//            map.put(nums[i],i);
//        }
//        return array;
//    }
}
