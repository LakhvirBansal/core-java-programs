package amazon;

import java.util.*;

class Song {
    String name;
    int rating;
    int playCount;

    public Song(String name, int rating, int playCount) {
        this.name = name;
        this.rating = rating;
        this.playCount = playCount;
    }

    @Override
    public String toString() {
        return name + " (Rating: " + rating + ", Plays: " + playCount + ")";
    }
}


public class OptimizedPlaylistGenerator {
    public static List<Song> generateMainPlaylist(List<List<Song>> userPlaylists, String sortBy, int maxSize) {
        PriorityQueue<Song> minHeap;

        Comparator<Song> comparator;
        switch (sortBy.toLowerCase()) {
            case "rating":
                comparator = Comparator.comparingInt(song -> song.rating);
                break;
            case "playcount":
                comparator = Comparator.comparingInt(song -> song.playCount);
                break;
            case "alphabetical":
                comparator = Comparator.comparing(song -> song.name);
                break;
            default:
                throw new IllegalArgumentException("Invalid sorting criteria");
        }

        minHeap = new PriorityQueue<>(maxSize + 1, comparator);

        // Aggregate and maintain only the top `maxSize` elements
        for (List<Song> playlist : userPlaylists) {
            for (Song song : playlist) {
                minHeap.add(song);
                if (minHeap.size() > maxSize) {
                    minHeap.poll();
                }
            }
        }

        List<Song> result = new ArrayList<>(minHeap);
        result.sort(comparator.reversed()); // Sort in descending order
        return result;
    }

    public static void main(String[] args) {
        List<Song> playlist1 = Arrays.asList(
                new Song("Song A", 5, 100),
                new Song("Song B", 3, 50)
        );
        List<Song> playlist2 = Arrays.asList(
                new Song("Song C", 4, 200),
                new Song("Song A", 5, 150) // Duplicate Song
        );
        List<Song> playlist3 = Arrays.asList(
                new Song("Song D", 2, 300),
                new Song("Song E", 5, 50)
        );

        List<List<Song>> userPlaylists = Arrays.asList(playlist1, playlist2, playlist3);

        List<Song> result = OptimizedPlaylistGenerator.generateMainPlaylist(userPlaylists, "playcount", 2);
        System.out.println("Generated Playlist: " + result);
    }
}
