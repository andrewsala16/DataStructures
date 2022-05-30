public class Test {
    public static void main(String[] args){
        BST<String> bst = new BST<>();
        bst.add("Kiwi");
        bst.add("Strawberry");
        bst.add("Apple");
        bst.add("Banana");
        bst.add("Orange");
        bst.add("Lemon");
        bst.add("Watermelon");
        bst.inorder();
        bst.remove("Banana");
        System.out.println(bst.contains("Banana"));
        bst.inorder();
        bst.remove("Orange");
        bst.inorder();
        bst.remove("Kiwi");
        bst.inorder();


        Heap<String> heap = new Heap<>();
        heap.add("Kiwi");
        heap.add("Strawberry");
        heap.add("Apple");
                heap.add("Banana");
        heap.add("Orange");
        heap.add("Lemon");
        heap.add("Watermelon");
        System.out.println("Heap: " + heap.toString());
        System.out.println("Removed: " + heap.remove());
        System.out.println("Heap: " + heap.toString());
        System.out.println("Heap contains Pear?: "
                            + heap.contains("Pear"));
    }
}
