package ra.service;



import ra.model.Singer;


import java.util.Scanner;

public class SingerService {
    public static Singer[] arrSinger = new Singer[100];
    public static int indexSinger = 0;

    public static void inputAddSinger(Scanner scanner) {
        System.out.println("Nhập vào số ca sĩ cần nhập: ");
        int countSinger = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < countSinger; i++) {

            arrSinger[indexSinger] = new Singer();
            arrSinger[indexSinger].inputData(scanner);
            indexSinger++;
        }
    }


    public static void displayListSinger() {
        for (int i = 0; i < indexSinger; i++) {
            arrSinger[i].displayData();
        }
    }

    public static int getIndexById(int singerId) {
        for (int i = 0; i < indexSinger; i++) {
            if(arrSinger[i].getSingerId() == singerId) {
                return i;
            }
        }
        return -1;
    }

    public static void changInfoSinger(Scanner scanner) {
        System.out.println("Nhập ID ca sĩ muốn thay đổi thông tin: ");
        int changeId = Integer.parseInt(scanner.nextLine());
        boolean found = false;
        for (int i = 0; i < indexSinger; i++) {
            if(arrSinger[i].getSingerId() == changeId) {
                System.out.println("Nhập thông tin mới cho ca sĩ: ");
                arrSinger[i].updateData(scanner);
                found = true;
            }
        }
        if(!found) {
            System.err.println("Không tìm thấy bài hát với mã ca sĩ đã nhập.");
        }
    }

    public static void deleteSinger(Scanner scanner) {
        System.out.println("Mời nhập vào ca sĩ cần xóa: ");
        int singerId = Integer.parseInt(scanner.nextLine());
        int indexDelete = getIndexById(singerId);
        if (indexDelete >= 0) {
            for (int i = indexDelete; i < indexSinger; i++) {
                arrSinger[i] = arrSinger[i + 1];
            }
            indexSinger--;
            System.out.println(" Đã xóa ca sĩ có ID:" + singerId);
        }
        else  {
            System.err.println("Mã ca sĩ không tồn tại");
        }
    }

}
