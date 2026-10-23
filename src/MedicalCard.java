import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.List;
public class MedicalCard {
    private static final List<String> BLOOD_TYPES = List.of("I", "II", "III", "IV");
    private static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ofPattern("dd.MM.uuuu").withResolverStyle(ResolverStyle.STRICT);
    private String cardNumber;
    private String patientName;
    private String bloodType;
    private String allergies;
    private String lastVisitDate;
    public MedicalCard() {
    }
    public MedicalCard(String cardNumber, String patientName, String bloodType,
                       String allergies, String lastVisitDate) {
        setCardNumber(cardNumber);
        setPatientName(patientName);
        setBloodType(bloodType);
        setAllergies(allergies);
        setLastVisitDate(lastVisitDate);
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        if (cardNumber == null || cardNumber.isBlank()) {
            throw new IllegalArgumentException("Номер карты не может быть пустым");
        }
        this.cardNumber = cardNumber;
    }
    public String getPatientName() {
        return patientName;
    }
    public void setPatientName(String patientName) {
        if (patientName == null || patientName.isBlank()) {
            throw new IllegalArgumentException("Имя пациента не может быть пустым");
        }
        this.patientName = patientName;
    }
    public String getBloodType() {
        return bloodType;
    }
    public void setBloodType(String bloodType) {
        // Проверка на null идёт первой: List.of(...).contains(null) выбросит NullPointerException
        if (bloodType == null || !BLOOD_TYPES.contains(bloodType)) {
            throw new IllegalArgumentException(
                    "Группа крови должна быть одной из: I, II, III, IV. Получено: " + bloodType);
        }
        this.bloodType = bloodType;
    }
    public String getAllergies() {
        return allergies;
    }
    public void setAllergies(String allergies) {
        if (allergies == null || allergies.isBlank()) {
            this.allergies = "нет";
        } else {
            this.allergies = allergies;
        }
    }
    public String getLastVisitDate() {
        return lastVisitDate;
    }
    public void setLastVisitDate(String lastVisitDate) {
        if (lastVisitDate == null) {
            throw new IllegalArgumentException("Дата визита не может быть null");
        }
        try {
            LocalDate.parse(lastVisitDate, DATE_FORMAT);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(
                    "Дата должна быть в формате дд.мм.гггг и существовать. Получено: " + lastVisitDate);
        }
        this.lastVisitDate = lastVisitDate;
    }
    public String getDescription() {
        return "Медкарта №" + cardNumber + ": " + patientName
                + " (группа крови " + bloodType
                + ", аллергии: " + allergies
                + ", последний визит: " + lastVisitDate + ")";
    }
    @Override
    public String toString() {
        return getDescription();
    }
}