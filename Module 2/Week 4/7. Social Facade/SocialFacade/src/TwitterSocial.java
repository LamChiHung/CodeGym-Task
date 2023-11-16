public class TwitterSocial implements SocialShare {
    public String message;

    @Override
    public void typeMessage(String message) {
        this.message = message;
    }

    @Override
    public void share() {
        System.out.println("Twitter: " + this.message);
    }
}
