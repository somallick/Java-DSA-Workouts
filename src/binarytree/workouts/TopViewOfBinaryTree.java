package src.binarytree.workouts;

import java.util.*;

//https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
public class TopViewOfBinaryTree {
    public static ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> finalViewList = new ArrayList<>();
        if (root == null)
            return finalViewList;
        Queue<Pair<Node, Integer>> levelQueue = new LinkedList<>();
        Map<Integer, Node> viewTracker = new HashMap<>();
        int maxDistance = Integer.MIN_VALUE;
        int minDistance = Integer.MAX_VALUE;

        levelQueue.add(new Pair<>(root, 0));

        while (!levelQueue.isEmpty()) {
            Pair<Node, Integer> front = levelQueue.poll();
            Node frontNode = front.getFirst();
            Integer distance = front.getSecond();
            // for check that node contain is first time w.r.t distance
            if (!viewTracker.containsKey(distance)) {
                viewTracker.put(distance, frontNode);
                // store the min distance and max distance in the tres
                maxDistance = Math.max(maxDistance, distance);
                minDistance = Math.min(minDistance, distance);
            }
            if (frontNode.left != null) {
                levelQueue.add(new Pair<>(frontNode.left, distance - 1));
            }
            if (frontNode.right != null) {
                levelQueue.add(new Pair<>(frontNode.right, distance + 1));
            }
        }
        for (int i = minDistance; i <= maxDistance; i++) {
            finalViewList.add(viewTracker.get(i).value);
        }
        return finalViewList;
    }
}

// for storing heterogeneous pair data
class Pair<U, V> {
    private U first;
    private V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    public U getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }
}
