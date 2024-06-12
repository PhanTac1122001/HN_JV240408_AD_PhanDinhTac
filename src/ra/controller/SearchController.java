package ra.controller;

import ra.service.SearchService;

import java.util.Scanner;

public class SearchController {
    public static void inputSearchSong(Scanner scanner) {
        boolean isExit = true;
        do {
            System.out.println("*******************   SEARCH-MANAGEMENT   *********************");
            System.out.println("*     1. Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại        *");
            System.out.println("*     2. Tìm kiếm ca sĩ theo tên hoặc thể loại                *");
            System.out.println("*     3. Hiển thị danh sách bài hát theo thứ tự tên tăng dần  *");
            System.out.println("*     4. Hiển thị 10 bài hát được đăng mới nhất               *");
            System.out.println("*     5. Quay lại                                             *");
            System.out.println("***************************************************************");
            System.out.println("Mời lựa chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    SearchService.searchSong(scanner);
                    break;
                case 2:
                    SearchService.searchSinger(scanner);
                    break;
                case 3:
                    SearchService.sortAscendingSong(scanner);
                    break;
                case 4:
                    SearchService.displayLatestSongs(scanner);
                    break;
                case 5:
                    isExit = false;
                    break;
                default:
                    System.out.println("Bạn phải nhập các chức năng từ 1 - 5, vui lòng nhập lại ");
                    break;

            }
        } while (isExit);
    }
}
