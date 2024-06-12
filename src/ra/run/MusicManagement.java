package ra.run;

import ra.controller.SearchController;
import ra.controller.SingerController;
import ra.controller.SongController;


import java.util.Scanner;

public class MusicManagement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("******************** Music-Management ******************");
            System.out.println("*                     1. Quản lý ca sĩ                 *");
            System.out.println("*                     2. Quản lý bài hát               *");
            System.out.println("*                     3. Tìm kiếm bài hát              *");
            System.out.println("*                     4. Thoát                         *");
            System.out.println("********************************************************");
            System.out.println("Mời bạn lựa chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    SingerController.displayMenuSinger(scanner);
                    break;
                case 2:
                    SongController.displayMenuSong(scanner);
                    break;
                case 3:
                    SearchController.inputSearchSong(scanner);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Bạn phải nhập các chức năng từ 1 - 4, vui lòng nhập lại ");
                    break;
            }

        } while (true);
    }


}

