package Service;

import Model.Song;

import java.util.Scanner;

import static Service.SongService.showAllSong;

public class SearchService {
    public void showingTheLastTenSongs(Scanner scanner) {
        for (int i = 0; i < SongService.currentSong-1; i++) {
            for (int j = i+1; j < SongService.currentSong; j++) {
                if(SongService.song[i].getCreatedDate().after(SongService.song[j].getCreatedDate())){
                    Song temp = SongService.song[i];
                    SongService.song[i] = SongService.song[j];
                    SongService.song[j] = temp;
                }
            }

        }
        int startIndex = Math.max(0, SongService.currentSong - 10);
        for (int i = startIndex ; i < SongService.currentSong ; i++) {
            SongService.song[i].displayDataSong(SingerService.singers,SingerService.currentSinger);
        }

    }



    public void sortSongNameIncrement(Scanner scanner) {
        for(int i =0;i< SongService.currentSong;i++ ){
            for (int j=i+1;j<SongService.currentSong;j++){
                if(SongService.song[i].getSongName()!=null && SongService.song[j].getSongName()!=null){
                    if(SongService.song[i].getSongName().compareTo(SongService.song[j].getSongName())>0){
                        Song temp = SongService.song[i];
                        SongService.song[i] = SongService.song[j];
                        SongService.song[j] = temp;
                    }
                }
            }
        } showAllSong();


    }

    public void searchSingerByNameorCategory(Scanner scanner) {
        if(SingerService.currentSinger==0){
            System.err.println("List ca sỹ đang trống");
            return;
        }
        System.out.println("Mời bạn nhập tên bài hát muốn thêm ");
        String keyword = scanner.nextLine();
        boolean check=false;
        for (int i=0;i<SingerService.currentSinger;i++){
            if(SingerService.singers[i].getSingerName().contains(keyword)||SingerService.singers[i].getGenre().contains(keyword)){
                SingerService.singers[i].displayDataSinger();
                check=true;

            }
        }
        if(!check){
            System.err.println("Không tìm thấy ca sỹ "+keyword);
        }
    }

    public void searchSongBySingerorCategory(Scanner scanner) {
        if(SongService.currentSong==0){
            System.err.println("List bài hat đang trống");
            return;
        }
        if(SingerService.currentSinger==0){
            System.err.println("List ca sỹ đang trống");
            return;
        }
        System.out.println("Mời bạn nhập tên tên bài hát muốn tìm");
        String keyword = scanner.nextLine();
        boolean check=false;
        for (int i = 0; i < SongService.currentSong; i++) {
            if(SongService.song[i].getSinger().getSingerName().contains(keyword) || SongService.song[i].getSinger().getGenre().contains(keyword)
            ){
                SongService.song[i].displayDataSong(SingerService.singers,SingerService.currentSinger);
                check=true;
            }
        }
        if(!check){
            System.err.println("Không tìm bài hát "+keyword);
        }
    }

}
