package Controller;

import Service.SongService;

import java.util.Scanner;

public class SongController {

    public void menuSong(Scanner scanner)
    {
        SongService songService = new SongService();
        boolean isLoop = true;
        do
        {
            System.out.println("---------------------------SONG-MANAGEMENT---------------------------\n" +
                    "\n" +
                    "1. Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mới\n" +
                    "2. Hiển thị danh sách tất cả bài hát đã lưu trữ\n" +
                    "3. Thay đổi thông tin bài hát theo mã id\n" +
                    "4. Xóa bài hát theo mã id\n" +
                    "5. Thoát\n"
            );
            System.out.println("Lựa chọn : ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice)
            {
                case 1:
                {   songService.addNewSong(scanner);
                    break;
                }
                case 2:
                {   songService.showAllSong();
                    break;
                }
                case 3:
                {
                    songService.updateSong(scanner);
                    break;
                }
                case 4:
                {   songService.deleteSong(scanner);
                    break;
                }
                case 5:
                {
                    isLoop = false;
                    break;
                }

                default:
                    System.err.println("Vui lòng nhập lại từ 1 -> 5");
            }
        }
        while (isLoop);
    }

}
