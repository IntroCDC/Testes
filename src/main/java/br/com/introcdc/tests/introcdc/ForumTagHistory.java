package br.com.introcdc.tests.introcdc;
/*
 * Written by IntroCDC, Bruno Coelho at 08/01/2025 - 01:14
 */

import br.com.introcdc.tests.database.DatabaseUtils;
import br.com.introcdc.tests.database.query.OrderType;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;
import java.util.List;

public class ForumTagHistory {

    private static final int TOP = 60;
    private static final boolean PER_MEMBER = true;
    private static final Map<Integer, String> forumsName = new HashMap<>();
    private static final Map<String, Integer> tagUses = new HashMap<>();
    private static final List<Integer> topics = new ArrayList<>();
    private static final boolean IN_JAVA = true;

    private JFrame window;
    private JTable tagTable;
    private DefaultTableModel tableModel;
    private JTextArea statusArea;

    public static void main(String[] args) throws Exception {
        OldForumMethods.initializeForum();
        SwingUtilities.invokeLater(() -> {
            try {
                new ForumTagHistory().start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void start() throws Exception {
        setupUI();
        initializeForumData();
        processForumData();
        updateStatus("Processamento concluído.");
    }

    private void setupUI() {
        // Configuração da janela principal
        window = new JFrame("TOP " + TOP + " PESSOAS MAIS MENCIONADAS");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        window.setSize(800, 600);

        // Configuração da tabela
        String[] columnNames = {"Posição", "Tag", "Uso"};
        tableModel = new DefaultTableModel(columnNames, 0);
        tagTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(tagTable);

        // Área de status
        statusArea = new JTextArea();
        statusArea.setEditable(false);
        JScrollPane statusScrollPane = new JScrollPane(statusArea);

        // Adicionando componentes
        window.add(tableScrollPane, BorderLayout.CENTER);
        window.add(statusScrollPane, BorderLayout.SOUTH);

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    private void initializeForumData() throws Exception {
        updateStatus("Inicializando dados do fórum...");
        for (int year = 1999; year <= 2023; year++) {
            for (String month : new String[]{"janeiro", "fevereiro", "março", "abril", "maio", "junho",
                    "julho", "agosto", "setembro", "outubro", "novembro", "dezembro"}) {
                // Simula a consulta ao banco de dados
                ResultSet set = DatabaseUtils.selectFromTable("forums_forums")
                        .whereEquals("name_seo", month + year)
                        .executeQuery();

                if (set.next()) {
                    int id = set.getInt("id");
                    forumsName.put(id, month.toUpperCase() + "/" + year);
                }
            }
        }
    }

    private void processForumData() throws Exception {
        updateStatus("Processando dados dos fóruns...");
        List<String> tagHistory = new ArrayList<>();
        for (int forumId : forumsName.keySet()) {
            ResultSet set = DatabaseUtils.selectFromTable("core_tags")
                    .whereEquals("tag_meta_parent_id", forumId)
                    .orderBy(OrderType.ASC, "tag_meta_id")
                    .executeQuery();

            Map<String, Integer> localTagUses = new HashMap<>();
            while (set.next()) {
                String tag = set.getString("tag_text");
                if (!filterTag(tag)) continue;

                localTagUses.put(tag, localTagUses.getOrDefault(tag, 0) + 1);
                tagUses.put(tag, tagUses.getOrDefault(tag, 0) + 1);
            }

            updateTagTable(tagUses);
        }
    }

    private void updateTagTable(Map<String, Integer> tagData) {
        SwingUtilities.invokeLater(() -> {
            tableModel.setRowCount(0);
            tagData.entrySet()
                    .stream()
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .limit(TOP)
                    .forEach(entry -> tableModel.addRow(new Object[]{
                            tableModel.getRowCount() + 1,
                            entry.getKey(),
                            format(entry.getValue())
                    }));
        });
    }

    private void updateStatus(String status) {
        SwingUtilities.invokeLater(() -> statusArea.append(status + "\n"));
    }

    private static boolean filterTag(String tag) {
        // Exemplo de filtro de tags
        return tag != null && !tag.trim().isEmpty();
    }

    private static String format(int number) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#,###", symbols);
        return decimalFormat.format(number);
    }
}

