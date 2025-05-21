package br.com.introcdc.tests.files;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PaymentPdfImporter {
    private static final Pattern LINE_PATTERN = Pattern.compile(
            "^(\\d{2}/\\d{2}(?:/\\d{4})?)\\s+(.+?)\\s+(-?[0-9\\.]+,[0-9]{2})(?!.*[0-9\\.]+,[0-9]{2})"
    );
    private static final Pattern INST_PATTERN = Pattern.compile("(\\d+)x");
    private static final Map<String,String> TYPE_MAP = Map.of(
            "COMPRA", "static",
            "PARCELADA", "installment",
            "MENSAL", "monthly",
            "ANUAL", "annual",
            "PIX", "static"
    );
    private static final int SHIFT_THRESHOLD = 21;
    private static final DateTimeFormatter INPUT_DATE = DateTimeFormatter.ofPattern("d/M/yyyy");
    private static final DateTimeFormatter SQL_DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) throws IOException {
        Path pdfDir = Paths.get("C:/Users/Bruno/Downloads/pdfs");
        Path sqlOut = Paths.get("C:/Users/Bruno/Downloads/import.sql");
        try (BufferedWriter writer = Files.newBufferedWriter(sqlOut)) {
            writeHeader(writer);
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(pdfDir, "*.pdf")) {
                int defaultYear = Calendar.getInstance().get(Calendar.YEAR);
                for (Path pdfPath : stream) {
                    processPdf(pdfPath, defaultYear, writer);
                }
            }
            System.out.println("Arquivo SQL gerado em: " + sqlOut);
        }
    }

    private static void writeHeader(BufferedWriter w) throws IOException {
        w.write("-- RESET E CRIAÇÃO DA TABELA payments\n");
        w.write("DROP TABLE IF EXISTS payments;\n");
        w.write("CREATE TABLE payments (\n");
        w.write("  id INT AUTO_INCREMENT PRIMARY KEY,\n");
        w.write("  description VARCHAR(255) NOT NULL,\n");
        w.write("  amount DECIMAL(10,2) NOT NULL,\n");
        w.write("  date DATE NOT NULL,\n");
        w.write("  type VARCHAR(50) NOT NULL,\n");
        w.write("  installments_count INT NULL,\n");
        w.write("  installment_index INT NULL,\n");
        w.write("  category VARCHAR(50) NULL,\n");
        w.write("  purchase_date DATE NULL\n");
        w.write(") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n\n");
    }

    private static void processPdf(Path pdfPath, int defaultYear, BufferedWriter writer) throws IOException {
        try (PDDocument doc = PDDocument.load(pdfPath.toFile())) {
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setSortByPosition(true);
            String text = stripper.getText(doc);
            for (String line : text.split("\\r?\\n")) {
                Matcher m = LINE_PATTERN.matcher(line.trim());
                if (!m.find()) continue;
                String datePart = m.group(1);
                String descRaw = m.group(2).trim();
                String desc = descRaw.replace("'", "\\'");
                String rawVal = m.group(3);
                boolean neg = rawVal.startsWith("-");
                rawVal = rawVal.replace("-", "");
                String amount = rawVal.replace(".", "").replace(",", ".");
                if (neg) amount = "-" + amount;
                // Data
                String fullDate = datePart.contains("/") && datePart.chars().filter(ch->ch=='/').count()==2
                        ? datePart
                        : datePart + "/" + defaultYear;
                LocalDate purchaseDate = LocalDate.parse(fullDate, INPUT_DATE);
                // Tipo e parcelas
                String rawType = extractRawType(descRaw);
                String type = TYPE_MAP.getOrDefault(rawType, "static");
                int installments = 1;
                Matcher mi = INST_PATTERN.matcher(descRaw);
                if ("installment".equals(type) && mi.find()) {
                    installments = Integer.parseInt(mi.group(1));
                    desc = desc.replaceFirst("\\b" + mi.group(1) + "x\\b", "").trim();
                }
                // Categoria conforme padrão SQL
                String category = detectCategory(descRaw, type);
                // Gera INSERTs
                for (int i=0; i<installments; i++) {
                    LocalDate fatura = getShiftedFatura(purchaseDate, i);
                    String dateSql = fatura.format(SQL_DATE);
                    String purchaseSql = purchaseDate.format(SQL_DATE);
                    writer.write(String.format(
                            "INSERT INTO payments (description, amount, date, type, installments_count, installment_index, category, purchase_date) " +
                                    "VALUES ('%s', %s, '%s', '%s', %d, %d, '%s', '%s');\n",
                            desc, amount, dateSql, type, installments, i+1, category, purchaseSql
                    ));
                }
            }
        }
    }

    private static String detectCategory(String descRaw, String type) {
        String up = descRaw.toUpperCase();
        if (up.startsWith("PIX")) return "pix";
        if ("annual".equals(type)) return "anual";
        if (up.contains("PAGUE MENOS") || up.contains("FARMACIA") || up.contains("FARMÁCIA")) return "farmacia";
        if (up.contains("AMAZON PRIME") || up.contains("NITRO")) return "mensalidade";
        if (up.contains("MERCADO") || up.contains("IFOOD") || up.contains("MUCURIPE") || up.contains("COMIDA")) return "comida";
        if (up.contains("ROUTE") || up.contains("LAZER") || up.contains("CINEMA") || up.contains("PICO") ) return "lazer";
        if ("installment".equals(type)) return "compras";
        // fallback
        return "outros";
    }

    private static LocalDate getShiftedFatura(LocalDate purchaseDate, int parcelIndex) {
        int shiftBase = purchaseDate.getDayOfMonth() >= SHIFT_THRESHOLD ? 2 : 1;
        return purchaseDate.withDayOfMonth(1).plusMonths(shiftBase + parcelIndex);
    }

    private static String extractRawType(String desc) {
        String up = desc.toUpperCase();
        if (up.startsWith("PIX")) return "PIX";
        if (up.startsWith("PARCELADA")) return "PARCELADA";
        if (up.startsWith("MENSAL")) return "MENSAL";
        if (up.startsWith("ANUAL")) return "ANUAL";
        return "COMPRA";
    }
}