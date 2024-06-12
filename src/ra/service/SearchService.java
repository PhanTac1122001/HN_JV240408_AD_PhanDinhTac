package ra.service;


import java.util.Scanner;

public class SearchService {

    public static void searchSong(Scanner scanner) {
        System.out.println("Nhập tên ca sĩ hoặc thể loại:");

        String nameSongSearch = scanner.nextLine();
        int cntSearch = 0;
        for (int i = 0; i < SongService.indexSong; i++) {
            if (SongService.arrSong[i].getSongWriter().toLowerCase().contains(nameSongSearch.toLowerCase())) {
                SongService.arrSong[i].displayData();
                cntSearch++;
            } else if (SingerService.arrSinger[i].getGenre().toLowerCase().contains(nameSongSearch.toLowerCase())) {
                SingerService.arrSinger[i].displayData();
                cntSearch++;
            }
        }
        System.out.printf("Có %d bài hát được tìm thấy \n", cntSearch);
    }


    public static void searchSinger(Scanner scanner) {
        System.out.println("Nhập tên ca sĩ hoặc thể loại:");
        String nameSingerSearch = scanner.nextLine();
        int cntSearch = 0;
        for (int i = 0; i < SingerService.indexSinger; i++) {
            if (SingerService.arrSinger[i].getSingerName().toLowerCase().contains(nameSingerSearch.toLowerCase())) {
                SingerService.arrSinger[i].displayData();
                cntSearch++;
            } else if (SingerService.arrSinger[i].getGenre().toLowerCase().contains(nameSingerSearch.toLowerCase())) {
                SingerService.arrSinger[i].displayData();
                cntSearch++;
            }
        }
        System.out.printf("Có %d ca sĩ được tìm thấy \n", cntSearch);
    }


    public static void sortAscendingSong(Scanner scanner) {

    }



    public static void displayLatestSongs(Scanner scanner) {
        int count = 0;
        System.out.println("10 bài hát mới nhất.");
        for (int i = SongService.indexSong; i >= 0; i--) {
            SongService.arrSong[i].displayData();
            count++;
            if (count == 9) {
                break;
            }
        }
    }
}
