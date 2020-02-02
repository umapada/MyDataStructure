package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSV {

    public static void main(String[] args) {
        getCsv();
    }

    private static List<String> getCsv() {
        String csvFile = "/Users/a012573/Projects/FCC/fcc_master/FCC/Fitnesse/src/test/resources/datasets/stella/ProductsResource/SparkPagination/ProductAttributes/member_attributes.csv";
        String line = "";
        String cvsSplitBy = ",";
        List<String> lst = new ArrayList<>();
        int count = 0;
        boolean b = false;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                if(!b){
                    b= true;
                    continue;
                }
                count ++;
                String[] country = line.split(cvsSplitBy);
                lst.add(country[1].trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lst;
    }
}


