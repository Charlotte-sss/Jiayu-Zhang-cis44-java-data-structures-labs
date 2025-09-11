import java.util.*;

abstract class Animal {

    public abstract String toString();
}

class Bear extends Animal {
    @Override
    public String toString() {
        return "B";
    }
}

class Fish extends Animal {
    @Override
    public String toString() {
        return "F";
    }
}

public class Ecosystem {
    private Animal[] river;
    private Random random;

    public Ecosystem(int riverSize, int numBears, int numFish) {
        river = new Animal[riverSize];
        random = new Random();


        for (int i = 0; i < numBears; i++) {
            placeRandom(new Bear());
        }

        for (int i = 0; i < numFish; i++) {
            placeRandom(new Fish());
        }
    }

    private void placeRandom(Animal animal) {
        int pos;
        do {
            pos = random.nextInt(river.length);
        } while (river[pos] != null);
        river[pos] = animal;
    }

    public void runStep() {
        Animal[] nextRiver = new Animal[river.length];

        for (int i = 0; i < river.length; i++) {
            Animal current = river[i];
            if (current == null) continue;

            // -1 = left, 0 = stay, 1 = right
            int move = random.nextInt(3) - 1;
            int newPos = i + move;


            if (newPos < 0 || newPos >= river.length) newPos = i;

            if (nextRiver[newPos] == null) {

                nextRiver[newPos] = current;
            } else {

                Animal other = nextRiver[newPos];

                // same: reproduction
                if (current.getClass() == other.getClass()) {
                    placeRandomInNext(nextRiver, current);

                    if (nextRiver[i] == null) nextRiver[i] = current;
                } else {
                    // Bear vs Fish
                    if (current instanceof Bear && other instanceof Fish) {
                        nextRiver[newPos] = current; // Bear replaces Fish
                    } else if (current instanceof Fish && other instanceof Bear) {

                        if (nextRiver[i] == null) nextRiver[i] = null;
                    }
                }
            }
        }


        river = nextRiver;
    }

    private void placeRandomInNext(Animal[] nextRiver, Animal parent) {
        List<Integer> empty = new ArrayList<>();
        for (int i = 0; i < nextRiver.length; i++) {
            if (nextRiver[i] == null) empty.add(i);
        }
        if (empty.isEmpty()) return;
        int pos = empty.get(random.nextInt(empty.size()));
        Animal baby;
        if (parent instanceof Bear) baby = new Bear();
        else baby = new Fish();
        nextRiver[pos] = baby;
    }

    public void visualize() {
        for (Animal animal : river) {
            System.out.print(animal == null ? "-" : animal.toString());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Ecosystem eco = new Ecosystem(20, 4, 6);
        Scanner sc = new Scanner(System.in);

        eco.visualize();
        for (int step = 1; step <= 20; step++) {
            System.out.println("Step " + step);
            eco.runStep();
            eco.visualize();
            System.out.print("Press Enter to continue...");
            sc.nextLine();
        }

        sc.close();
    }
}
