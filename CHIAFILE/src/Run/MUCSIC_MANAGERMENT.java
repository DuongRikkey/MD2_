package Run;
import Controller.SearchController;
import Controller.SingerController;
import Controller.SongController;

import java.util.Scanner;
public class MUCSIC_MANAGERMENT {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // show ra menu
        do
        {
            MUCSIC_MANAGERMENT main = new MUCSIC_MANAGERMENT();
            System.out.println("********************* MUSIC-MANAGEMENT *********************");
            System.out.println("1. Quản lý ca sỹ");
            System.out.println("2. Quản lý bài hát");
            System.out.println("3. Tìm kiếm bài hát");
            System.out.println("4. Thoát");
            System.out.println("************************************************************");
            System.out.println("Lựa chọn đê: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice)
            {
                case 1:
                {
                    new SingerController().menuSinger(scanner);
                    break;
                }
                case 2:
                {
                    new SongController().menuSong(scanner);
                    break;
                }
                case 3:
                {
                    new SearchController().menuSearch(scanner);
                    break;
                }
                case 4:
                {
                    System.exit(0);
                    break;
                }
                default:
                    System.err.println("Vui lòng nhập lại từ 1 -> 4");
            }
        }
        while (true);

    }

}
