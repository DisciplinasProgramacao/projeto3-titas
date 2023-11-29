# Correção
  
  - **Estacionamento** usando construtor errado de Vaga.
  - **Estacionamento** com getID de cliente em lugar de equals
  - **Estacionamento** percorrendo vetor em lugar de registrar última posição livre
  - **Estacionamento** valor médio é por uso, não por cliente
  - **App** diversos erros de compilação. Não está nem perto de executar nada.
  - **Uso** calcula a saída 2x no valor pago
  - **Uso** fraçao de minutos (inteiro, não double)
  - **TesteEstacionamento** usando método privado
  - **TesteEstacionamento** métodos em branco
  - **TesteVeiculo** valor>=0 não garante que ele usou. Tem que ser >0 e tem que ser um valor conhecido
  - Testes movidos de lugar e, então, sem importar o pacote de entidades

## Nota base do grupo: 11

  - Contribuições
    - Ana Carolina 
      - Vaga ✔️
      - Teste Uso ✔️
      - Uso com servicos ⚠️( fez só o enum?)
      - Top5 no estacionamento ❌
      - Excecoes uso vaga ✔️
    - Gabriel 
      - Estacionamento P1 ➕➖
      - App inicial ⚠️
      - App: chamar relatorios ❌
      - App: robustez ❌
    - Guilherme 
      - Cliente ✔️
      - Teste Estacionamento ⚠️⚠️
    - João Pedro
      - Uso ⚠️
      - Teste Veiculo ⚠️
      - Carga de dados ❌
    - Leandra 
      - Estacionamento P2 ➕➖
      - Teste Vaga ✔️
      - Excecoes estacionamento ❌
    - Luca 
      - Veiculo ✔️
      - Teste Cliente (commit do Leroy?) ✔️
      - Serialização ✔️
      - Historico Cliente ❌ 
      - Estacionamento (sem ser sua classe, dificultando ver o que os outros alunos fizeram) ✔️
      - Servico (sem ser sua classe, mexendo sem necessidade) ➕➖
      - Uso de Vaga (sem ser sua classe, mexendo sem necessidade) ➕➖
      - Cliente (sem ser sua classe, mexendo sem necessidade, piorou o código do Leroy) ⚠️

    
- Tarefas nas aulas 04 e 11/10: 5 pontos;
    - Ana Carolina ➕➖ ✔️
    - Gabriel ➕➖ ❌
    - Guilherme ➕➖ ✔️
    - João Pedro ❌ ✔️
    - Leandra ❌ ✔️
    - Luca ✔️ ✔️

- Requisitos : 8/12 pontos;
- Documentação: 3/3 pontos;

## Requisitos
  - Estacionar, sair e cobrança: R$4 a cada 15 minutos, com valor limite de R$50.  
  - Serviços, tempo mínimo e cobrança 
  - Um cliente identificado tem acesso a seu histórico de uso do estacionamento.  
  - Os dados das classes existentes devem ser salvos utilizando-se serialização; 
  - App:
    - Cadastrar estacionamentos com número de vagas
    - Veículos registrados por placa e ligados a clientes. 
    - Cliente identificado com nome e com mais de um veículo. 
    - Dados de clientes e veículos salvos e carregados.
    - 3 estacionamentos
	  - Gerar aleatoriamente 50 usos de vagas
  - Relatórios:
    - Valor total arrecadado do estacionamento;
    - Valor arrecadado em determinado mês;
    - Valor médio de cada utilização do estacionamento;
    - Ranking dos clientes que mais geraram arrecadação em um determinado mês.
  - Exceções que serão tratadas no aplicativo:
    - Sair de uma vaga cujo uso já foi finalizado;
    - Estacionar em uma vaga sem haver finalizado o uso anterior;
    - Cadastrar um cliente já existente;
    - Cadastrar um veículo já existente;
  
❌
➕➖
✔️
⚠️






