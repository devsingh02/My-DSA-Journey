class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, ans, new Stack<>());
        return ans;
    }

    private void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, Stack<Integer> ds) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        if (ind == arr.length || target < 0) {
            return;
        }

        // Choice 1: Take the current element
        if (arr[ind] <= target) {
            ds.push(arr[ind]);
            findCombinations(ind, arr, target - arr[ind], ans, ds);
            ds.pop();
        }

        // Choice 2: Don't take the current element
        findCombinations(ind + 1, arr, target, ans, ds);
    }
}
// class Solution {
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>> subsets = new ArrayList<>();
//         backtrack(0, target, candidates, new ArrayList<>(), subsets);
//         return subsets;
//     }

//     private void backtrack(int index, int target, int[] candidates, List<Integer> currentSubset, List<List<Integer>> subsets) {
//         if (target == 0) {
//             subsets.add(new ArrayList<>(currentSubset));
//             return;
//         }

//         for (int i = index; i < candidates.length; i++) {
//             if (candidates[i] <= target) {
//                 currentSubset.add(candidates[i]);
//                 backtrack(i, target - candidates[i], candidates, currentSubset, subsets);
//                 currentSubset.remove(currentSubset.size() - 1);
//             }
//         }
//     }
// }


// // MEHTOD 1 : SubSequence 

// class Solution {
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>> subset = new ArrayList<>();
//         List<Integer> curset = new ArrayList<>();
//         helper(0, target, candidates, curset, subset);
//         return subset;
//     }
//     static void helper(int i, int target, int[] candidates, List<Integer> curset, List<List<Integer>> subset) {
//         if (i == candidates.length || target < 0) {
//             if (target == 0) subset.add(new ArrayList<>(curset));
//             return;
//         }
//         // choice 1 : Take
//         curset.add(candidates[i]);
//         helper(i, target - candidates[i], candidates, curset, subset);
//         //choice 2 : Don't Take
//         curset.remove(curset.size() - 1);
//         helper(i + 1, target, candidates, curset, subset);
//     }
// }

// METHOD 2 : C(n,k) 
//
// class Solution {
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>> subset = new ArrayList<>();
//         Stack<Integer> curset = new Stack<>();
//         helper(0, candidates, target, curset, subset);
//         return subset;
//     }

//     static void helper(int i, int[] candidates, int target, Stack<Integer> curset, List<List<Integer>> subset) {
//         if (target == 0) {
//             subset.add(new ArrayList<>(curset));
//             return;
//         }
//         if (target < 0)
//             return;
//         for (int j = i; j < candidates.length; j++) {
//             curset.push(candidates[j]);
//             target -= candidates[j];
//             helper(j, candidates, target, curset, subset);
//             target += curset.pop(); // sum + element removed
//         }
//     }
// }