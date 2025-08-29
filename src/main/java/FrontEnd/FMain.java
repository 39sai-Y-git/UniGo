/*
 * Copyright (C) 2025 Saien Naidu
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package FrontEnd;

// IMPORTS
import Managers.DegManager;
import Managers.FacManager;
import Managers.ReqManager;
import Managers.UniManager;
import Objects.University;
import Objects.Degree;
import Objects.Requirement;
import Managers.SavedDegrees;
import Objects.Faculty;
import Objects.Filter;
import java.awt.Color;
import javax.swing.JTable;

/**
 *
 * @author Saien Naidu
 */
public class FMain extends javax.swing.JFrame {

    // FIELDS
    // Manager Objects
    private final UniManager um = new UniManager();
    private final FacManager fm = new FacManager();
    private final DegManager dm = new DegManager();
    private final ReqManager rm = new ReqManager();
    private final SavedDegrees sd = new SavedDegrees();

    // Other frames
    private final FFilter frm_filters = new FFilter();

    // So that a new String[] does not need to be made each time a table is made
    private final String[] columnName = new String[1];

    // Keep track of the Degree currently being displayed in the Degree Tab
    private Degree degreeTab;

    // PROPERTIES
    /**
     * Creates new form Main
     */
    public FMain() {
        initComponents();
        initUserMarksTab();
        initSavedDegreesTable();
        initUniversityTable();
        initFinderTable();
        initFiltersFrame();
    }

