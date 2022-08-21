import java.util.*;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class cc {

    public int minNumberOfHours(int initEnergy, int initExp, int[] energy, int[] experience) {
        int hours = 0;
        int n = energy.length;

        for(int i=0; i<n; i++){
            if(initEnergy<=energy[i]){
                hours += energy[i]-initEnergy+1;
                initEnergy+=energy[i]-initEnergy+1;
            }
            initEnergy-= energy[i];
            if(initExp<=experience[i]){
                hours += experience[i]-initExp+1;
                initExp+=experience[i]-initExp+1;
            }
            initExp+=experience[i];
        }
        return hours;
    }
    
    int level;

    public int amountOfTime(TreeNode root, int start) {
        level = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        dfs(root, map);
        Set<Integer> visited = new HashSet<>();
        maxLevel(start, 0, map, visited);
        return level;
    }


    private void maxLevel(int val, int lvl, Map<Integer, Set<Integer>> map,Set<Integer> set) {
        if(set.contains(val)) return;
        set.add(val);
        Set<Integer> des = map.get(val);
        for (Integer integer : des) {
            maxLevel(integer, lvl+1, map, set);
        }
        level = Math.max(level, lvl);
    }

    private void dfs(TreeNode node, Map<Integer, Set<Integer>> map){
        if(node==null) return;

        TreeNode l = node.left;
        TreeNode r = node.right;
            if(map.containsKey(node.val)){
                if(l!=null)map.get(node.val).add(l.val);
                if(r!=null)map.get(node.val).add(r.val);
            }else{
                Set<Integer> set = new HashSet<>();
                if(l!=null)set.add(l.val);
                if(r!=null)set.add(r.val);
                if(!set.isEmpty())map.put(node.val, set);
            }
            
            if(l!=null){
                if(map.containsKey(l.val)){
                    map.get(l.val).add(node.val);
                } else {
                    Set<Integer> set = new HashSet<>();
                    set.add(node.val);
                    map.put(l.val, set);
                }
            }
            if(r!=null){
                if(map.containsKey(r.val)){
                    map.get(r.val).add(node.val);
                } else {
                    Set<Integer> set = new HashSet<>();
                    set.add(node.val);
                    map.put(r.val, set);
                }
            }

            dfs(node.left, map);
            dfs(node.right, map);
        
    }
}
