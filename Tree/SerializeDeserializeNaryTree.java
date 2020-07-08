package Tree;


import java.util.*;

class NodeNary {
    public int val;
    public List<NodeNary> children;

    public NodeNary() {}

    public NodeNary(int _val) {
        val = _val;
    }

    public NodeNary(int _val, List<NodeNary> _children) {
        val = _val;
        children = _children;
    }
};



class SerializeDeserializeNaryTree {

    // Encodes a tree to a single string.
    public String serialize(NodeNary root) {
        List<String> list=new LinkedList<>();
        serializeHelper(root,list);
        return String.join(",",list);
    }

    private void serializeHelper(NodeNary root, List<String> list){
        if(root==null){
            return;
        }else{
            list.add(String.valueOf(root.val));
            list.add(String.valueOf(root.children.size()));
            for(NodeNary child:root.children){
                serializeHelper(child,list);
            }
        }
    }

    // Decodes your encoded data to tree.
    public NodeNary deserialize(String data) {
        if(data.isEmpty())
            return null;

        Queue<String> q=new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(q);
    }

    private NodeNary deserializeHelper(Queue<String> q){
        NodeNary root=new NodeNary();
        root.val=Integer.parseInt(q.poll());
        int size=Integer.parseInt(q.poll());
        root.children=new ArrayList(size);
        for(int i=0;i<size;i++){
            root.children.add(deserializeHelper(q));
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));