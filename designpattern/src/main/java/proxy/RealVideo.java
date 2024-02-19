package proxy;

public class RealVideo implements Video {
    private String videoUrl;

    public RealVideo(String videoUrl) {
        this.videoUrl = videoUrl;
        loadVideo(videoUrl);
    }

    private void loadVideo(String videoUrl) {
        // Simulate loading the video from the given URL
        System.out.println("Loading video from " + videoUrl);
    }

    @Override
    public void play() {
        System.out.println("Playing video from " + videoUrl);
    }
}