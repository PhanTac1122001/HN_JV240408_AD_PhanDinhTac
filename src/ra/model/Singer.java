package ra.model;


import ra.service.SingerService;

import java.util.Scanner;

public class Singer {
    private int singerId;
    private String singerName;
    private int age;
    private String nationality;
    private boolean gender;
    private String genre;

    public Singer() {
    }


    public Singer(int singerId, String singerName, int age, String nationality, boolean gender, String genre) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
        this.genre = genre;
    }



    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public void inputData(Scanner scanner) {
        this.singerId = inputSingerId();
        this.singerName = inputSingerName(scanner);
        this.age = inputAge(scanner);
        this.nationality = inputNationality(scanner);
        this.gender = inputGender(scanner);
        this.genre = inputGenre(scanner);
    }

    public void updateData(Scanner scanner) {
        this.singerName = inputSingerName(scanner);
        this.age = inputAge(scanner);
        this.nationality = inputNationality(scanner);
        this.gender = inputGender(scanner);
        this.genre = inputGenre(scanner);
    }

    public int inputSingerId() {
        if (SingerService.indexSinger == 0) {
            return 1;
        }
        else {
            int maxId = SingerService.arrSinger[0].getSingerId();
            for (int i = 0; i < SingerService.indexSinger; i++) {
                if(maxId < SingerService.arrSinger[i].getSingerId()) {
                    maxId = SingerService.arrSinger[i].getSingerId();
                }
            }
            return maxId + 1;
        }
    }
    public String inputSingerName(Scanner scanner) {
        System.out.println("Mời nhập vào tên ca sĩ: ");
        do {
            String singerName = scanner.nextLine();
            if (singerName.trim().isEmpty()) {
                System.err.println("Tên ca sĩ không được để trống");
            } else {
                return singerName;
            }
        } while (true);
    }

    public int inputAge(Scanner scanner) {
        System.out.println("Nhập vào tuổi ca sĩ: ");
        do {
            int age = Integer.parseInt(scanner.nextLine());
            if (age > 0) {
                return age;
            }
            else {
                System.err.println("Tuổi ca sĩ phải lớn hơn 0, vui lòng nhập lại");
            }
        } while (true);
    }

    public String inputNationality(Scanner scanner) {
        System.out.println("Mời nhập vào quốc tịch ca sĩ: ");
        do {
            String nationality = scanner.nextLine();
            if (nationality.trim().isEmpty()) {
                System.err.println("Quốc tịch ca sĩ không được để trống");
            } else {
                return nationality;
            }
        } while (true);
    }

    public boolean inputGender (Scanner scanner) {
        System.out.println("Mời nhập vào giới tính ca sĩ: ");
        do {
            String gender = scanner.nextLine();
            if (gender.equals("true") || gender.equals("false")) {
                return Boolean.parseBoolean(gender);
            } else {
                System.err.println("Giới tính ca sĩ chỉ nhận giá trị true | false, vui lòng nhập lại");
            }
        }
        while (true);
    }

    public String inputGenre(Scanner scanner) {
        System.out.println("Mời nhập vào thể loại: ");
        do {
            String genre = scanner.nextLine();
            if (genre.trim().isEmpty()) {
                System.err.println("Thể loại không được để trống");
            } else {
                return genre;
            }
        } while (true);
    }
    public void displayData() {
        System.out.printf("Mã ca sĩ: %d - Tên ca sĩ: %s - Tuổi ca sĩ: %d - Quốc tịch: %s - Giới tính: %s - Thể loại: %s\n",
                this.singerId,
                this.singerName,
                this.age,
                this.nationality,
                this.gender?"Nam":"Nữ",
                this.genre);
        System.out.println("-------------------------------------------------------------------------------------------");
    }
}
