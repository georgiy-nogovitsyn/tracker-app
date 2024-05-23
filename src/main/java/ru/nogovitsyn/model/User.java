package ru.nogovitsyn.model;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

public class User {
    UUID id;
    String name;
    String surname;
    String sex;
    String birthday;
    LocalDate registrationDate;
    double weight;
    double height;

    public User(String name, String sex, String birthday) {
        registrationDate = LocalDate.now();
        id = UUID.randomUUID();
        setName(name);
        setSex(sex);
        setBirthday(birthday);
    }

    public void setName(String name) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            if(checkName(name)){
                this.name = name.toUpperCase().charAt(0) + name.substring(1).toLowerCase();
                System.out.println(this.name + " name set");
                return;
            }
            System.out.print("Invalid name, only characters from 2 to 30\nEnter the name: ");
            name = sc.nextLine();
        }

    }

    public void setSurname(String surname) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            if(checkName(surname)){
                this.surname = surname.toUpperCase().charAt(0) + surname.substring(1).toLowerCase();
                System.out.println(this.surname + " surname set");
                return;
            }
            System.out.print("Invalid surname, only characters from 2 to 30\nEnter the surname: ");
            surname = sc.nextLine();
        }

    }

    public void setSex(String sex) {
        Scanner sc = new Scanner(System.in);
        sex = sex.toLowerCase();
        while(true) {
            if(sex.equals("male") || sex.equals("female") || sex.equals("not specified")) {
                this.sex = sex;
                return;
            }
            System.out.print("Only \"male\", \"female\", \"not specified\" allowed. Enter your sex: ");
            name = sc.nextLine();
        }
    }

    public void setBirthday(String birthday) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            if(checkBirthday(birthday)) {
                this.birthday = birthday;
                System.out.println(this.birthday + " birthday set");
                return;
            }
            System.out.print("Invalid format date. Only digits and dots, e.g. 01.01.1970: ");
            birthday = sc.nextLine();
        }
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    private boolean checkName(String name) {
        if (name.length() <= 1 || name.length() >= 30) return false;
        for (int i = 0; i < name.length(); i++) {
            if (name.toUpperCase().charAt(i) < 'A' || name.toUpperCase().charAt(0) > 'Z') return false;
        }
        return true;

    }

    private boolean checkBirthday(String birthday) {
        String[] bd = birthday.split("\\.");
        int day, month, year;
        if(bd.length == 3) {
            for(String datePart : bd) {
                for(int i = 0; i < datePart.length(); i++) {
                    if(datePart.charAt(i) < '0' || birthday.charAt(i) > '9') {
                        return false;
                    }
                }
            }
            day = Integer.parseInt(bd[0]);
            month = Integer.parseInt(bd[1]);
            year = Integer.parseInt(bd[2]);

            return checkDate(day, month, year);
        }
        return false;
    }

    private boolean checkDate(int day, int month, int year) {
        if((day < 0 || day > 31) || (month < 0 || month > 12) || (year < 1905 || year > LocalDate.now().getYear())) return false;
        if(day == 31 && (month == 4 || month == 6 || month == 9 || month == 11)) return false;
        if(day > 29 && month == 2) return false;
        if((day == 29 && month == 2) && (year % 400 != 0 && !(year % 4 == 0 && year % 100 != 0))) return false;

        return true;
    }

}
