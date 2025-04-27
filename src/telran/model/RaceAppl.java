package telran.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RaceAppl {
    public static void main(String[] args) throws IOException, InterruptedException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Write number of tarakans for the race:");
        int nTar = Integer.parseInt(br.readLine());
        System.out.println("Write distance of the race:");
        int dist = Integer.parseInt(br.readLine());

        Tarakan[] tasks = new Tarakan[nTar];
            for (int i = 0; i < tasks.length; i++) {
                tasks[i] = new Tarakan("tarakan #" + (i + 1), dist);
            }
            Thread[] threads = new Thread[tasks.length];
            for (int i = 0; i < threads.length; i++) {
                threads[i] = new Thread(tasks[i]);
            }
            for (int i = 0; i < threads.length; i++) {
                threads[i].start();
            }
            for (int i = 0; i < threads.length; i++) {
                threads[i].join();
            }



    }
}
