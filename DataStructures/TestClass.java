package Practice.Tree;

/**
 * Created by gsrinivasagam on 11/21/2018.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;


class MirrorTrees {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] initChar = line.split(" ");
        int N = Integer.parseInt(initChar[0]);
        int Q = Integer.parseInt(initChar[1]);

        Map<Integer, Node> nodeMap = new HashMap<>();
        for (int i = 0; i < N - 1; i++) {
            String[] strArr = br.readLine().split(" ");
            Integer parent = Integer.parseInt(strArr[0]);
            Integer child = Integer.parseInt(strArr[1]);
            if(strArr[2].equals("R")){
                populateMapForRightNode(parent,child,nodeMap);
            }else{
                populateMapForLeftNode(parent,child,nodeMap);
            }
        }

        Node root = nodeMap.get(1);
        nodeMap=null;

        for(int i = 0; i<Q;i++){
            int val = Integer.parseInt(br.readLine());
            Node n=getMirrorImage(root,val,root);
            if(n==null)
                System.out.println(-1);
            else
                System.out.println(n.item);
        }
    }

    private static Node getMirrorImage(Node root,int val, Node result){
        if(root==null){
            return null;
        }
        if(root.item==val){
            return result;
        }

        Node left = result.right==null?null:getMirrorImage(root.left,val,result.right);
        Node right =result.left==null?null: getMirrorImage(root.right,val,result.left);
        if(left != null)
            return left;
        else if(right != null)
            return right;
        else
            return null;

    }

    private static void populateMapForRightNode(Integer parent,Integer child,Map<Integer, Node> nodeMap){
        if(nodeMap.get(parent)==null){
            Node node = new Node(parent);
            node.right = new Node(child);
            nodeMap.put(parent,node);
            nodeMap.put(child,node.right);
        }else{
            Node node = nodeMap.get(parent);
            node.right = new Node(child);
            nodeMap.put(child,node.right);
        }
    }
    private static void populateMapForLeftNode(Integer parent,Integer child,Map<Integer, Node> nodeMap){
        if(nodeMap.get(parent)==null){
            Node node = new Node(parent);
            node.left = new Node(child);
            nodeMap.put(parent,node);
            nodeMap.put(child,node.left);
        }else{
            Node node = nodeMap.get(parent);
            node.left = new Node(child);
            nodeMap.put(child,node.left);
        }
    }

    private static class Node{
        public int item;
        public Node left;
        public Node right;
        public Node(int item){
            this.item = item;
        }
    }
}
