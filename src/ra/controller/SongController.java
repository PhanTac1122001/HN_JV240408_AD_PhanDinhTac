package ra.controller;


import ra.service.SongService;

import java.util.Scanner;

public class SongController {
    public static void displayMenuSong (Scanner scanner) {
        boolean isExit = true;
        do {
            System.out.println("************************     SONG-MANAGEMENT    ************************");
            System.out.println("* 1. Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mới *");
            System.out.println("* 2. Hiển thị danh sách tất cả bài hát đã lưu trữ                      *");
            System.out.println("* 3. Thay đổi thông tin bài hát theo mã id                             *");
            System.out.println("* 4. Xóa bài hát theo mã id                                            *");
            System.out.println("* 5. Quay lai                                                          *");
            System.out.println("************************************************************************");
            System.out.println("Mời lựa chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    SongService.inputAddSong(scanner);
                    break;
                case 2:
                    SongService.displayListSong();
                    break;
                case 3 :
                    SongService.changInfoSong(scanner);
                    break;
                case 4:
                    SongService.deleteSong(scanner);
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
