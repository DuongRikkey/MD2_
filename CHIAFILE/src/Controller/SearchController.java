package Controller;

import Service.SearchService;
import Service.SongService;

import java.util.Scanner;

public class SearchController {
    public void menuSearch(Scanner scanner) {
        SearchService searchService = new SearchService();
        boolean isLoop = true;
        do
        {
            System.out.println("--------------------------*SEARCH-MANAGEMENT*---------------------------\n" +
                    "\n" +
                    "1. Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại\n" +
                    "2. Tìm kiếm ca sĩ theo tên hoặc thể loại \n" +
                    "3. Hiển thị danh sách bài hát theo thứ tự tên tăng dần\n" +
                    "4. Hiển thị 10 bài hát được đăng mới nhất\n" +
                    "5. Thoát" );
            System.out.println("Lựa chọn đê: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice)
            {
                case 1:
                {   searchService.searchSongBySingerorCategory(scanner);
                    break;
                }
                case 2:
                {   searchService.searchSingerByNameorCategory(scanner);
                    break;
                }
                case 3:
                {   searchService.sortSongNameIncrement(scanner);
                    break;
                }
                case 4:
                {   searchService.showingTheLastTenSongs(scanner);
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
