/**
 * 使用数组实现一个环形队列
 */
public class CircleArrayQueueDemo {

}

class CircleArrayQueue{
    private int maxsize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArrayQueue(int size){
        this.maxsize = size;
        this.arr = new int[maxsize];
    }

    public Boolean isEmpty(){
        return front == rear;
    }

    public boolean isFull(){
        return (rear + 1) % maxsize == front;
    }

    public void addQueue(int n){
        if(isFull()){
            throw new RuntimeException("队列已满");
        }
        arr[rear] = n;
        rear = (rear + 1) % maxsize;
    }

    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列已空");
        }
        int value = arr[front];
        front = (front + 1) % maxsize;
        return value;
    }

    public int getSize(){
        return (rear - front +maxsize) % maxsize;
    }

    public void showQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列已空");
        }
        for(int i = front;i < front + getSize();i++){
            System.out.printf("arr[%d]:%d",i % maxsize,arr[i % maxsize]);
        }
    }

    public void showHead(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        System.out.println(arr[front]);
    }
}
