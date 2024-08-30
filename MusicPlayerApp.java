import java.awt.Desktop;
import java.net.URI;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Timer;
import java.util.TimerTask;

// Represents a song in the playlist
class Song {
    private String title;
    private Song previous;
    private Song next;

    public Song(String title) {
        this.title = title;
        this.previous = null;
        this.next = null;
    }

    public String getTitle() {
        return title;
    }

    public Song getPrevious() {
        return previous;
    }

    public void setPrevious(Song previous) {
        this.previous = previous;
    }

    public Song getNext() {
        return next;
    }

    public void setNext(Song next) {
        this.next = next;
    }
}

// Manages the playlist of songs
class Playlist {
    private Song head;
    private Song tail;

    public Playlist() {
        this.head = null;
        this.tail = null;
    }

    // Getter for the head node
    public Song getHead() {
        return head;
    }

    // Getter for the tail node
    public Song getTail() {
        return tail;
    }

    public void addFirst(String title) {
        Song newSong = new Song(title);
        if (head == null) {
            head = tail = newSong;
        } else {
            newSong.setNext(head);
            head.setPrevious(newSong);
            head = newSong;
        }
    }

    public void addLast(String title) {
        Song newSong = new Song(title);
        if (tail == null) {
            head = tail = newSong;
        } else {
            tail.setNext(newSong);
            newSong.setPrevious(tail);
            tail = newSong;
        }
    }

    public void delete(String title) {
        Song current = head;
        while (current != null && !current.getTitle().equals(title)) {
            current = current.getNext();
        }

        if (current == null) {
            System.out.println("===================== Song Not Found =====================");
            return; // Song not found
        }

        if (current == head) {
            head = head.getNext();
            if (head != null) {
                head.setPrevious(null);
            }
        } else if (current == tail) {
            tail = tail.getPrevious();
            if (tail != null) {
                tail.setNext(null);
            }
        } else {
            current.getPrevious().setNext(current.getNext());
            current.getNext().setPrevious(current.getPrevious());
        }
    }

    public int getSize() {
        int size = 0;
        Song current = head;
        while (current != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }

    public Song getRandomSong() {
        if (head == null) {
            return null;
        }
        Random random = new Random();
        int randomIndex = random.nextInt(getSize());
        Song current = head;
        for (int i = 0; i < randomIndex; i++) {
            current = current.getNext();
        }
        return current;
    }

    public void displayFromLast() {
        if (tail == null) {
            System.out.println("No songs in the playlist.");
            return;
        }

        Song current = tail;
        int count = 1;

        while (current != null) {
            System.out.println("Song no. " + count + ": " + current.getTitle());
            current = current.getPrevious();
            count++;
        }

        System.out.println();
    }

    public void displayFromFirst() {
        if (head == null) {
            System.out.println("No songs in the playlist.");
            return;
        }

        Song current = head;
        int count = 1;

        while (current != null) {
            System.out.println("Song no. " + count + ": " + current.getTitle());
            current = current.getNext();
            count++;
        }

        System.out.println();
    }
}

// Handles file operations for saving and loading the playlist
class FileManager {
    public static void savePlaylist(Playlist playlist, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            Song current = playlist.getHead();
            while (current != null) {
                writer.write(current.getTitle());
                writer.newLine();
                current = current.getNext();
            }
        } catch (IOException e) {
            System.out.println("Error saving data to file: " + e.getMessage());
        }
    }

    public static void loadPlaylist(Playlist playlist, String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                playlist.addLast(line);
            }
        } catch (IOException e) {
            System.out.println("Error loading data from file: " + e.getMessage());
        }
    }
}

// Main application class that interacts with the user
public class MusicPlayerApp {
    private static Playlist playlist = new Playlist(); // Track current playlist
    private static final String DEFAULT_PLAYLIST_FILE = "playlist.txt";

