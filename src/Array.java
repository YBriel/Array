public class Array {
    private int[] data; //int类型数组
    private int size;  //描述data数组有多少有用的元素

    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    //无参构造函数，默认容量为10
    public Array() {
        this(10);
    }

    //获取数组中的元素个数
    public int getSize() {
        return size;
    }

    //获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    //判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //往数组末尾添加一个元素
    public void addLast(int e) {
        //判断是否有容量容纳新的元素
        if (size == data.length) {
            throw new IllegalArgumentException("AddLast failed,array is full");
        }
        data[size] = e;
        size++;
    }

    //数组头添加元素
    public void addFirst(int e) {
        add(0, e);
    }

    //往数组中插入元素
    public void add(int index, int e) {
        //往index插入e元素
        if (size == data.length) {
            throw new IllegalArgumentException("AddLast failed,array is full");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed,index Requireindex<0 || index>size");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //是否包含元素e
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    //是否找到元素e
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }
    //删除元素e
    public int remove(int index){
        if (size == data.length) {
            throw new IllegalArgumentException("AddLast failed,array is full");
        }
        int ret=data[index];
        for(int i=index+1;i<size;i++){
            data[i-1]=data[i];
        }size--;
        return ret;
    }
    //移除第一个元素e
    public int removeFirst(){
        return remove(0);
    }
    //移除第二个元素
    public int removeLast(){
        return remove(size-1);
    }
    public void removeElement(int e){
        int index = find(e);
        if(index !=-1){
            remove(index);
        }
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size= %d , capacity= %d \n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }
}

