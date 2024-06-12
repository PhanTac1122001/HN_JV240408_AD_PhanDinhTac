package ra.controller;

import ra.service.SingerService;

import java.util.Scanner;

public class SingerController {

    public static void displayMenuSinger (Scanner scanner) {

        boolean isExit = true;
        do {
            System.out.println("**********************   SINGER-MANAGEMENT   *************************");
            System.out.println("* 1. Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới *");
            System.out.println("* 2. Hiển thị danh sách tất cả ca sĩ đã lưu trữ                      *");
            System.out.println("* 3. Thay đổi thông tin ca sĩ theo mã id                             *");
            System.out.println("* 4. Xóa ca sĩ theo mã id                                            *");
            System.out.println("* 5. Quay lai                                                        *");
            System.out.println("**********************************************************************");
            System.out.println("Mời lựa chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    SingerService.inputAddSinger(scanner);
                    break;
                case 2:
                    SingerService.displayListSinger();
                    break;
                case 3:
                    SingerService.changInfoSinger(scanner);
                    break;
                case 4:
                    SingerService.deleteSinger(scanner);
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
