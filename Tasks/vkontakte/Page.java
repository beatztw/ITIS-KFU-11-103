package space.enthropy.examtasks.vkontakte;

public abstract class Page {
    private static int start = 1;

    public void entries() {
         start++;
    }

    public abstract void paidSubscription();
}
