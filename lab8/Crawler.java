import java.util.LinkedList;

/** Класс, который перемещается по веб-страницам и ищет URL-адреса **/
public class Crawler {

    public static void main(String[] args) {
        // String[] args = new String[]{"http://mtuci.ru/", "1", "3"};
        if (args.length == 3 && checkNum(args[1]) && checkNum(args[2])) {
            String surl = args[0];
            int treadNum = Integer.parseInt(args[2]);

            URLPool pool = new URLPool(Integer.parseInt(args[1]));
            pool.addPair(new URLDepthPair(surl, 0));

            for (int i = 0; i < treadNum; i++) {
                CrawlerTask c = new CrawlerTask(pool);
                Thread t = new Thread(c);
                t.start();
            }

            while (pool.getWait() != treadNum) {
                try {
                    Thread.sleep(500);
                }

                catch (InterruptedException e) {
                    System.out.println("Ignoring Interrupted Exception");
                }
            }
            try {
                showResult(pool.getResult());
            }

            catch (NullPointerException e) {
                System.out.println("Not Link");
            }
            System.exit(0);

        } else
            System.out.println("Error");
    }

    public static void showResult(LinkedList<URLDepthPair> resultLink) {
        for (URLDepthPair c : resultLink)
            System.out.println("Depth: " + c.getDepth() + "\tLink: " + c.toString());
    }

    /** Вспомогательная функция для проверки, является ли строка числом **/
    public static boolean checkNum(String num) {
        boolean ok = true;
        for (int i = 0; i < num.length() && ok; i++)
            ok = Character.isDigit(num.charAt(i));
        return ok;
    }
}