    // <editor-fold defaultstate="collapsed" desc="Initialization code">
    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnG_hl = new javax.swing.ButtonGroup();
        btnG_fal = new javax.swing.ButtonGroup();
        btnG_math = new javax.swing.ButtonGroup();
        tbdPn_main = new javax.swing.JTabbedPane();
        pnl_menu = new javax.swing.JPanel();
        pnl_menuProfile = new javax.swing.JPanel();
        btn_results = new javax.swing.JButton();
        btn_saved = new javax.swing.JButton();
        pnl_menuBrowse = new javax.swing.JPanel();
        btn_browse = new javax.swing.JButton();
        btn_finder = new javax.swing.JButton();
        pnl_results = new javax.swing.JPanel();
        btn_results_back = new javax.swing.JButton();
        lbl_resultsTitle = new javax.swing.JLabel();
        lbl_hl = new javax.swing.JLabel();
        lbl_fal = new javax.swing.JLabel();
        lbl_math = new javax.swing.JLabel();
        lbl_opt1 = new javax.swing.JLabel();
        lbl_opt2 = new javax.swing.JLabel();
        lbl_opt3 = new javax.swing.JLabel();
        lbl_lo = new javax.swing.JLabel();
        spn_hl = new javax.swing.JSpinner();
        spn_fal = new javax.swing.JSpinner();
        spn_math = new javax.swing.JSpinner();
        spn_opt1 = new javax.swing.JSpinner();
        spn_opt2 = new javax.swing.JSpinner();
        spn_opt3 = new javax.swing.JSpinner();
        spn_lo = new javax.swing.JSpinner();
        rBtn_hlEng = new javax.swing.JRadioButton();
        rBtn_hlOther = new javax.swing.JRadioButton();
        rBtn_falEng = new javax.swing.JRadioButton();
        rBtn_mathT = new javax.swing.JRadioButton();
        rBtn_mathL = new javax.swing.JRadioButton();
        rBtn_mathC = new javax.swing.JRadioButton();
        rBtn_falOther = new javax.swing.JRadioButton();
        cbx_opt1 = new javax.swing.JComboBox<>();
        cbx_opt2 = new javax.swing.JComboBox<>();
        cbx_opt3 = new javax.swing.JComboBox<>();
        btn_save = new javax.swing.JButton();
        lbl_saveIndicator = new javax.swing.JLabel();
        pnl_saved = new javax.swing.JPanel();
        lbl_saved = new javax.swing.JLabel();
        txF_saved_search = new javax.swing.JTextField();
        scP_saved = new javax.swing.JScrollPane();
        tbl_saved = new javax.swing.JTable();
        btn_saved_view = new javax.swing.JButton();
        btn_saved_remove = new javax.swing.JButton();
        btn_saved_back = new javax.swing.JButton();
        pnl_browse = new javax.swing.JPanel();
        lbl_browse = new javax.swing.JLabel();
        txF_browse_search = new javax.swing.JTextField();
        scP_browse = new javax.swing.JScrollPane();
        tbl_browse = new javax.swing.JTable();
        btn_browse_view = new javax.swing.JButton();
        btn_browse_back = new javax.swing.JButton();
        pnl_finder = new javax.swing.JPanel();
        btn_finder_back = new javax.swing.JButton();
        lbl_finder = new javax.swing.JLabel();
        txF_finder_search = new javax.swing.JTextField();
        btn_filter = new javax.swing.JButton();
        btn_finder_view = new javax.swing.JButton();
        scP_finder = new javax.swing.JScrollPane();
        tbl_finder = new javax.swing.JTable();
        tbdPn_dedicated = new javax.swing.JTabbedPane();
        pnl_help = new javax.swing.JPanel();
        lbl_help = new javax.swing.JLabel();
        btn_toBrowse = new javax.swing.JButton();
        btn_toSaved = new javax.swing.JButton();
        btn_toFinder = new javax.swing.JButton();
        lbl_contact = new javax.swing.JLabel();
        pnl_uni = new javax.swing.JPanel();
        lbl_uni = new javax.swing.JLabel();
        txA_uniDesc = new javax.swing.JTextArea();
        scP_uniFac = new javax.swing.JScrollPane();
        tbl_uniFac = new javax.swing.JTable();
        btn_facView = new javax.swing.JButton();
        lbl_students = new javax.swing.JLabel();
        lbl_accRate = new javax.swing.JLabel();
        txA_rank = new javax.swing.JLabel();
        txA_location = new javax.swing.JLabel();
        txA_estb = new javax.swing.JLabel();
        txA_students = new javax.swing.JLabel();
        txA_accRate = new javax.swing.JLabel();
        lbl_rank = new javax.swing.JLabel();
        lbl_location = new javax.swing.JLabel();
        lbl_estb = new javax.swing.JLabel();
        btn_uni_back = new javax.swing.JButton();
        pnl_fac = new javax.swing.JPanel();
        scP_facDeg = new javax.swing.JScrollPane();
        tbl_facDeg = new javax.swing.JTable();
        lbl_fac = new javax.swing.JLabel();
        txA_facDesc = new javax.swing.JTextArea();
        btn_degView = new javax.swing.JButton();
        btn_fac_back = new javax.swing.JButton();
        pnl_deg = new javax.swing.JPanel();
        lbl_deg = new javax.swing.JLabel();
        txA_degDesc = new javax.swing.JTextArea();
        txA_req = new javax.swing.JTextArea();
        btn_saveDeg = new javax.swing.JButton();
        btn_degree_back = new javax.swing.JButton();
        lbl_title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UniGo V1.0");
        setBackground(new java.awt.Color(179, 224, 255));
        setLocation(new java.awt.Point(370, 150));
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(853, 480));
        setName("main"); // NOI18N
        setPreferredSize(new java.awt.Dimension(853, 480));
        setSize(new java.awt.Dimension(853, 480));

        tbdPn_main.setBackground(new java.awt.Color(179, 224, 255));
        tbdPn_main.setForeground(new java.awt.Color(0, 0, 0));
        tbdPn_main.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tbdPn_main.setEnabled(false);

        pnl_menu.setBackground(new java.awt.Color(179, 224, 255));

        pnl_menuProfile.setBackground(new java.awt.Color(179, 224, 255));
        pnl_menuProfile.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Profile", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(86, 94, 255))); // NOI18N

        btn_results.setBackground(java.awt.SystemColor.menu);
        btn_results.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        btn_results.setForeground(new java.awt.Color(0, 0, 0));
        btn_results.setText("Your Results");
        btn_results.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        btn_results.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resultsActionPerformed(evt);
            }
        });

        btn_saved.setBackground(java.awt.SystemColor.menu);
        btn_saved.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        btn_saved.setForeground(new java.awt.Color(0, 0, 0));
        btn_saved.setText("Your Saved Degrees");
        btn_saved.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        btn_saved.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_savedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_menuProfileLayout = new javax.swing.GroupLayout(pnl_menuProfile);
        pnl_menuProfile.setLayout(pnl_menuProfileLayout);
        pnl_menuProfileLayout.setHorizontalGroup(
            pnl_menuProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menuProfileLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(btn_results, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(btn_saved, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        pnl_menuProfileLayout.setVerticalGroup(
            pnl_menuProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menuProfileLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(pnl_menuProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_results, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_saved, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pnl_menuBrowse.setBackground(new java.awt.Color(179, 224, 255));
        pnl_menuBrowse.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Browse", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(86, 94, 255))); // NOI18N

        btn_browse.setBackground(java.awt.SystemColor.menu);
        btn_browse.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        btn_browse.setForeground(new java.awt.Color(0, 0, 0));
        btn_browse.setText("Browse Universities");
        btn_browse.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        btn_browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_browseActionPerformed(evt);
            }
        });

        btn_finder.setBackground(java.awt.SystemColor.menu);
        btn_finder.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        btn_finder.setForeground(new java.awt.Color(0, 0, 0));
        btn_finder.setText("Degree Finder");
        btn_finder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        btn_finder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_finderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_menuBrowseLayout = new javax.swing.GroupLayout(pnl_menuBrowse);
        pnl_menuBrowse.setLayout(pnl_menuBrowseLayout);
        pnl_menuBrowseLayout.setHorizontalGroup(
            pnl_menuBrowseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menuBrowseLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(btn_browse, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_finder, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        pnl_menuBrowseLayout.setVerticalGroup(
            pnl_menuBrowseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menuBrowseLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(pnl_menuBrowseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_browse, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_finder, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_menuLayout = new javax.swing.GroupLayout(pnl_menu);
        pnl_menu.setLayout(pnl_menuLayout);
        pnl_menuLayout.setHorizontalGroup(
            pnl_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_menuProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_menuBrowse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_menuLayout.setVerticalGroup(
            pnl_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menuLayout.createSequentialGroup()
                .addComponent(pnl_menuProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_menuBrowse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbdPn_main.addTab("Main Menu", null, pnl_menu, "");
        pnl_menu.getAccessibleContext().setAccessibleName("menu");

        pnl_results.setBackground(new java.awt.Color(179, 224, 255));

        btn_results_back.setBackground(new java.awt.Color(179, 224, 255));
        btn_results_back.setForeground(new java.awt.Color(0, 0, 0));
        btn_results_back.setText("Back");
        btn_results_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_results_backActionPerformed(evt);
            }
        });

        lbl_resultsTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_resultsTitle.setForeground(new java.awt.Color(86, 94, 255));
        lbl_resultsTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_resultsTitle.setText("Your Results");

        lbl_hl.setForeground(new java.awt.Color(0, 0, 0));
        lbl_hl.setText("Home Language:");

        lbl_fal.setForeground(new java.awt.Color(0, 0, 0));
        lbl_fal.setText("1st Additional Language:");

        lbl_math.setForeground(new java.awt.Color(0, 0, 0));
        lbl_math.setText("Mathematics:");

        lbl_opt1.setForeground(new java.awt.Color(0, 0, 0));
        lbl_opt1.setText("1st Subject Choice:");

        lbl_opt2.setForeground(new java.awt.Color(0, 0, 0));
        lbl_opt2.setText("2nd Subject Choice:");

        lbl_opt3.setForeground(new java.awt.Color(0, 0, 0));
        lbl_opt3.setText("3rd Subject Choice");

        lbl_lo.setForeground(new java.awt.Color(0, 0, 0));
        lbl_lo.setText("LO:");

        spn_hl.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        spn_fal.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        spn_math.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        spn_opt1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        spn_opt2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        spn_opt3.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        spn_lo.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        btnG_hl.add(rBtn_hlEng);
        rBtn_hlEng.setForeground(new java.awt.Color(0, 0, 0));
        rBtn_hlEng.setText("English");
        rBtn_hlEng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtn_hlEngActionPerformed(evt);
            }
        });

        btnG_hl.add(rBtn_hlOther);
        rBtn_hlOther.setForeground(new java.awt.Color(0, 0, 0));
        rBtn_hlOther.setText("Other");
        rBtn_hlOther.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtn_hlOtherActionPerformed(evt);
            }
        });

        btnG_fal.add(rBtn_falEng);
        rBtn_falEng.setForeground(new java.awt.Color(0, 0, 0));
        rBtn_falEng.setText("English");
        rBtn_falEng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtn_falEngActionPerformed(evt);
            }
        });

        btnG_math.add(rBtn_mathT);
        rBtn_mathT.setForeground(new java.awt.Color(0, 0, 0));
        rBtn_mathT.setText("Technical");

        btnG_math.add(rBtn_mathL);
        rBtn_mathL.setForeground(new java.awt.Color(0, 0, 0));
        rBtn_mathL.setText("Literacy");

        btnG_math.add(rBtn_mathC);
        rBtn_mathC.setForeground(new java.awt.Color(0, 0, 0));
        rBtn_mathC.setText("Core");

        btnG_fal.add(rBtn_falOther);
        rBtn_falOther.setForeground(new java.awt.Color(0, 0, 0));
        rBtn_falOther.setText("Other");
        rBtn_falOther.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtn_falOtherActionPerformed(evt);
            }
        });

        cbx_opt1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Accounting", "Business Studies", "CAT", "Consumer Studies", "Dance Studies", "Design", "Dramatic Arts", "EGD", "Economics", "Geography", "History", "Hospitality Studies", "Information Technology", "Life Sciences", "Marine Sciences", "Music", "Physical Sciences", "Tourism", "Visual Arts", "Other" }));

        cbx_opt2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Accounting", "Business Studies", "CAT", "Consumer Studies", "Dance Studies", "Design", "Dramatic Arts", "EGD", "Economics", "Geography", "History", "Hospitality Studies", "Information Technology", "Life Sciences", "Marine Sciences", "Music", "Physical Sciences", "Tourism", "Visual Arts", "Other" }));

        cbx_opt3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Accounting", "Business Studies", "CAT", "Consumer Studies", "Dance Studies", "Design", "Dramatic Arts", "EGD", "Economics", "Geography", "History", "Hospitality Studies", "Information Technology", "Life Sciences", "Marine Sciences", "Music", "Physical Sciences", "Tourism", "Visual Arts", "Other" }));

        btn_save.setBackground(java.awt.SystemColor.menu);
        btn_save.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        btn_save.setForeground(new java.awt.Color(0, 0, 0));
        btn_save.setText("Save");
        btn_save.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        lbl_saveIndicator.setForeground(new java.awt.Color(255, 51, 0));
        lbl_saveIndicator.setText("Saved!");

        javax.swing.GroupLayout pnl_resultsLayout = new javax.swing.GroupLayout(pnl_results);
        pnl_results.setLayout(pnl_resultsLayout);
        pnl_resultsLayout.setHorizontalGroup(
            pnl_resultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_resultsLayout.createSequentialGroup()
                .addGroup(pnl_resultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_resultsLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btn_results_back)
                        .addGap(176, 176, 176)
                        .addComponent(lbl_resultsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_resultsLayout.createSequentialGroup()
                        .addGap(323, 323, 323)
                        .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150)
                        .addComponent(lbl_saveIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_resultsLayout.createSequentialGroup()
                .addGap(0, 39, Short.MAX_VALUE)
                .addGroup(pnl_resultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_hl, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_lo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_opt3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_opt2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_opt1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_math, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_fal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(pnl_resultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spn_hl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spn_fal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spn_math, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spn_opt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spn_opt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spn_opt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spn_lo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addGroup(pnl_resultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbx_opt1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_resultsLayout.createSequentialGroup()
                        .addGroup(pnl_resultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnl_resultsLayout.createSequentialGroup()
                                .addComponent(rBtn_mathC, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rBtn_mathL, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnl_resultsLayout.createSequentialGroup()
                                .addComponent(rBtn_falEng, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rBtn_falOther, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnl_resultsLayout.createSequentialGroup()
                                .addComponent(rBtn_hlEng, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rBtn_hlOther, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(rBtn_mathT, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbx_opt2, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_opt3, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );
        pnl_resultsLayout.setVerticalGroup(
            pnl_resultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_resultsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_resultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_results_back)
                    .addComponent(lbl_resultsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(pnl_resultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_resultsLayout.createSequentialGroup()
                        .addGroup(pnl_resultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_resultsLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(rBtn_hlOther))
                            .addComponent(spn_hl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnl_resultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_fal)
                            .addComponent(spn_fal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rBtn_falEng)
                            .addComponent(rBtn_falOther))
                        .addGap(17, 17, 17)
                        .addGroup(pnl_resultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_math)
                            .addComponent(spn_math, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rBtn_mathC)
                            .addComponent(rBtn_mathL)
                            .addComponent(rBtn_mathT))
                        .addGap(18, 18, 18)
                        .addGroup(pnl_resultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_opt1)
                            .addComponent(spn_opt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbx_opt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_resultsLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(pnl_resultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_hl)
                            .addComponent(rBtn_hlEng))))
                .addGap(18, 18, 18)
                .addGroup(pnl_resultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_opt2)
                    .addComponent(spn_opt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_opt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_resultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_opt3)
                    .addComponent(spn_opt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_opt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_resultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_lo)
                    .addComponent(spn_lo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(pnl_resultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_saveIndicator))
                .addGap(25, 25, 25))
        );

        tbdPn_main.addTab("Your Results", null, pnl_results, "");
        pnl_results.getAccessibleContext().setAccessibleName("results");

        pnl_saved.setBackground(new java.awt.Color(179, 224, 255));

        lbl_saved.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_saved.setForeground(new java.awt.Color(86, 94, 255));
        lbl_saved.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_saved.setText("Your Saved Degrees");

        txF_saved_search.setBackground(new java.awt.Color(179, 224, 255));
        txF_saved_search.setForeground(new java.awt.Color(0, 0, 0));
        txF_saved_search.setToolTipText("");
        txF_saved_search.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(86, 94, 255))); // NOI18N
        txF_saved_search.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txF_saved_searchCaretUpdate(evt);
            }
        });

        tbl_saved.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_saved.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scP_saved.setViewportView(tbl_saved);

        btn_saved_view.setBackground(java.awt.SystemColor.menu);
        btn_saved_view.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        btn_saved_view.setForeground(new java.awt.Color(0, 0, 0));
        btn_saved_view.setText("View");
        btn_saved_view.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        btn_saved_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saved_viewActionPerformed(evt);
            }
        });

        btn_saved_remove.setBackground(java.awt.SystemColor.menu);
        btn_saved_remove.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        btn_saved_remove.setForeground(new java.awt.Color(0, 0, 0));
        btn_saved_remove.setText("Remove");
        btn_saved_remove.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        btn_saved_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saved_removeActionPerformed(evt);
            }
        });

        btn_saved_back.setBackground(new java.awt.Color(179, 224, 255));
        btn_saved_back.setForeground(new java.awt.Color(0, 0, 0));
        btn_saved_back.setText("Back");
        btn_saved_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saved_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_savedLayout = new javax.swing.GroupLayout(pnl_saved);
        pnl_saved.setLayout(pnl_savedLayout);
        pnl_savedLayout.setHorizontalGroup(
            pnl_savedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_savedLayout.createSequentialGroup()
                .addGroup(pnl_savedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_savedLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btn_saved_back)
                        .addGap(181, 181, 181)
                        .addComponent(lbl_saved, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_savedLayout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(btn_saved_view, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123)
                        .addComponent(btn_saved_remove, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_savedLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(pnl_savedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scP_saved, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txF_saved_search, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        pnl_savedLayout.setVerticalGroup(
            pnl_savedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_savedLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_savedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_saved, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_saved_back))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txF_saved_search, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scP_saved, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_savedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_saved_remove, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_saved_view, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tbdPn_main.addTab("Saved Degrees", pnl_saved);

        pnl_browse.setBackground(new java.awt.Color(179, 224, 255));

        lbl_browse.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_browse.setForeground(new java.awt.Color(86, 94, 255));
        lbl_browse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_browse.setText("Browse Universities");

        txF_browse_search.setBackground(new java.awt.Color(179, 224, 255));
        txF_browse_search.setToolTipText("");
        txF_browse_search.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(86, 94, 255))); // NOI18N
        txF_browse_search.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txF_browse_searchCaretUpdate(evt);
            }
        });

        scP_browse.setViewportView(tbl_browse);

        btn_browse_view.setBackground(java.awt.SystemColor.menu);
        btn_browse_view.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        btn_browse_view.setForeground(new java.awt.Color(0, 0, 0));
        btn_browse_view.setText("View");
        btn_browse_view.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        btn_browse_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_browse_viewActionPerformed(evt);
            }
        });

        btn_browse_back.setBackground(new java.awt.Color(179, 224, 255));
        btn_browse_back.setForeground(new java.awt.Color(0, 0, 0));
        btn_browse_back.setText("Back");
        btn_browse_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_browse_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_browseLayout = new javax.swing.GroupLayout(pnl_browse);
        pnl_browse.setLayout(pnl_browseLayout);
        pnl_browseLayout.setHorizontalGroup(
            pnl_browseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_browseLayout.createSequentialGroup()
                .addGroup(pnl_browseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_browseLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btn_browse_back)
                        .addGap(179, 179, 179)
                        .addComponent(lbl_browse, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_browseLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(pnl_browseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scP_browse, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txF_browse_search, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_browseLayout.createSequentialGroup()
                                .addGap(258, 258, 258)
                                .addComponent(btn_browse_view, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        pnl_browseLayout.setVerticalGroup(
            pnl_browseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_browseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_browseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_browse, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_browse_back))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txF_browse_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scP_browse, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_browse_view, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        tbdPn_main.addTab("Universities", pnl_browse);

        pnl_finder.setBackground(new java.awt.Color(179, 224, 255));

        btn_finder_back.setBackground(new java.awt.Color(179, 224, 255));
        btn_finder_back.setForeground(new java.awt.Color(0, 0, 0));
        btn_finder_back.setText("Back");
        btn_finder_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_finder_backActionPerformed(evt);
            }
        });

        lbl_finder.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_finder.setForeground(new java.awt.Color(86, 94, 255));
        lbl_finder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_finder.setText("Degree Finder");

        txF_finder_search.setBackground(new java.awt.Color(179, 224, 255));
        txF_finder_search.setToolTipText("");
        txF_finder_search.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(86, 94, 255))); // NOI18N
        txF_finder_search.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txF_finder_searchCaretUpdate(evt);
            }
        });

        btn_filter.setBackground(new java.awt.Color(102, 102, 102));
        btn_filter.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btn_filter.setForeground(new java.awt.Color(0, 0, 0));
        btn_filter.setText("Filters");
        btn_filter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        btn_filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filterActionPerformed(evt);
            }
        });

        btn_finder_view.setBackground(java.awt.SystemColor.menu);
        btn_finder_view.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        btn_finder_view.setForeground(new java.awt.Color(0, 0, 0));
        btn_finder_view.setText("View");
        btn_finder_view.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        btn_finder_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_finder_viewActionPerformed(evt);
            }
        });

        tbl_finder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scP_finder.setViewportView(tbl_finder);

        javax.swing.GroupLayout pnl_finderLayout = new javax.swing.GroupLayout(pnl_finder);
        pnl_finder.setLayout(pnl_finderLayout);
        pnl_finderLayout.setHorizontalGroup(
            pnl_finderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_finderLayout.createSequentialGroup()
                .addGroup(pnl_finderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_finderLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btn_finder_back)
                        .addGap(190, 190, 190)
                        .addComponent(lbl_finder, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_finderLayout.createSequentialGroup()
                        .addGap(328, 328, 328)
                        .addComponent(btn_finder_view, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_finderLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(pnl_finderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_finderLayout.createSequentialGroup()
                                .addComponent(txF_finder_search, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_filter, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(scP_finder, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        pnl_finderLayout.setVerticalGroup(
            pnl_finderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_finderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_finderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_finder, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_finder_back))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_finderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txF_finder_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_filter, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scP_finder, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_finder_view, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        tbdPn_main.addTab("Degree Finder", pnl_finder);

        tbdPn_dedicated.setBackground(new java.awt.Color(179, 224, 255));
        tbdPn_dedicated.setForeground(new java.awt.Color(0, 0, 0));
        tbdPn_dedicated.setEnabled(false);
        tbdPn_dedicated.setOpaque(true);

        pnl_help.setBackground(new java.awt.Color(179, 224, 255));
        pnl_help.setEnabled(false);

        lbl_help.setForeground(new java.awt.Color(0, 0, 0));
        lbl_help.setText("To use the browser, click one of the buttons below, select an entry from the list, and click [View]");

        btn_toBrowse.setBackground(java.awt.SystemColor.menu);
        btn_toBrowse.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        btn_toBrowse.setForeground(new java.awt.Color(0, 0, 0));
        btn_toBrowse.setText("Go to list of Universities");
        btn_toBrowse.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        btn_toBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_toBrowseActionPerformed(evt);
            }
        });

        btn_toSaved.setBackground(java.awt.SystemColor.menu);
        btn_toSaved.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        btn_toSaved.setForeground(new java.awt.Color(0, 0, 0));
        btn_toSaved.setText("View your Saved Degrees");
        btn_toSaved.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        btn_toSaved.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_toSavedActionPerformed(evt);
            }
        });

        btn_toFinder.setBackground(java.awt.SystemColor.menu);
        btn_toFinder.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        btn_toFinder.setForeground(new java.awt.Color(0, 0, 0));
        btn_toFinder.setText("Find a Degree");
        btn_toFinder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        btn_toFinder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_toFinderActionPerformed(evt);
            }
        });

        lbl_contact.setForeground(new java.awt.Color(0, 0, 0));
        lbl_contact.setText("For queries or bug reports , contact saiennaidu99@gmail.com");

        javax.swing.GroupLayout pnl_helpLayout = new javax.swing.GroupLayout(pnl_help);
        pnl_help.setLayout(pnl_helpLayout);
        pnl_helpLayout.setHorizontalGroup(
            pnl_helpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_helpLayout.createSequentialGroup()
                .addGroup(pnl_helpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_helpLayout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(btn_toSaved, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_helpLayout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addGroup(pnl_helpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_toFinder, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_toBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_helpLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(pnl_helpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_help)
                            .addGroup(pnl_helpLayout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(lbl_contact)))))
                .addContainerGap(147, Short.MAX_VALUE))
        );
        pnl_helpLayout.setVerticalGroup(
            pnl_helpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_helpLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(lbl_help, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(btn_toSaved, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_toBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_toFinder, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(lbl_contact, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        tbdPn_dedicated.addTab("Help", pnl_help);

        pnl_uni.setBackground(new java.awt.Color(179, 224, 255));

        lbl_uni.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_uni.setForeground(new java.awt.Color(86, 94, 255));
        lbl_uni.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_uni.setText("[University name]");

        txA_uniDesc.setEditable(false);
        txA_uniDesc.setBackground(new java.awt.Color(179, 224, 255));
        txA_uniDesc.setColumns(20);
        txA_uniDesc.setForeground(new java.awt.Color(0, 0, 0));
        txA_uniDesc.setLineWrap(true);
        txA_uniDesc.setRows(5);
        txA_uniDesc.setText("[description]");

        tbl_uniFac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Faculties"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scP_uniFac.setViewportView(tbl_uniFac);

        btn_facView.setBackground(java.awt.SystemColor.menu);
        btn_facView.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        btn_facView.setForeground(new java.awt.Color(0, 0, 0));
        btn_facView.setText("View");
        btn_facView.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        btn_facView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_facViewActionPerformed(evt);
            }
        });

        lbl_students.setForeground(new java.awt.Color(0, 0, 0));
        lbl_students.setText("Students:");

        lbl_accRate.setForeground(new java.awt.Color(0, 0, 0));
        lbl_accRate.setText("Acceptance Rate (%):");

        txA_rank.setForeground(new java.awt.Color(0, 0, 0));
        txA_rank.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txA_rank.setText("[Rank]");

        txA_location.setForeground(new java.awt.Color(0, 0, 0));
        txA_location.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txA_location.setText("[Location]");

        txA_estb.setForeground(new java.awt.Color(0, 0, 0));
        txA_estb.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txA_estb.setText("[etsb]");

        txA_students.setForeground(new java.awt.Color(0, 0, 0));
        txA_students.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txA_students.setText("[Students]");

        txA_accRate.setForeground(new java.awt.Color(0, 0, 0));
        txA_accRate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txA_accRate.setText("[AccRate]");

        lbl_rank.setForeground(new java.awt.Color(0, 0, 0));
        lbl_rank.setText("National Ranking:");

        lbl_location.setForeground(new java.awt.Color(0, 0, 0));
        lbl_location.setText("Location:");

        lbl_estb.setForeground(new java.awt.Color(0, 0, 0));
        lbl_estb.setText("Year Established:");

        btn_uni_back.setBackground(new java.awt.Color(179, 224, 255));
        btn_uni_back.setForeground(new java.awt.Color(0, 0, 0));
        btn_uni_back.setText("Back");
        btn_uni_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_uni_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_uniLayout = new javax.swing.GroupLayout(pnl_uni);
        pnl_uni.setLayout(pnl_uniLayout);
        pnl_uniLayout.setHorizontalGroup(
            pnl_uniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_uniLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_uniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnl_uniLayout.createSequentialGroup()
                        .addComponent(lbl_accRate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                        .addComponent(txA_accRate))
                    .addGroup(pnl_uniLayout.createSequentialGroup()
                        .addComponent(lbl_students)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txA_students))
                    .addGroup(pnl_uniLayout.createSequentialGroup()
                        .addComponent(lbl_estb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txA_estb))
                    .addGroup(pnl_uniLayout.createSequentialGroup()
                        .addComponent(lbl_location)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txA_location))
                    .addGroup(pnl_uniLayout.createSequentialGroup()
                        .addComponent(lbl_rank)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txA_rank)))
                .addGap(18, 18, 18)
                .addComponent(txA_uniDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
            .addGroup(pnl_uniLayout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(scP_uniFac, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_facView, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 154, Short.MAX_VALUE))
            .addGroup(pnl_uniLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_uni_back)
                .addGap(83, 83, 83)
                .addComponent(lbl_uni, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_uniLayout.setVerticalGroup(
            pnl_uniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_uniLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_uniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_uni, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_uni_back))
                .addGroup(pnl_uniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_uniLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_uniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_uniLayout.createSequentialGroup()
                                .addComponent(lbl_rank)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addGroup(pnl_uniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_location)
                                    .addComponent(txA_location))
                                .addGap(21, 21, 21)
                                .addGroup(pnl_uniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_estb)
                                    .addComponent(txA_estb))
                                .addGap(18, 18, 18)
                                .addGroup(pnl_uniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_students)
                                    .addComponent(txA_students))
                                .addGap(16, 16, 16)
                                .addGroup(pnl_uniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_accRate)
                                    .addComponent(txA_accRate)))
                            .addComponent(txA_rank)))
                    .addGroup(pnl_uniLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txA_uniDesc)))
                .addGap(18, 18, 18)
                .addGroup(pnl_uniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scP_uniFac, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_facView, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        tbdPn_dedicated.addTab("University", pnl_uni);

        pnl_fac.setBackground(new java.awt.Color(179, 224, 255));

        tbl_facDeg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Degrees"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scP_facDeg.setViewportView(tbl_facDeg);

        lbl_fac.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_fac.setForeground(new java.awt.Color(86, 94, 255));
        lbl_fac.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_fac.setText("[Faculty name]");

        txA_facDesc.setEditable(false);
        txA_facDesc.setBackground(new java.awt.Color(179, 224, 255));
        txA_facDesc.setColumns(20);
        txA_facDesc.setForeground(new java.awt.Color(0, 0, 0));
        txA_facDesc.setLineWrap(true);
        txA_facDesc.setRows(5);
        txA_facDesc.setText("[description]");

        btn_degView.setBackground(java.awt.SystemColor.menu);
        btn_degView.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        btn_degView.setForeground(new java.awt.Color(0, 0, 0));
        btn_degView.setText("View");
        btn_degView.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        btn_degView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_degViewActionPerformed(evt);
            }
        });

        btn_fac_back.setBackground(new java.awt.Color(179, 224, 255));
        btn_fac_back.setForeground(new java.awt.Color(0, 0, 0));
        btn_fac_back.setText("Back");
        btn_fac_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fac_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_facLayout = new javax.swing.GroupLayout(pnl_fac);
        pnl_fac.setLayout(pnl_facLayout);
        pnl_facLayout.setHorizontalGroup(
            pnl_facLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_facLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(scP_facDeg, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnl_facLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txA_facDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_degView, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(pnl_facLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_fac_back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_fac, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(188, 188, 188))
        );
        pnl_facLayout.setVerticalGroup(
            pnl_facLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_facLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_facLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_fac, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_fac_back))
                .addGap(19, 19, 19)
                .addGroup(pnl_facLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scP_facDeg, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_facLayout.createSequentialGroup()
                        .addComponent(txA_facDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_degView, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        tbdPn_dedicated.addTab("Faculty", pnl_fac);

        pnl_deg.setBackground(new java.awt.Color(179, 224, 255));

        lbl_deg.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_deg.setForeground(new java.awt.Color(86, 94, 255));
        lbl_deg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_deg.setText("[Degree name]");

        txA_degDesc.setEditable(false);
        txA_degDesc.setBackground(new java.awt.Color(179, 224, 255));
        txA_degDesc.setColumns(20);
        txA_degDesc.setForeground(new java.awt.Color(0, 0, 0));
        txA_degDesc.setLineWrap(true);
        txA_degDesc.setRows(5);
        txA_degDesc.setText("[description]");

        txA_req.setBackground(java.awt.SystemColor.menu);
        txA_req.setColumns(20);
        txA_req.setRows(5);
        txA_req.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        btn_saveDeg.setBackground(java.awt.SystemColor.menu);
        btn_saveDeg.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        btn_saveDeg.setForeground(new java.awt.Color(0, 0, 0));
        btn_saveDeg.setText("Save");
        btn_saveDeg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        btn_saveDeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveDegActionPerformed(evt);
            }
        });

        btn_degree_back.setBackground(new java.awt.Color(179, 224, 255));
        btn_degree_back.setForeground(new java.awt.Color(0, 0, 0));
        btn_degree_back.setText("Back");
        btn_degree_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_degree_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_degLayout = new javax.swing.GroupLayout(pnl_deg);
        pnl_deg.setLayout(pnl_degLayout);
        pnl_degLayout.setHorizontalGroup(
            pnl_degLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_degLayout.createSequentialGroup()
                .addGroup(pnl_degLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_degLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_degree_back)
                        .addGap(33, 33, 33)
                        .addComponent(lbl_deg, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_degLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(pnl_degLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txA_req, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txA_degDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(pnl_degLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_degLayout.createSequentialGroup()
                    .addGap(604, 604, 604)
                    .addComponent(btn_saveDeg, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(39, Short.MAX_VALUE)))
        );
        pnl_degLayout.setVerticalGroup(
            pnl_degLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_degLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_degLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_deg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_degree_back))
                .addGap(18, 18, 18)
                .addComponent(txA_degDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txA_req, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
            .addGroup(pnl_degLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_degLayout.createSequentialGroup()
                    .addGap(361, 361, 361)
                    .addComponent(btn_saveDeg, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(20, Short.MAX_VALUE)))
        );

        tbdPn_dedicated.addTab("Degree", pnl_deg);

        tbdPn_main.addTab("Browser", tbdPn_dedicated);

        lbl_title.setFont(new java.awt.Font("Niagara Solid", 2, 24)); // NOI18N
        lbl_title.setText("UniGo V1.0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbdPn_main)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_title, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lbl_title, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tbdPn_main, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Sets up the User Marks tab
    private void initUserMarksTab() {
        // Fetch user marks
        Requirement userMarks = rm.getUserMarks();

        // For each subject, fetch the mark and choice
        // Select Radio Buttons according to the user's subject choices
        // Home Language
        spn_hl.setValue(userMarks.getHlMark());
        if (userMarks.getHlChoice().equals("eng")) {
            rBtn_hlEng.setSelected(true);
            rBtn_falEng.setEnabled(false);
        } else {
            rBtn_hlOther.setSelected(true);
        }

        // First Add Lang
        spn_fal.setValue(userMarks.getFalMark());
        if (userMarks.getFalChoice().equals("eng")) {
            rBtn_falEng.setSelected(true);
            rBtn_hlEng.setEnabled(false);
        } else {
            rBtn_falOther.setSelected(true);
        }

        // Mathematics
        spn_math.setValue(userMarks.getMathMark());
        switch (userMarks.getMathChoice()) {
            case "cor" ->
                rBtn_mathC.setSelected(true);
            case "lit" ->
                rBtn_mathL.setSelected(true);
            default ->
                rBtn_mathT.setSelected(true);
        }

        // 1st Subject Choice
        spn_opt1.setValue(userMarks.getOpt1Mark());
        String opt1C = rm.getSubject(userMarks.getOpt1Choice());
        cbx_opt1.setSelectedItem(opt1C);

        // 2nd Subject Choice
        spn_opt2.setValue(userMarks.getOpt2Mark());
        String opt2C = rm.getSubject(userMarks.getOpt2Choice());
        cbx_opt2.setSelectedItem(opt2C);

        // 3rd Subject Choice
        spn_opt3.setValue(userMarks.getOpt3Mark());
        String opt3C = rm.getSubject(userMarks.getOpt3Choice());
        cbx_opt3.setSelectedItem(opt3C);

        // LO
        spn_lo.setValue(userMarks.getLo());

        // Make the saved indicator invisible
        lbl_saveIndicator.setVisible(false);
    }

    // Initializes the list of the user's saved degrees
    private void initSavedDegreesTable() {
        columnName[0] = "Degrees";
        JTable temp = new JTable(sd.createTable(), columnName);
        tbl_saved.setModel(temp.getModel());
    }

    // Initializes the list of all the Universities in the DB
    private void initUniversityTable() {
        columnName[0] = "Universities";
        JTable temp = new JTable(um.createTable(), columnName);
        tbl_browse.setModel(temp.getModel());
        btn_filter.setBackground(Color.lightGray);
    }

    // Initializes the list of all the Degrees in the DB
    private void initFinderTable() {
        columnName[0] = "Degrees";
        JTable temp = new JTable(dm.createTable(), columnName);
        tbl_finder.setModel(temp.getModel());
    }

    // Sets the filter frame to be invisible when the program is opened.
    private void initFiltersFrame() {
        frm_filters.setVisible(false);
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Update code">
    // Update the list of Saved Degrees based on text
    private void updateSavedDegreesTable(String input) {
        columnName[0] = "Degrees";
        JTable temp = new JTable(sd.createTable(input), columnName);
        tbl_saved.setModel(temp.getModel());
    }

    // Update the list of Universities in based on an array of Universities
    private void updateUniversityTable(University[] input) {
        columnName[0] = "Universities";
        JTable temp = new JTable(um.createTable(input), columnName);
        tbl_browse.setModel(temp.getModel());
    }

    // Update the list of Degrees based on an array of Degrees
    private void updateFinderTable(Degree[] input) {
        columnName[0] = "Degrees";
        JTable temp = new JTable(dm.createTable(input), columnName);
        tbl_finder.setModel(temp.getModel());
    }

    // Display a new University in the dedictaed university tab
    private void updateUniversityTab(University uni) {
        lbl_uni.setText(uni.getName());
        txA_rank.setText(uni.getRank() + "");
        txA_location.setText(uni.getLocation());
        txA_estb.setText("" + uni.getEstb());
        txA_students.setText("" + uni.getStudents());
        txA_accRate.setText(uni.getAccRate() + "%");
        txA_uniDesc.setText(uni.getDesc());

        columnName[0] = "Faculties";
        JTable temp = new JTable(fm.createTable(uni), columnName);
        tbl_uniFac.setModel(temp.getModel());
    }

    // Display a new Faculty in the dedictaed faculty tab
    private void updateFacultyTab(Faculty fac) {
        lbl_fac.setText(fac.getName());
        txA_facDesc.setText(fac.getDesc());

        columnName[0] = "Degrees";

        JTable temp = new JTable(dm.createTable(fac), columnName);
        tbl_facDeg.setModel(temp.getModel());
    }

    // Display a new Degree in the dedictaed degree tab
    private void updateDegreeTab(Degree deg) {
        // Update the variable storing the current Degree being shown
        degreeTab = deg;

        lbl_deg.setText(deg.getName());
        txA_degDesc.setText(deg.getDesc());

        // Fetch the Requirement Object linked to this degree
        Requirement req = rm.getReqWithDegID(deg.getDegreeID());

        txA_req.setText(rm.toString(req));

        // If this degree is bookmarked, disable the save button
        int[] saved = sd.getSavedDegrees();
        boolean isSaved = false;
        for (int i = 0; i < saved.length; i++) {
            if (deg.getDegreeID() == saved[i]) {
                isSaved = true;
            }
        }
        if (isSaved) {
            btn_saveDeg.setText("Saved");
            btn_saveDeg.setEnabled(false);
        } else {
            btn_saveDeg.setEnabled(true);
            btn_saveDeg.setText("Save");
        }
    }

    // Update the list of degrees based on the filter provided
    // <editor-fold defaultstate="collapsed" desc="Degree Finder">
    public void updateFinderTable(Filter f) {

        // If a filter is applied:
        if (f.isCommerce() || f.isEastcape() || f.isEngineering() || f.isExclude() || f.isFreestate() || f.isGauteng() || f.isHealth() || f.isHumanities() || f.isInclude() || f.isKzn() || f.isLaw() || f.isLimpopo() || f.isMpumalanga() || f.isNorthwest() || f.isSciences() || f.isUseMarks() || f.isWestcape()) {
            // Hide the frame
            this.setVisible(false);

            // Update table
            columnName[0] = "Degrees";
            JTable temp = new JTable(dm.createTable(dm.degreeFinder(f)), columnName);
            tbl_finder.setModel(temp.getModel());

            // Open the right tab
            tbdPn_main.setSelectedIndex(4);
            // Set the filter button color to show that a filter is being applied
            btn_filter.setBackground(Color.white);
            // Disable the search bar 
            System.out.println("Searching for degrees while a filter is applied is not implemented yet");
            txF_finder_search.setEnabled(false);
            // Show the frame
            this.setVisible(true);
        } else { // If no filter is applied:
            // Hide the frame
            this.setVisible(false);

            // Set the list of degrees to show all the degrees in the DB.
            initFinderTable();

            // Open the right tab
            tbdPn_main.setSelectedIndex(4);
            // Set the filter button color to show that a filter is NOT being applied
            btn_filter.setBackground(Color.darkGray);
            // Enable the search bar
            System.out.println("Searching for degrees while a filter is applied is not implemented yet");
            txF_finder_search.setEditable(true);
            // Show the frame
            this.setVisible(true);
        }

    }
    // </editor-fold>

    // </editor-fold>
    // When [Degree Finder] is clicked, navigate to the 'Degree Finder' tab.
    private void btn_finderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_finderActionPerformed
        tbdPn_main.setSelectedIndex(4);
    }//GEN-LAST:event_btn_finderActionPerformed

    // When [Save] is clicked on 'Your Results' tab, save the changes made to the user's marks to the text file
    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // For every subject, store both the...
        // ...mark:
        int hlM = (int) spn_hl.getValue();
        // ...and the choice:
        String hlC;
        if (rBtn_hlEng.isSelected()) {
            hlC = "eng";
        } else {
            hlC = "oth";
        }

        int falM = (int) spn_fal.getValue();
        String falC;
        if (rBtn_falEng.isSelected()) {
            falC = "eng";
        } else {
            falC = "oth";
        }

        int mathM = (int) spn_math.getValue();
        String mathC;
        if (rBtn_mathC.isSelected()) {
            mathC = "cor";
        } else if (rBtn_mathL.isSelected()) {
            mathC = "lit";
        } else {
            mathC = "tec";
        }

        // For every optional subject...
        // ...store the mark:
        int opt1M = (int) spn_opt1.getValue();
        // ...store the choice by fetching it from the combobox and abbreviating it using a method:
        String opt1C = rm.getAbbreviation((String) cbx_opt1.getSelectedItem());

        int opt2M = (int) spn_opt2.getValue();
        String opt2C = rm.getAbbreviation((String) cbx_opt2.getSelectedItem());

        int opt3M = (int) spn_opt3.getValue();
        String opt3C = rm.getAbbreviation((String) cbx_opt3.getSelectedItem());

        // Only store the mark for LO
        int lo = (int) spn_lo.getValue();

        // Save marks
        rm.setUserMarks(hlM, hlC, falM, falC, mathM, mathC, opt1M, opt1C, opt2M, opt2C, opt3M, opt3C, lo);

        // Show that the marks have been saved
        lbl_saveIndicator.setVisible(true);
    }//GEN-LAST:event_btn_saveActionPerformed

    // When [Remove] is clicked on 'Saved Degrees', Remove the bookmark on selected degree
    private void btn_saved_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saved_removeActionPerformed
        // Fetch the index of the selected row
        int index = tbl_saved.getSelectedRow();

        // If the user actually has a row selected:
        if (index != -1) {
            // Delete the degree from the text file
            sd.remove(index);
            // Update the table
            initSavedDegreesTable();
        }
    }//GEN-LAST:event_btn_saved_removeActionPerformed

    // When [View] is clicked on the 'Saved Degrees' tab, display the selected degree's information on the dedicated Degree tab.
    private void btn_saved_viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saved_viewActionPerformed
        // Fetch index of selected row
        int selectedRow = tbl_saved.getSelectedRow();

        // If the user actually selected a row:
        if (selectedRow != -1) {
            // Fetch the list of Degree IDs
            int[] tableArr = sd.getSavedDegrees();

            // Instantiate necessary Objects
            Degree deg = dm.getDegWithID(tableArr[selectedRow]);
            Faculty fac = deg.getFac();
            University uni = fac.getUni();

            // Update dedicated tabs as needed
            updateUniversityTab(uni);
            updateFacultyTab(fac);
            updateDegreeTab(deg);

            // Switch focus from main tabs to dedicated
            changeToDedicatedTabs(3);
        }
    }//GEN-LAST:event_btn_saved_viewActionPerformed

    // When [View] is clicked on the 'Universities' tab, display the selected university's information on the dedicated University tab.
    private void btn_browse_viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_browse_viewActionPerformed
        // Fetch index of selected row
        int selectedRow = tbl_browse.getSelectedRow();

        // If a row is actually selected:
        if (selectedRow != -1) {
            // Fetch the list of Universities which are currently being displayed
            int[] tableArr = um.getTableArr();

            // Instantiate necessary Objects
            University uni = um.getUniWithID(tableArr[selectedRow]);

            // Update dedicated tabs as needed
            updateUniversityTab(uni);

            // Switch focus from main tabs to dedicated
            changeToDedicatedTabs(1);
        }

    }//GEN-LAST:event_btn_browse_viewActionPerformed

    // When [View] is clicked on the 'Degree Finder' tab, display the selected Degree's information on the dedicated Degree tab.
    private void btn_finder_viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_finder_viewActionPerformed
        // Fetch index of selected row
        int selectedRow = tbl_finder.getSelectedRow();

        // If a row is actually selected:
        if (selectedRow != -1) {
            // Fetch the list of Degrees which are currently being displayed
            int[] tableArr = dm.getTableArr();

            // Instantiate necessary Objects
            Degree deg = dm.getDegWithID(tableArr[selectedRow]);
            Faculty fac = deg.getFac();
            University uni = fac.getUni();

            // Update dedicated tabs as needed
            updateUniversityTab(uni);
            updateFacultyTab(fac);
            updateDegreeTab(deg);

            // Switch focus from main tabs to dedicated
            changeToDedicatedTabs(3);
        }
    }//GEN-LAST:event_btn_finder_viewActionPerformed

    // When [View] is clicked on the dedicated University tab, display the selected Faculty's information on the dedicated Faculty tab.
    private void btn_facViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_facViewActionPerformed
        // Fetch index of selected row
        int selectedRow = tbl_uniFac.getSelectedRow();

        // If a row is actually selected:
        if (selectedRow != -1) {
            // Fetch the list of Faculties which are currently being displayed
            int[] tableArr = fm.getTableArr();

            // Instantiate necessary Objects
            Faculty fac = fm.getFacWithID(tableArr[selectedRow]);

            // Update dedicated tabs as needed
            updateFacultyTab(fac);

            // Nevigate to Faculty dedicated tab
            changeToDedicatedTabs(2);
        }
    }//GEN-LAST:event_btn_facViewActionPerformed

    // When [View] is clicked on the dedicated Faculty tab, display the selected Degree's information on the dedicated Degree tab.
    private void btn_degViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_degViewActionPerformed
        // Fetch index of selected row
        int selectedRow = tbl_facDeg.getSelectedRow();

        // If a row is actually selected:
        if (selectedRow != -1) {
            // Fetch the list of Faculties which are currently being displayed
            int[] tableArr = dm.getTableArr();

            // Instantiate necessary Objects
            Degree deg = dm.getDegWithID(tableArr[selectedRow]);

            // Update dedicated tabs as needed
            updateDegreeTab(deg);

            // Nevigate to Degree dedicated tab
            changeToDedicatedTabs(3);
        }
    }//GEN-LAST:event_btn_degViewActionPerformed

    // When [Save] is clicked on the dedicated Degree tab, bookmark the degree
    private void btn_saveDegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveDegActionPerformed
        // Using the degree stored in the class variable 'degreeTab'...
        // (which changes every time a different degree is displayed on the dedicated degree tab)...
        // bookmark the degree
        sd.add(degreeTab.getDegreeID());
        // Update saved degrees table
        initSavedDegreesTable();
        // Show the user that the degree has been saved
        btn_saveDeg.setText("Saved");
        btn_saveDeg.setEnabled(false);
    }//GEN-LAST:event_btn_saveDegActionPerformed

    // When 'Your Results' is clicked, navigate to the 'Your Results' tab.
    private void btn_resultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resultsActionPerformed
        tbdPn_main.setSelectedIndex(1);
    }//GEN-LAST:event_btn_resultsActionPerformed

    // When 'Your saved degrees' is clicked, navigate to the 'Saved Degrees' tab.
    private void btn_savedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_savedActionPerformed
        tbdPn_main.setSelectedIndex(2);
    }//GEN-LAST:event_btn_savedActionPerformed

    // When 'Browse Universities' is clicked, navigate to the 'Universities' tab.
    private void btn_browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_browseActionPerformed
        tbdPn_main.setSelectedIndex(3);
    }//GEN-LAST:event_btn_browseActionPerformed

    // Navigate back to the main menu
    private void btn_results_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_results_backActionPerformed
        // Hide the save indicator
        lbl_saveIndicator.setVisible(false);

        // Navigate to the main menu
        tbdPn_main.setSelectedIndex(0);
    }//GEN-LAST:event_btn_results_backActionPerformed

    // Since you can only take English once...
    // If the English FAL radio button is chosen, deactivate English HL
    private void rBtn_falEngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtn_falEngActionPerformed
        rBtn_hlEng.setEnabled(false);
    }//GEN-LAST:event_rBtn_falEngActionPerformed

    // Since you can only take English once...
    // If the English HL radio button is chosen, deactivate English FAL
    private void rBtn_hlEngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtn_hlEngActionPerformed
        rBtn_falEng.setEnabled(false);
    }//GEN-LAST:event_rBtn_hlEngActionPerformed

    // If the user chooses 'Other' as their HL, activate English FAL
    private void rBtn_hlOtherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtn_hlOtherActionPerformed
        rBtn_falEng.setEnabled(true);
    }//GEN-LAST:event_rBtn_hlOtherActionPerformed

    // If the user chooses 'Other' as their FAL, activate English HL
    private void rBtn_falOtherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtn_falOtherActionPerformed
        rBtn_hlEng.setEnabled(true);
    }//GEN-LAST:event_rBtn_falOtherActionPerformed

    // When [Back] is clicked on 'Saved Degrees', return to main menu
    private void btn_saved_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saved_backActionPerformed
        tbdPn_main.setSelectedIndex(0);
    }//GEN-LAST:event_btn_saved_backActionPerformed

    // When user types into the search bar on 'Saved Degrees', update the list according to the search
    private void txF_saved_searchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txF_saved_searchCaretUpdate
        String input = txF_saved_search.getText();
        updateSavedDegreesTable(input);
    }//GEN-LAST:event_txF_saved_searchCaretUpdate

    // When [Back] is clicked on 'Universities', return to main menu
    private void btn_browse_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_browse_backActionPerformed
        tbdPn_main.setSelectedIndex(0);
    }//GEN-LAST:event_btn_browse_backActionPerformed

    // When user types into the search bar on 'Universities', update the list according to the search
    private void txF_browse_searchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txF_browse_searchCaretUpdate
        String input = txF_browse_search.getText();

        // If the search is not blank:
        if (!input.equals("")) {
            // Get results using DB query
            University[] results = um.getUniWithName("SELECT * FROM University_Table "
                    + "WHERE UniversityName LIKE '*" + input + "*';");
            // Update table based on fetched results
            updateUniversityTable(results);
        } else { // If it is blank:
            // Update table to show all universities within the DB
            initUniversityTable();
        }
    }//GEN-LAST:event_txF_browse_searchCaretUpdate

    // When [Back] is clicked on 'Degree Finder', return to main menu
    private void btn_finder_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_finder_backActionPerformed
        tbdPn_main.setSelectedIndex(0);
    }//GEN-LAST:event_btn_finder_backActionPerformed

    // When user types into the search bar on 'Degree Finder', update the list according to the search
    private void txF_finder_searchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txF_finder_searchCaretUpdate
        // If no filter is applied:
        if (btn_filter.getBackground() != Color.white) {
            // Fetch search
            String input = txF_finder_search.getText();
            // If search is not blank:
            if (!input.equals("")) {
                // Get results using DB query
                Degree[] results = dm.getDegWithQuery("SELECT * FROM Degree_Table "
                        + "WHERE DegreeName LIKE '*" + input + "*';");
                // Update table based on these results.
                updateFinderTable(results);
            } else { // If it is:
                // Update table to show all universities within the DB
                initFinderTable();
            }
        }
    }//GEN-LAST:event_txF_finder_searchCaretUpdate

    // When [Filters] is clicked, open the filter frame
    private void btn_filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filterActionPerformed
        this.setVisible(false);
        frm_filters.setEnabled(true);
        frm_filters.setVisible(true);
    }//GEN-LAST:event_btn_filterActionPerformed

    // When [Go to list of Universities] is clicked, navigate to 'Universities'
    private void btn_toBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_toBrowseActionPerformed
        tbdPn_main.setSelectedIndex(3);
    }//GEN-LAST:event_btn_toBrowseActionPerformed

    // When [View your Saved Degrees] is clicked, navigate to 'Saved Degrees'
    private void btn_toSavedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_toSavedActionPerformed
        tbdPn_main.setSelectedIndex(2);
    }//GEN-LAST:event_btn_toSavedActionPerformed

    // When [Find a Degree] is clicked, navigate to 'Degree Finder'
    private void btn_toFinderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_toFinderActionPerformed
        tbdPn_main.setSelectedIndex(4);
    }//GEN-LAST:event_btn_toFinderActionPerformed

    // When [Back] is clicked on dedictaed University tab, return to main menu
    private void btn_uni_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_uni_backActionPerformed
        // Update university table to show all universities in DB
        initUniversityTable();
        // Update degree table to show all degrees in DB
        initFinderTable();
        tbdPn_main.setSelectedIndex(0);
    }//GEN-LAST:event_btn_uni_backActionPerformed

    // When [Back] is clicked on dedictaed Faculty tab, return to dedicated University tab
    private void btn_fac_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fac_backActionPerformed
        tbdPn_dedicated.setSelectedIndex(1);
    }//GEN-LAST:event_btn_fac_backActionPerformed

    // When [Back] is clicked on dedictaed Degree tab, return to dedicated Faculty tab
    private void btn_degree_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_degree_backActionPerformed
        tbdPn_dedicated.setSelectedIndex(2);
    }//GEN-LAST:event_btn_degree_backActionPerformed

    // Switch focus to dedicated tabs
    private void changeToDedicatedTabs(int tab) {
        tbdPn_main.setSelectedIndex(5);
        tbdPn_dedicated.setSelectedIndex(tab);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FMain().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnG_fal;
    private javax.swing.ButtonGroup btnG_hl;
    private javax.swing.ButtonGroup btnG_math;
    private javax.swing.JButton btn_browse;
    private javax.swing.JButton btn_browse_back;
    private javax.swing.JButton btn_browse_view;
    private javax.swing.JButton btn_degView;
    private javax.swing.JButton btn_degree_back;
    private javax.swing.JButton btn_facView;
    private javax.swing.JButton btn_fac_back;
    private javax.swing.JButton btn_filter;
    private javax.swing.JButton btn_finder;
    private javax.swing.JButton btn_finder_back;
    private javax.swing.JButton btn_finder_view;
    private javax.swing.JButton btn_results;
    private javax.swing.JButton btn_results_back;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_saveDeg;
    private javax.swing.JButton btn_saved;
    private javax.swing.JButton btn_saved_back;
    private javax.swing.JButton btn_saved_remove;
    private javax.swing.JButton btn_saved_view;
    private javax.swing.JButton btn_toBrowse;
    private javax.swing.JButton btn_toFinder;
    private javax.swing.JButton btn_toSaved;
    private javax.swing.JButton btn_uni_back;
    private javax.swing.JComboBox<String> cbx_opt1;
    private javax.swing.JComboBox<String> cbx_opt2;
    private javax.swing.JComboBox<String> cbx_opt3;
    private javax.swing.JLabel lbl_accRate;
    private javax.swing.JLabel lbl_browse;
    private javax.swing.JLabel lbl_contact;
    private javax.swing.JLabel lbl_deg;
    private javax.swing.JLabel lbl_estb;
    private javax.swing.JLabel lbl_fac;
    private javax.swing.JLabel lbl_fal;
    private javax.swing.JLabel lbl_finder;
    private javax.swing.JLabel lbl_help;
    private javax.swing.JLabel lbl_hl;
    private javax.swing.JLabel lbl_lo;
    private javax.swing.JLabel lbl_location;
    private javax.swing.JLabel lbl_math;
    private javax.swing.JLabel lbl_opt1;
    private javax.swing.JLabel lbl_opt2;
    private javax.swing.JLabel lbl_opt3;
    private javax.swing.JLabel lbl_rank;
    private javax.swing.JLabel lbl_resultsTitle;
    private javax.swing.JLabel lbl_saveIndicator;
    private javax.swing.JLabel lbl_saved;
    private javax.swing.JLabel lbl_students;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JLabel lbl_uni;
    private javax.swing.JPanel pnl_browse;
    private javax.swing.JPanel pnl_deg;
    private javax.swing.JPanel pnl_fac;
    private javax.swing.JPanel pnl_finder;
    private javax.swing.JPanel pnl_help;
    private javax.swing.JPanel pnl_menu;
    private javax.swing.JPanel pnl_menuBrowse;
    private javax.swing.JPanel pnl_menuProfile;
    private javax.swing.JPanel pnl_results;
    private javax.swing.JPanel pnl_saved;
    private javax.swing.JPanel pnl_uni;
    private javax.swing.JRadioButton rBtn_falEng;
    private javax.swing.JRadioButton rBtn_falOther;
    private javax.swing.JRadioButton rBtn_hlEng;
    private javax.swing.JRadioButton rBtn_hlOther;
    private javax.swing.JRadioButton rBtn_mathC;
    private javax.swing.JRadioButton rBtn_mathL;
    private javax.swing.JRadioButton rBtn_mathT;
    private javax.swing.JScrollPane scP_browse;
    private javax.swing.JScrollPane scP_facDeg;
    private javax.swing.JScrollPane scP_finder;
    private javax.swing.JScrollPane scP_saved;
    private javax.swing.JScrollPane scP_uniFac;
    private javax.swing.JSpinner spn_fal;
    private javax.swing.JSpinner spn_hl;
    private javax.swing.JSpinner spn_lo;
    private javax.swing.JSpinner spn_math;
    private javax.swing.JSpinner spn_opt1;
    private javax.swing.JSpinner spn_opt2;
    private javax.swing.JSpinner spn_opt3;
    private javax.swing.JTabbedPane tbdPn_dedicated;
    private javax.swing.JTabbedPane tbdPn_main;
    private javax.swing.JTable tbl_browse;
    private javax.swing.JTable tbl_facDeg;
    private javax.swing.JTable tbl_finder;
    private javax.swing.JTable tbl_saved;
    private javax.swing.JTable tbl_uniFac;
    private javax.swing.JLabel txA_accRate;
    private javax.swing.JTextArea txA_degDesc;
    private javax.swing.JLabel txA_estb;
    private javax.swing.JTextArea txA_facDesc;
    private javax.swing.JLabel txA_location;
    private javax.swing.JLabel txA_rank;
    private javax.swing.JTextArea txA_req;
    private javax.swing.JLabel txA_students;
    private javax.swing.JTextArea txA_uniDesc;
    private javax.swing.JTextField txF_browse_search;
    private javax.swing.JTextField txF_finder_search;
    private javax.swing.JTextField txF_saved_search;
    // End of variables declaration//GEN-END:variables
}
