package ra.model;


import ra.service.SingerService;
import ra.service.SongService;

import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Song {
    private String songId;
    private String songName;
    private String description;
    private Singer singer;
    private String songWriter;
    private Date createdDate;
    private boolean songStatus;


    public Song() {

    }

    public Song(String songId, String songName, String description, Singer singer, String songWriter, Date createdDate, boolean songStatus) {
        this.songId = songId;
        this.songName = songName;
        this.description = description;
        this.singer = singer;
        this.songWriter = songWriter;
        this.createdDate = createdDate;
        this.songStatus = songStatus;
    }



    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    public void inputData(Scanner scanner) {
        this.songId = inputSongId(scanner);
        this.songName = inputSongName(scanner);
        this.description = inputDescription(scanner);
        this.singer = inputSinger(scanner);
        this.songWriter = inputSongWriter(scanner);
        this.createdDate = new Date();
        this.songStatus = inputSongStatus(scanner);
    }


    public String inputSongId (Scanner scanner) {
        String songIdRegex = "S\\w{3}";
        System.out.println("Mời nhập vào mã bài hát: ");
        do{
            String songId = scanner.nextLine();
            if (Pattern.matches(songIdRegex, songId)) {
                boolean isExist = false;
                for (int i = 0; i < SongService.indexSong; i++) {
                    if (SongService.arrSong[i].getSongId().equals(songId)) {
                        isExist = true;
                        break;
                    }
                }
                if (isExist) {
                    System.err.println("Mã bài hát đã tồn tại, vui lòng nhập lại");
                }
                else  {
                    return songId;
                }
            }
            else {
                System.err.println("Mã bài hát gồm 4 ký tự bắt đầu là S, vui lòng nhập lại");
            }
        } while (true);
    }


    public String inputSongName (Scanner scanner) {
        System.out.println("Mời nhập vào tên bài hát: ");
        do {
            String songName = scanner.nextLine();
            if (songName.trim().isEmpty()) {
                System.err.println("Tên bài hát không được để trống ");
            }
            else  {
                return songName;
            }
        } while (true);
    }


    public String inputDescription (Scanner scanner) {
        System.out.println("Mời nhập vào mô tả bài hát");
        return scanner.nextLine();
    }


    public Singer inputSinger (Scanner scanner) {
        if (SingerService.indexSinger == 0) {
            System.err.println("Chưa có ca sĩ nào , Mời nhập ca sĩ trước");
            System.exit(0);
        }
        else {
            System.out.println("Chọn ca sĩ của bài hát:");
            for (int i = 0; i < SingerService.indexSinger; i++) {
                System.out.printf("%d. %s\n", (i + 1), SingerService.arrSinger[i].getSingerName());
            }

            while (true) {
                System.out.print("Nhập số : ");
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= SingerService.indexSinger) {
                    return SingerService.arrSinger[choice - 1];
                } else {
                    System.err.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                }
            }
        }
        return null;
    }


    public String inputSongWriter (Scanner scanner) {
        System.out.println("Mời nhập vào tên người sáng tác: ");
        do {
            String songWrite = scanner.nextLine();
            if (songWrite.trim().isEmpty()) {
                System.err.println("Tên người sáng tác không được để trống ");
            }
            else  {
                return songWrite;
            }
        } while (true);
    }


    public boolean inputSongStatus (Scanner scanner) {
        System.out.println("Mời nhập vào trang thái bài hát: ");
        do {
            String songStatus = scanner.nextLine();
            if( songStatus.equals("true") || songStatus.equals("false")) {
                return Boolean.parseBoolean(songStatus);
            } else  {
                System.err.println("Trạng thái bài hát chỉ nhận giá trị true | false, vui lòng nhập lại");
            }
        } while (true);

    }


    public void displayData() {

        System.out.printf("Mã bài hát: %s - Tên bài hát: %s - Ca sĩ: %s - Người sáng tác: %s \n",
                this.songId , this.songName, this.singer.getSingerName() , this.songWriter);
        System.out.printf("Mô tả bài hát: %s \n", this.description);
        System.out.printf("Ngày tạo: %s - Trạng thái: %s \n", this.createdDate, this.songStatus);
        System.out.println("------------------------------------------------------------------------------");
    }
}
