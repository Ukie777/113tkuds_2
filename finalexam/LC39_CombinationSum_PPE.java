import java.util.*;

class LC39_CombinationSum_PPE {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] candidates, int remain, int start, List<Integer> path, List<List<Integer>> res) {
        if (remain == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remain) break;
            path.add(candidates[i]);
            backtrack(candidates, remain - candidates[i], i, path, res); // 可重複使用 → 傳 i
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        LC39_CombinationSum_PPE sol = new LC39_CombinationSum_PPE();
        int[] nums = {2,3,6,7};
        System.out.println(sol.combinationSum(nums, 7)); // [[2,2,3],[7]]
    }
}
