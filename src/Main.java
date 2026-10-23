public class Main {
    public static void main(String[] args) {
        //Часть 1. Класс Book
        Book book1 = new Book(1, "Война и мир", "Толстой Л.Н.", 1869);
        Book book2 = new Book(2, "Мастер и Маргарита", "Булгаков М.А.", 1967);
        Book book3 = new Book();
        book3.setId(3);
        book3.setTitle("Преступление и наказание");
        book3.setAuthor("Достоевский Ф.М.");
        book3.setYear(1866);
        System.out.println("=== Список книг ===");
        System.out.println("1. " + book1.getDescription());
        System.out.println("2. " + book2.getDescription());
        System.out.println("3. " + book3); // вызовется toString()
        System.out.println();
        System.out.println("=== Проверка валидации Book ===");
        try {
            book1.setYear(3000);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            book1.setTitle("   ");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        //Часть 2. Класс MedicalCard
        MedicalCard card1 = new MedicalCard("МК-001", "Иванов И.И.", "II", "нет", "15.05.2026");
        MedicalCard card2 = new MedicalCard("МК-002", "Петрова А.С.", "I", "пенициллин", "03.09.2026");
        MedicalCard card3 = new MedicalCard();
        card3.setCardNumber("МК-003");
        card3.setPatientName("Сидоров П.П.");
        card3.setBloodType("IV");
        card3.setAllergies("пыльца, орехи");
        card3.setLastVisitDate("21.10.2026");
        System.out.println();
        System.out.println("=== Список медицинских карт ===");
        System.out.println("1. " + card1.getDescription());
        System.out.println("2. " + card2.getDescription());
        System.out.println("3. " + card3);
        System.out.println();
        System.out.println("=== Проверка валидации MedicalCard ===");
        try {
            card1.setBloodType("V");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            card1.setLastVisitDate("31.02.2026");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            card1.setCardNumber("   ");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}