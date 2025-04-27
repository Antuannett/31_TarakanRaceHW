package telran.model;

public class RaceAppl {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Wrong number of arguments");
            return;
        }
        try {
            Tarakan[] tasks = new Tarakan[Integer.parseInt(args[0])];
            for (int i = 0; i < tasks.length; i++) {
                tasks[i] = new Tarakan("tarakan #" + (i + 1), Integer.parseInt(args[0]));
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

        }catch (NumberFormatException e) {
            System.out.println("Wrong number format");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