    public static void main(String[] args) {
        final String GREEN = "\033[0;32m";
        final String RESET = "\033[0m";
        final String CYAN = "\033[0;36m";
        final String YELLOW = "\033[0;33m";
        final String RED_BOLD = "\033[1;31m";

        System.out.println(GREEN + "\r\n" + //
                "  _______            __          __             \r\n" + //
                " |__   __|           \\ \\        / /             \r\n" + //
                "    | |_   _ _ __   __\\ \\  /\\  / /_ ___   _____ \r\n" + //
                "    | | | | | '_ \\ / _ \\ \\/  \\/ / _` \\ \\ / / _ \\\r\n" + //
                "    | | |_| | | | |  __/\\  /\\  / (_| |\\ V /  __/\r\n" + //
                "    |_|\\__,_|_| |_|\\___| \\/  \\/ \\__,_| \\_/ \\___|\r\n" + //
                "                                                \r\n" + //
                "                                                \r\n" + //
                "" + RESET);

        File file = new File(DEFAULT_PLAYLIST_FILE);
        if (!file.exists()) {
            System.out.println("Playlist file not found. Creating a new file...");
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error creating file: " + e.getMessage());
            }
        }
        FileManager.loadPlaylist(playlist, DEFAULT_PLAYLIST_FILE);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(CYAN + "What would you like to do with your music playlist?" + RESET);
            System.out.println("1. Add new song at last");
            System.out.println("2. Add new song at first");
            System.out.println("3. Remove song");
            System.out.println("4. Show playlist from new to old");
            System.out.println("5. Show playlist from old to new");
            System.out.println("6. Play a random song from the playlist");
            System.out.println("7. See total number of songs");
            System.out.println("8. Create a new playlist");
            System.out.println("9. Exit");

            System.out.print(RED_BOLD + ">>> " + RESET);
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            String songTitle;

            switch (option) {
                case 1:
                    System.out.print(CYAN + "Enter the song title: " + RESET);
                    songTitle = scanner.nextLine();
                    playlist.addLast(songTitle);
                    FileManager.savePlaylist(playlist, DEFAULT_PLAYLIST_FILE);
                    System.out.println("Song added to the end of the playlist.");
                    break;
                case 2:
                    System.out.print(CYAN + "Enter the song title: " + RESET);
                    songTitle = scanner.nextLine();
                    playlist.addFirst(songTitle);
                    FileManager.savePlaylist(playlist, DEFAULT_PLAYLIST_FILE);
                    System.out.println("Song added to the beginning of the playlist.");
                    break;
                case 3:
                    playlist.displayFromFirst();
                    System.out.print(CYAN + "Enter the song title to remove: " + RESET);
                    songTitle = scanner.nextLine();
                    playlist.delete(songTitle);
                    FileManager.savePlaylist(playlist, DEFAULT_PLAYLIST_FILE);
                    System.out.println("Song removed from the playlist.");
                    break;
                case 4:
                    playlist.displayFromLast();
                    break;
                case 5:
                    playlist.displayFromFirst();
                    break;
                case 6:
                    Song randomSong = playlist.getRandomSong();
                    if (randomSong != null) {
                        System.out.println("Playing random song: " + randomSong.getTitle());
                        playSongOnYouTube(randomSong.getTitle());
                    } else {
                        System.out.println("Playlist is empty.");
                    }
                    break;
                case 7:
                    System.out.println("Total number of songs: " + playlist.getSize());
                    break;
                case 8:
                    createNewPlaylist(scanner);
                    break;
                case 9:
                    System.out.println(RED_BOLD + "Exiting..." + RESET);
                    return;
                default:
                    System.out.println(RED_BOLD + "Invalid option. Please try again." + RESET);
            }
            System.out.println(YELLOW + "--------------------------------------" + RESET);
            System.out.println();
        }
    }

    private static void createNewPlaylist(Scanner scanner) {
        System.out.print("Enter the name of the new playlist: ");
        String playlistName = scanner.nextLine();
        String newPlaylistFile = playlistName + ".txt";

        File newPlaylist = new File(newPlaylistFile);
        try {
            if (newPlaylist.createNewFile()) {
                System.out.println("New playlist file created: " + newPlaylistFile);
            } else {
                System.out.println("Playlist file already exists: " + newPlaylistFile);
            }
        } catch (IOException e) {
            System.out.println("Error creating playlist file: " + e.getMessage());
            return;
        }

        Playlist newPlaylistInstance = new Playlist();
        System.out.print("How many songs do you want to add to the new playlist? ");
        int numberOfSongs = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numberOfSongs; i++) {
            System.out.print("Enter song title: ");
            String songTitle = scanner.nextLine();
            newPlaylistInstance.addLast(songTitle);
        }

        FileManager.savePlaylist(newPlaylistInstance, newPlaylistFile);
        System.out.println("Songs added to the new playlist.");

        // Switch to the new playlist
        playlist = newPlaylistInstance;
        FileManager.loadPlaylist(playlist, newPlaylistFile);
        System.out.println("Now using playlist: " + newPlaylistFile);
    }

    private static void playSongOnYouTube(String songTitle) {
        String youtubeLink = "https://www.youtube.com/results?search_query=" + songTitle.replace(" ", "+");
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    Desktop.getDesktop().browse(new URI(youtubeLink));
                } catch (Exception e) {
                    System.out.println("Error opening YouTube link: " + e.getMessage());
                }
            }
        }, 1000);
    }
}
