import java.util.*;

class QueueArray {
    int SIZE = 50;
    int front = -1;
    int rear = -1;
    int array[] = new int[SIZE];

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
        if (front == -1 || front > rear) {
            return -1;
        }
        int item = array[front];
        front++;
        return item;
    }
}

class ReverseFirstNElementsOfaGivenQueue {
    /*
     * class QueueArray { int SIZE=50; int front=-1; int rear=-1; int array[]=new
     * int[SIZE]; void enqueue(int item); void dequeue(); Abobe is the queue
     * declaration.
     */
    static void reverseKelementsQueue(QueueArray q, int k) {
        int arr[] = new int[k];
        for (int i = 0, j = q.front + k - 1; j >= 0; j--, i++) {
            arr[i] = q.array[j];
        }
        for (int i = q.front; i < q.front + k; i++) {
            q.array[i] = arr[i];
        }

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t, n, q1, q2, k;
        t = Integer.parseInt(s.nextLine());
        while (t > 0) {
            QueueArray ob1 = new QueueArray();
            n = Integer.parseInt(s.nextLine());
            k = Integer.parseInt(s.nextLine());
            q2 = n;
            while (n > 0) {
                q1 = Integer.parseInt(s.nextLine());
                ob1.enqueue(q1);
                n--;
            }
            reverseKelementsQueue(ob1, k);
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