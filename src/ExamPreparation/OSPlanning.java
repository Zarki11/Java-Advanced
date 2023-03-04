package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OSPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();
        ArrayDeque<Integer> threadQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(tasksStack::push);
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(threadQueue::offer);
        int toRemove = Integer.parseInt(scanner.nextLine());

        while (tasksStack.contains(toRemove)) {
            int task = tasksStack.peek();
            int thread = threadQueue.peek();

            if (thread >= task && tasksStack.peek() != toRemove) {
                tasksStack.pop();
                threadQueue.poll();
            } else if (tasksStack.peek() == toRemove) {
                tasksStack.pop();
            } else{
                threadQueue.poll();
            }
        }
        System.out.printf("Thread with value %d killed task %d%n", threadQueue.peek(), toRemove);
        //String print = threadQueue.stream().forEach(el-> String.join(", ", el).toString());
        //System.out.println(print);
    }
}
