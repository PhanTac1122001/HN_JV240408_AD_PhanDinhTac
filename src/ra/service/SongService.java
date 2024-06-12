package ra.service;


import ra.model.Song;

import java.util.Scanner;


public class SongService {

    public static Song[] arrSong = new Song[100];



    public static int indexSong = 0;
    public static void inputAddSong(Scanner scanner) {
        System.out.println("Nhập vào số bài hát cần nhập: ");
        int countSong = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < countSong; i++) {
            arrSong[indexSong] = new Song();
            arrSong[indexSong].inputData(scanner);
            indexSong++;
        }
    }

    public static void displayListSong() {
        for (int i = 0; i < indexSong; i++) {
            arrSong[i].displayData();
        }
    }

    public static int getIndexBySongId(String songId) {
        for (int i = 0; i < indexSong; i++) {
            if(arrSong[i].getSongId().equals(songId)) {
                return i;
            }
        }
        return -1;
    }

    public static void changInfoSong(Scanner scanner) {
        while (true) {
            System.out.println("Nhập ID bai hat muốn thay đổi thông tin: ");
            String changeId = scanner.nextLine();
            for (int i = 0; i < indexSong; i++) {
                if (arrSong[i].getSongId().equals(changeId)) {
                    arrSong[i].inputData(scanner);
                    return;
                }
            }
            System.err.println("Khong tim thay id bài hát");
        }
    }

    public static void deleteSong(Scanner scanner) {
        System.out.println("Mời nhập vào bài hát cần xóa: ");
        String songId = scanner.nextLine();
        int indexDelete = getIndexBySongId(songId);
        if (indexDelete >= 0) {
            for (int i = indexDelete; i < indexSong; i++) {
                arrSong[i] = arrSong[i + 1];
            }
            indexSong--;
            System.out.println(" Đã xóa bài hát có ID:" + songId);
        }
        else  {
            System.err.println("Mã bài hát không tồn tại");
        }
    }

}
