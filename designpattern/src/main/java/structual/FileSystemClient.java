package structual;

public class FileSystemClient {
    public static void main(String[] args) {
        // Creating a file system structure
        FileSystemComponent file1 = new File("document.txt");
        FileSystemComponent file2 = new File("image.jpg");

        Directory directory1 = new Directory("Folder 1");
        directory1.addComponent(file1);
        directory1.addComponent(file2);

        FileSystemComponent file3 = new File("video.mp4");

        Directory rootDirectory = new Directory("Root");
        rootDirectory.addComponent(directory1);
        rootDirectory.addComponent(file3);

        // Displaying the file system structure
        rootDirectory.display();
    }
}
