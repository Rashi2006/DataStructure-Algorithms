import java.util.Scanner;

public class MusicPlayer {

    class SongNode {
        // Represents a node of a doubly linked list
        String info;
        SongNode lpter;
        SongNode rpter;

        public SongNode(String data) {
            this.info = data;
            this.lpter = null;
            this.rpter = null;
        }
    }

    public SongNode l = null;
    public SongNode r = null;
    public SongNode curr = null;

    public void insertAtLast(String data) {
        SongNode newNode = new SongNode(data);
        // If list is empty, newNode will be the first Node
        if (l == null && r == null) {
            l = r = curr = newNode;
            return;
        }

        newNode.rpter = null;
        newNode.lpter = r;
        r.rpter = newNode;
        r = newNode;
    }

    public void display() {
        if (l == null && r == null) {
            System.out.println("List is empty");
            return;
        }
        SongNode save = l;
        System.out.print("null-->");
        while (save != null) {
            System.out.print(save.info + "-->");
            save = save.rpter;
        }
        System.out.println("null");
    }

    public int sizeOfLinkedList() {
        if (r == null && l == null) {
            return 0;
        }
        int count = 0;
        SongNode save = l;
        while (save != null) {
            count++;
            save = save.rpter;
        }
        return count;
    }

    public void playSong(int n) {
        if (n > sizeOfLinkedList() || n < 1) {
            System.out.println("Song is not available in your playlist");
            return;
        }
        curr = l;
        for (int i = 1; i < n; i++) {
            curr = curr.rpter;
        }
        System.out.println("song: " + curr.info);
    }

    public void playPrevSong() {
        if (curr == null || curr.lpter == null) {
            System.out.println("No previous song");
            return;
        }
        curr = curr.lpter;
        System.out.println("song: " + curr.info);
    }

    public void playNextSong() {
        if (curr == null || curr.rpter == null) {
            System.out.println("No next song");
            return;
        }
        curr = curr.rpter;
        System.out.println("song: " + curr.info);
    }

    public void deleteSongsFromQueue(int p) {
        if(p>sizeOfLinkedList()){
            System.out.println("Given song is not in queue");
            return;
        }
        if (r == null && l == null) {
            System.out.println("queue is empty");
            return;
        }
        if (l == r && p == 1) {
            l = r = curr = null;
            System.out.println("Song deleted");
            return;
        }
        if (p == 1) {
            l = l.rpter;
            l.lpter = null;
            System.out.println("Song deleted");
            return;
        }
        if (p == sizeOfLinkedList()) {
            r = r.lpter;
            r.rpter = null;
            System.out.println("Song deleted");
            return;
        }

        SongNode save = l;
        int count = 1;
        while (save != null && count != p) {
            save = save.rpter;
            count++;
        }
        if (save != null) {
            save.lpter.rpter = save.rpter;
            if (save.rpter != null) {
                save.rpter.lpter = save.lpter;
            }
            System.out.println("Song deleted");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MusicPlayer mp = new MusicPlayer();
        MusicPlayer queue = new MusicPlayer();

        System.out.println("Enter 1 to create playlist");
        System.out.println("Enter 2 to add songs into your playlist");
        System.out.println("Enter 3 to play song");
        System.out.println("Enter 4 to play prev song");
        System.out.println("Enter 5 to play next song");
        System.out.println("Enter 6 to add songs to queue");
        System.out.println("Enter 7 to remove songs from queue");
        System.out.println("Enter 8 to exit");

        while (true) {
            System.out.println("Please enter your choice:");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline left-over
            switch (choice) {
                case 1:
                    System.out.println("Your playlist is created");
                    break;
                case 2:
                    System.out.println("Enter the song you want to add:");
                    System.out.println("Enter 1 if you want to add more songs");
                    System.out.println("Enter 2 if you have completed adding songs");

                    while (true) {
                        System.out.println("Enter your choice:");
                        int a = sc.nextInt();
                        sc.nextLine(); // Consume newline left-over
                        if (a == 2) {
                            break;
                        } else if (a == 1) {
                            System.out.println("Enter song:");
                            String s = sc.nextLine();
                            mp.insertAtLast(s);
                        } else {
                            System.out.println("Invalid choice");
                        }
                    }
                    System.out.println("Songs are added successfully");
                    break;
                case 3:
                    System.out.println("Enter 1 if You want to play song from playlist");
                    System.out.println("Enter 2 if You want to play song from queue");
                    int a = sc.nextInt();
                    if (a == 1) {
                        System.out.println("Please enter song number you want to play:");
                        mp.playSong(sc.nextInt());
                    } else if (a == 2) {
                        System.out.println("Please enter song number you want to play:");
                        queue.playSong(sc.nextInt());
                    } else {
                        System.out.println("Invalid choice");
                    }
                    break;
                case 4:
                    System.out.println("Enter 1 if You want to play song from playlist");
                    System.out.println("Enter 2 if You want to play song from queue");
                    a = sc.nextInt();
                    if (a == 1) {
                        mp.playPrevSong();
                    } else if (a == 2) {
                        queue.playPrevSong();
                    } else {
                        System.out.println("Invalid choice");
                    }
                    break;
                case 5:
                    System.out.println("Enter 1 if You want to play song from playlist");
                    System.out.println("Enter 2 if You want to play song from queue");
                    a = sc.nextInt();
                    if (a == 1) {
                        mp.playNextSong();
                    } else if (a == 2) {
                        queue.playNextSong();
                    } else {
                        System.out.println("Invalid choice");
                    }
                    break;
                case 6:
                    System.out.println("Enter the song you want to add to queue:");
                    System.out.println("Enter 1 if you want to add more songs");
                    System.out.println("Enter 2 if you have completed adding songs");

                    while (true) {
                        System.out.println("Enter your choice:");
                        a = sc.nextInt();
                        sc.nextLine(); // Consume newline left-over
                        if (a == 2) {
                            break;
                        } else if (a == 1) {
                            System.out.println("Enter song:");
                            String s = sc.nextLine();
                            queue.insertAtLast(s);
                        } else {
                            System.out.println("Invalid choice");
                        }
                    }
                    System.out.println("Songs are added to queue successfully");
                    break;
                case 7:
                    System.out.println("Enter the song number to be deleted from queue:");
                    int n= sc.nextInt();
                    queue.deleteSongsFromQueue(n);
                    break;
                case 8:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
