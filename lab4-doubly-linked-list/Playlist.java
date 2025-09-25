// Playlist.java
public class Playlist {
    private static class Node {
        Song song;
        Node next;

        Node(Song song) {
            this.song = song;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private Node currentNode;
    private int size;

    public Playlist() {
        this.head = null;
        this.tail = null;
        this.currentNode = null;
        this.size = 0;
    }

    // Add a song to the end of the playlist
    public void addSong(Song song) {
        Node newNode = new Node(song);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Remove a song by title
    public void removeSong(String title) {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        // Case 1: removing head
        if (head.song.getTitle().equalsIgnoreCase(title)) {
            head = head.next;
            if (head == null) { // if list is now empty
                tail = null;
            }
            size--;
            System.out.println("Removed song: " + title);
            return;
        }

        // Case 2: remove from elsewhere
        Node prev = head;
        Node current = head.next;
        while (current != null) {
            if (current.song.getTitle().equalsIgnoreCase(title)) {
                prev.next = current.next;
                if (current == tail) { // if last node removed
                    tail = prev;
                }
                size--;
                System.out.println("Removed song: " + title);
                return;
            }
            prev = current;
            current = current.next;
        }

        System.out.println("Song not found: " + title);
    }

    // Play next song
    public void playNext() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        if (currentNode == null || currentNode.next == null) {
            currentNode = head; // wrap around
        } else {
            currentNode = currentNode.next;
        }

        System.out.println("Now playing: " + currentNode.song);
    }

    // Display playlist
    public void displayPlaylist() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        System.out.println("Playlist:");
        Node temp = head;
        while (temp != null) {
            System.out.println(" - " + temp.song);
            temp = temp.next;
        }
    }
}
