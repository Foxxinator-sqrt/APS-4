package fenixv.ui;

import fenixv.algoritmos.Play;

public class Resultados extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Resultados.class.getName());

    public Resultados() {
        initComponents();
        fetchElements();
        
        // O ícone personalizado aparece na janela principal do sistema e também na segunda janela Resultados.
        setIconImage(new javax.swing.ImageIcon( getClass().getResource("/imagens/icone.png")).getImage());
        
    }
    
    private int idBotaoCapacidade = 0;
    
    // Esse método funciona quando usuário escolhe qual a capacidade.
    public void selecionarBotaoCapacidade(javax.swing.JButton botaoSelecionado, int idBotaoCapacidade){
        java.awt.Color corPadrao = new java.awt.Color(255,255,255);
        java.awt.Color corSelecionado = new java.awt.Color(0,180,80);

        jButton1000.setBackground(corPadrao);
        jButton10000.setBackground(corPadrao);
        jButton100000.setBackground(corPadrao);
        jButton500000.setBackground(corPadrao);
        jButton1000000.setBackground(corPadrao);

        botaoSelecionado.setBackground(corSelecionado);
        this.idBotaoCapacidade = idBotaoCapacidade;
        
        int offset = 0;
        switch (idBotaoCapacidade){
            case 2 -> offset = 3;
            case 3 -> offset = 6;
            case 4 -> offset = 9;
            case 5 -> offset = 12;
        }
        
        for (int i = 0; i < 5; i++){
            if (Play.dados[i][offset] != 0){
                rows[i][0].setText(String.format("%.3fms%n", (double) Play.dados[i][offset] / 1_000_000.0));
                addBarraProgresso(i, (Play.dados[i][offset] / 1_000_000.0), idBotaoCapacidade);
            }
            else{
                rows[i][0].setText("-");
                resetarBarraProgresso(i, (Play.dados[i][offset] / 1_000_000.0));
            }
          
            if (Play.dados[i][offset + 1] != 0)
                rows[i][1].setText(Integer.toString(Play.dados[i][offset + 1]));
            else rows[i][1].setText("-");
            
            if (Play.dados[i][offset + 2] != 0)
                rows[i][2].setText(Integer.toString(Play.dados[i][offset + 2]));
            else rows[i][2].setText("-");
        }
    }
    
    // Adiciona os valores do tempo ms nas barras de progresso em cada algoritmo, para uma boa visualização gráfica.
    private void addBarraProgresso(int id, double valor, int capacidade){
        if(capacidade == 5 || capacidade == 4 || capacidade == 3){
                capacidade *= 10000;
            }
        else{
               capacidade *= 3000;
         }
        if(id == 0){
             jProgressBarQuickSort.setMaximum(capacidade);
            jProgressBarQuickSort.setValue((int) (valor * 1000));
            jProgressBarQuickSort.setStringPainted(true);
            jProgressBarQuickSort.setString(String.format("%.3fms%n", valor));
        }
        else if(id == 1){
            jProgressBarMergeSort.setMaximum(capacidade);
            jProgressBarMergeSort.setValue((int) (valor * 1000));
            jProgressBarMergeSort.setStringPainted(true);
            jProgressBarMergeSort.setString(String.format("%.3fms%n", valor));
        }
        else if(id == 2){
            jProgressBarHeapSort.setMaximum(capacidade);
            jProgressBarHeapSort.setValue((int) (valor * 1000));
            jProgressBarHeapSort.setStringPainted(true);
            jProgressBarHeapSort.setString(String.format("%.3fms%n", valor));
        }
        else if(id == 3){
            jProgressBarTimSort.setMaximum(capacidade);
            jProgressBarTimSort.setValue((int) (valor * 1000));
            jProgressBarTimSort.setStringPainted(true);
            jProgressBarTimSort.setString(String.format("%.3fms%n", valor));
        }
        else if(id == 4){
            jProgressBarInsertionSort.setMaximum(capacidade);
            jProgressBarInsertionSort.setValue((int) (valor * 1000));
            jProgressBarInsertionSort.setStringPainted(true);
            jProgressBarInsertionSort.setString(String.format("%.3fms%n", valor));
        }
    }
    // Reseta os valores do tempo ms nas barras de progresso em cada algoritmo quando o usuário escolhe outra capacidade.
    // Para não ocorre os valores que não pertence a outra capacidade.
    private void resetarBarraProgresso(int id, double valor){
        if(id == 0 && valor  == 0.0){
            jProgressBarQuickSort.setValue(0);
            jProgressBarQuickSort.setString(" ");
        }
        else if(id == 1 &&  valor == 0.0){
            jProgressBarMergeSort.setValue(0);
            jProgressBarMergeSort.setString(" ");
        }
        else if(id == 2 &&  valor == 0.0){
            jProgressBarHeapSort.setValue(0);
            jProgressBarHeapSort.setString(" ");
        }
        else if(id == 3 &&  valor == 0.0){
            jProgressBarTimSort.setValue(0);
            jProgressBarTimSort.setString(" ");
        }
        else if(id == 4 &&  valor == 0.0){
            jProgressBarInsertionSort.setValue(0);
            jProgressBarInsertionSort.setString(" ");
        }
    }
    
    private void fetchElements(){
        rows = new javax.swing.JLabel[][]{{
            jLabelNomeResultadoQuickSortTempo,
            jLabelNomeResultadoQuickSortMovimentacoes,
            jLabelNomeResultadoQuickSortComparacoes,
        }, {
            jLabelNomeResultadoMergeSortTempo,
            jLabelNomeResultadoMergeSortMovimentacoes,
            jLabelNomeResultadoMergeSortComparacoes
        }, {
            jLabelNomeResultadoHeapSortTempo,
            jLabelNomeResultadoHeapSortMovimentacoes,
            jLabelNomeResultadoHeapSortComparacoes
        }, {
            jLabelNomeResultadoTimSortTempo,
            jLabelNomeResultadoTimSortMovimentacoes,
            jLabelNomeResultadoTimSortComparacoes
        }, {
            jLabelNomeResultadoInsertionSortTempo,
            jLabelNomeResultadoInsertionSortMovimentacoes,
            jLabelNomeResultadoInsertionSortComparacoes
        }};
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCapacidade = new javax.swing.JPanel();
        TituloCapacidade = new javax.swing.JLabel();
        Capacidade10000 = new javax.swing.JLabel();
        Capacidade1000 = new javax.swing.JLabel();
        jButton1000 = new javax.swing.JButton();
        jButton10000 = new javax.swing.JButton();
        jButton100000 = new javax.swing.JButton();
        jButton500000 = new javax.swing.JButton();
        jButton1000000 = new javax.swing.JButton();
        Capacidade1000000 = new javax.swing.JLabel();
        Capacidade500000 = new javax.swing.JLabel();
        Capacidade100000 = new javax.swing.JLabel();
        jPanelResultados = new javax.swing.JPanel();
        TituloCapacidade1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelTituloTempo = new javax.swing.JLabel();
        jLabelMovimentacoes = new javax.swing.JLabel();
        jLabelTituloComparacoes = new javax.swing.JLabel();
        jLabelQuickSort = new javax.swing.JLabel();
        jLabelMergeSort = new javax.swing.JLabel();
        jLabelHeapSort = new javax.swing.JLabel();
        jLabelTimSort = new javax.swing.JLabel();
        jLabelInsertionSort = new javax.swing.JLabel();
        jLabelNomeResultadoMergeSortTempo = new javax.swing.JLabel();
        jLabelNomeResultadoHeapSortTempo = new javax.swing.JLabel();
        jLabelNomeResultadoTimSortTempo = new javax.swing.JLabel();
        jLabelNomeResultadoInsertionSortTempo = new javax.swing.JLabel();
        jLabelNomeResultadoQuickSortMovimentacoes = new javax.swing.JLabel();
        jLabelNomeResultadoHeapSortMovimentacoes = new javax.swing.JLabel();
        jLabelNomeResultadoTimSortMovimentacoes = new javax.swing.JLabel();
        jLabelNomeResultadoInsertionSortMovimentacoes = new javax.swing.JLabel();
        jLabelNomeResultadoMergeSortComparacoes = new javax.swing.JLabel();
        jLabelNomeResultadoHeapSortComparacoes = new javax.swing.JLabel();
        jLabelNomeResultadoTimSortComparacoes = new javax.swing.JLabel();
        jLabelNomeResultadoInsertionSortComparacoes = new javax.swing.JLabel();
        jProgressBarQuickSort = new javax.swing.JProgressBar();
        jLabelNomeResultadoQuickSortTempo = new javax.swing.JLabel();
        jLabelNomeResultadoMergeSortMovimentacoes = new javax.swing.JLabel();
        jLabelNomeResultadoQuickSortComparacoes = new javax.swing.JLabel();
        jProgressBarMergeSort = new javax.swing.JProgressBar();
        jLabelTituloTempo1 = new javax.swing.JLabel();
        jLabelMovimentacoes1 = new javax.swing.JLabel();
        jLabelTituloComparacoes1 = new javax.swing.JLabel();
        jProgressBarTimSort = new javax.swing.JProgressBar();
        jLabelTituloTempo2 = new javax.swing.JLabel();
        jLabelMovimentacoes2 = new javax.swing.JLabel();
        jLabelTituloComparacoes2 = new javax.swing.JLabel();
        jProgressBarHeapSort = new javax.swing.JProgressBar();
        jLabelTituloTempo3 = new javax.swing.JLabel();
        jLabelMovimentacoes3 = new javax.swing.JLabel();
        jLabelTituloComparacoes3 = new javax.swing.JLabel();
        jProgressBarInsertionSort = new javax.swing.JProgressBar();
        jLabelTituloTempo4 = new javax.swing.JLabel();
        jLabelMovimentacoes4 = new javax.swing.JLabel();
        jLabelTituloComparacoes4 = new javax.swing.JLabel();
        jButtonVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Resultados dos Algoritmos");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanelCapacidade.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCapacidade.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TituloCapacidade.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TituloCapacidade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TituloCapacidade.setText("Capacidade");

        Capacidade10000.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Capacidade10000.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Capacidade10000.setText("10.000");
        Capacidade10000.setPreferredSize(null);

        Capacidade1000.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Capacidade1000.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Capacidade1000.setText("1.000");
        Capacidade1000.setPreferredSize(null);

        jButton1000.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1000.setText("●");
        jButton1000.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1000.setPreferredSize(null);
        jButton1000.addActionListener(this::jButton1000ActionPerformed);

        jButton10000.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton10000.setText("●");
        jButton10000.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton10000.setPreferredSize(null);
        jButton10000.addActionListener(this::jButton10000ActionPerformed);

        jButton100000.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton100000.setText("●");
        jButton100000.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton100000.setPreferredSize(null);
        jButton100000.addActionListener(this::jButton100000ActionPerformed);

        jButton500000.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton500000.setText("●");
        jButton500000.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton500000.setPreferredSize(null);
        jButton500000.addActionListener(this::jButton500000ActionPerformed);

        jButton1000000.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1000000.setText("●");
        jButton1000000.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1000000.setPreferredSize(null);
        jButton1000000.addActionListener(this::jButton1000000ActionPerformed);

        Capacidade1000000.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Capacidade1000000.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Capacidade1000000.setText("1.000.000");
        Capacidade1000000.setPreferredSize(null);

        Capacidade500000.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Capacidade500000.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Capacidade500000.setText("500.000");

        Capacidade100000.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Capacidade100000.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Capacidade100000.setText("100.000");

        javax.swing.GroupLayout jPanelCapacidadeLayout = new javax.swing.GroupLayout(jPanelCapacidade);
        jPanelCapacidade.setLayout(jPanelCapacidadeLayout);
        jPanelCapacidadeLayout.setHorizontalGroup(
            jPanelCapacidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCapacidadeLayout.createSequentialGroup()
                .addComponent(TituloCapacidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanelCapacidadeLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(jPanelCapacidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCapacidadeLayout.createSequentialGroup()
                        .addComponent(jButton1000, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10000, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton100000, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton500000, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButton1000000, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCapacidadeLayout.createSequentialGroup()
                        .addComponent(Capacidade1000, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Capacidade10000, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Capacidade100000, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Capacidade500000, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Capacidade1000000, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelCapacidadeLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Capacidade1000, Capacidade10000, Capacidade100000, Capacidade1000000, Capacidade500000, jButton1000, jButton10000, jButton100000, jButton1000000, jButton500000});

        jPanelCapacidadeLayout.setVerticalGroup(
            jPanelCapacidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCapacidadeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TituloCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCapacidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCapacidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Capacidade100000, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Capacidade10000, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Capacidade1000, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Capacidade500000, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Capacidade1000000, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCapacidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1000000, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton500000, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton100000, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10000, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1000, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelResultados.setBackground(new java.awt.Color(255, 255, 255));
        jPanelResultados.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TituloCapacidade1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TituloCapacidade1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TituloCapacidade1.setText("Resultados dos Algoritmos");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setMinimumSize(new java.awt.Dimension(476, 185));

        jLabelTituloTempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTituloTempo.setText("Tempo (ms):");
        jLabelTituloTempo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelMovimentacoes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMovimentacoes.setText("Movimentações:");
        jLabelMovimentacoes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelTituloComparacoes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTituloComparacoes.setText("Comparações:");
        jLabelTituloComparacoes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelQuickSort.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelQuickSort.setText("QuickSort");

        jLabelMergeSort.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelMergeSort.setText("MergeSort");

        jLabelHeapSort.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelHeapSort.setText("HeapSort");

        jLabelTimSort.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTimSort.setText("TimSort");

        jLabelInsertionSort.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelInsertionSort.setText("InsertionSort");

        jLabelNomeResultadoMergeSortTempo.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNomeResultadoMergeSortTempo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNomeResultadoMergeSortTempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNomeResultadoMergeSortTempo.setText("-");
        jLabelNomeResultadoMergeSortTempo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelNomeResultadoMergeSortTempo.setOpaque(true);

        jLabelNomeResultadoHeapSortTempo.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNomeResultadoHeapSortTempo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNomeResultadoHeapSortTempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNomeResultadoHeapSortTempo.setText("-");
        jLabelNomeResultadoHeapSortTempo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelNomeResultadoHeapSortTempo.setOpaque(true);

        jLabelNomeResultadoTimSortTempo.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNomeResultadoTimSortTempo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNomeResultadoTimSortTempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNomeResultadoTimSortTempo.setText("-");
        jLabelNomeResultadoTimSortTempo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelNomeResultadoTimSortTempo.setOpaque(true);

        jLabelNomeResultadoInsertionSortTempo.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNomeResultadoInsertionSortTempo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNomeResultadoInsertionSortTempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNomeResultadoInsertionSortTempo.setText("-");
        jLabelNomeResultadoInsertionSortTempo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelNomeResultadoInsertionSortTempo.setOpaque(true);

        jLabelNomeResultadoQuickSortMovimentacoes.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNomeResultadoQuickSortMovimentacoes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNomeResultadoQuickSortMovimentacoes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNomeResultadoQuickSortMovimentacoes.setText("-");
        jLabelNomeResultadoQuickSortMovimentacoes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelNomeResultadoQuickSortMovimentacoes.setOpaque(true);

        jLabelNomeResultadoHeapSortMovimentacoes.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNomeResultadoHeapSortMovimentacoes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNomeResultadoHeapSortMovimentacoes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNomeResultadoHeapSortMovimentacoes.setText("-");
        jLabelNomeResultadoHeapSortMovimentacoes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelNomeResultadoHeapSortMovimentacoes.setOpaque(true);

        jLabelNomeResultadoTimSortMovimentacoes.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNomeResultadoTimSortMovimentacoes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNomeResultadoTimSortMovimentacoes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNomeResultadoTimSortMovimentacoes.setText("-");
        jLabelNomeResultadoTimSortMovimentacoes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelNomeResultadoTimSortMovimentacoes.setOpaque(true);

        jLabelNomeResultadoInsertionSortMovimentacoes.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNomeResultadoInsertionSortMovimentacoes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNomeResultadoInsertionSortMovimentacoes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNomeResultadoInsertionSortMovimentacoes.setText("-");
        jLabelNomeResultadoInsertionSortMovimentacoes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelNomeResultadoInsertionSortMovimentacoes.setOpaque(true);

        jLabelNomeResultadoMergeSortComparacoes.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNomeResultadoMergeSortComparacoes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNomeResultadoMergeSortComparacoes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNomeResultadoMergeSortComparacoes.setText("-");
        jLabelNomeResultadoMergeSortComparacoes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelNomeResultadoMergeSortComparacoes.setOpaque(true);

        jLabelNomeResultadoHeapSortComparacoes.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNomeResultadoHeapSortComparacoes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNomeResultadoHeapSortComparacoes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNomeResultadoHeapSortComparacoes.setText("-");
        jLabelNomeResultadoHeapSortComparacoes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelNomeResultadoHeapSortComparacoes.setOpaque(true);

        jLabelNomeResultadoTimSortComparacoes.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNomeResultadoTimSortComparacoes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNomeResultadoTimSortComparacoes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNomeResultadoTimSortComparacoes.setText("-");
        jLabelNomeResultadoTimSortComparacoes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelNomeResultadoTimSortComparacoes.setOpaque(true);

        jLabelNomeResultadoInsertionSortComparacoes.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNomeResultadoInsertionSortComparacoes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNomeResultadoInsertionSortComparacoes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNomeResultadoInsertionSortComparacoes.setText("-");
        jLabelNomeResultadoInsertionSortComparacoes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelNomeResultadoInsertionSortComparacoes.setOpaque(true);

        jProgressBarQuickSort.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jProgressBarQuickSort.setForeground(new java.awt.Color(0, 0, 0));
        jProgressBarQuickSort.setMaximum(10000);
        jProgressBarQuickSort.setToolTipText("");

        jLabelNomeResultadoQuickSortTempo.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNomeResultadoQuickSortTempo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNomeResultadoQuickSortTempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNomeResultadoQuickSortTempo.setText("-");
        jLabelNomeResultadoQuickSortTempo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelNomeResultadoQuickSortTempo.setOpaque(true);

        jLabelNomeResultadoMergeSortMovimentacoes.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNomeResultadoMergeSortMovimentacoes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNomeResultadoMergeSortMovimentacoes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNomeResultadoMergeSortMovimentacoes.setText("-");
        jLabelNomeResultadoMergeSortMovimentacoes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelNomeResultadoMergeSortMovimentacoes.setOpaque(true);

        jLabelNomeResultadoQuickSortComparacoes.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNomeResultadoQuickSortComparacoes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNomeResultadoQuickSortComparacoes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNomeResultadoQuickSortComparacoes.setText("-");
        jLabelNomeResultadoQuickSortComparacoes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelNomeResultadoQuickSortComparacoes.setOpaque(true);

        jProgressBarMergeSort.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jProgressBarMergeSort.setForeground(new java.awt.Color(0, 0, 0));
        jProgressBarMergeSort.setMaximum(10000);
        jProgressBarMergeSort.setToolTipText("");

        jLabelTituloTempo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTituloTempo1.setText("Tempo (ms):");
        jLabelTituloTempo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelMovimentacoes1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMovimentacoes1.setText("Movimentações:");
        jLabelMovimentacoes1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelTituloComparacoes1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTituloComparacoes1.setText("Comparações:");
        jLabelTituloComparacoes1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jProgressBarTimSort.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jProgressBarTimSort.setForeground(new java.awt.Color(0, 0, 0));
        jProgressBarTimSort.setMaximum(10000);
        jProgressBarTimSort.setToolTipText("");

        jLabelTituloTempo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTituloTempo2.setText("Tempo (ms):");
        jLabelTituloTempo2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelMovimentacoes2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMovimentacoes2.setText("Movimentações:");
        jLabelMovimentacoes2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelTituloComparacoes2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTituloComparacoes2.setText("Comparações:");
        jLabelTituloComparacoes2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jProgressBarHeapSort.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jProgressBarHeapSort.setForeground(new java.awt.Color(0, 0, 0));
        jProgressBarHeapSort.setMaximum(10000);
        jProgressBarHeapSort.setToolTipText("");

        jLabelTituloTempo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTituloTempo3.setText("Tempo (ms):");
        jLabelTituloTempo3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelMovimentacoes3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMovimentacoes3.setText("Movimentações:");
        jLabelMovimentacoes3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelTituloComparacoes3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTituloComparacoes3.setText("Comparações:");
        jLabelTituloComparacoes3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jProgressBarInsertionSort.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jProgressBarInsertionSort.setForeground(new java.awt.Color(0, 0, 0));
        jProgressBarInsertionSort.setMaximum(10000);
        jProgressBarInsertionSort.setToolTipText("");

        jLabelTituloTempo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTituloTempo4.setText("Tempo (ms):");
        jLabelTituloTempo4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelMovimentacoes4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMovimentacoes4.setText("Movimentações:");
        jLabelMovimentacoes4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelTituloComparacoes4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTituloComparacoes4.setText("Comparações:");
        jLabelTituloComparacoes4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jProgressBarMergeSort, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTituloTempo2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelNomeResultadoMergeSortTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelTimSort, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                            .addComponent(jLabelMergeSort, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelMovimentacoes1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelNomeResultadoMergeSortMovimentacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTituloComparacoes2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelNomeResultadoMergeSortComparacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jProgressBarTimSort, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTituloTempo4))
                            .addComponent(jLabelInsertionSort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jProgressBarInsertionSort, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelMovimentacoes4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelNomeResultadoInsertionSortMovimentacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelTituloComparacoes4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelNomeResultadoInsertionSortComparacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTituloTempo3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelNomeResultadoInsertionSortTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelNomeResultadoTimSortTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jProgressBarHeapSort, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelTituloTempo1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelNomeResultadoHeapSortTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabelQuickSort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabelMovimentacoes)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelNomeResultadoQuickSortMovimentacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelTituloComparacoes1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelNomeResultadoQuickSortComparacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabelMovimentacoes3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelNomeResultadoTimSortMovimentacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelTituloComparacoes3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelNomeResultadoTimSortComparacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabelHeapSort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabelMovimentacoes2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelNomeResultadoHeapSortMovimentacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelTituloComparacoes)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelNomeResultadoHeapSortComparacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jProgressBarQuickSort, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelTituloTempo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelNomeResultadoQuickSortTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabelHeapSort, jLabelInsertionSort, jLabelQuickSort, jLabelTimSort});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelQuickSort)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBarQuickSort, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelNomeResultadoQuickSortTempo)
                        .addComponent(jLabelTituloTempo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMovimentacoes)
                    .addComponent(jLabelNomeResultadoQuickSortComparacoes)
                    .addComponent(jLabelNomeResultadoQuickSortMovimentacoes)
                    .addComponent(jLabelTituloComparacoes1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMergeSort)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBarMergeSort, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelNomeResultadoMergeSortTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelTituloTempo2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMovimentacoes1)
                    .addComponent(jLabelNomeResultadoMergeSortMovimentacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNomeResultadoMergeSortComparacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTituloComparacoes2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelHeapSort)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelTituloTempo1)
                        .addComponent(jLabelNomeResultadoHeapSortTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jProgressBarHeapSort, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMovimentacoes2)
                    .addComponent(jLabelNomeResultadoHeapSortMovimentacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTituloComparacoes)
                    .addComponent(jLabelNomeResultadoHeapSortComparacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTimSort)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBarTimSort, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelNomeResultadoTimSortTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelTituloTempo4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMovimentacoes3)
                    .addComponent(jLabelNomeResultadoTimSortMovimentacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTituloComparacoes3)
                    .addComponent(jLabelNomeResultadoTimSortComparacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelInsertionSort)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBarInsertionSort, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelTituloTempo3)
                        .addComponent(jLabelNomeResultadoInsertionSortTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMovimentacoes4)
                    .addComponent(jLabelNomeResultadoInsertionSortMovimentacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTituloComparacoes4)
                    .addComponent(jLabelNomeResultadoInsertionSortComparacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabelHeapSort, jLabelInsertionSort, jLabelMergeSort, jLabelMovimentacoes, jLabelNomeResultadoHeapSortComparacoes, jLabelNomeResultadoHeapSortMovimentacoes, jLabelNomeResultadoHeapSortTempo, jLabelNomeResultadoInsertionSortComparacoes, jLabelNomeResultadoInsertionSortMovimentacoes, jLabelNomeResultadoInsertionSortTempo, jLabelNomeResultadoMergeSortComparacoes, jLabelNomeResultadoMergeSortMovimentacoes, jLabelNomeResultadoMergeSortTempo, jLabelNomeResultadoQuickSortComparacoes, jLabelNomeResultadoQuickSortMovimentacoes, jLabelNomeResultadoQuickSortTempo, jLabelNomeResultadoTimSortComparacoes, jLabelNomeResultadoTimSortMovimentacoes, jLabelNomeResultadoTimSortTempo, jLabelQuickSort, jLabelTimSort, jLabelTituloComparacoes, jLabelTituloTempo, jProgressBarQuickSort});

        javax.swing.GroupLayout jPanelResultadosLayout = new javax.swing.GroupLayout(jPanelResultados);
        jPanelResultados.setLayout(jPanelResultadosLayout);
        jPanelResultadosLayout.setHorizontalGroup(
            jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelResultadosLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelResultadosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(TituloCapacidade1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );
        jPanelResultadosLayout.setVerticalGroup(
            jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TituloCapacidade1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButtonVoltar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonVoltar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonVoltar.addActionListener(this::jButtonVoltarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelCapacidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(326, 326, 326)
                .addComponent(jButtonVoltar)
                .addContainerGap(339, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonVoltar)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        // TODO add your handling code here:
        Menu tela = new Menu();
        tela.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButton1000ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1000ActionPerformed
        // TODO add your handling code here:
        selecionarBotaoCapacidade(jButton1000, 1);
    }//GEN-LAST:event_jButton1000ActionPerformed

    private void jButton10000ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10000ActionPerformed
        // TODO add your handling code here:
        selecionarBotaoCapacidade(jButton10000, 2);
    }//GEN-LAST:event_jButton10000ActionPerformed

    private void jButton100000ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton100000ActionPerformed
        // TODO add your handling code here:
        selecionarBotaoCapacidade(jButton100000, 3);
    }//GEN-LAST:event_jButton100000ActionPerformed

    private void jButton500000ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton500000ActionPerformed
        // TODO add your handling code here:
        selecionarBotaoCapacidade(jButton500000, 4);
    }//GEN-LAST:event_jButton500000ActionPerformed

    private void jButton1000000ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1000000ActionPerformed
        // TODO add your handling code here:
        selecionarBotaoCapacidade(jButton1000000, 5);
    }//GEN-LAST:event_jButton1000000ActionPerformed

    public static void main(String args[]){
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Resultados().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Capacidade1000;
    private javax.swing.JLabel Capacidade10000;
    private javax.swing.JLabel Capacidade100000;
    private javax.swing.JLabel Capacidade1000000;
    private javax.swing.JLabel Capacidade500000;
    private javax.swing.JLabel TituloCapacidade;
    private javax.swing.JLabel TituloCapacidade1;
    private javax.swing.JButton jButton1000;
    private javax.swing.JButton jButton10000;
    private javax.swing.JButton jButton100000;
    private javax.swing.JButton jButton1000000;
    private javax.swing.JButton jButton500000;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabelHeapSort;
    private javax.swing.JLabel jLabelInsertionSort;
    private javax.swing.JLabel jLabelMergeSort;
    private javax.swing.JLabel jLabelMovimentacoes;
    private javax.swing.JLabel jLabelMovimentacoes1;
    private javax.swing.JLabel jLabelMovimentacoes2;
    private javax.swing.JLabel jLabelMovimentacoes3;
    private javax.swing.JLabel jLabelMovimentacoes4;
    private javax.swing.JLabel jLabelNomeResultadoHeapSortComparacoes;
    private javax.swing.JLabel jLabelNomeResultadoHeapSortMovimentacoes;
    private javax.swing.JLabel jLabelNomeResultadoHeapSortTempo;
    private javax.swing.JLabel jLabelNomeResultadoInsertionSortComparacoes;
    private javax.swing.JLabel jLabelNomeResultadoInsertionSortMovimentacoes;
    private javax.swing.JLabel jLabelNomeResultadoInsertionSortTempo;
    private javax.swing.JLabel jLabelNomeResultadoMergeSortComparacoes;
    private javax.swing.JLabel jLabelNomeResultadoMergeSortMovimentacoes;
    private javax.swing.JLabel jLabelNomeResultadoMergeSortTempo;
    private javax.swing.JLabel jLabelNomeResultadoQuickSortComparacoes;
    private javax.swing.JLabel jLabelNomeResultadoQuickSortMovimentacoes;
    private javax.swing.JLabel jLabelNomeResultadoQuickSortTempo;
    private javax.swing.JLabel jLabelNomeResultadoTimSortComparacoes;
    private javax.swing.JLabel jLabelNomeResultadoTimSortMovimentacoes;
    private javax.swing.JLabel jLabelNomeResultadoTimSortTempo;
    private javax.swing.JLabel jLabelQuickSort;
    private javax.swing.JLabel jLabelTimSort;
    private javax.swing.JLabel jLabelTituloComparacoes;
    private javax.swing.JLabel jLabelTituloComparacoes1;
    private javax.swing.JLabel jLabelTituloComparacoes2;
    private javax.swing.JLabel jLabelTituloComparacoes3;
    private javax.swing.JLabel jLabelTituloComparacoes4;
    private javax.swing.JLabel jLabelTituloTempo;
    private javax.swing.JLabel jLabelTituloTempo1;
    private javax.swing.JLabel jLabelTituloTempo2;
    private javax.swing.JLabel jLabelTituloTempo3;
    private javax.swing.JLabel jLabelTituloTempo4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelCapacidade;
    private javax.swing.JPanel jPanelResultados;
    private javax.swing.JProgressBar jProgressBarHeapSort;
    private javax.swing.JProgressBar jProgressBarInsertionSort;
    private javax.swing.JProgressBar jProgressBarMergeSort;
    private javax.swing.JProgressBar jProgressBarQuickSort;
    private javax.swing.JProgressBar jProgressBarTimSort;
    // End of variables declaration//GEN-END:variables

    // Grupos para tornar atualização dos campos mais facil.
    // Isso ta dando que é nulo. Por algum motivo.
    static javax.swing.JLabel[][] rows;
}
