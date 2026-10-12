package interfaceGrafica;

import com.opencsv.exceptions.CsvValidationException;
import fenixv.aps4.APS4;
import fenixv.aps4.QuickSort;
import fenixv.aps4.MergeSort;
import fenixv.aps4.HeapSort;
import fenixv.aps4.TimSort;
import fenixv.aps4.InsertionSort;
import java.io.IOException;
// As blibliotecas do nosso código para associar aqui na interface gráfica, Pedro.
public class Menu extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Menu.class.getName());

    public Menu() {
        initComponents();
        
       // Todos os elementos estão renomeados. Se quiser mudar os nomes para facilitar o entendimento, fique à vontade, Pedro.
        
        // O ícone personalizado aparece na janela principal do sistema e também.
        // Se quiser trocar a imagem, é só baixar outra e colocar na pasta Other Sources > resources > imagens.
        // Depois, altere o caminho da imagem no código, por exemplo: "/imagens/icone.png".
        // Sempre execute a interface gráfica para conferir se o ícone apareceu corretamente.
        setIconImage(new javax.swing.ImageIcon( getClass().getResource("/imagens/icone.png")).getImage());

        // Se o usuário esquecer de selecionar o algoritmo ou a capacidade, a mensagem de erro deve aparecer na interface gráfica, avisando o que está faltando.
        // Se ele selecionar tudo corretamente, a mensagem deve ficar escondida novamente.
        jLabelMensagemErro.setVisible(false);
    }
    
    
    private int idBotaoAlgoritmo = 0;
    private int idBotaoCapacidade = 0;
    
     // Esse método funciona quando usuário escolhe qual o algoritmo que ele quer.
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
    
    // Esse método funciona quando usuário escolhe qual a capacidade.
    public void selecionarBotaoCapacidade(javax.swing.JButton botaoSelecionado, int idBotaoCapacidade){
         java.awt.Color corPadrao = new java.awt.Color(255,255,255);
         java.awt.Color corSelecionado = new java.awt.Color(0,180,80);
         
         jButton1000.setBackground(corPadrao);
         jButton10000.setBackground(corPadrao);
         jButton100000.setBackground(corPadrao);
         jButton500000.setBackground(corPadrao);
         jButton1000000.setBackground(corPadrao);
         
         switch (idBotaoCapacidade){
             default -> {
                 break;
             }
             case 1 -> {
                 idBotaoCapacidade = 1000;
                 break;
             }
             case 2 -> {
                 idBotaoCapacidade = 10000;
                 break;
             }
             case 3 -> {
                 idBotaoCapacidade = 100000;
                 break;
             }
             case 4 -> {
                 idBotaoCapacidade = 500000;
                 break;
             }
             case 5 -> {
                 idBotaoCapacidade = 1000000;
                 break;
             }
         }
         
         botaoSelecionado.setBackground(corSelecionado);
          this.idBotaoCapacidade = idBotaoCapacidade;
    }
    
    // Aqui deve implementar os resultados os dois botões selecionados.
    public void executarRun(int idBotaoAlgoritmo, int idBotaoCapacidade){
        
        if(idBotaoAlgoritmo != 0 && idBotaoCapacidade != 0){
            jLabelMensagemErro.setVisible(false);
            // Cria o (switch case) ou (if, else if e else) 
            // Para chamar cada método do algoritmo por id do botão e altera o texto nos resultados bem aqui nesse método que seria o algoritmo.
        }
        else{
            jLabelMensagemErro.setVisible(true);
        }
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
        QuickSort = new javax.swing.JLabel();
        MergeSort = new javax.swing.JLabel();
        HeapSort = new javax.swing.JLabel();
        TimSort = new javax.swing.JLabel();
        InsertionSort = new javax.swing.JLabel();
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
        setName(""); // NOI18N

        PainelAlgoritmos.setBackground(new java.awt.Color(255, 255, 255));
        PainelAlgoritmos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        TituloMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TituloMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TituloMenu.setText("Algoritmos");

        QuickSort.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        QuickSort.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        QuickSort.setText("QuickSort");

        MergeSort.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        MergeSort.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MergeSort.setText("MergeSort");

        HeapSort.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        HeapSort.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HeapSort.setText("HeapSort");

        TimSort.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        TimSort.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TimSort.setText("TimSort");

        InsertionSort.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        InsertionSort.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        InsertionSort.setText("InsertionSort");

        jButtonQuickSort.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonQuickSort.setText("●");
        jButtonQuickSort.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonQuickSort.addActionListener(this::jButtonQuickSortActionPerformed);

        jButtonMergeSort.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonMergeSort.setText("●");
        jButtonMergeSort.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonMergeSort.addActionListener(this::jButtonMergeSortActionPerformed);

        jButtonHeapSort.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonHeapSort.setText("●");
        jButtonHeapSort.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonHeapSort.addActionListener(this::jButtonHeapSortActionPerformed);

        jButtonTimSort.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonTimSort.setText("●");
        jButtonTimSort.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonTimSort.addActionListener(this::jButtonTimSortActionPerformed);

        jButtonInsertionSort.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonInsertionSort.setText("●");
        jButtonInsertionSort.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonInsertionSort.addActionListener(this::jButtonInsertionSortActionPerformed);

        jButton1000.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1000.setText("●");
        jButton1000.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1000.setPreferredSize(null);
        jButton1000.addActionListener(this::jButton1000ActionPerformed);

        jButton10000.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton10000.setText("●");
        jButton10000.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10000.setPreferredSize(null);
        jButton10000.addActionListener(this::jButton10000ActionPerformed);

        jButton100000.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton100000.setText("●");
        jButton100000.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton100000.setPreferredSize(null);
        jButton100000.addActionListener(this::jButton100000ActionPerformed);

        jButton500000.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton500000.setText("●");
        jButton500000.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton500000.setPreferredSize(null);
        jButton500000.addActionListener(this::jButton500000ActionPerformed);

        jButton1000000.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1000000.setText("●");
        jButton1000000.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        javax.swing.GroupLayout PainelAlgoritmosLayout = new javax.swing.GroupLayout(PainelAlgoritmos);
        PainelAlgoritmos.setLayout(PainelAlgoritmosLayout);
        PainelAlgoritmosLayout.setHorizontalGroup(
            PainelAlgoritmosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelAlgoritmosLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(PainelAlgoritmosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelAlgoritmosLayout.createSequentialGroup()
                        .addGroup(PainelAlgoritmosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PainelAlgoritmosLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TituloMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PainelAlgoritmosLayout.createSequentialGroup()
                                .addComponent(QuickSort, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(MergeSort, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(HeapSort, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addComponent(TimSort, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(InsertionSort, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PainelAlgoritmosLayout.createSequentialGroup()
                        .addComponent(jButtonQuickSort, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButtonMergeSort, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButtonHeapSort, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButtonTimSort, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonInsertionSort, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelAlgoritmosLayout.createSequentialGroup()
                        .addComponent(jButton1000, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton10000, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButton100000, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButton500000, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButton1000000, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelAlgoritmosLayout.createSequentialGroup()
                        .addGroup(PainelAlgoritmosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PainelAlgoritmosLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TituloCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PainelAlgoritmosLayout.createSequentialGroup()
                                .addComponent(Capacidade1000, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Capacidade10000, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Capacidade100000, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addComponent(Capacidade500000, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Capacidade1000000, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );
        PainelAlgoritmosLayout.setVerticalGroup(
            PainelAlgoritmosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelAlgoritmosLayout.createSequentialGroup()
                .addComponent(TituloMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(PainelAlgoritmosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(QuickSort, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(MergeSort)
                    .addComponent(HeapSort)
                    .addComponent(TimSort)
                    .addComponent(InsertionSort))
                .addGap(12, 12, 12)
                .addGroup(PainelAlgoritmosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonQuickSort)
                    .addComponent(jButtonMergeSort)
                    .addComponent(jButtonHeapSort)
                    .addComponent(jButtonTimSort)
                    .addComponent(jButtonInsertionSort))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TituloCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelAlgoritmosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Capacidade1000, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Capacidade10000, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Capacidade100000, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Capacidade500000, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Capacidade1000000, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(PainelAlgoritmosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1000, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10000, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton100000, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton500000, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1000000, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelResultados.setBackground(new java.awt.Color(255, 255, 255));
        jPanelResultados.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jButtonResultados.setText("《 Resultados");
        jButtonResultados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonResultados.addActionListener(this::jButtonResultadosActionPerformed);

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCancelar.addActionListener(this::jButtonCancelarActionPerformed);

        jButtonRun.setText("Run");
        jButtonRun.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRun.addActionListener(this::jButtonRunActionPerformed);

        jLabelMensagemErro.setBackground(new java.awt.Color(255, 0, 0));
        jLabelMensagemErro.setForeground(new java.awt.Color(255, 0, 0));
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
                    .addComponent(jLabelMovimentacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelTempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCapacidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22)
                .addGroup(jPanelResultadosAlgoritmoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNomeResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCapacidadeResultado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelTempoResultado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelMovimentacoesResultado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelComparacoesResultado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonResultados)
                .addGap(57, 57, 57)
                .addGroup(jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelResultadosLayout.createSequentialGroup()
                        .addComponent(jPanelResultadosAlgoritmo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(303, 303, 303))
                    .addGroup(jPanelResultadosLayout.createSequentialGroup()
                        .addGroup(jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelResultadosLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabelMensagemErro))
                            .addGroup(jPanelResultadosLayout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabelTituloResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(45, 45, 45)
                                .addComponent(jButtonRun)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCancelar)))
                        .addGap(151, 151, 151))))
        );

        jPanelResultadosLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonCancelar, jButtonRun});

        jPanelResultadosLayout.setVerticalGroup(
            jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonResultados)
                        .addComponent(jButtonCancelar)
                        .addComponent(jButtonRun))
                    .addGroup(jPanelResultadosLayout.createSequentialGroup()
                        .addComponent(jLabelTituloResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jPanelResultadosAlgoritmo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jLabelMensagemErro)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(PainelAlgoritmos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PainelAlgoritmos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Eventos dos botões, responsáveis por executar cada ação.
    private void jButtonQuickSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuickSortActionPerformed
        // TODO add your handling code here:
        selecionarBotaoAlgoritimos(jButtonQuickSort, 1);
    }//GEN-LAST:event_jButtonQuickSortActionPerformed

    private void jButtonMergeSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMergeSortActionPerformed
        // TODO add your handling code here:
        selecionarBotaoAlgoritimos(jButtonMergeSort, 2);
    }//GEN-LAST:event_jButtonMergeSortActionPerformed

    private void jButtonHeapSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHeapSortActionPerformed
        // TODO add your handling code here:
        selecionarBotaoAlgoritimos(jButtonHeapSort, 3);
    }//GEN-LAST:event_jButtonHeapSortActionPerformed

    private void jButtonTimSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTimSortActionPerformed
        // TODO add your handling code here:
        selecionarBotaoAlgoritimos(jButtonTimSort, 4);
    }//GEN-LAST:event_jButtonTimSortActionPerformed

    private void jButtonInsertionSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertionSortActionPerformed
        // TODO add your handling code here:
        selecionarBotaoAlgoritimos(jButtonInsertionSort, 5);
    }//GEN-LAST:event_jButtonInsertionSortActionPerformed

    
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

    
    private void jButtonResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResultadosActionPerformed
        // TODO add your handling code here:
        Resultados tela = new Resultados();
        tela.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_jButtonResultadosActionPerformed

    private void jButtonRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRunActionPerformed
        // TODO add your handling code here:
        executarRun(idBotaoAlgoritmo, idBotaoCapacidade);
    }//GEN-LAST:event_jButtonRunActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        executarCancelar();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    
    public static void main(String args[]) throws IOException, CsvValidationException {
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
    private javax.swing.JLabel HeapSort;
    private javax.swing.JLabel InsertionSort;
    private javax.swing.JLabel MergeSort;
    private javax.swing.JPanel PainelAlgoritmos;
    private javax.swing.JLabel QuickSort;
    private javax.swing.JLabel TimSort;
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
