class MyCircularDeque {
    int[] arr;
    int st, end, n;
    public MyCircularDeque(int k) {
        arr = new int[k];
        st=-1;
        end=-1;
        n=k;
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;
        if(isEmpty()){
            st=0;
            end=0;
        }else{
            st = (st-1+n)%n;
        }
        arr[st] = value;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        if(isEmpty()){
            st=0;
            end=0;
        }else{
            end = (end+1)%n;
        }
        arr[end] = value;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        if(st==end){
            st=-1;
            end=-1;
        }else{
            st = (st+1)%n;
        }
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
        if(st==end){
            st=-1;
            end=-1;
        }else{
            end = (end-1+n)%n;
        }
        return true;
    }
    
    public int getFront() {
        if(isEmpty()) return -1;
        return arr[st];
    }
    
    public int getRear() {
        if(isEmpty()) return -1;
        return arr[end];
    }
    
    public boolean isEmpty() {
        return end==-1 && st==-1;
    }
    
    public boolean isFull() {
        return (end+1)%n == st;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */