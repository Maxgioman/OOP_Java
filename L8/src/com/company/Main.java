package com.company;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class Main {
    private static JFrame frmBureau;
    private JTextField SextextField;
    private JTextField NumbertextField;
    private JTextField DatetextField;
    private JTextField NametextField;
    private JTextField HeighttextField;
    private JTextField EyecolortextField;
    private JTextField DateofbirthtextField;
    private JTextField HobbytextField;
    private JTextField RequirementtextField;
    private ArrayList<Bureau> data = new ArrayList<>();
    //Bureau bureau = new Bureau();
    private Functional functional = new Functional();
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run() {
                try {
                    Main window = new Main();
                    window.frmBureau.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }});
    }

    private Main(){
        frmBureau = new JFrame();
        frmBureau.getContentPane().setBackground(Color.CYAN);
        frmBureau.setTitle("BUREAU");
        frmBureau.setBounds(100, 100, 600, 400);
        frmBureau.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmBureau.getContentPane().setLayout(null);

        JButton ShowButton = new JButton("Show all profiles");
        ShowButton.setBounds(315, 11, 250, 25);
        frmBureau.getContentPane().add(ShowButton);

        JButton AddButton = new JButton("Add profile");
        AddButton.setBounds(315, 45, 250, 25);
        frmBureau.getContentPane().add(AddButton);

        JButton RemoveButton = new JButton("Remove profile");
        RemoveButton.setBounds(315, 79, 250, 25);
        frmBureau.getContentPane().add(RemoveButton);

        JButton SortButton = new JButton("Sort profiles by ID");
        SortButton.setBounds(315, 113, 250, 25);
        frmBureau.getContentPane().add(SortButton);

        JButton SaveToXMLButton = new JButton("Save to XML");
        SaveToXMLButton.setBounds(315, 147, 120, 25);
        frmBureau.getContentPane().add(SaveToXMLButton);

        JButton SaveToTXTButton = new JButton("Save to TXT");
        SaveToTXTButton.setBounds(445, 147, 120, 25);
        frmBureau.getContentPane().add(SaveToTXTButton);

        JButton LoadFromXMLButton = new JButton("Load from XML");
        LoadFromXMLButton.setBounds(315, 181, 120, 25);
        frmBureau.getContentPane().add(LoadFromXMLButton);

        JButton LoadFromTXTButton =  new JButton("Load from TXT");
        LoadFromTXTButton.setBounds(445, 181, 120, 25);
        frmBureau.getContentPane().add(LoadFromTXTButton);

        JLabel SexLabel = new JLabel("Gender: ");
        SexLabel.setVisible(false);
        SexLabel.setBounds(10, 15, 80, 20);
        frmBureau.getContentPane().add(SexLabel);

        SextextField = new JTextField();
        SextextField.setVisible(false);
        SextextField.setBounds(91, 15, 162, 20);
        frmBureau.getContentPane().add(SextextField);
        SextextField.setColumns(10);

        JLabel NumberLabel = new JLabel("ID:");
        NumberLabel.setVisible(false);
        NumberLabel.setBounds(10, 45, 80, 20);
        frmBureau.getContentPane().add(NumberLabel);

        NumbertextField = new JTextField();
        NumbertextField.setVisible(false);
        NumbertextField.setBounds(91, 45, 162, 20);
        frmBureau.getContentPane().add(NumbertextField);
        NumbertextField.setColumns(10);

        JLabel DateLabel = new JLabel("Date(reg):");
        DateLabel.setVisible(false);
        DateLabel.setBounds(10, 75, 80, 20);
        frmBureau.getContentPane().add(DateLabel);

        DatetextField = new JTextField();
        DatetextField.setVisible(false);
        DatetextField.setBounds(91, 75, 162, 20);
        frmBureau.getContentPane().add(DatetextField);
        DatetextField.setColumns(10);

        /*DatePicker datePicker = new DatePicker();
        datePicker.setValue(LocalDate.of(2016, 7, 25));
        datePicker.setShowWeekNumbers(true);*/

        JLabel NameLabel = new JLabel("Name:");
        NameLabel.setVisible(false);
        NameLabel.setBounds(10, 105, 80, 20);
        frmBureau.getContentPane().add(NameLabel);

        NametextField = new JTextField();
        NametextField.setVisible(false);
        NametextField.setBounds(91,105,162,20);
        frmBureau.getContentPane().add(NametextField);
        DatetextField.setColumns(10);

        JLabel HeightLabel = new JLabel("Height:");
        HeightLabel.setVisible(false);
        HeightLabel.setBounds(10, 135, 80, 20);
        frmBureau.getContentPane().add(HeightLabel);

        HeighttextField = new JTextField();
        HeighttextField.setVisible(false);
        HeighttextField.setBounds(91,135,162,20);
        frmBureau.getContentPane().add(HeighttextField);
        HeighttextField.setColumns(10);

        JLabel EyeColorLabel = new JLabel("Eye color:");
        EyeColorLabel.setVisible(false);
        EyeColorLabel.setBounds(10, 165, 80, 20);
        frmBureau.getContentPane().add(EyeColorLabel);

        EyecolortextField = new JTextField();
        EyecolortextField.setVisible(false);
        EyecolortextField.setBounds(91, 165, 162, 20);
        frmBureau.getContentPane().add(EyecolortextField);
        EyecolortextField.setColumns(10);

        JLabel DateofbirthLabel = new JLabel("Date(birth):");
        DateofbirthLabel.setVisible(false);
        DateofbirthLabel.setBounds(10, 195, 80, 20);
        frmBureau.getContentPane().add(DateofbirthLabel);

        DateofbirthtextField = new JTextField();
        DateofbirthtextField.setVisible(false);
        DateofbirthtextField.setBounds(91, 195, 162, 20);
        frmBureau.getContentPane().add(DateofbirthtextField);
        DateofbirthtextField.setColumns(10);

        JLabel HobbyLabel = new JLabel("Hobby:");
        HobbyLabel.setVisible(false);
        HobbyLabel.setBounds(10, 225, 80, 20);
        frmBureau.getContentPane().add(HobbyLabel);

        HobbytextField = new JTextField();
        HobbytextField.setVisible(false);
        HobbytextField.setBounds(91, 225, 162, 20);
        frmBureau.getContentPane().add(HobbytextField);
        HobbytextField.setColumns(10);

        JLabel RequirementLabel = new JLabel("Demands:");
        RequirementLabel.setVisible(false);
        RequirementLabel.setBounds(10, 255, 80, 20);
        frmBureau.getContentPane().add(RequirementLabel);

        RequirementtextField = new JTextField();
        RequirementtextField.setVisible(false);
        RequirementtextField.setBounds(91, 255, 162, 20);
        frmBureau.getContentPane().add(RequirementtextField);
        RequirementtextField.setColumns(10);

        JTextField FiletextFieldXML = new JTextField();
        FiletextFieldXML.setVisible(false);
        FiletextFieldXML.setBounds(65, 200, 150, 20);
        frmBureau.getContentPane().add(FiletextFieldXML);
        FiletextFieldXML.setColumns(10);

        JTextField FiletextFieldTXT = new JTextField();
        FiletextFieldTXT.setVisible(false);
        FiletextFieldTXT.setBounds(65, 200, 150, 20);
        frmBureau.getContentPane().add(FiletextFieldTXT);
        FiletextFieldTXT.setColumns(10);

        JButton AddNewButton = new JButton("Add");
        AddNewButton.setVisible(false);
        AddNewButton.setBounds(10, 285, 121, 23);
        frmBureau.getContentPane().add(AddNewButton);

        JButton BackButton = new JButton("Back");
        BackButton.setVisible(false);
        BackButton.setBounds(132, 285, 121, 23);
        frmBureau.getContentPane().add(BackButton);

        JLabel EnterTheNumberOfProfileLabel = new JLabel("Enter the number of profile");
        EnterTheNumberOfProfileLabel.setVisible(false);
        EnterTheNumberOfProfileLabel.setBounds(53, 50, 200, 20);
        frmBureau.getContentPane().add(EnterTheNumberOfProfileLabel);

        JLabel YouWantToRemoveLabel = new JLabel("you want to remove:");
        YouWantToRemoveLabel.setVisible(false);
        YouWantToRemoveLabel.setBounds(79, 70, 121, 20);
        frmBureau.getContentPane().add(YouWantToRemoveLabel);

        JButton RemoveNewButton = new JButton("Remove");
        RemoveNewButton.setVisible(false);
        RemoveNewButton.setBounds(10, 181, 121, 23);
        frmBureau.getContentPane().add(RemoveNewButton);

        JLabel ToSaveLabel = new JLabel("you want to save:");
        ToSaveLabel.setVisible(false);
        ToSaveLabel.setBounds(79, 67, 121, 20);
        frmBureau.getContentPane().add(ToSaveLabel);

        JLabel EnterTheNameOfFileLabel1 = new JLabel("Enter the name of file");
        EnterTheNameOfFileLabel1.setVisible(false);
        EnterTheNameOfFileLabel1.setBounds(65, 150, 150, 20);
        frmBureau.getContentPane().add(EnterTheNameOfFileLabel1);

        JLabel YouWantToSaveToLabel1 = new JLabel("you want to save to:");
        YouWantToSaveToLabel1.setVisible(false);
        YouWantToSaveToLabel1.setBounds(65, 175, 150, 20);
        frmBureau.getContentPane().add(YouWantToSaveToLabel1);

        JButton SaveNewToXMLButton = new JButton("Save");
        SaveNewToXMLButton.setVisible(false);
        SaveNewToXMLButton.setBounds(10, 285, 121, 23);
        frmBureau.getContentPane().add(SaveNewToXMLButton);

        JLabel EnterTheNameOfFileLabel2 = new JLabel("Enter the name the file");
        EnterTheNameOfFileLabel2.setVisible(false);
        EnterTheNameOfFileLabel2.setBounds(66, 50, 150, 20);
        frmBureau.getContentPane().add(EnterTheNameOfFileLabel2);

        JLabel YouWantToLoadFromLabel = new JLabel("you want to load from:");
        YouWantToLoadFromLabel.setVisible(false);
        YouWantToLoadFromLabel.setBounds(79, 70, 150, 20);
        frmBureau.getContentPane().add(YouWantToLoadFromLabel);

        JButton LoadButton = new JButton("Load");
        LoadButton.setVisible(false);
        LoadButton.setBounds(10, 181, 121, 23);
        frmBureau.getContentPane().add(LoadButton);

        JSpinner spinner1 = new JSpinner();
        spinner1.setVisible(false);
        spinner1.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
        spinner1.setBounds(91, 113, 84, 20);
        frmBureau.getContentPane().add(spinner1);

        JButton ClearButton = new JButton("Clear");
        ClearButton.setVisible(true);
        ClearButton.setBounds(140, 181, 120, 23);
        frmBureau.getContentPane().add(ClearButton);

        JSpinner spinner2 = new JSpinner();
        spinner2.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
        spinner2.setVisible(false);
        spinner2.setBounds(91, 90, 84, 20);
        frmBureau.getContentPane().add(spinner2);

        JButton LoadNewFromTXTButton = new JButton("Load");
        LoadNewFromTXTButton.setVisible(false);
        LoadNewFromTXTButton.setBounds(10, 285, 121, 23);
        frmBureau.getContentPane().add(LoadNewFromTXTButton);

        JButton LoadNewFromXMLButton = new JButton("Load");
        LoadNewFromTXTButton.setVisible(false);
        LoadNewFromTXTButton.setBounds(10, 285, 121, 23);
        frmBureau.getContentPane().add(LoadNewFromTXTButton);

        JButton SaveNewToTXTButton = new JButton("Save");
        SaveNewToTXTButton.setVisible(false);
        SaveNewToTXTButton.setBounds(10, 285, 121, 23);
        frmBureau.getContentPane().add(SaveNewToTXTButton);

        JScrollPane ViewPanel = new JScrollPane();
        ViewPanel.setBounds(10, 11, 250, 159);
        frmBureau.getContentPane().add(ViewPanel);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        ViewPanel.setViewportView(textArea);

        AddButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SexLabel.setVisible(true);SextextField.setVisible(true);
                NumberLabel.setVisible(true);NumbertextField.setVisible(true);
                DateLabel.setVisible(true);DatetextField.setVisible(true);
                NameLabel.setVisible(true);NametextField.setVisible(true);
                HeightLabel.setVisible(true);HeighttextField.setVisible(true);
                EyeColorLabel.setVisible(true);EyecolortextField.setVisible(true);
                DateofbirthLabel.setVisible(true);DateofbirthtextField.setVisible(true);
                HobbyLabel.setVisible(true);HobbytextField.setVisible(true);
                RequirementLabel.setVisible(true);RequirementtextField.setVisible(true);
                SaveNewToXMLButton.setVisible(false);
                SaveNewToTXTButton.setVisible(false);
                ClearButton.setVisible(false);
                ViewPanel.setVisible(false);
                textArea.setVisible(false);
                ShowButton.setVisible(false);
                AddButton.setVisible(false);
                RemoveButton.setVisible(false);
                SortButton.setVisible(false);
                SaveToXMLButton.setVisible(false);
                SaveToTXTButton.setVisible(false);
                LoadFromXMLButton.setVisible(false);
                LoadFromTXTButton.setVisible(false);
                AddNewButton.setVisible(true);
                BackButton.setVisible(true);
                NameLabel.setVisible(true);
                NumberLabel.setVisible(true);
                DateLabel.setVisible(true);
                NameLabel.setVisible(true);
                EyeColorLabel.setVisible(true);
                FiletextFieldXML.setVisible(false);
                FiletextFieldTXT.setVisible(false);
                SextextField.setText("");
                NumbertextField.setText("");
                DatetextField.setText("");
                NametextField.setText("");
                HeighttextField.setText("");
                EyecolortextField.setText("");
                DateofbirthtextField.setText("");
                HobbytextField.setText("");
            }
        });
        SortButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                functional.sort(data);
            }
        });
        ClearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });
        BackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SexLabel.setVisible(false);SextextField.setVisible(false);
                NumberLabel.setVisible(false);NumbertextField.setVisible(false);
                DateLabel.setVisible(false);DatetextField.setVisible(false);
                NameLabel.setVisible(false);NametextField.setVisible(false);
                HeightLabel.setVisible(false);HeighttextField.setVisible(false);
                EyeColorLabel.setVisible(false);EyecolortextField.setVisible(false);
                DateofbirthLabel.setVisible(false);DateofbirthtextField.setVisible(false);
                HobbyLabel.setVisible(false);HobbytextField.setVisible(false);
                RequirementLabel.setVisible(false);RequirementtextField.setVisible(false);
                SaveNewToTXTButton.setVisible(false);
                SaveNewToXMLButton.setVisible(false);
                ClearButton.setVisible(true);
                ViewPanel.setVisible(true);
                textArea.setVisible(true);
                ShowButton.setVisible(true);
                AddButton.setVisible(true);
                RemoveButton.setVisible(true);
                SortButton.setVisible(true);
                SaveToXMLButton.setVisible(true);
                SaveToTXTButton.setVisible(true);
                LoadFromXMLButton.setVisible(true);
                LoadFromTXTButton.setVisible(true);
                AddNewButton.setVisible(false);
                BackButton.setVisible(false);
                YouWantToRemoveLabel.setVisible(false);
                EnterTheNameOfFileLabel2.setVisible(false);
                spinner1.setVisible(false);
                RemoveNewButton.setVisible(false);
                EnterTheNumberOfProfileLabel.setVisible(false);
                ToSaveLabel.setVisible(false);
                EnterTheNameOfFileLabel1.setVisible(false);
                YouWantToSaveToLabel1.setVisible(false);
                spinner2.setVisible(false);
                BackButton.setVisible(false);
                SaveNewToTXTButton.setVisible(false);
                YouWantToLoadFromLabel.setVisible(false);
                BackButton.setVisible(false);
                LoadNewFromTXTButton.setVisible(false);
                LoadNewFromTXTButton.setVisible(false);
                SaveNewToTXTButton.setVisible(false);
                FiletextFieldXML.setVisible(false);
                FiletextFieldTXT.setVisible(false);
            }
        });
        AddNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (SextextField.getText().matches("(Male)|(Female)"))
                    if (NumbertextField.getText().matches("[0-9]{1,}"))
                        if (DatetextField.getText().matches("([0][1-9]|[1-2][0-9]|[3][0-1])+\\.+((01)|(02)|(03)|(04)|(05)|(06)|(07)|(08)|(09)|(10)|(11)|(12))+\\.+[1-2][0-9]{3}"))
                            if (NametextField.getText().matches("[A-Z]{1}[a-z]{1,}"))
                                if (HeighttextField.getText().matches("[0-2]{1}[0-9]{2}"))
                                    if (EyecolortextField.getText().matches("(blue)|(green)|(grey)|(brown)|(red)|(mixed)|(tired)"))
                                        if (DateofbirthtextField.getText().matches("([0][1-9]|[1-2][0-9]|[3][0-1])+\\.+((01)|(02)|(03)|(04)|(05)|(06)|(07)|(08)|(09)|(10)|(11)|(12))+\\.+[1-2][0-9]{3}"))
                                        {
                                        String name = NametextField.getText();
                                        String height = HeighttextField.getText();
                                        String eyecolor = EyecolortextField.getText();
                                        String dateofbirth = DateofbirthtextField.getText();
                                        String hobby = HobbytextField.getText();
                                        Info info = new Info (name,height,eyecolor,dateofbirth,hobby);
                                        String sex = SextextField.getText();
                                        String date = DatetextField.getText();
                                        String number = NumbertextField.getText();
                                        String requirement = RequirementtextField.getText();
                                        data.add(new Bureau(sex,number,date,info,requirement));
                                            SexLabel.setVisible(false);SextextField.setVisible(false);
                                            NumberLabel.setVisible(false);NumbertextField.setVisible(false);
                                            DateLabel.setVisible(false);DatetextField.setVisible(false);
                                            NameLabel.setVisible(false);NametextField.setVisible(false);
                                            HeightLabel.setVisible(false);HeighttextField.setVisible(false);
                                            EyeColorLabel.setVisible(false);EyecolortextField.setVisible(false);
                                            DateofbirthLabel.setVisible(false);DateofbirthtextField.setVisible(false);
                                            HobbyLabel.setVisible(false);HobbytextField.setVisible(false);
                                            RequirementLabel.setVisible(false);RequirementtextField.setVisible(false);
                                            ClearButton.setVisible(true);
                                            ViewPanel.setVisible(true);
                                            textArea.setVisible(true);
                                            ShowButton.setVisible(true);
                                            AddButton.setVisible(true);
                                            RemoveButton.setVisible(true);
                                            SortButton.setVisible(true);
                                            SaveToXMLButton.setVisible(true);
                                            SaveToTXTButton.setVisible(true);
                                            LoadFromXMLButton.setVisible(true);
                                            LoadFromTXTButton.setVisible(true);
                                            AddNewButton.setVisible(false);
                                            BackButton.setVisible(false);
                                            YouWantToRemoveLabel.setVisible(false);
                                            EnterTheNameOfFileLabel2.setVisible(false);
                                            spinner1.setVisible(false);
                                            RemoveNewButton.setVisible(false);
                                            EnterTheNumberOfProfileLabel.setVisible(false);
                                            ToSaveLabel.setVisible(false);
                                            EnterTheNameOfFileLabel1.setVisible(false);
                                            YouWantToSaveToLabel1.setVisible(false);
                                            spinner2.setVisible(false);
                                            BackButton.setVisible(false);
                                            SaveNewToTXTButton.setVisible(false);
                                            YouWantToLoadFromLabel.setVisible(false);
                                            BackButton.setVisible(false);
                                            LoadNewFromTXTButton.setVisible(false);
                                            LoadNewFromTXTButton.setVisible(false);
                                            SaveNewToTXTButton.setVisible(false);
                                        }
                if (!SextextField.getText().matches("(Male)|(Female)"))
                    SextextField.setText("Wrong format!");
                if (!NumbertextField.getText().matches("[0-9]{1,}"))
                    NumbertextField.setText("Wrong format!");
                if (!DatetextField.getText().matches("([0][1-9]|[1-2][0-9]|[3][0-1])+\\.+((01)|(02)|(03)|(04)|(05)|(06)|(07)|(08)|(09)|(10)|(11)|(12))+\\.+[1-2][0-9]{3}"))
                    DatetextField.setText("Wrong format!");
                if (!NametextField.getText().matches("[A-Z]{1}[a-z]{1,}"))
                    NametextField.setText("Wrong format!");
                if (!HeighttextField.getText().matches("[0-2]{1}[0-9]{2}"))
                    HeighttextField.setText("Wrong format!");
                if (!EyecolortextField.getText().matches("(blue)|(green)|(grey)|(brown)|(red)|(mixed)|(tired)"))
                    EyecolortextField.setText("Wrong format!");
                if (!DateofbirthtextField.getText().matches("([0][1-9]|[1-2][0-9]|[3][0-1])+\\.+((01)|(02)|(03)|(04)|(05)|(06)|(07)|(08)|(09)|(10)|(11)|(12))+\\.+[1-2][0-9]{3}"))
                    DateofbirthtextField.setText("Wrong format!");
            }
        });
        RemoveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewPanel.setVisible(false);
                ShowButton.setVisible(false);
                AddButton.setVisible(false);
                RemoveButton.setVisible(false);
                SortButton.setVisible(false);
                SaveToXMLButton.setVisible(false);
                SaveToTXTButton.setVisible(false);
                LoadFromXMLButton.setVisible(false);
                LoadFromTXTButton.setVisible(false);
                EnterTheNumberOfProfileLabel.setVisible(true);
                YouWantToRemoveLabel.setVisible(true);
                BackButton.setVisible(true);
                AddNewButton.setVisible(false);
                spinner1.setVisible(true);
                RemoveNewButton.setVisible(true);
                functional.getNumbers(textArea,data);
            }
        });
        RemoveNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewPanel.setVisible(true);
                ShowButton.setVisible(true);
                AddButton.setVisible(true);
                RemoveButton.setVisible(true);
                SortButton.setVisible(true);
                SaveToXMLButton.setVisible(true);
                SaveToTXTButton.setVisible(true);
                LoadFromXMLButton.setVisible(true);
                LoadFromTXTButton.setVisible(true);
                EnterTheNumberOfProfileLabel.setVisible(false);
                YouWantToRemoveLabel.setVisible(false);
                BackButton.setVisible(false);
                AddNewButton.setVisible(true);
                spinner1.setVisible(false);
                RemoveNewButton.setVisible(false);
                int i = (int) spinner1.getValue();
                int index = i-1;
                functional.remove(index,data);
                spinner1.setValue(1);
            }
        });
        SaveToXMLButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewPanel.setVisible(false);
                textArea.setVisible(false);
                ClearButton.setVisible(false);
                ShowButton.setVisible(false);
                AddButton.setVisible(false);
                RemoveButton.setVisible(false);
                SortButton.setVisible(false);
                SaveToXMLButton.setVisible(false);
                SaveToTXTButton.setVisible(false);
                LoadFromXMLButton.setVisible(false);
                LoadFromTXTButton.setVisible(false);
                EnterTheNumberOfProfileLabel.setVisible(true);
                ToSaveLabel.setVisible(true);
                EnterTheNameOfFileLabel1.setVisible(true);
                YouWantToSaveToLabel1.setVisible(true);
                spinner2.setVisible(true);
                BackButton.setVisible(true);
                SaveNewToXMLButton.setVisible(true);
                FiletextFieldXML.setVisible(true);
                FiletextFieldXML.setText(".xml");
                functional.getNumbers(textArea,data);
            }
        });
        SaveToTXTButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewPanel.setVisible(false);
                textArea.setVisible(false);
                ClearButton.setVisible(false);
                ShowButton.setVisible(false);
                AddButton.setVisible(false);
                RemoveButton.setVisible(false);
                SortButton.setVisible(false);
                SaveToXMLButton.setVisible(false);
                SaveToTXTButton.setVisible(false);
                LoadFromXMLButton.setVisible(false);
                LoadFromTXTButton.setVisible(false);
                EnterTheNumberOfProfileLabel.setVisible(true);
                ToSaveLabel.setVisible(true);
                EnterTheNameOfFileLabel1.setVisible(true);
                YouWantToSaveToLabel1.setVisible(true);
                spinner2.setVisible(true);
                BackButton.setVisible(true);
                SaveNewToTXTButton.setVisible(true);
                functional.getNumbers(textArea,data);
                FiletextFieldTXT.setVisible(true);
                FiletextFieldTXT.setText(".txt");
            }
        });
        SaveNewToXMLButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewPanel.setVisible(true);
                textArea.setVisible(true);
                ClearButton.setVisible(true);
                ShowButton.setVisible(true);
                AddButton.setVisible(true);
                RemoveButton.setVisible(true);
                SortButton.setVisible(true);
                SaveToXMLButton.setVisible(true);
                SaveToTXTButton.setVisible(true);
                LoadFromXMLButton.setVisible(true);
                LoadFromTXTButton.setVisible(true);
                EnterTheNumberOfProfileLabel.setVisible(false);
                ToSaveLabel.setVisible(false);
                EnterTheNameOfFileLabel1.setVisible(false);
                YouWantToSaveToLabel1.setVisible(false);
                spinner2.setVisible(false);
                FiletextFieldXML.setVisible(false);
                FiletextFieldTXT.setVisible(false);
                BackButton.setVisible(false);
                SaveNewToTXTButton.setVisible(false);
                int i = (int) spinner2.getValue();
                int index = i-1;
                String filename = FiletextFieldXML.getText();
                functional.WriteXML(filename, index, textArea,data);
                FiletextFieldXML.setText("");
                spinner2.setValue(1);
                SaveNewToXMLButton.setVisible(false);
            }
        });
        SaveNewToTXTButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewPanel.setVisible(true);
                textArea.setVisible(true);
                ClearButton.setVisible(true);
                ShowButton.setVisible(true);
                AddButton.setVisible(true);
                RemoveButton.setVisible(true);
                SortButton.setVisible(true);
                SaveToXMLButton.setVisible(true);
                SaveToTXTButton.setVisible(true);
                LoadFromXMLButton.setVisible(true);
                LoadFromTXTButton.setVisible(true);
                EnterTheNumberOfProfileLabel.setVisible(false);
                ToSaveLabel.setVisible(false);
                EnterTheNameOfFileLabel1.setVisible(false);
                YouWantToSaveToLabel1.setVisible(false);
                spinner2.setVisible(false);
                FiletextFieldTXT.setVisible(false);
                FiletextFieldXML.setVisible(false);
                BackButton.setVisible(false);
                SaveNewToTXTButton.setVisible(false);
                SaveNewToXMLButton.setVisible(false);
                int i = (int) spinner2.getValue();
                int index = i-1;
                String filename = FiletextFieldTXT.getText();
                functional.Write(filename, index, textArea,data);
                FiletextFieldTXT.setText("");
                spinner2.setValue(1);
            }
        });
        LoadFromXMLButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewPanel.setVisible(false);
                textArea.setVisible(false);
                ClearButton.setVisible(false);
                EnterTheNameOfFileLabel2.setVisible(true);
                YouWantToLoadFromLabel.setVisible(true);
                ShowButton.setVisible(false);
                AddButton.setVisible(false);
                RemoveButton.setVisible(false);
                SortButton.setVisible(false);
                SaveToXMLButton.setVisible(false);
                SaveToTXTButton.setVisible(false);
                LoadFromXMLButton.setVisible(false);
                LoadFromTXTButton.setVisible(false);
                FiletextFieldXML.setVisible(true);
                BackButton.setVisible(true);
                LoadNewFromTXTButton.setVisible(true);
                FiletextFieldXML.setText(".xml");
                AddNewButton.setVisible(false);
            }
        });
        LoadNewFromXMLButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewPanel.setVisible(true);
                textArea.setVisible(true);
                ClearButton.setVisible(true);
                ShowButton.setVisible(true);
                AddButton.setVisible(true);
                RemoveButton.setVisible(true);
                SortButton.setVisible(true);
                SaveToXMLButton.setVisible(true);
                SaveToTXTButton.setVisible(true);
                LoadFromXMLButton.setVisible(true);
                LoadFromTXTButton.setVisible(true);
                FiletextFieldXML.setVisible(false);
                FiletextFieldTXT.setVisible(false);
                BackButton.setVisible(false);
                LoadNewFromTXTButton.setVisible(false);
                EnterTheNameOfFileLabel2.setVisible(false);
                YouWantToLoadFromLabel.setVisible(false);
                String fileName = FiletextFieldXML.getText();
                functional.ReadXML(fileName, textArea);
                //FiletextFieldXML.setText("");
            }
        });
        LoadFromTXTButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewPanel.setVisible(false);
                textArea.setVisible(false);
                ClearButton.setVisible(false);
                EnterTheNameOfFileLabel2.setVisible(true);
                YouWantToLoadFromLabel.setVisible(true);
                ShowButton.setVisible(false);
                AddButton.setVisible(false);
                RemoveButton.setVisible(false);
                SortButton.setVisible(false);
                SaveToXMLButton.setVisible(false);
                SaveToTXTButton.setVisible(false);
                LoadFromXMLButton.setVisible(false);
                LoadFromTXTButton.setVisible(false);
                FiletextFieldTXT.setVisible(true);
                BackButton.setVisible(true);
                LoadNewFromTXTButton.setVisible(true);
                FiletextFieldTXT.setText(".txt");
                AddNewButton.setVisible(false);
            }
        });

        LoadNewFromTXTButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewPanel.setVisible(true);
                textArea.setVisible(true);
                ClearButton.setVisible(true);
                ShowButton.setVisible(true);
                AddButton.setVisible(true);
                RemoveButton.setVisible(true);
                SortButton.setVisible(true);
                SaveToXMLButton.setVisible(true);
                SaveToTXTButton.setVisible(true);
                LoadFromXMLButton.setVisible(true);
                LoadFromTXTButton.setVisible(true);
                FiletextFieldTXT.setVisible(false);
                FiletextFieldXML.setVisible(false);
                BackButton.setVisible(false);
                LoadNewFromTXTButton.setVisible(false);
                EnterTheNameOfFileLabel2.setVisible(false);
                YouWantToLoadFromLabel.setVisible(false);
                String filename = FiletextFieldTXT.getText();
                functional.Read(filename, textArea);
                //FiletextFieldTXT.setText("");
            }
        });
        ShowButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                functional.show(textArea,data);
            }
        });
    }
}

