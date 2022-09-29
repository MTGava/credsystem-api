package com.api.credsystem.manager.utils;

import lombok.Getter;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class Utils {
    public static Date formatDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException("Não foi possível formatar a data para o padrão da aplicação: " + e);
        }
    }
}
