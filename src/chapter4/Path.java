package chapter4;

import java.util.HashSet;

public class Path {
    /**
     * 对于一个有向图，请实现一个算法，找出两点之间是否存在一条路径。
     * 给定图中的两个结点的指针UndirectedGraphNode* a,UndirectedGraphNode* b(请不要在意数据类型，图是有向图),
     * 请返回一个bool，代表两点之间是否存在一条路径(a到b或b到a)。
     */
    public boolean checkPath(UndirectedGraphNode a, UndirectedGraphNode b) {
        // write code here
        //有向图要检查两个方向
        return BFS(a,b, new HashSet()) || BFS(b,a,new HashSet());
    }

    public boolean BFS(UndirectedGraphNode start, UndirectedGraphNode target, HashSet visited){
        if(start == null || target == null) return false;
        if(start.label == target.label) return true;
        visited.add(start);//破环
        for (UndirectedGraphNode neighbor:start.neighbors) {
            if(visited.contains(neighbor)) continue;
            else  return BFS(neighbor,target,visited);
        }
        return false;
    }
}
