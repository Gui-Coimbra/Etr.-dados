public class Main {
    public static void main(String[] args) {
        Repository repository = new Repository();

        repository.addAtEnd('A');
        repository.addAtEnd('G');
        repository.addAtEnd('Y');
        repository.addAtEnd(' ');
        repository.addAtEnd('k');
        repository.addAtEnd('r');
        repository.addAtEnd('r');
        repository.addAtEnd('B');
        repository.addAtEnd('G');

        System.out.println("-".repeat(20));

        repository.show();

        System.out.println("-".repeat(20));

        repository.addAtIndex(4, 'C');
        repository.addAfterSpace('Y');

        repository.show();

        System.out.println("-".repeat(20));

        repository.duplicateValue('G');

        repository.show();

        System.out.println("-".repeat(20));

        repository.removeDuplicate('G');

        repository.show();

        System.out.println("Exibindo recursivo: ");

        repository.showRecursivo();

    }
}