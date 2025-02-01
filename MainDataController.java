import java.util.Scanner;
import java.util.Arrays;

public class MainDataController {

    private MainDataController() {initData();
    }

    private static MainDataController INSTANCE = null;

    public static synchronized MainDataController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MainDataController();
        }
        return INSTANCE;
    }

    private Scanner scanner = new Scanner(System.in);

    public static MainData[] listMainData = new MainData[3];
    private int sizable = 3;

    public void initData() {
        listMainData[0] = new MainData(1, "Book1", 2.2);
        listMainData[1] = new MainData(2, "Book2", 2.4);
        listMainData[2] = new MainData(3, "Book3", 2.5);
    }

    public void displayData() {
        for (MainData data : listMainData) {
            if (data == null)
                continue;
            System.out.println(data.getId() + "\t" + data.getTitle() + "\t" + data.getPrice());
        }
    }

    private int currentId() {
        return listMainData[sizable - 1].getId() + 1;
    }

    public void inputData() {
        System.out.print("Enter title  = ");
        String title = scanner.nextLine();
        System.out.print("Enter price  = ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        listMainData = Arrays.copyOf(listMainData, sizable + 1);
        listMainData[sizable] = new MainData(currentId(), title, price);
        sizable++;
    }

    public void editData() {

        System.out.print("Enter id for search update  = ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < listMainData.length; i++) {
            if (listMainData[i].getId() == id) {
                editAgain: while (true) { 
                    System.out.print("Enter title  = ");
                    String title = scanner.nextLine();
                    System.out.print("Enter price  = ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    MainData mainData = new MainData();
                    mainData.setTitle(title);
                    mainData.setPrice(price);
                    if (mainData.getPrice() <= 0)
                        continue editAgain;
                    else {
                        listMainData[i] = new MainData(id, title, price);
                        break;
                    }

                }

            }
        }
        displayData();
    }
}
