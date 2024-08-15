package Service;

import Model.Song;

import java.util.Scanner;

public class SongService {
    public static  Song[] song=new Song[100];
    public static  int currentSong=0;

    public static void deleteSong(Scanner scanner) {

        System.out.println("Mời bạn nhập iD muốn xóa");
        String ID = scanner.nextLine();
        int indexDelete=findindexSongByID(ID);

        if(indexDelete!=-1){
            for (int i=indexDelete; i<currentSong; i++){
                song[i]=song[i+1];
                currentSong--;
                System.out.println("Xóa thành công");
            }
        }else {
            System.err.println("Không tìm thấy vị trí ID muốn xóa"+indexDelete);
        }

    }

    public static void updateSong(Scanner scanner) {
        System.out.println("Nhập id muốn thay đổi");
        String idUpdateP = scanner.nextLine();
        if (  findSongBYID(idUpdateP)!=null) {

            findSongBYID(idUpdateP).inputUpdateSong(scanner,song,currentSong,SingerService.singers,SingerService.currentSinger);

        }
        else {
            System.err.println("Không tồn tại id có mã"+idUpdateP);
        }
    }

    public static void showAllSong() {
        if(currentSong==0){
            System.err.println("Danh sách trống");
            return;
        }

        for (int i=0; i<currentSong;i++){
            song[i].displayDataSong(SingerService.singers,SingerService.currentSinger);

        }
    }

    public static Song findSongBYID(String id2) {
        for (int i = 0; i <currentSong; i++) {
            if(song[i].getSongId().equals(id2) ){
                return song[i];}
        }
        return null;
    }
    public static int findindexSongByID(String id) {
        for (int i = 0; i <currentSong; i++) {
            if(song[i].getSongId().equals(id) ){
                return i;
            }
        }
        return -1;
    }

    public static void addNewSong(Scanner scanner) {
        System.out.println("Nhập số bài hát muốn thêm vào?");
        do {
            if (SingerService.currentSinger == 0) {
                System.err.println("Danh sách ca sĩ đang trống, cần nhập thêm");
                break;
            }
            try {
                int n = Integer.parseInt(scanner.nextLine());
                if (n > 0) {
                    for (int i = 0; i < n; i++) {
                        System.out.println("Mã bài hát thứ " + (i + 1));
                        song[currentSong] = new Song();
                        song[currentSong].inputDataSong(scanner, song, currentSong, SingerService.singers,SingerService.currentSinger);
                        currentSong++;
                    }
                    break;
                } else {
                    System.err.println("N phải lớn hơn 0");
                }
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập một số nguyên hợp lệ.");
            } catch (Exception e) {
                System.err.println("Đã xảy ra lỗi: " + e.getMessage());
            }
        } while (true);
    }
}
