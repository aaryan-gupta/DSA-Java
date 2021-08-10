import java.util.*;

class QueueArray {
    static int SIZE = 4;
    static int front = -1;
    static int rear = -1;
    static int array[] = new int[SIZE];
    /*
     * static int SIZE=4; static int front=-1; static int rear=-1; static int
     * array[]=new int[SIZE]; These variables are set for the queue.
     */

    void enqueue(int item) {
        if (front == -1) {
            front = 0;
            rear = 0;
            array[front] = item;
        } else if (front == 0 && rear == array.length - 1) {

        } else if (rear + 1 == front) {

        } else if (rear == array.length - 1) {
            rear = 0;
            array[rear] = item;
        } else {
            rear++;
            array[rear] = item;
        }
    }

    int dequeue() {
        int temp;
        if (front == -1) {
            return -1;
        } else if (front == rear) {
            temp = array[front];
            front = -1;
            rear = -1;

        }

        else if (front == array.length - 1) {
            temp = array[front];
            front = 0;

        } else {
            temp = array[front];
            front++;
        }
        return temp;

    }
}

class ImplementCircularQueueUsingArray {
    public static void main(String[] args) {
        QueueArray ob1 = new QueueArray();
        Scanner s = new Scanner(System.in);
        int t, n, q1, q2;
        t = Integer.parseInt(s.nextLine().trim());
        while (t > 0) {
            n = Integer.parseInt(s.nextLine().trim());
            while (n > 0) {
                q1 = Integer.parseInt(s.nextLine().trim());
                if (q1 == 1) {
                    q2 = Integer.parseInt(s.nextLine().trim());
                    ob1.enqueue(q2);
                } else
                    System.out.print(ob1.dequeue() + " ");
                n--;
            }
            System.out.println();
            t--;
        }
        s.close();
    }
}
