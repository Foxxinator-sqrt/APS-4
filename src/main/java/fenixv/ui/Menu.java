package fenixv.ui;

import fenixv.algoritmos.*;
import fenixv.play.Play;
import java.io.IOException;

public class Menu extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Menu.class.getName());

    public Menu() {
        initComponents();
        
        // O ícone personalizado aparece na janela principal do sistema e também na segunda janela Resultados.
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone.png")).getImage());

        // Se o usuário esquecer de selecionar o algoritmo e/ou a capacidade, a mensagem de erro deve aparecer na interface gráfica, avisando o que está faltando.
        // Se ele selecionar tudo corretamente, a mensagem deve ficar escondida novamente.
        jLabelMensagemErro.setVisible(false);
    }
    
    private int idBotaoAlgoritmo = 0;
    private int idBotaoCapacidade = 0;
    
    /*  Esse método é usado por todos os botões de algoritmo.
        Ele recebe a referencia ao botão pressionado, e o seu id.
        Usando esses parametros para alterar a cor do botão,
        e armazenar o valor do botão selecionado, respectivamente.
    */
    public void selecionarBotaoAlgoritimos(javax.swing.JButton botaoSelecionado, int idBotaoAlgoritimo){
        java.awt.Color corPadrao = new java.awt.Color(255,255,255);
        java.awt.Color corSelecionado = new java.awt.Color(0,180,80);

        jButtonQuickSort.setBackground(corPadrao);
        jButtonMergeSort.setBackground(corPadrao);
        jButtonHeapSort.setBackground(corPadrao);
        jButtonTimSort.setBackground(corPadrao);
        jButtonInsertionSort.setBackground(corPadrao);

        botaoSelecionado.setBackground(corSelecionado);
        this.idBotaoAlgoritmo = idBotaoAlgoritimo;
    }
    
    /*  Esse método é usado por todos os botões de capacidade.
        Assim como o metodo acima, recebe uma referencia ao botão que foi ativado, e seu id.
        Usando esses parâmetros para alterar a cor do botão, e determinar o valor da capacidade selecionada.
    */
    public void selecionarBotaoCapacidade(javax.swing.JButton botaoSelecionado, int idBotaoCapacidade){
        java.awt.Color corPadrao = new java.awt.Color(255,255,255);
        java.awt.Color corSelecionado = new java.awt.Color(0,180,80);

        jButton1000.setBackground(corPadrao);
        jButton10000.setBackground(corPadrao);
        jButton100000.setBackground(corPadrao);
        jButton500000.setBackground(corPadrao);
        jButton1000000.setBackground(corPadrao);

        switch (idBotaoCapacidade){
            case 1 -> idBotaoCapacidade = 1000;
            case 2 -> idBotaoCapacidade = 10000;
            case 3 -> idBotaoCapacidade = 100000;
            case 4 -> idBotaoCapacidade = 500000;
            case 5 -> idBotaoCapacidade = 1000000;
        }

        botaoSelecionado.setBackground(corSelecionado);
        this.idBotaoCapacidade = idBotaoCapacidade;
    }
    
    /*  Método chamado quando o botão "Run" é pressionado.
        Ele usa as variaveis idBotaoAlgoritmo e idBotaoCapacidade para
        Determinar qual função de ordenação deve ser chamada, e com qual capacidade,
        alem de atualizar as labels com os dados do algoritmo executado. */
    public void executarRun(int idBotaoAlgoritmo, int idBotaoCapacidade){
        if(idBotaoAlgoritmo != 0 && idBotaoCapacidade != 0){
            jLabelMensagemErro.setVisible(false);
            
            // Executa o algoritmo selecionado pelo usuário.
            int[] vetor = Play.gerarVetor(idBotaoCapacidade);
            switch (idBotaoAlgoritmo){
                case 1 -> {
                    QuickSort.executar(Play.dados, idBotaoCapacidade, vetor);
                    jLabelNomeResultado.setText("Quick Sort");
                }
                case 2 -> {
                    MergeSort.executar(Play.dados, idBotaoCapacidade, vetor);
                    jLabelNomeResultado.setText("Merge Sort");
                }
                case 3 -> {
                    HeapSort.executar(Play.dados, idBotaoCapacidade, vetor);
                    jLabelNomeResultado.setText("Heap Sort");
                }
                case 4 -> {
                    TimSort.executar(Play.dados, idBotaoCapacidade, vetor);
                    jLabelNomeResultado.setText("Tim Sort");
                }
                case 5 -> {
                    InsertionSort.executar(Play.dados, idBotaoCapacidade, vetor);
                    jLabelNomeResultado.setText("Insertion Sort");
                }
            }
            
            int offset = 0;
            switch (idBotaoCapacidade){
                case 10000 -> offset = 3;
                case 100000 -> offset = 6;
                case 500000 -> offset = 9;
                case 1000000 -> offset = 12;
            }
            
            // Atualiza as labels com os dados resultantes.
            jLabelCapacidadeResultado.setText(Integer.toString(idBotaoCapacidade));
            double tempo = (double) Play.dados[idBotaoAlgoritmo - 1][offset] / 1_000_000.0;
            jLabelTempoResultado.setText(String.format("%.3fms%n", tempo));
            jLabelMovimentacoesResultado.setText(Long.toString(Play.dados[idBotaoAlgoritmo - 1][offset + 1]));
            jLabelComparacoesResultado.setText(Long.toString(Play.dados[idBotaoAlgoritmo - 1][offset + 2]));
        }
        else jLabelMensagemErro.setVisible(true);
    }
    
    // Faz que cores selecionadas voltem para suas cores originais e os ids BotaoAlgoritmo e a capacidade seja 0.
    // Quando clica o botão de cancelar, se clicar no botão run logo depois, aparece a mensagem de erro até selecionar os dois botões.
    public void executarCancelar(){
        java.awt.Color corPadrao = new java.awt.Color(255,255,255);

        jButtonQuickSort.setBackground(corPadrao);
        jButtonMergeSort.setBackground(corPadrao);
        jButtonHeapSort.setBackground(corPadrao);
        jButtonTimSort.setBackground(corPadrao);
        jButtonInsertionSort.setBackground(corPadrao);

        jButton1000.setBackground(corPadrao);
        jButton10000.setBackground(corPadrao);
        jButton100000.setBackground(corPadrao);
        jButton500000.setBackground(corPadrao);
        jButton1000000.setBackground(corPadrao);

        this.idBotaoAlgoritmo = 0;
        this.idBotaoCapacidade = 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelAlgoritmos = new javax.swing.JPanel();
        TituloMenu = new javax.swing.JLabel();
        QuickSortLabel = new javax.swing.JLabel();
        MergeSortLabel = new javax.swing.JLabel();
        HeapSortLabel = new javax.swing.JLabel();
        TimSortLabel = new javax.swing.JLabel();
        InsertionSortLabel = new javax.swing.JLabel();
        jButtonQuickSort = new javax.swing.JButton();
        jButtonMergeSort = new javax.swing.JButton();
        jButtonHeapSort = new javax.swing.JButton();
        jButtonTimSort = new javax.swing.JButton();
        jButtonInsertionSort = new javax.swing.JButton();
        jButton1000 = new javax.swing.JButton();
        jButton10000 = new javax.swing.JButton();
        jButton100000 = new javax.swing.JButton();
        jButton500000 = new javax.swing.JButton();
        jButton1000000 = new javax.swing.JButton();
        Capacidade1000000 = new javax.swing.JLabel();
        Capacidade500000 = new javax.swing.JLabel();
        Capacidade100000 = new javax.swing.JLabel();
        Capacidade10000 = new javax.swing.JLabel();
        Capacidade1000 = new javax.swing.JLabel();
        TituloCapacidade = new javax.swing.JLabel();
        jPanelResultados = new javax.swing.JPanel();
        jButtonResultados = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonRun = new javax.swing.JButton();
        jLabelMensagemErro = new javax.swing.JLabel();
        jLabelTituloResultados = new javax.swing.JLabel();
        jPanelResultadosAlgoritmo = new javax.swing.JPanel();
        jLabelNome = new javax.swing.JLabel();
        jLabelCapacidade = new javax.swing.JLabel();
        jLabelTempo = new javax.swing.JLabel();
        jLabelMovimentacoes = new javax.swing.JLabel();
        jLabelComparacoes = new javax.swing.JLabel();
        jLabelNomeResultado = new javax.swing.JLabel();
        jLabelCapacidadeResultado = new javax.swing.JLabel();
        jLabelTempoResultado = new javax.swing.JLabel();
        jLabelMovimentacoesResultado = new javax.swing.JLabel();
        jLabelComparacoesResultado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(640, 460));
        setName(""); // NOI18N
        setResizable(false);

        PainelAlgoritmos.setBackground(new java.awt.Color(255, 255, 255));
        PainelAlgoritmos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PainelAlgoritmos.setMaximumSize(new java.awt.Dimension(640, 230));
        PainelAlgoritmos.setPreferredSize(new java.awt.Dimension(640, 230));
        PainelAlgoritmos.setRequestFocusEnabled(false);

        TituloMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TituloMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TituloMenu.setText("Algoritmos");

        QuickSortLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        QuickSortLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        QuickSortLabel.setText("QuickSort");

        MergeSortLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        MergeSortLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MergeSortLabel.setText("MergeSort");

        HeapSortLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        HeapSortLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HeapSortLabel.setText("HeapSort");

        TimSortLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        TimSortLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TimSortLabel.setText("TimSort");

        InsertionSortLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        InsertionSortLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        InsertionSortLabel.setText("InsertionSort");

        jButtonQuickSort.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonQuickSort.setText("●");
        jButtonQuickSort.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonQuickSort.addActionListener(this::jButtonQuickSortActionPerformed);

        jButtonMergeSort.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonMergeSort.setText("●");
        jButtonMergeSort.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonMergeSort.addActionListener(this::jButtonMergeSortActionPerformed);

        jButtonHeapSort.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonHeapSort.setText("●");
        jButtonHeapSort.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonHeapSort.addActionListener(this::jButtonHeapSortActionPerformed);

        jButtonTimSort.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonTimSort.setText("●");
        jButtonTimSort.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonTimSort.addActionListener(this::jButtonTimSortActionPerformed);

        jButtonInsertionSort.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonInsertionSort.setText("●");
        jButtonInsertionSort.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonInsertionSort.addActionListener(this::jButtonInsertionSortActionPerformed);

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

        Capacidade10000.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Capacidade10000.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Capacidade10000.setText("10.000");
        Capacidade10000.setPreferredSize(null);

        Capacidade1000.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Capacidade1000.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Capacidade1000.setText("1.000");
        Capacidade1000.setPreferredSize(null);

        TituloCapacidade.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TituloCapacidade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TituloCapacidade.setText("Capacidade");
        TituloCapacidade.setPreferredSize(new java.awt.Dimension(78, 20));

        javax.swing.GroupLayout PainelAlgoritmosLayout = new javax.swing.GroupLayout(PainelAlgoritmos);
        PainelAlgoritmos.setLayout(PainelAlgoritmosLayout);
        PainelAlgoritmosLayout.setHorizontalGroup(
            PainelAlgoritmosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelAlgoritmosLayout.createSequentialGroup()
                .addGap(0, 38, Short.MAX_VALUE)
                .addGroup(PainelAlgoritmosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(PainelAlgoritmosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PainelAlgoritmosLayout.createSequentialGroup()
                            .addComponent(Capacidade1000, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Capacidade10000, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Capacidade100000, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Capacidade500000, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Capacidade1000000, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PainelAlgoritmosLayout.createSequentialGroup()
                            .addComponent(jButton1000, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton10000, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton100000, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton500000, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton1000000, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PainelAlgoritmosLayout.createSequentialGroup()
                        .addComponent(jButtonQuickSort, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonMergeSort, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jButtonHeapSort, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonTimSort, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonInsertionSort, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PainelAlgoritmosLayout.createSequentialGroup()
                        .addComponent(QuickSortLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MergeSortLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(HeapSortLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TimSortLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(InsertionSortLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TituloMenu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TituloCapacidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 38, Short.MAX_VALUE))
        );
        PainelAlgoritmosLayout.setVerticalGroup(
            PainelAlgoritmosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelAlgoritmosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TituloMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(PainelAlgoritmosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelAlgoritmosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(QuickSortLabel)
                        .addComponent(MergeSortLabel)
                        .addComponent(HeapSortLabel))
                    .addGroup(PainelAlgoritmosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(InsertionSortLabel)
                        .addComponent(TimSortLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelAlgoritmosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonInsertionSort)
                    .addComponent(jButtonTimSort)
                    .addComponent(jButtonHeapSort)
                    .addComponent(jButtonMergeSort)
                    .addComponent(jButtonQuickSort))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TituloCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelAlgoritmosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Capacidade1000, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Capacidade10000, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Capacidade100000, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Capacidade500000, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Capacidade1000000, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(PainelAlgoritmosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1000, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10000, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton100000, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton500000, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1000000, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanelResultados.setBackground(new java.awt.Color(255, 255, 255));
        jPanelResultados.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelResultados.setMaximumSize(new java.awt.Dimension(640, 230));
        jPanelResultados.setPreferredSize(new java.awt.Dimension(638, 230));

        jButtonResultados.setText("《 Resultados");
        jButtonResultados.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonResultados.addActionListener(this::jButtonResultadosActionPerformed);

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonCancelar.addActionListener(this::jButtonCancelarActionPerformed);

        jButtonRun.setText("Run");
        jButtonRun.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonRun.addActionListener(this::jButtonRunActionPerformed);

        jLabelMensagemErro.setBackground(new java.awt.Color(255, 0, 0));
        jLabelMensagemErro.setForeground(new java.awt.Color(255, 0, 0));
        jLabelMensagemErro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensagemErro.setText("Selecione um algoritmo e uma capacidade antes de executar.");

        jLabelTituloResultados.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTituloResultados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTituloResultados.setText("Resultado do Algoritmo");

        jPanelResultadosAlgoritmo.setBackground(new java.awt.Color(239, 239, 239));
        jPanelResultadosAlgoritmo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM));

        jLabelNome.setText("Nome:");

        jLabelCapacidade.setText("Capacidade:");

        jLabelTempo.setText("Tempo: ");

        jLabelMovimentacoes.setText("Movimentações:");

        jLabelComparacoes.setText("Comparações:");

        jLabelNomeResultado.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNomeResultado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNomeResultado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNomeResultado.setText("-");
        jLabelNomeResultado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelNomeResultado.setOpaque(true);

        jLabelCapacidadeResultado.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCapacidadeResultado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelCapacidadeResultado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCapacidadeResultado.setText("-");
        jLabelCapacidadeResultado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelCapacidadeResultado.setOpaque(true);

        jLabelTempoResultado.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTempoResultado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelTempoResultado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTempoResultado.setText("-");
        jLabelTempoResultado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelTempoResultado.setOpaque(true);

        jLabelMovimentacoesResultado.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMovimentacoesResultado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelMovimentacoesResultado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMovimentacoesResultado.setText("-");
        jLabelMovimentacoesResultado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelMovimentacoesResultado.setOpaque(true);

        jLabelComparacoesResultado.setBackground(new java.awt.Color(255, 255, 255));
        jLabelComparacoesResultado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelComparacoesResultado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelComparacoesResultado.setText("-");
        jLabelComparacoesResultado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelComparacoesResultado.setOpaque(true);

        javax.swing.GroupLayout jPanelResultadosAlgoritmoLayout = new javax.swing.GroupLayout(jPanelResultadosAlgoritmo);
        jPanelResultadosAlgoritmo.setLayout(jPanelResultadosAlgoritmoLayout);
        jPanelResultadosAlgoritmoLayout.setHorizontalGroup(
            jPanelResultadosAlgoritmoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelResultadosAlgoritmoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelResultadosAlgoritmoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelComparacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelMovimentacoes, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(jLabelTempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCapacidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelResultadosAlgoritmoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelMovimentacoesResultado, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(jLabelTempoResultado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCapacidadeResultado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelNomeResultado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelComparacoesResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelResultadosAlgoritmoLayout.setVerticalGroup(
            jPanelResultadosAlgoritmoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelResultadosAlgoritmoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelResultadosAlgoritmoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelNomeResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelResultadosAlgoritmoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCapacidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCapacidadeResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelResultadosAlgoritmoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelTempoResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelResultadosAlgoritmoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMovimentacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelMovimentacoesResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelResultadosAlgoritmoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelComparacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelComparacoesResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelResultadosLayout = new javax.swing.GroupLayout(jPanelResultados);
        jPanelResultados.setLayout(jPanelResultadosLayout);
        jPanelResultadosLayout.setHorizontalGroup(
            jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelResultadosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanelResultadosAlgoritmo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelResultadosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelMensagemErro))
                    .addGroup(jPanelResultadosLayout.createSequentialGroup()
                        .addComponent(jButtonResultados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelTituloResultados)
                        .addGap(65, 65, 65)
                        .addComponent(jButtonRun)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar)))
                .addContainerGap())
        );

        jPanelResultadosLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonCancelar, jButtonRun});

        jPanelResultadosLayout.setVerticalGroup(
            jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTituloResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonResultados)
                    .addComponent(jButtonRun)
                    .addComponent(jButtonCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelResultadosAlgoritmo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabelMensagemErro)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                    .addComponent(PainelAlgoritmos, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PainelAlgoritmos, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Eventos dos botões, responsáveis por executar cada ação.
    private void jButtonQuickSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuickSortActionPerformed
        selecionarBotaoAlgoritimos(jButtonQuickSort, 1);
    }//GEN-LAST:event_jButtonQuickSortActionPerformed

    private void jButtonMergeSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMergeSortActionPerformed
        selecionarBotaoAlgoritimos(jButtonMergeSort, 2);
    }//GEN-LAST:event_jButtonMergeSortActionPerformed

    private void jButtonHeapSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHeapSortActionPerformed
        selecionarBotaoAlgoritimos(jButtonHeapSort, 3);
    }//GEN-LAST:event_jButtonHeapSortActionPerformed

    private void jButtonTimSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTimSortActionPerformed
        selecionarBotaoAlgoritimos(jButtonTimSort, 4);
    }//GEN-LAST:event_jButtonTimSortActionPerformed

    private void jButtonInsertionSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertionSortActionPerformed
        selecionarBotaoAlgoritimos(jButtonInsertionSort, 5);
    }//GEN-LAST:event_jButtonInsertionSortActionPerformed

    private void jButton1000ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1000ActionPerformed
        selecionarBotaoCapacidade(jButton1000, 1);
    }//GEN-LAST:event_jButton1000ActionPerformed

    private void jButton10000ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10000ActionPerformed
        selecionarBotaoCapacidade(jButton10000, 2);
    }//GEN-LAST:event_jButton10000ActionPerformed

    private void jButton100000ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton100000ActionPerformed
        selecionarBotaoCapacidade(jButton100000, 3);
    }//GEN-LAST:event_jButton100000ActionPerformed

    private void jButton500000ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton500000ActionPerformed
        selecionarBotaoCapacidade(jButton500000, 4);
    }//GEN-LAST:event_jButton500000ActionPerformed

    private void jButton1000000ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1000000ActionPerformed
        selecionarBotaoCapacidade(jButton1000000, 5);
    }//GEN-LAST:event_jButton1000000ActionPerformed

    private void jButtonResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResultadosActionPerformed
        Resultados tela = new Resultados();
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonResultadosActionPerformed

    private void jButtonRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRunActionPerformed
        executarRun(idBotaoAlgoritmo, idBotaoCapacidade);
    }//GEN-LAST:event_jButtonRunActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        executarCancelar();
    }//GEN-LAST:event_jButtonCancelarActionPerformed
    
    public static void init() throws IOException {
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
        java.awt.EventQueue.invokeLater(() -> new Menu().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Capacidade1000;
    private javax.swing.JLabel Capacidade10000;
    private javax.swing.JLabel Capacidade100000;
    private javax.swing.JLabel Capacidade1000000;
    private javax.swing.JLabel Capacidade500000;
    private javax.swing.JLabel HeapSortLabel;
    private javax.swing.JLabel InsertionSortLabel;
    private javax.swing.JLabel MergeSortLabel;
    private javax.swing.JPanel PainelAlgoritmos;
    private javax.swing.JLabel QuickSortLabel;
    private javax.swing.JLabel TimSortLabel;
    private javax.swing.JLabel TituloCapacidade;
    private javax.swing.JLabel TituloMenu;
    private javax.swing.JButton jButton1000;
    private javax.swing.JButton jButton10000;
    private javax.swing.JButton jButton100000;
    private javax.swing.JButton jButton1000000;
    private javax.swing.JButton jButton500000;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonHeapSort;
    private javax.swing.JButton jButtonInsertionSort;
    private javax.swing.JButton jButtonMergeSort;
    private javax.swing.JButton jButtonQuickSort;
    private javax.swing.JButton jButtonResultados;
    private javax.swing.JButton jButtonRun;
    private javax.swing.JButton jButtonTimSort;
    private javax.swing.JLabel jLabelCapacidade;
    private javax.swing.JLabel jLabelCapacidadeResultado;
    private javax.swing.JLabel jLabelComparacoes;
    private javax.swing.JLabel jLabelComparacoesResultado;
    private javax.swing.JLabel jLabelMensagemErro;
    private javax.swing.JLabel jLabelMovimentacoes;
    private javax.swing.JLabel jLabelMovimentacoesResultado;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNomeResultado;
    private javax.swing.JLabel jLabelTempo;
    private javax.swing.JLabel jLabelTempoResultado;
    private javax.swing.JLabel jLabelTituloResultados;
    private javax.swing.JPanel jPanelResultados;
    private javax.swing.JPanel jPanelResultadosAlgoritmo;
    // End of variables declaration//GEN-END:variables
}
