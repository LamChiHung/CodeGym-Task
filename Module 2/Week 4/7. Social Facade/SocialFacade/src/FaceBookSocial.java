public class FaceBookSocial implements SocialShare {
    private String message;

    @Override
    public void typeMessage(String message) {
        this.message = message;
    }

    @Override
    public void share() {
        System.out.println("Facebook: " + this.message);
    }
}
