import java.util.*;
abstract class Animal {
    private  String animaltype;
    private String name;
    private int age;

    public Animal() {
    }

    public Animal(String animaltype, String name, int age) {
        this.animaltype = animaltype;
        this.name = name;
        this.age = age;
    }

    public String getAnimaltype() {
        return animaltype;
    }

    public void setAnimaltype(String animaltype) {
        this.animaltype = animaltype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animaltype='" + animaltype + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public abstract  void cry();
}

class Cat extends Animal {
    private String shout1;

    public Cat() {
    }

    public Cat(String animaltype, String name, int age) {
        super(animaltype, name, age);
        this.shout1 = "MIAOMIAOMIAO~";
    }

    @Override
    public void cry(){
        System.out.println("I am a cat,I am "+super.getAge()+",my name is "+super.getName()+"."+shout1+".");
    }
}

class Dog extends Animal {
    private  String shout2;

    public Dog() {}

    public Dog(String animaltype, String name, int age) {
        super(animaltype, name, age);
        this.shout2 = "WANGWANGWANG~";
    }

    public String getShout2() {
        return shout2;
    }

    public void setShout2(String shout2) {
        this.shout2 = shout2;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "shout2='" + shout2 + '\'' +
                '}';
    }

    @Override
    public void cry(){
        System.out.println("I am a dog,I am "+super.getAge()+",my name is "+super.getName()+"."+shout2+".");
    }
}


public class Main {
    public static void main(String[] args){
        int n,i;

        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();

        Animal[] animal=new Animal[n];
        String a,b;
        int c;

        for(i=0;i<n;i++){
            a = scanner.next();
            b = scanner.next();
            c = scanner.nextInt();
            if(a.equals("cat")){
                animal[i]=new Cat(a,b,c);
            }else {
                animal[i]=new Dog(a,b,c);
            }
        }
        for(i=0;i<n;i++){
            animal[i].cry();
            System.out.println(animal[i].getClass().getName()+","+animal[i].getClass().getSuperclass().getName());
        }
        System.out.println(n);

    }
}
