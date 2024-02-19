package proxy;

public class StreamingServiceClient {
    public static void main(String[] args) {
        // Simulate a user with a premium subscription
        Video premiumVideo = new VideoProxy("https://premium-video.com", true);
        premiumVideo.play();

        // Simulate a user without a premium subscription
        Video regularVideo = new VideoProxy("https://regular-video.com", false);
        regularVideo.play();
    }
}
