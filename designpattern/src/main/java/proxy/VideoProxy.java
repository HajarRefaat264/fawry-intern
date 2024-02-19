package proxy;

public class VideoProxy implements Video {
    private RealVideo realVideo;
    private String videoUrl;
    private boolean userHasPremiumSubscription;

    public VideoProxy(String videoUrl, boolean userHasPremiumSubscription) {
        this.videoUrl = videoUrl;
        this.userHasPremiumSubscription = userHasPremiumSubscription;
    }

    @Override
    public void play() {
        if (userHasPremiumSubscription) {
            if (realVideo == null) {
                realVideo = new RealVideo(videoUrl);
            }
            realVideo.play();
        } else {
            System.out.println("Sorry, you need a premium subscription to access this video.");
        }
    }
}