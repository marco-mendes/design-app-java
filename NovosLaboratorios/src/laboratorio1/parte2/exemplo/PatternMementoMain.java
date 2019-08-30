package laboratorio1.parte2.exemplo;

public class PatternMementoMain {

    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker();
        WordDocument document = new WordDocument("Marcio", "Meu novo documento", "");
        System.out.println(String.format("Estrutura inicial WordDocument: %s", document.toString()));

        document.setTitulo("Savepoint 1");
        document.setConteudo("Dentro do Savepoint 1");
        caretaker.saveMemento("Savepoint 1", document.createMemento());
        System.out.println(String.format("Salvando primeiro estado: %s", document.toString()));

        document.setTitulo("Savepoint 2");
        document.setConteudo("Dentro do Savepoint 2");
        caretaker.saveMemento("Savepoint 2", document.createMemento());
        System.out.println(String.format("Salvando segundo estado: %s", document.toString()));

        document.setTitulo("Savepoint 3");
        document.setConteudo("Dentro do Savepoint 3");
        caretaker.saveMemento("Savepoint 3", document.createMemento());
        System.out.println(String.format("Salvando terceiro estado: %s", document.toString()));

        System.out.println("Restaurando para o primeiro estado!");
        document.restoreMemento(caretaker.getMemento("Savepoint 1"));
        System.out.println(String.format("Estado restaurado para: %s", document));

        System.out.println("Restaurando para o segundo estado!");
        document.restoreMemento(caretaker.getMemento("Savepoint 2"));
        System.out.println(String.format("Estado restaurado para: %s", document));

        System.out.println("Restaurando para o terceiro estado!");
        document.restoreMemento(caretaker.getMemento("Savepoint 3"));
        System.out.println(String.format("Estado restaurado para: %s", document));

        System.out.println("Limpando nosso Caretaker!");
        caretaker.clearSavePoints();

    }

}
