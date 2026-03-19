import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

abstract class Animal {
    private long id;
    private String name;
    private int age;
    private double weight;
    private ArrayList<String> abilities;

    Animal(long id, String name, int age, double weight, ArrayList<String> abilities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.abilities = abilities;
    }

    public abstract String sound();

    public String perfomAbility(String ability) {
        if (this.abilities.contains(ability)) {
            return this.name + " can " + ability;
        } else {
            return this.name + " can't " + ability;
        }
    }

    public long getId() { 
        return id; 
    }
    public String getName() { 
        return name; 
    }
}

class Cat extends Animal {
    public Cat(long id, int age, double weight) {
        super(id, "Frajola", age, weight, new ArrayList<>(Arrays.asList("agility")));
    }
    public String sound() { 
        return "meow"; 
    }
}

class Dog extends Animal {
    public Dog(long id, int age, double weight) {
        super(id, "Bolt", age, weight, new ArrayList<>(Arrays.asList("sniff")));
    }
    public String sound() { 
        return "au"; 
    }
}

class Bird extends Animal {
    public Bird(long id, int age, double weight) {
        super(id, "Blue", age, weight, new ArrayList<>(Arrays.asList("fly")));
    }
    public String sound() { 
        return "piu"; 
    }
}

class Zoo {
    private ArrayList<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal) {
        if (animal != null) {
            this.animals.add(animal);
        }
    }

    public ArrayList<Animal> listAnimals() {
        return this.animals;
    }

    public boolean removeAnimal(long id) {
        for (int i = animals.size() - 1; i >= 0; i--) {
            if (animals.get(i).getId() == id) {
                animals.remove(i);
                return true;
            }
        }
        return false;
    }

    public Animal ProcurarId(long id) {
        for (Animal a : animals) {
            if (a.getId() == id) return a;
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Zoo zoo = new Zoo();
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("\nBem vindo ao Zoológico!");
            System.out.println("1 - Adicionar animal");
            System.out.println("2 - Listar todos os animais");
            System.out.println("3 - Remover animal (por ID)");
            System.out.println("4 - Emitir som de um animal (por ID)");
            System.out.println("5 - Testar habilidade de um animal (por ID)");
            System.out.println("6 - Sair do programa");
            System.out.print("Escolha uma opção: ");
            opcao = s.nextInt(); 

            switch (opcao) {
                case 1:
                    System.out.println("Adicionar (1- Cat, 2- Dog ou 3- Bird)");
                    int tipo = s.nextInt();
                    System.out.println("ID:");
                    long id = s.nextLong();
                    System.out.println("Idade:");
                    int age = s.nextInt();
                    System.out.println("Peso:");
                    double weight = s.nextDouble();

                    if (tipo == 1) zoo.addAnimal(new Cat(id, age, weight));
                    else if (tipo == 2) zoo.addAnimal(new Dog(id, age, weight));
                    else if (tipo == 3) zoo.addAnimal(new Bird(id, age, weight));
                    break;

                case 2:
                    System.out.println("\nLista de animais:");
                    for (Animal a : zoo.listAnimals()) {
                        System.out.println("ID: " + a.getId() + " | Nome: " + a.getName());
                    }
                    break;

                case 3:
                    System.out.println("Digite o ID para remover o animal:");
                    boolean removido = zoo.removeAnimal(s.nextLong());
                    System.out.println("Animal removido: " + removido);
                    break;

                case 4:
                    System.out.println("Digite o ID para a emissão do som:");
                    Animal soundAnimal = zoo.ProcurarId(s.nextLong());
                    if (soundAnimal != null) {
                        System.out.println(soundAnimal.getName() + " says " + soundAnimal.sound());
                    } else {
                        System.out.println("Animal não encontrado!");
                    }
                    break;

                case 5:
                    System.out.println("Digite o ID para a habilidade:");
                    Animal habilidadeAnimal = zoo.ProcurarId(s.nextLong());
                    if (habilidadeAnimal != null) {
                        System.out.println("Qual habilidade testar?");
                        String habilidade = s.next();
                        System.out.println(habilidadeAnimal.perfomAbility(habilidade));
                    } else {
                        System.out.println("Animal não encontrado!");
                    }
                    break;
            }
        }
        System.out.println("Programa encerrado!");
        s.close();
    }
}