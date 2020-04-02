package com.xch.ext;

/**
 * @author xiech
 * @create 2020-04-02 11:24
 */
public class ExtLinkedList<E>  {

    private int  size;
    /**
     * 第一个元素（头节点）
     */
    private Node first;
    /**
     * 最后一个元素（尾节点）
     */
    private Node last;

    /**
     * 添加新节点
     * @param e
     */
    public void add(E e){
        //创建节点
        Node<E> newNode=new Node<>();
        //设置节点的内容
        newNode.item=e;
        if (first==null){
            // 头节点为新创建的节点
            first=newNode;
       }else{
            //设置新节点的上一个节点是之前的最后的节点
            newNode.prev=last;
            //设置之前最后的节点的下一个节点是为当前创建的新节点
            last.next=newNode;
        }
        //将当前创建的新节点设置为最后的节点
        last=newNode;
        size++;
    }

    /**
     * 查询
     * @param index
     * @return
     */
    public E get(int index){
        //校验下标（指针）
        checkElementIndex(index);

        return node(index).item;
    }

    /**
     * 删除节点
     * @param index
     * @return
     */
    public E remove(int index){
        checkElementIndex(index);
        //查询要删除的节点
        Node<E> oldNode=node(index);
        //获取上一个节点
        Node<E> oldPrveNode=oldNode.prev;
        //获取下一个节点
        Node<E> oldNextNode=oldNode.next;
        if(oldPrveNode==null){
            //如果删除的是第一个元素
            first=oldNextNode;
        }else{
            oldPrveNode.next=oldNextNode;
            oldNode.prev=null;
        }

        if(oldNextNode==null){
            //如果删除的是最后一个节点
            last=oldPrveNode;
        }else{
            oldPrveNode.prev=oldPrveNode;
            oldNode.next=null;
        }
        oldNode.item=null;
        size--;
        return oldNode.item;
    }

    /**
     * 指定下标添加元素
     * @param index
     * @param e
     */
    public void add(int index,E e){
        checkElementIndex(index);
        if(index==size){
            add(e);
        }else{
            //获取当前节点
            Node<E> oldNode=node(index);
            //获取这个节点的上个节点
            Node<E> pred=oldNode.prev;
            //创建新节点
            Node<E> newNode=new Node<E>();
            newNode.item=e;
            oldNode.prev=newNode;
            if(pred==null){
                first=newNode;
            }else{
                pred.next=newNode;
            }
            size++;
        }
    }

    /**
     * 获取长度
     * @return
     */
    public int size(){
        return size;
    }

    Node<E> node(int index){
        if(index<(size>>1)){
            //从前往后找
            Node<E> x=first;
            for (int i=0;i<index;i++) {
                x=x.next;
            }
            return x;
        }else{
            //从后往前找
            Node<E> x=last;
            for(int i=size-1;i>index;i--){
                x=x.prev;
            }
            return x;
        }
    }


    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("越界啦！");
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }
    /**
     * 链表节点存储的元素
     */
    private static class Node<E>{
         E item;
         Node prev;
         Node next;

    }
}
