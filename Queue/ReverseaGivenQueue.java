import java.util.*;

class QueueArray {
    static int SIZE = 100;
    static int front = -1;
    static int rear = -1;
    static int array[] = new int[SIZE];

    // Method to add an item to the queue.
    void enqueue(int item) {
        if (rear == SIZE) // Queue is full
            return;
        if (front == -1 && rear == -1) {
            front++;
            rear++;
        } else
            rear++;
        array[rear] = item;
    }

    // Method to remove an item from queue.
    int dequeue() {
        if (front > rear) {
            return -1;
        }
        int item = array[front];
        front++;
        return item;
    }
}

class ReverseaGivenQueue {
    /*
     * class QueueArray { static int SIZE=10; static int front=-1; static int
     * rear=-1; static int array[]=new int[SIZE]; void enqueue(int item); void
     * dequeue(); Abobe is the queue declaration.
     */
    static void reverseQueue(QueueArray q) {
        int[] arr = new int[q.rear + 1];
        // for(int i=0;i<q.rear+1;i++)
        // {
        // System.out.print(" "+q.array[i]+" i is: "+i+" ;");
        // }
        for (int i = q.front, j = q.rear; i < q.rear + 1; i++, j--) {
            arr[i] = q.array[j];
        }
        for (int i = q.front; i < q.rear + 1; i++) {
            q.array[i] = arr[i];
            // System.out.println("i is "+i+" array[i] is "+q.array[i]+" arr[i] is
            // "+arr[i]);
        }
        System.out.println();
        // System.out.println();
        // System.out.println("-------------------------------");
        // for(int i=0;i<arr.length;i++)
        // {
        // System.out.print(" "+arr[i]+" i is: "+i+" ;");
        // }
        // System.out.println();
        // System.out.println("-------------------------------");

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t, n, q1, q2;
        t = s.nextInt();
        while (t > 0) {
            QueueArray ob1 = new QueueArray();
            n = s.nextInt();
            q2 = n;
            while (n > 0) {
                q1 = s.nextInt();
                ob1.enqueue(q1);
                n--;
            }
            reverseQueue(ob1);
            while (q2 > 0) {
                System.out.print(ob1.dequeue() + " ");
                q2--;
            }
            System.out.println();
            t--;
        }
        s.close();
    }
}