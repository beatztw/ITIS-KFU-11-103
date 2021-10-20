package Workers;

public class Main {
    public static void main(String[] args) {
        Worker worker1 = new Worker("Jack", "Programmer",23, 181.3, 85.5);
        Worker worker2 = new Worker("John", "Office worker",44, 175.1, 65);
        Worker worker3 = new Worker("Maks", "Foreman",31, 171, 71);
        System.out.println("Worker №1: " + worker1.name + " " + worker1.profession + " ( Age, weight, height: " + worker1.age + ", " + worker1.weight + ", " + worker1.height + "). ");
        System.out.println("Worker №2: " + worker2.name + " " + worker2.profession + " ( Age, weight, height: " + worker2.age + ", " + worker2.weight + ", " + worker2.height + "). ");
        System.out.println("Worker №3: " + worker3.name + " " + worker3.profession + " ( Age, weight, height: " + worker3.age + ", " + worker3.weight + ", " + worker3.height + "). ");
    }
}
