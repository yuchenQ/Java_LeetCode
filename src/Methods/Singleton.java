package Methods;

public class Singleton {

    private Singleton(){}

    private static class SingletonLoader {
        private static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonLoader.instance;
    }
}
