public class Main {
    
    public static void main(String[] args) {
        

        MainDataController controller = MainDataController.getInstance();

        controller.initData();
        controller.displayData();
        controller.inputData();
        controller.editData();
        

    }
}
