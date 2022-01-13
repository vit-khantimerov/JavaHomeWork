package com.pb.khantimerov.hw1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class _DateTime_ {

   public static void main(String[] args) {
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formattedDTime = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm:ss");
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM, dd, yyyy HH:mm:ss", Locale.US);
            System.out.println(dateTime.format(formattedDTime));
        }
    }

