public class FacadeSocial {
    private FaceBookSocial faceBookSocial;
    private InstagramSocial instagramSocial;
    private TwitterSocial twitterSocial;

    public void shareSocial(String message) {
        this.faceBookSocial = new FaceBookSocial();
        this.instagramSocial = new InstagramSocial();
        this.twitterSocial = new TwitterSocial();
        faceBookSocial.typeMessage(message);
        instagramSocial.typeMessage(message);
        twitterSocial.typeMessage(message);
        faceBookSocial.share();
        instagramSocial.share();
        twitterSocial.share();
    }
}
