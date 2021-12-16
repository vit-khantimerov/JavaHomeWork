package com.pb.khantimerov.hw11;

import com.pb.khantimerov.hw3.Array;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/*
ФИО
дата рождения
телефоны (количество не ограничено)
адрес
дата и время редактирования
 */
public class Abonent {
    String fio;
    LocalDate dateOfBirth;
    //String dateBirth; // - изменить тип
    List<String> phoneNrs;
    String address;
    //String edited; // - изменить тип
    LocalDateTime edited;

    public Abonent(String fio, LocalDate dateOfBirth, List<String> phoneNrs,
                   String address, LocalDateTime edited) {
        this.fio = fio;
        this.dateOfBirth = dateOfBirth;
        this.phoneNrs = phoneNrs;
        this.address = address;
        this.edited = edited;
    }

    @Override
    public String toString() {
        return "\nДанные абонента (" +
                "Ф.И.О.: " + fio +
                ", Дата рождения: " + dateOfBirth +
                ",\n Номера телефонов: " + phoneNrs +
                ",\n Адрес: " + address +
                ",\n Изменено: " + edited + ".";
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<String> getPhoneNrs() {
        return phoneNrs;
    }

    public void setPhoneNrs(List<String> phoneNrs) {
        this.phoneNrs = phoneNrs;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getEdited() {
        return edited;
    }

    public void setEdited(LocalDateTime edited) {
        this.edited = edited;
    }

}
