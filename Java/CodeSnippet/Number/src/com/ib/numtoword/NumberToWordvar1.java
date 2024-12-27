package com.ib.numtoword;

import java.text.DecimalFormat;

public class NumberToWordvar1 {
    private static final String[] units = { "", "एक", "दो", "तीन", "चार", "पांच", "छह", "सात", "आठ", "नौ", "दस",
            "ग्यारह", "बारह", "तेरह", "चौदह", "पंद्रह", "सोलह", "सत्रह", "अठारह", "उन्नीस", "बीस", "इक्कीस", "बाईस", "तेईस",
            "चौबीस", "पच्चीस", "छब्बीस", "सत्ताईस", "अट्ठाईस", "उनतीस", "तीस", "इकतीस", "बत्तीस", "तेइतीस", "चौंतीस", "पैंतीस",
            "छत्तीस", "सैंतीस", "अड़तीस", "उनतालीस", "चालीस", "इकतालीस", "बयालीस", "तैंतालीस", "चौवालीस", "पैंतालीस", "छियालीस",
            "सैंतालीस", "अड़तालीस", "उनचास", "पचास", "इक्यावन", "बावन", "तिरपन", "चौवन", "पचपन", "छप्पन", "सत्तावन", "अठावन",
            "उनसठ", "साठ", "इकसठ", "बासठ", "तिरसठ", "चौंसठ", "पैंसठ", "छियासठ", "सड़सठ", "अड़सठ", "उनहतर", "सत्तर", "इकहतर",
            "बहतर", "तिहतर", "चौहतर", "पचहतर", "छिहतर", "सतहतर", "अठहतर", "उन्नासी", "अस्सी", "इक्यासी", "बयासी", "तिरासी",
            "चौरासी", "पचासी", "छियासी", "सतासी", "अठासी", "नवासी", "नब्बे", "इक्यानवे", "बानवे", "तिरानवे", "चौरानवे", "पचानवे",
            "छियानवे", "सत्तानवे", "अट्ठानवे", "निन्यानवे" };

    private static final String[] tens = { "", "", "बीस", "तीस", "चालीस", "पचास", "साठ", "सत्तर", "अस्सी", "नव्वे" };

    private static final String[] scales = { "", "हजार", "लाख", "करोड़" };

    public static String convertRupeesToWords(double amount) {
        //DecimalFormat decimalFormat = new DecimalFormat("##,##,##,###.00");
        String formattedAmount =Double.toString(amount);
        String[] parts = formattedAmount.split("\\.");

        int rupees = Integer.parseInt(parts[0]);
        int paise = Integer.parseInt(parts[1]);

        String rupeesInWords = convertNumberToWords(rupees);
        String paiseInWords = convertNumberToWords(paise);

        String amountInWords = rupeesInWords + " रुपये ";

        if (paise > 0) {
            amountInWords += paiseInWords + " पैसे";
        }

        return amountInWords;
    }

    private static String convertNumberToWords(int number) {
        if (number == 0) {
            return "शून्य";
        }

        String words = "";

        int scaleIndex = 0;

        while (number > 0) {
            int lastThreeDigits = number % 1000;

            if (lastThreeDigits != 0) {
                String hundreds = units[lastThreeDigits / 100];

                if (!hundreds.equals("")) {
                    words += hundreds + " सौ ";
                }

                String tensAndUnits = convertTensAndUnits(lastThreeDigits % 100);

                words += tensAndUnits + scales[scaleIndex] + " ";
            }

            number /= 1000;
            scaleIndex++;
        }

        return words.trim();
    }

    private static String convertTensAndUnits(int number) {
        if (number < 20) {
            return units[number];
        } else {
            String tensDigit = tens[number / 10];
            String unitsDigit = units[number % 10];
            return tensDigit + " " + unitsDigit;
        }
    }

    public static void main(String[] args) {
        double amount = 99;
        String amountInWords = convertRupeesToWords(amount);
        System.out.println("धनराशि: " + amountInWords);
    }
}
