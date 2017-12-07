public class Main {
    public static void main(String[] args) {
        Project p = new Project("asd", "asdasd");
        p.assignTask(12,1);
        p.assignTask(11,2);
        p.assignTask(10,1);
        p.assignTask(1);

        p.showTaskUser();

    }
}
